/**
 * 
 */
package com.fuzzycontrol.core.controller.fuzzy;

import java.util.List;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import com.fuzzycontrol.core.controller.base.FuzzyControlInterface;
import com.fuzzycontrol.core.model.fuzzy.FuzzyCoordinate;
import com.fuzzycontrol.core.model.fuzzy.FuzzySystem;
import com.fuzzycontrol.core.model.fuzzy.FuzzyTerm;
import com.fuzzycontrol.core.model.fuzzy.enums.DefuzzificationMethod;
import com.fuzzycontrol.core.model.fuzzy.enums.MembershipFunctionEnum;
import com.fuzzycontrol.core.model.fuzzy.enums.VariableType;
import com.fuzzycontrol.core.model.fuzzy.exception.InvalidParametersSizeException;
import com.fuzzycontrol.core.model.fuzzy.exception.MembershipFunctionInstantiationException;
import com.fuzzycontrol.core.model.fuzzy.put.Input;

/**
 * @author Pedro Almir
 *
 */
public class FuzzyController implements FuzzyControlInterface {

	@Override
	public FIS createSystem(FuzzySystem system) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFuzzyControl(FIS fis, String name, FunctionBlock control) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FunctionBlock createFuzzyControl(FIS fis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInput(FunctionBlock control, Variable input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOutput(FunctionBlock control, Variable output) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Variable createOutput(String name, VariableType variableType,
			DefuzzificationMethod defuzzificationMethod, String defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addInputTerm(Variable input, LinguisticTerm term) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOutputTerm(Variable output, LinguisticTerm term) {
		// TODO Auto-generated method stub
		
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