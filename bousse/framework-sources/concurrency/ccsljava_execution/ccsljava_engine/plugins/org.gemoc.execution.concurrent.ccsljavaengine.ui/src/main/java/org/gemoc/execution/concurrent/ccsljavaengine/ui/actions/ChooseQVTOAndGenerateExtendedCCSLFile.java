package org.gemoc.execution.concurrent.ccsljavaengine.ui.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.Dialog;
import org.gemoc.commons.eclipse.ui.dialogs.SelectAnyIFileDialog;

public class ChooseQVTOAndGenerateExtendedCCSLFile extends GenerateExtendedCCSLFileAction
{

	/**
	 * Constructor for Action1.
	 */
	public ChooseQVTOAndGenerateExtendedCCSLFile() {
		super();
	}

	@Override
	protected String getTransformationURI() {
		SelectAnyIFileDialog dialog = new SelectAnyIFileDialog();
		dialog.setPattern("*.qvto");
		if (dialog.open() == Dialog.OK)
			return "platform:/resource" + ((IResource) dialog.getResult()[0]).getFullPath().toString();
		return null;
	}
	
	@Override
	protected String getMoCFileExtension() {
		return "extendedCCSL";
	}

}
