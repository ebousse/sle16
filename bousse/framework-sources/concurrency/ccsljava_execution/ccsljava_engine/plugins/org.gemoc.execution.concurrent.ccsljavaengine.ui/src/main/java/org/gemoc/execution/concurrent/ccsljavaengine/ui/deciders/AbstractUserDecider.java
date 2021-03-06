package org.gemoc.execution.concurrent.ccsljavaengine.ui.deciders;

import java.util.List;
import java.util.concurrent.Semaphore;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener2;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.concurrent.ccsljavaengine.ui.SharedIcons;
import org.gemoc.execution.concurrent.ccsljavaengine.ui.views.step.LogicalStepsView;
import org.gemoc.execution.concurrent.ccsljavaxdsml.api.core.IConcurrentExecutionEngine;
import org.gemoc.execution.concurrent.ccsljavaxdsml.api.core.ILogicalStepDecider;

import fr.inria.diverse.trace.commons.model.trace.Step;

public abstract class AbstractUserDecider implements ILogicalStepDecider 
{

	public AbstractUserDecider() 
	{
		super();
	}
	
	private Step _selectedLogicalStep;

	private Semaphore _semaphore = null;

	@Override
	public Step decide(final IConcurrentExecutionEngine engine, final List<Step> possibleLogicalSteps)
			throws InterruptedException {
		_preemptionHappened = false;
		_semaphore = new Semaphore(0);
		if(!isStepByStep() 
			&& engine.getPossibleLogicalSteps().size() == 1) 
			return possibleLogicalSteps.get(0);

		decisionView = ViewHelper.<LogicalStepsView>retrieveView(LogicalStepsView.ID);
		
		// add action into view menu
		IMenuListener2 menuListener = new IMenuListener2() 
		{
		
			private Action _action = null;
						
			public void menuAboutToShow(IMenuManager manager) 
			{
				if (_action == null
					&& decisionView.getSelectedLogicalStep() != null
					&& engine.getPossibleLogicalSteps().contains(decisionView.getSelectedLogicalStep())) 
				{
					_action = createAction();
				}
				if (decisionView.getSelectedLogicalStep() != null
					&& _action != null)
					manager.add(_action);
			}

			public void menuAboutToHide(IMenuManager manager) 
			{
				if (_action != null)
					manager.remove(_action.getId());
			}
		};
		decisionView.addMenuListener(menuListener);
		
		// add action on double click
		IDoubleClickListener doubleClickListener = new IDoubleClickListener() 
		{
			public void doubleClick(DoubleClickEvent event) 
			{
				if (decisionView.getSelectedLogicalStep() != null
					&& engine.getPossibleLogicalSteps().contains(decisionView.getSelectedLogicalStep())) 
				{
					Action selectLogicalStepAction = new Action() 
					{
						public void run() 
						{
							_selectedLogicalStep = decisionView.getSelectedLogicalStep();
							_semaphore.release();
						}
					};
					selectLogicalStepAction.run();
				}
			}
		};
		decisionView.addDoubleClickListener(doubleClickListener);
		
		
		// wait for user selection if it applies to this engine
		_semaphore.acquire();
		_semaphore = null;
		// clean menu listener
		decisionView.removeMenuListener(menuListener);
		decisionView.removeDoubleClickListener(doubleClickListener);
		if (_preemptionHappened)
			return null;
		return _selectedLogicalStep;
	}

	private LogicalStepsView decisionView;

	@Override
	public void dispose() {
		if (_semaphore != null)
			_semaphore.release();
	}

	private boolean _preemptionHappened = false;
	@Override
	public void preempt() 
	{
		_preemptionHappened = true;
		if (_semaphore != null)
			_semaphore.release();
	}
	
	private Action createAction() {
		
		Action selectLogicalStepAction = new Action() 
		{
			public void run() 
			{
				_selectedLogicalStep = decisionView.getSelectedLogicalStep();
				_semaphore.release();
			}
		};
		selectLogicalStepAction.setId("org.gemoc.executionframework.engine.io.commands.SelectLogicalStep");
		selectLogicalStepAction.setText("Select LogicalStep");
		selectLogicalStepAction.setToolTipText("Use selected LogicalStep");
		selectLogicalStepAction.setImageDescriptor(SharedIcons.LOGICALSTEP_ICON);
		return selectLogicalStepAction;
	}

	public abstract boolean isStepByStep();

	public void decideFromTimeLine(Step logicalStep)
	{
		_selectedLogicalStep = logicalStep;
		if (_semaphore != null)
			_semaphore.release();
	}
	
}
