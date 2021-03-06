package org.gemoc.execution.concurrent.ccsljavaxdsml.api.dse;

import org.gemoc.execution.concurrent.ccsljavaxdsml.api.moc.ISolver;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;



public interface IMSEStateController
{

	void applyMSEFutureStates(ISolver solver);
	void forcePresenceInTheFuture(ModelSpecificEvent mse);
	void forceAbsenceTickInTheFuture(ModelSpecificEvent mse);
	void freeInTheFuture(ModelSpecificEvent mse);
	
}
