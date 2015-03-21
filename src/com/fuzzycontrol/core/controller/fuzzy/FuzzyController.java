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
import com.fuzzycontrol.core.model.fuzzy.FuzzySystem;
import com.fuzzycontrol.core.model.fuzzy.enums.DefuzzificationMethod;
import com.fuzzycontrol.core.model.fuzzy.enums.MembershipFunctionEnum;
import com.fuzzycontrol.core.model.fuzzy.enums.VariableType;

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
	public Variable createInput(String name, VariableType variableType) {
		// TODO Auto-generated method stub
		return null;
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
	public LinguisticTerm createTerm(String name, MembershipFunction function) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembershipFunction createMembershipFunction(MembershipFunctionEnum function, List<String> params) {
		//FIXME - TO BE CONTINUED... 
		return function.createMembershipFunction(params);
	}


}
