package org.gemoc.execution.concurrent.ccsljavaxdsml.ui.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.gemoc.execution.concurrent.ccsljavaxdsml.ui.wizards.pages.CreateDSAWizardPage;

public class CreateDSAWizard extends Wizard {

	protected CreateDSAWizardContextAction context;
	

	public CreateDSAWizard(CreateDSAWizardContextAction context) {
		super();
		this.setWindowTitle("Create DSA");
		//context = new CreateDSAWizardContextAction(updatedGemocLanguageProject);
		this.context = context;
		addPage(new CreateDSAWizardPage("Create DSA", context));
	}

	@Override
	public void addPages() {
		
		super.addPages();
	}

	@Override
	public boolean performFinish() {
		// do the selected actions now ...
		context.execute();
		return true;
	}
}
