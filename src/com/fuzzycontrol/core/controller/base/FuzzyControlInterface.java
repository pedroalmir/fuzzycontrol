/**
 * 
 */
package com.fuzzycontrol.core.controller.base;

import java.util.List;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;

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
public interface FuzzyControlInterface {
	/**
	 * @param name
	 * @param description
	 * @return FuzzySytem
	 */
	FIS createSystem(FuzzySystem system);
	
	/**
	 * @param system
	 * @param control
	 */
	void addFuzzyControl(FIS fis, String name, FunctionBlock control);
	
	/**
	 * @param name
	 * @param description
	 * @return FuzzyControl
	 */
	FunctionBlock createFuzzyControl(FIS fis);
	/**
	 * @param control
	 * @param input
	 */
	void addInput(FunctionBlock control, Variable input);
	/**
	 * @param control
	 * @param output
	 */
	void addOutput(FunctionBlock control, Variable output);
	
	/**
	 * @param name
	 * @param variableType
	 * @param defuzzificationMethod
	 * @param defaultValue
	 * @return Output
	 */
	Variable createOutput(String name, VariableType variableType, DefuzzificationMethod defuzzificationMethod, String defaultValue);
	
	/**
	 * @param input
	 * @param term
	 */
	void addInputTerm(Variable input, LinguisticTerm term);
	/**
	 * @param output
	 * @param term
	 */
	void addOutputTerm(Variable output, LinguisticTerm term);
	
	//TODO - To Comment
	
	Variable createInput(Input input) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
	LinguisticTerm createTerm(FuzzyTerm fuzzyTerm) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
	MembershipFunction createMembershipFunction(MembershipFunctionEnum function, List<FuzzyCoordinate> params) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
}
