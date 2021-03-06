package org.gemoc.execution.concurrent.ccsljavaxdsml.ui.wizards;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.gemoc.commons.eclipse.core.resources.Project;
import org.gemoc.commons.eclipse.pde.ui.PluginConverter;
import org.gemoc.execution.concurrent.ccsljavaxdsml.ui.Activator;
import org.gemoc.execution.concurrent.ccsljavaxdsml.ui.dse.AddRemoveGemocDSENatureHandler;
import org.gemoc.execution.concurrent.ccsljavaxdsml.ui.wizards.pages.AskDSEInfoWizardPage;

public class CreateNewDSEProject extends Wizard implements INewWizard {

	public WizardNewProjectCreationPage _askProjectNamePage;
	public AskDSEInfoWizardPage _askDSEInfoPage;
	private AddRemoveGemocDSENatureHandler nature;
	
	private IProject createdProject = null; 
	
	
	public String createdProjectName = "";
	public String createdTemplateECLFile = "";
	

	public CreateNewDSEProject() {
		super();
		this.nature = new AddRemoveGemocDSENatureHandler();
		this.setWindowTitle("Create DSE project");
		_askProjectNamePage = new WizardNewProjectCreationPage("NewProjectName");
		_askProjectNamePage.setTitle("Project");
		_askProjectNamePage.setDescription("Create a new DSE Project");
		addPage(_askProjectNamePage);

		_askDSEInfoPage = new AskDSEInfoWizardPage("NewDSEInfo");
		_askDSEInfoPage.setTitle("Language");
		_askDSEInfoPage.setDescription("Specify the DSE");
		addPage(_askDSEInfoPage);	
	}

	@Override
	public void addPages() {
		super.addPages();
	}

	@Override
	public boolean needsPreviousAndNextButtons() {
		return true;
	}
	
	@Override
	public boolean canFinish() {
		return getContainer().getCurrentPage() == _askDSEInfoPage
				&& _askDSEInfoPage.isPageComplete();
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page == _askProjectNamePage) {
			//_askLanguageNamePage.setLanguageName(_askProjectNamePage.getProjectName());
		}
		return super.getNextPage(page);
	}
		
	@Override
	public boolean performFinish() {
		
		try {
			createdProject = _askProjectNamePage.getProjectHandle();
			//final String languageName = _askLanguageNamePage.getLanguageName();

			IWorkspace workspace = ResourcesPlugin.getWorkspace(); 
			final IProjectDescription description = workspace.newProjectDescription(createdProject.getName());
			if (!_askProjectNamePage.getLocationPath().equals(workspace.getRoot().getLocation()))
				description.setLocation(_askProjectNamePage.getLocationPath());
			//description.setLocationURI(_askProjectNamePage.getLocationURI());
			
			IWorkspaceRunnable operation = new IWorkspaceRunnable() {
				 public void run(IProgressMonitor monitor) throws CoreException {
					 createdProject.create(description, monitor);
					 createdProject.open(monitor);			 
					 try {
						PluginConverter.convert(createdProject);
					 } catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					 } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					 }
					 Project.createFolder(createdProject, "ecl", monitor);

					 String content = "rootElement = "
								+ _askDSEInfoPage.getRootContainerModelElement();
					 Project.createFile(createdProject, "moc2as.properties", content, monitor);
					 String filePath = "ecl/" + _askDSEInfoPage.getTemplateECLFileNameFile() + ".ecl";
					 
					 StringBuilder eclfilecontent = new StringBuilder();
					 eclfilecontent.append("import '"+_askDSEInfoPage.getEcoreFile()+"'\n");
					 String packageName;
					 if(_askDSEInfoPage.getRootContainerModelElement().contains("::")){
						 packageName = _askDSEInfoPage.getRootContainerModelElement().substring(0, _askDSEInfoPage.getRootContainerModelElement().indexOf("::"));
						 eclfilecontent.append("package "+packageName+"\nendpackage");
					 }
					 
					 
					 Project.createFile(createdProject, filePath, eclfilecontent.toString(), monitor);
//						
					 String buildFileContent = "bin.includes = META-INF/,\\\r\n\tqvto-gen/modeling/";
					 Project.setFileContent(createdProject, "build.properties", buildFileContent);
					 
					 
					 addDSEProjectNature(createdProject);

					 // save some result for embedding this wizard in a process
					 createdProjectName = _askProjectNamePage.getProjectName();
					 createdTemplateECLFile = _askDSEInfoPage.getTemplateECLFileNameFile();
					 
					 createdProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
					 createdProject.touch(new NullProgressMonitor()); // [FT] One touch to force eclipse to serialize the project properties that will update accordingly the gemoc actions in the menu.
					 //createdProject.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
				 }
			};
			ResourcesPlugin.getWorkspace().run(operation, null);
		} catch (CoreException exception) {
			Activator.error(exception.getMessage(), exception);
			return false;
		}
		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	private void addDSEProjectNature(IProject project) throws CoreException {
		 this.nature.toggleNature(project);
	}
	
	public IProject getCreatedProject() {
		return createdProject;
	}
}
