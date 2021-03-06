/**
 */
package org.gemoc.execution.concurrent.ccsljavaxdsml.concurrent_xdsml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.gemoc.execution.concurrent.ccsljavaxdsml.concurrent_xdsml.Concurrent_xdsmlPackage;
import org.gemoc.execution.concurrent.ccsljavaxdsml.concurrent_xdsml.DSEProject;
import org.gemoc.executionframework.xdsml_base.impl.ProjectResourceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DSE Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.execution.concurrent.ccsljavaxdsml.concurrent_xdsml.impl.DSEProjectImpl#getQvtoURI <em>Qvto URI</em>}</li>
 *   <li>{@link org.gemoc.execution.concurrent.ccsljavaxdsml.concurrent_xdsml.impl.DSEProjectImpl#getSolverClass <em>Solver Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DSEProjectImpl extends ProjectResourceImpl implements DSEProject {
	/**
	 * The default value of the '{@link #getQvtoURI() <em>Qvto URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtoURI()
	 * @generated
	 * @ordered
	 */
	protected static final String QVTO_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQvtoURI() <em>Qvto URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtoURI()
	 * @generated
	 * @ordered
	 */
	protected String qvtoURI = QVTO_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSolverClass() <em>Solver Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolverClass()
	 * @generated
	 * @ordered
	 */
	protected static final String SOLVER_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSolverClass() <em>Solver Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolverClass()
	 * @generated
	 * @ordered
	 */
	protected String solverClass = SOLVER_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DSEProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Concurrent_xdsmlPackage.Literals.DSE_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQvtoURI() {
		return qvtoURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtoURI(String newQvtoURI) {
		String oldQvtoURI = qvtoURI;
		qvtoURI = newQvtoURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Concurrent_xdsmlPackage.DSE_PROJECT__QVTO_URI, oldQvtoURI, qvtoURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSolverClass() {
		return solverClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolverClass(String newSolverClass) {
		String oldSolverClass = solverClass;
		solverClass = newSolverClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Concurrent_xdsmlPackage.DSE_PROJECT__SOLVER_CLASS, oldSolverClass, solverClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Concurrent_xdsmlPackage.DSE_PROJECT__QVTO_URI:
				return getQvtoURI();
			case Concurrent_xdsmlPackage.DSE_PROJECT__SOLVER_CLASS:
				return getSolverClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Concurrent_xdsmlPackage.DSE_PROJECT__QVTO_URI:
				setQvtoURI((String)newValue);
				return;
			case Concurrent_xdsmlPackage.DSE_PROJECT__SOLVER_CLASS:
				setSolverClass((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Concurrent_xdsmlPackage.DSE_PROJECT__QVTO_URI:
				setQvtoURI(QVTO_URI_EDEFAULT);
				return;
			case Concurrent_xdsmlPackage.DSE_PROJECT__SOLVER_CLASS:
				setSolverClass(SOLVER_CLASS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Concurrent_xdsmlPackage.DSE_PROJECT__QVTO_URI:
				return QVTO_URI_EDEFAULT == null ? qvtoURI != null : !QVTO_URI_EDEFAULT.equals(qvtoURI);
			case Concurrent_xdsmlPackage.DSE_PROJECT__SOLVER_CLASS:
				return SOLVER_CLASS_EDEFAULT == null ? solverClass != null : !SOLVER_CLASS_EDEFAULT.equals(solverClass);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (qvtoURI: ");
		result.append(qvtoURI);
		result.append(", solverClass: ");
		result.append(solverClass);
		result.append(')');
		return result.toString();
	}

} //DSEProjectImpl
