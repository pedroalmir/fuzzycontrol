package com.fuzzycontrol.core.controller.base;

import java.util.List;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

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
public interface FuzzyControlInterface {
	
	//TODO - To Comment
	
	FIS createFuzzySystem(FuzzySystem fuzzySystem) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
	FunctionBlock createFuzzyControl(FuzzyControl fuzzyControl, FIS fis) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
	Variable createOutput(Output output) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
	Variable createInput(Input input) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
	LinguisticTerm createTerm(FuzzyTerm fuzzyTerm) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
	MembershipFunction createMembershipFunction(MembershipFunctionEnum function, List<FuzzyCoordinate> params) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
	
}
