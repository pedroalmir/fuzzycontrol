/**
 * 
 */
package com.fuzzycontrol.core.controller.fuzzy;

import java.util.List;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierCenterOfArea;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import com.fuzzycontrol.core.controller.base.FuzzyControlInterface;
import com.fuzzycontrol.core.model.fuzzy.FuzzyControl;
import com.fuzzycontrol.core.model.fuzzy.FuzzyCoordinate;
import com.fuzzycontrol.core.model.fuzzy.FuzzySystem;
import com.fuzzycontrol.core.model.fuzzy.FuzzyTerm;
import com.fuzzycontrol.core.model.fuzzy.enums.MembershipFunctionEnum;
import com.fuzzycontrol.core.model.fuzzy.exception.InvalidParametersSizeException;
import com.fuzzycontrol.core.model.fuzzy.exception.MembershipFunctionInstantiationException;
import com.fuzzycontrol.core.model.fuzzy.put.Input;
import com.fuzzycontrol.core.model.fuzzy.put.Output;

/**
 * @author Pedro Almir
 *
 */
public class FuzzyController implements FuzzyControlInterface {

	@Override
	public FIS createFuzzySystem(FuzzySystem fuzzySystem) throws InvalidParametersSizeException, MembershipFunctionInstantiationException {
		FIS system = new FIS();
		for (FuzzyControl control : fuzzySystem.getControls())
			system.addFunctionBlock(control.getName(), createFuzzyControl(control, system));
		return system;
	}

	@Override
	public FunctionBlock createFuzzyControl(FuzzyControl fuzzyControl, FIS fis) throws InvalidParametersSizeException, MembershipFunctionInstantiationException {
		FunctionBlock functionBlock = new FunctionBlock(fis);
		functionBlock.setName(fuzzyControl.getName());
		for (Input input : fuzzyControl.getInputs())
			functionBlock.setVariable(input.getName(), createInput(input));
		for (Output output : fuzzyControl.getOutputs())
			functionBlock.setVariable(output.getName(), createOutput(output));
		//FIXME - What about rules???
		return functionBlock;
	}

	@Override
	public Variable createOutput(Output output) throws InvalidParametersSizeException, MembershipFunctionInstantiationException {
		Variable outputVar = new Variable(output.getName());
		outputVar.setDefuzzifier(new DefuzzifierCenterOfArea(outputVar));//FIXME - Set deffuzifier dynamic
		outputVar.setDefaultValue(Double.valueOf(output.getDefaultValue()));
		for (FuzzyTerm term : output.getTerms()) {
			outputVar.add(createTerm(term));
		}
		return outputVar;
	}

	@Override
	public Variable createInput(Input input) throws InvalidParametersSizeException, MembershipFunctionInstantiationException {
		Variable inputVar = new Variable(input.getName());
		for (FuzzyTerm term : input.getTerms()) {
			inputVar.add(createTerm(term));
		}
		return inputVar;
	}

	@Override
	public LinguisticTerm createTerm(FuzzyTerm fuzzyTerm) throws InvalidParametersSizeException, MembershipFunctionInstantiationException {
		return new LinguisticTerm(fuzzyTerm.getName(), createMembershipFunction(fuzzyTerm.getFunction(), fuzzyTerm.getParams()));
	}

	@Override
	public MembershipFunction createMembershipFunction(MembershipFunctionEnum function, List<FuzzyCoordinate> params) throws InvalidParametersSizeException, MembershipFunctionInstantiationException {
		return function.createMembershipFunction(params);
	}

}