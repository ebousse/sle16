package org.gemoc.execution.concurrent.ccsljavaxdsml.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IProject;
import org.gemoc.xdsmlframework.ide.ui.commands.AbstractMelangeSelectHandler;
import org.gemoc.xdsmlframework.ide.ui.xdsml.wizards.CreateAnimatorProjectWizardContextAction;
import org.gemoc.xdsmlframework.ide.ui.xdsml.wizards.CreateAnimatorProjectWizardContextAction.CreateAnimatorProjectAction;

import fr.inria.diverse.melange.metamodel.melange.Language;

public class CreateAnimatorProjectHandler extends AbstractMelangeSelectHandler implements
		IHandler {

	@Override
	public Object executeForSelectedLanguage(ExecutionEvent event,
			IProject updatedGemocLanguageProject, Language language) throws ExecutionException {
		
		
		CreateAnimatorProjectWizardContextAction action = new CreateAnimatorProjectWizardContextAction(
				updatedGemocLanguageProject, language);
		action.actionToExecute = CreateAnimatorProjectAction.CREATE_NEW_SIRIUS_PROJECT;
		action.execute();
		return null;
	}
	
	@Override
	public String getSelectionMessage() {
		return "Select Melange language that will be used to initialize the new Animator project";
	}
}
