package org.gemoc.execution.concurrent.ccsljavaxdsml.ui.templates;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.gemoc.commons.eclipse.core.resources.FileFinderVisitor;
import org.gemoc.execution.concurrent.ccsljavaxdsml.ui.Activator;
import org.gemoc.execution.concurrent.ccsljavaxdsml.ui.dialogs.SelectDSAIProjectDialog;
import org.osgi.framework.BundleException;

import fr.inria.diverse.commons.eclipse.pde.manifest.ManifestChanger;
import fr.inria.diverse.commons.eclipse.pde.wizards.pages.pde.ui.templates.AbstractStringWithButtonOption;
import fr.inria.diverse.commons.eclipse.pde.wizards.pages.pde.ui.templates.TemplateOption;
import fr.inria.diverse.melange.ui.templates.melange.SimpleMTTemplate;

public class ConcurrentTemplate extends SimpleMTTemplate{

	public static final String KEY_ECLFILE_PATH = "eclFilePath"; //$NON-NLS-1$
	public static final String KEY_ASPECTS = "listOfAspects"; //$NON-NLS-1$
	
	protected static final String ECL_EXTENSION = "ecl";
	
	// other data specific to this template
	public IFile 		eclIFile;
	protected String 	eclProjectPath;
	protected String 	dsaProjectName;
	
	private TemplateOption dsaProjectLocationOption;
	
	public ConcurrentTemplate() {
		super();
		TemplateOption eclLocationOption  = new AbstractStringWithButtonOption(this, KEY_ECLFILE_PATH, "ECL path") {
			@Override
			public String doSelectButton() {
				final IWorkbenchWindow workbenchWindow = PlatformUI
						.getWorkbench().getActiveWorkbenchWindow();
				Object selection = null;
				if (workbenchWindow.getSelectionService().getSelection() instanceof IStructuredSelection) {
					selection = ((IStructuredSelection) workbenchWindow
							.getSelectionService().getSelection())
							.getFirstElement();
				}
				final IFile selectedEclFile = selection != null
						&& selection instanceof IFile
						&& ECL_EXTENSION.equals(((IFile) selection)
								.getFileExtension()) ? (IFile) selection : null;
				ViewerFilter viewerFilter = new ViewerFilter() {
					@Override
					public boolean select(Viewer viewer, Object parentElement,
							Object element) {
						if (element instanceof IFile) {
							IFile file = (IFile) element;
							return ECL_EXTENSION.equals(file
									.getFileExtension())
									&& (selectedEclFile == null || !selectedEclFile
											.getFullPath().equals(
													file.getFullPath()));
						}
						return true;
					}
				};
				final IFile[] files = WorkspaceResourceDialog
						.openFileSelection(workbenchWindow.getShell(), null,
								"Select ecl", true, null,
								Collections.singletonList(viewerFilter));
				if (files.length > 0) {
					ConcurrentTemplate.this.eclIFile = files[0];
					//txtPathEcore.setText(files[i].getFullPath().toOSString());
					ConcurrentTemplate.this.eclProjectPath = files[0].getProject().getFullPath().toString();
					return files[0].getFullPath().toString();
				}

				return null;
			}
		};
		
		dsaProjectLocationOption  = new AbstractStringWithButtonOption(this, KEY_ASPECTS, "DSA project") {

			@Override
			public String doSelectButton() {
				
				SelectDSAIProjectDialog dialog = new SelectDSAIProjectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
				dialog.open();
				
				Object[] selection = dialog.getResult();
				if(selection != null && selection.length > 0){
					dsaProjectName = ((IProject) selection[0]).getName();
					return dsaProjectName;
				}
				
				return null;
			}
		};
		dsaProjectLocationOption.setRequired(false);
		eclLocationOption.setRequired(false);
		registerOption(dsaProjectLocationOption, (String) null, 0);
		registerOption(eclLocationOption, (String) null, 0);
	}
	
	@Override
	public String getSectionId() {
		return "ConcurrentLanguage";
	}
	
	@Override
	public URL getTemplateLocation() {
		// Need to override to get the local Activator
		try {
			String[] candidates = getDirectoryCandidates();
			for (int i = 0; i < candidates.length; i++) {
				if (Activator.getDefault().getBundle().getEntry(candidates[i]) != null) {
					URL candidate = new URL(getInstallURL(), candidates[i]);
					return candidate;
				}
			}
		} catch (MalformedURLException e) { // do nothing
		}
		return null;
	}
	
	@Override
	protected URL getInstallURL() {
		// Need to override to get the local Activator
		return Activator.getDefault().getBundle().getEntry("/");
	}
	
	/** find the mapping properties file in the project and retrieves the aspectClasses
	 * 
	 * @param k3IProject
	 * @return
	 */
	public static Set<String> getAspectClassesList(IProject k3IProject){
		HashSet<String> aspectClasses = new HashSet<String>();
		FileFinderVisitor projectVisitor = new FileFinderVisitor("properties");
		try {
			//ResourcesPlugin.getWorkspace().getRoot().getProject(languageDefinition.getDsaProject().getProjectName());
			k3IProject.accept(projectVisitor);
			List<IFile> possibleAspectMappingPropertiesFiles = projectVisitor.getFiles();
			for(IFile aspectMappingPropertiesFile : possibleAspectMappingPropertiesFiles){
				if(aspectMappingPropertiesFile.getName().endsWith("k3_aspect_mapping.properties")){
					Properties properties = new Properties();
					if(aspectMappingPropertiesFile.exists()){
						try {
							properties.load(aspectMappingPropertiesFile.getContents());
							for(Object commaSeparatedPropvalues:properties.values()){
								for(String propVal :((String)commaSeparatedPropvalues).split(",")){
									aspectClasses.add(propVal);
								}
							}
						} catch (IOException e) {
							// ...
						} catch (CoreException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
		return aspectClasses;
	}
	
	@Override
	public void execute(IProject project, IProgressMonitor monitor)
			throws CoreException {
		
		//Replace KEY_ASPECTS' value (which is a project name) by a list of aspects 
		final String DEFAULT_VALUE = "/*\n *\twith qualified.class.name\n */\n";
		
		String selection = dsaProjectName;
		if(selection != null && !selection.isEmpty()){
			
			IProject dsaProject = ResourcesPlugin.getWorkspace().getRoot().getProject(selection);
			Set<String> aspects = getAspectClassesList(dsaProject);
			
			StringBuilder templateWith = new StringBuilder();
			if(aspects.isEmpty()){
				templateWith.append(DEFAULT_VALUE);
			}
			else{
				for(String aspect : aspects){
					templateWith.append("\twith "+aspect+"\n");
				}
			}
			dsaProjectLocationOption.setValue(templateWith.toString());
		}
		else{
			dsaProjectLocationOption.setValue(DEFAULT_VALUE);
		}
		
		//Then do the normal stuff
		super.execute(project, monitor);
	}
	
	@Override
	protected void generateFiles(IProgressMonitor monitor) throws CoreException {
		super.generateFiles(monitor);
		
		// now also fix the project configuration
		if(this.dsaProjectName != null && !this.dsaProjectName.isEmpty()){
			ManifestChanger manifestChanger;
			try {
				manifestChanger = new ManifestChanger(project.getFile("META-INF/MANIFEST.MF"));
				manifestChanger.addPluginDependency(this.dsaProjectName, "0.0.0", false, true);
				manifestChanger.commit();
			} catch (IOException | BundleException e) {
			}
		}
	}
}
