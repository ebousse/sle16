/*
* generated by Xtext
*/
package org.gemoc.gel.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.gemoc.gel.services.GELGrammarAccess;

public class GELParser extends AbstractContentAssistParser {
	
	@Inject
	private GELGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.gemoc.gel.ui.contentassist.antlr.internal.InternalGELParser createParser() {
		org.gemoc.gel.ui.contentassist.antlr.internal.InternalGELParser result = new org.gemoc.gel.ui.contentassist.antlr.internal.InternalGELParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getDomainSpecificEventAccess().getAlternatives(), "rule__DomainSpecificEvent__Alternatives");
					put(grammarAccess.getDomainSpecificEventReferenceOrPatternAccess().getAlternatives(), "rule__DomainSpecificEventReferenceOrPattern__Alternatives");
					put(grammarAccess.getDomainSpecificEventReferenceWithOrWithoutTargetAccess().getAlternatives(), "rule__DomainSpecificEventReferenceWithOrWithoutTarget__Alternatives");
					put(grammarAccess.getListOfArgumentsAccess().getAlternatives(), "rule__ListOfArguments__Alternatives");
					put(grammarAccess.getGNegationExpressionAccess().getAlternatives(), "rule__GNegationExpression__Alternatives");
					put(grammarAccess.getGReferenceExpressionAccess().getAlternatives(), "rule__GReferenceExpression__Alternatives");
					put(grammarAccess.getGPrimaryExpressionAccess().getAlternatives(), "rule__GPrimaryExpression__Alternatives");
					put(grammarAccess.getGNumericExpressionAccess().getAlternatives(), "rule__GNumericExpression__Alternatives");
					put(grammarAccess.getNavigationOperatorAccess().getAlternatives(), "rule__NavigationOperator__Alternatives");
					put(grammarAccess.getVisibilityAccess().getAlternatives(), "rule__Visibility__Alternatives");
					put(grammarAccess.getExecutionKindAccess().getAlternatives(), "rule__ExecutionKind__Alternatives");
					put(grammarAccess.getCallKindAccess().getAlternatives(), "rule__CallKind__Alternatives");
					put(grammarAccess.getGEqualityOperatorAccess().getAlternatives(), "rule__GEqualityOperator__Alternatives");
					put(grammarAccess.getGRelationOperatorAccess().getAlternatives(), "rule__GRelationOperator__Alternatives");
					put(grammarAccess.getGAdditionOperatorAccess().getAlternatives(), "rule__GAdditionOperator__Alternatives");
					put(grammarAccess.getGMultiplicationOperatorAccess().getAlternatives(), "rule__GMultiplicationOperator__Alternatives");
					put(grammarAccess.getGNegationOperatorAccess().getAlternatives(), "rule__GNegationOperator__Alternatives");
					put(grammarAccess.getDomainSpecificEventsSpecificationAccess().getGroup(), "rule__DomainSpecificEventsSpecification__Group__0");
					put(grammarAccess.getImportStatementAccess().getGroup(), "rule__ImportStatement__Group__0");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getGroup(), "rule__AtomicDomainSpecificEvent__Group__0");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getGroup_7(), "rule__AtomicDomainSpecificEvent__Group_7__0");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getGroup_7_2(), "rule__AtomicDomainSpecificEvent__Group_7_2__0");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getGroup_8(), "rule__AtomicDomainSpecificEvent__Group_8__0");
					put(grammarAccess.getCompositeDomainSpecificEventAccess().getGroup(), "rule__CompositeDomainSpecificEvent__Group__0");
					put(grammarAccess.getUnfoldingStrategyAccess().getGroup(), "rule__UnfoldingStrategy__Group__0");
					put(grammarAccess.getLocalVariableAccess().getGroup(), "rule__LocalVariable__Group__0");
					put(grammarAccess.getInstantiationPredicateAccess().getGroup(), "rule__InstantiationPredicate__Group__0");
					put(grammarAccess.getLogicalSequenceAccess().getGroup(), "rule__LogicalSequence__Group__0");
					put(grammarAccess.getLogicalSequenceAccess().getGroup_1(), "rule__LogicalSequence__Group_1__0");
					put(grammarAccess.getCoincidencePatternAccess().getGroup(), "rule__CoincidencePattern__Group__0");
					put(grammarAccess.getCoincidencePatternAccess().getGroup_1(), "rule__CoincidencePattern__Group_1__0");
					put(grammarAccess.getOrPatternAccess().getGroup(), "rule__OrPattern__Group__0");
					put(grammarAccess.getOrPatternAccess().getGroup_1(), "rule__OrPattern__Group_1__0");
					put(grammarAccess.getXorPatternAccess().getGroup(), "rule__XorPattern__Group__0");
					put(grammarAccess.getXorPatternAccess().getGroup_1(), "rule__XorPattern__Group_1__0");
					put(grammarAccess.getPlusPatternAccess().getGroup(), "rule__PlusPattern__Group__0");
					put(grammarAccess.getPlusPatternAccess().getGroup_1(), "rule__PlusPattern__Group_1__0");
					put(grammarAccess.getIterationPatternAccess().getGroup(), "rule__IterationPattern__Group__0");
					put(grammarAccess.getIterationPatternAccess().getGroup_1(), "rule__IterationPattern__Group_1__0");
					put(grammarAccess.getDomainSpecificEventReferenceOrPatternAccess().getGroup_1(), "rule__DomainSpecificEventReferenceOrPattern__Group_1__0");
					put(grammarAccess.getDomainSpecificEventReferenceAccess().getGroup(), "rule__DomainSpecificEventReference__Group__0");
					put(grammarAccess.getDomainSpecificEventReferenceWithArgumentsAccess().getGroup(), "rule__DomainSpecificEventReferenceWithArguments__Group__0");
					put(grammarAccess.getSingleArgumentAccess().getGroup(), "rule__SingleArgument__Group__0");
					put(grammarAccess.getMultipleArgumentsAccess().getGroup(), "rule__MultipleArguments__Group__0");
					put(grammarAccess.getFeedbackPolicyAccess().getGroup(), "rule__FeedbackPolicy__Group__0");
					put(grammarAccess.getFeedbackRuleAccess().getGroup(), "rule__FeedbackRule__Group__0");
					put(grammarAccess.getDefaultFeedbackRuleAccess().getGroup(), "rule__DefaultFeedbackRule__Group__0");
					put(grammarAccess.getFeedbackFilterAccess().getGroup(), "rule__FeedbackFilter__Group__0");
					put(grammarAccess.getFeedbackConsequenceAccess().getGroup(), "rule__FeedbackConsequence__Group__0");
					put(grammarAccess.getEclEventAccess().getGroup(), "rule__EclEvent__Group__0");
					put(grammarAccess.getKermeta3ExecutionFunctionAccess().getGroup(), "rule__Kermeta3ExecutionFunction__Group__0");
					put(grammarAccess.getKermeta3ExecutionFunctionAccess().getGroup_3(), "rule__Kermeta3ExecutionFunction__Group_3__0");
					put(grammarAccess.getExecutionFunctionResultAccess().getGroup(), "rule__ExecutionFunctionResult__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getGProgramAccess().getGroup(), "rule__GProgram__Group__0");
					put(grammarAccess.getGProgramAccess().getGroup_1(), "rule__GProgram__Group_1__0");
					put(grammarAccess.getGProgramAccess().getGroup_1_1(), "rule__GProgram__Group_1_1__0");
					put(grammarAccess.getGImportStatementAccess().getGroup(), "rule__GImportStatement__Group__0");
					put(grammarAccess.getGOrExpressionAccess().getGroup(), "rule__GOrExpression__Group__0");
					put(grammarAccess.getGOrExpressionAccess().getGroup_1(), "rule__GOrExpression__Group_1__0");
					put(grammarAccess.getGXorExpressionAccess().getGroup(), "rule__GXorExpression__Group__0");
					put(grammarAccess.getGXorExpressionAccess().getGroup_1(), "rule__GXorExpression__Group_1__0");
					put(grammarAccess.getGAndExpressionAccess().getGroup(), "rule__GAndExpression__Group__0");
					put(grammarAccess.getGAndExpressionAccess().getGroup_1(), "rule__GAndExpression__Group_1__0");
					put(grammarAccess.getGEqualityExpressionAccess().getGroup(), "rule__GEqualityExpression__Group__0");
					put(grammarAccess.getGEqualityExpressionAccess().getGroup_1(), "rule__GEqualityExpression__Group_1__0");
					put(grammarAccess.getGRelationExpressionAccess().getGroup(), "rule__GRelationExpression__Group__0");
					put(grammarAccess.getGRelationExpressionAccess().getGroup_1(), "rule__GRelationExpression__Group_1__0");
					put(grammarAccess.getGAdditionExpressionAccess().getGroup(), "rule__GAdditionExpression__Group__0");
					put(grammarAccess.getGAdditionExpressionAccess().getGroup_1(), "rule__GAdditionExpression__Group_1__0");
					put(grammarAccess.getGMultiplicationExpressionAccess().getGroup(), "rule__GMultiplicationExpression__Group__0");
					put(grammarAccess.getGMultiplicationExpressionAccess().getGroup_1(), "rule__GMultiplicationExpression__Group_1__0");
					put(grammarAccess.getGNegationExpressionAccess().getGroup_1(), "rule__GNegationExpression__Group_1__0");
					put(grammarAccess.getGNavigationExpressionAccess().getGroup(), "rule__GNavigationExpression__Group__0");
					put(grammarAccess.getGNavigationExpressionAccess().getGroup_1(), "rule__GNavigationExpression__Group_1__0");
					put(grammarAccess.getGReferenceExpressionAccess().getGroup_1(), "rule__GReferenceExpression__Group_1__0");
					put(grammarAccess.getGStringExpressionAccess().getGroup(), "rule__GStringExpression__Group__0");
					put(grammarAccess.getGBooleanExpressionAccess().getGroup(), "rule__GBooleanExpression__Group__0");
					put(grammarAccess.getGIntegerExpressionAccess().getGroup(), "rule__GIntegerExpression__Group__0");
					put(grammarAccess.getGDoubleExpressionAccess().getGroup(), "rule__GDoubleExpression__Group__0");
					put(grammarAccess.getGEnumLiteralExpressionAccess().getGroup(), "rule__GEnumLiteralExpression__Group__0");
					put(grammarAccess.getGIfExpressionAccess().getGroup(), "rule__GIfExpression__Group__0");
					put(grammarAccess.getGBraceExpressionAccess().getGroup(), "rule__GBraceExpression__Group__0");
					put(grammarAccess.getDomainSpecificEventsSpecificationAccess().getImportsAssignment_1(), "rule__DomainSpecificEventsSpecification__ImportsAssignment_1");
					put(grammarAccess.getDomainSpecificEventsSpecificationAccess().getEventsAssignment_2(), "rule__DomainSpecificEventsSpecification__EventsAssignment_2");
					put(grammarAccess.getImportStatementAccess().getImportURIAssignment_1(), "rule__ImportStatement__ImportURIAssignment_1");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getVisibilityAssignment_1(), "rule__AtomicDomainSpecificEvent__VisibilityAssignment_1");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getNameAssignment_3(), "rule__AtomicDomainSpecificEvent__NameAssignment_3");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getUponMoccEventAssignment_6(), "rule__AtomicDomainSpecificEvent__UponMoccEventAssignment_6");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getExecutionKindAssignment_7_0(), "rule__AtomicDomainSpecificEvent__ExecutionKindAssignment_7_0");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getExecutionFunctionAssignment_7_1(), "rule__AtomicDomainSpecificEvent__ExecutionFunctionAssignment_7_1");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getFeedbackPolicyAssignment_7_2_2(), "rule__AtomicDomainSpecificEvent__FeedbackPolicyAssignment_7_2_2");
					put(grammarAccess.getAtomicDomainSpecificEventAccess().getRaisedMoccEventAssignment_8_1(), "rule__AtomicDomainSpecificEvent__RaisedMoccEventAssignment_8_1");
					put(grammarAccess.getCompositeDomainSpecificEventAccess().getVisibilityAssignment_1(), "rule__CompositeDomainSpecificEvent__VisibilityAssignment_1");
					put(grammarAccess.getCompositeDomainSpecificEventAccess().getNameAssignment_3(), "rule__CompositeDomainSpecificEvent__NameAssignment_3");
					put(grammarAccess.getCompositeDomainSpecificEventAccess().getUnfoldingStrategyAssignment_5(), "rule__CompositeDomainSpecificEvent__UnfoldingStrategyAssignment_5");
					put(grammarAccess.getCompositeDomainSpecificEventAccess().getBodyAssignment_6(), "rule__CompositeDomainSpecificEvent__BodyAssignment_6");
					put(grammarAccess.getUnfoldingStrategyAccess().getLocalVariablesAssignment_3(), "rule__UnfoldingStrategy__LocalVariablesAssignment_3");
					put(grammarAccess.getUnfoldingStrategyAccess().getInstantiationPredicatesAssignment_7(), "rule__UnfoldingStrategy__InstantiationPredicatesAssignment_7");
					put(grammarAccess.getLocalVariableAccess().getNameAssignment_1(), "rule__LocalVariable__NameAssignment_1");
					put(grammarAccess.getLocalVariableAccess().getTypeAssignment_3(), "rule__LocalVariable__TypeAssignment_3");
					put(grammarAccess.getInstantiationPredicateAccess().getBodyAssignment_1(), "rule__InstantiationPredicate__BodyAssignment_1");
					put(grammarAccess.getLogicalSequenceAccess().getRightOperandAssignment_1_2(), "rule__LogicalSequence__RightOperandAssignment_1_2");
					put(grammarAccess.getCoincidencePatternAccess().getRightOperandAssignment_1_2(), "rule__CoincidencePattern__RightOperandAssignment_1_2");
					put(grammarAccess.getOrPatternAccess().getRightOperandAssignment_1_2(), "rule__OrPattern__RightOperandAssignment_1_2");
					put(grammarAccess.getXorPatternAccess().getRightOperandAssignment_1_2(), "rule__XorPattern__RightOperandAssignment_1_2");
					put(grammarAccess.getIterationPatternAccess().getNumberOfIterationsAssignment_1_2(), "rule__IterationPattern__NumberOfIterationsAssignment_1_2");
					put(grammarAccess.getDomainSpecificEventReferenceAccess().getReferencedDseAssignment_1(), "rule__DomainSpecificEventReference__ReferencedDseAssignment_1");
					put(grammarAccess.getDomainSpecificEventReferenceWithArgumentsAccess().getReferencedDseAssignment_1(), "rule__DomainSpecificEventReferenceWithArguments__ReferencedDseAssignment_1");
					put(grammarAccess.getDomainSpecificEventReferenceWithArgumentsAccess().getArgumentsAssignment_3(), "rule__DomainSpecificEventReferenceWithArguments__ArgumentsAssignment_3");
					put(grammarAccess.getSingleArgumentAccess().getArgumentAssignment_1(), "rule__SingleArgument__ArgumentAssignment_1");
					put(grammarAccess.getMultipleArgumentsAccess().getHeadAssignment_1(), "rule__MultipleArguments__HeadAssignment_1");
					put(grammarAccess.getMultipleArgumentsAccess().getTailAssignment_3(), "rule__MultipleArguments__TailAssignment_3");
					put(grammarAccess.getFeedbackPolicyAccess().getRulesAssignment_1(), "rule__FeedbackPolicy__RulesAssignment_1");
					put(grammarAccess.getFeedbackPolicyAccess().getDefaultRuleAssignment_2(), "rule__FeedbackPolicy__DefaultRuleAssignment_2");
					put(grammarAccess.getFeedbackRuleAccess().getFilterAssignment_2(), "rule__FeedbackRule__FilterAssignment_2");
					put(grammarAccess.getFeedbackRuleAccess().getConsequenceAssignment_5(), "rule__FeedbackRule__ConsequenceAssignment_5");
					put(grammarAccess.getDefaultFeedbackRuleAccess().getConsequenceAssignment_3(), "rule__DefaultFeedbackRule__ConsequenceAssignment_3");
					put(grammarAccess.getFeedbackFilterAccess().getBodyAssignment_1(), "rule__FeedbackFilter__BodyAssignment_1");
					put(grammarAccess.getFeedbackConsequenceAccess().getNavigationPathToMoccEventAssignment_2(), "rule__FeedbackConsequence__NavigationPathToMoccEventAssignment_2");
					put(grammarAccess.getEclEventAccess().getEventReferenceAssignment_1(), "rule__EclEvent__EventReferenceAssignment_1");
					put(grammarAccess.getKermeta3ExecutionFunctionAccess().getNavigationPathToOperationAssignment_1(), "rule__Kermeta3ExecutionFunction__NavigationPathToOperationAssignment_1");
					put(grammarAccess.getKermeta3ExecutionFunctionAccess().getCallKindAssignment_2(), "rule__Kermeta3ExecutionFunction__CallKindAssignment_2");
					put(grammarAccess.getKermeta3ExecutionFunctionAccess().getResultAssignment_3_1(), "rule__Kermeta3ExecutionFunction__ResultAssignment_3_1");
					put(grammarAccess.getExecutionFunctionResultAccess().getNameAssignment_1(), "rule__ExecutionFunctionResult__NameAssignment_1");
					put(grammarAccess.getGProgramAccess().getImportsAssignment_0(), "rule__GProgram__ImportsAssignment_0");
					put(grammarAccess.getGProgramAccess().getExpressionsAssignment_1_0(), "rule__GProgram__ExpressionsAssignment_1_0");
					put(grammarAccess.getGProgramAccess().getExpressionsAssignment_1_1_1(), "rule__GProgram__ExpressionsAssignment_1_1_1");
					put(grammarAccess.getGImportStatementAccess().getImportURIAssignment_1(), "rule__GImportStatement__ImportURIAssignment_1");
					put(grammarAccess.getGOrExpressionAccess().getOperatorAssignment_1_1(), "rule__GOrExpression__OperatorAssignment_1_1");
					put(grammarAccess.getGOrExpressionAccess().getRightOperandAssignment_1_2(), "rule__GOrExpression__RightOperandAssignment_1_2");
					put(grammarAccess.getGXorExpressionAccess().getOperatorAssignment_1_1(), "rule__GXorExpression__OperatorAssignment_1_1");
					put(grammarAccess.getGXorExpressionAccess().getRightOperandAssignment_1_2(), "rule__GXorExpression__RightOperandAssignment_1_2");
					put(grammarAccess.getGAndExpressionAccess().getOperatorAssignment_1_1(), "rule__GAndExpression__OperatorAssignment_1_1");
					put(grammarAccess.getGAndExpressionAccess().getRightOperandAssignment_1_2(), "rule__GAndExpression__RightOperandAssignment_1_2");
					put(grammarAccess.getGEqualityExpressionAccess().getOperatorAssignment_1_1(), "rule__GEqualityExpression__OperatorAssignment_1_1");
					put(grammarAccess.getGEqualityExpressionAccess().getRightOperandAssignment_1_2(), "rule__GEqualityExpression__RightOperandAssignment_1_2");
					put(grammarAccess.getGRelationExpressionAccess().getOperatorAssignment_1_1(), "rule__GRelationExpression__OperatorAssignment_1_1");
					put(grammarAccess.getGRelationExpressionAccess().getRightOperandAssignment_1_2(), "rule__GRelationExpression__RightOperandAssignment_1_2");
					put(grammarAccess.getGAdditionExpressionAccess().getOperatorAssignment_1_1(), "rule__GAdditionExpression__OperatorAssignment_1_1");
					put(grammarAccess.getGAdditionExpressionAccess().getRightOperandAssignment_1_2(), "rule__GAdditionExpression__RightOperandAssignment_1_2");
					put(grammarAccess.getGMultiplicationExpressionAccess().getOperatorAssignment_1_1(), "rule__GMultiplicationExpression__OperatorAssignment_1_1");
					put(grammarAccess.getGMultiplicationExpressionAccess().getRightOperandAssignment_1_2(), "rule__GMultiplicationExpression__RightOperandAssignment_1_2");
					put(grammarAccess.getGNegationExpressionAccess().getOperatorAssignment_1_1(), "rule__GNegationExpression__OperatorAssignment_1_1");
					put(grammarAccess.getGNegationExpressionAccess().getOperandAssignment_1_2(), "rule__GNegationExpression__OperandAssignment_1_2");
					put(grammarAccess.getGNavigationExpressionAccess().getReferencedEObjectAssignment_1_2(), "rule__GNavigationExpression__ReferencedEObjectAssignment_1_2");
					put(grammarAccess.getGReferenceExpressionAccess().getReferencedEObjectAssignment_1_1(), "rule__GReferenceExpression__ReferencedEObjectAssignment_1_1");
					put(grammarAccess.getGStringExpressionAccess().getValueAssignment_1(), "rule__GStringExpression__ValueAssignment_1");
					put(grammarAccess.getGBooleanExpressionAccess().getValueAssignment_1(), "rule__GBooleanExpression__ValueAssignment_1");
					put(grammarAccess.getGIntegerExpressionAccess().getValueAssignment_1(), "rule__GIntegerExpression__ValueAssignment_1");
					put(grammarAccess.getGDoubleExpressionAccess().getValueAssignment_1(), "rule__GDoubleExpression__ValueAssignment_1");
					put(grammarAccess.getGEnumLiteralExpressionAccess().getValueAssignment_2(), "rule__GEnumLiteralExpression__ValueAssignment_2");
					put(grammarAccess.getGIfExpressionAccess().getConditionAssignment_2(), "rule__GIfExpression__ConditionAssignment_2");
					put(grammarAccess.getGIfExpressionAccess().getThenExpressionAssignment_4(), "rule__GIfExpression__ThenExpressionAssignment_4");
					put(grammarAccess.getGIfExpressionAccess().getElseExpressionAssignment_6(), "rule__GIfExpression__ElseExpressionAssignment_6");
					put(grammarAccess.getGBraceExpressionAccess().getInnerExpressionAssignment_2(), "rule__GBraceExpression__InnerExpressionAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.gemoc.gel.ui.contentassist.antlr.internal.InternalGELParser typedParser = (org.gemoc.gel.ui.contentassist.antlr.internal.InternalGELParser) parser;
			typedParser.entryRuleDomainSpecificEventsSpecification();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public GELGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(GELGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
