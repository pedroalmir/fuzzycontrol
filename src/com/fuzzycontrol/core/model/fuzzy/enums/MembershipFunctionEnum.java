/**
 * 
 */
package com.fuzzycontrol.core.model.fuzzy.enums;

import java.util.List;

import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTrapetzoidal;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular;
import net.sourceforge.jFuzzyLogic.membership.Value;

import com.fuzzycontrol.core.model.fuzzy.FuzzyCoordinate;
import com.fuzzycontrol.core.model.fuzzy.exception.InvalidParametersSizeException;
import com.fuzzycontrol.core.model.fuzzy.exception.MembershipFunctionInstantiationException;

/**
 * @author Pedro Almir
 */
public enum MembershipFunctionEnum {
	
	/**
	 * Represents the TRIANGULAR function and wait for parameters <code>min</code>, <code>mid</code>, <code>max</code>
	 */
	TRIANGULAR(3) {
		
		@Override
		public MembershipFunction createMembershipFunction(List<FuzzyCoordinate> params) throws InvalidParametersSizeException, MembershipFunctionInstantiationException {
			validateParametersSize(this.getParamsNumber(), params);
			return defaultInstantiation(MembershipFunctionTriangular.class, params);
		}

	}, 
	
	/**
	 * Represents the TRAPETZOIDAL function and wait for parameters <code>min</code>, <code>midLow</code>, <code>midHigh</code>, <code>max</code>
	 */
	TRAPETZOIDAL(4) {
		
		@Override
		public MembershipFunction createMembershipFunction(List<FuzzyCoordinate> params) throws InvalidParametersSizeException, MembershipFunctionInstantiationException {
			validateParametersSize(this.getParamsNumber(), params);	
			return defaultInstantiation(MembershipFunctionTrapetzoidal.class, params);
		}
		
	};
	
	private int paramsNumber;
	
	private MembershipFunctionEnum(int paramsNumber) {
		this.paramsNumber = paramsNumber;
	}
	
	/**
	 * Definition of the method responsible for creating a MembershipFunction
	 * @param params - <code>params</code> list
	 * @return - A instance of MembershipFunction
	 * @throws InvalidParametersSizeException
	 * @throws MembershipFunctionInstantiationException
	 */
	public abstract MembershipFunction createMembershipFunction(List<FuzzyCoordinate> params) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
	
	/**
	 * Define the format for invalid parameter size message
	 * @return - the format
	 */
	public static String getInvalidParameterSizeMessageFormat() {
		return "The method expect %d parameters, but got %d";
	}
	
	/**
	 * Verify if the size of <code>params</code> list is valid
	 * @param expected - expected size for <code>params</code> list 
	 * @param params - <code>params</code> list
	 * @throws InvalidParametersSizeException
	 */
	private static void validateParametersSize(int expected, List<FuzzyCoordinate> params) throws InvalidParametersSizeException {
		if (params == null || params.size() != expected)
			throw new InvalidParametersSizeException(String.format(getInvalidParameterSizeMessageFormat(), expected, params.size()));
	}
	
	/**
	 * Instance a SubClass of MembershipFunction through the constructor that waits for instances of <code>Value</code> class
	 * @param clazz - subClass of MembershipFunction
	 * @param params - <code>params</code> list
	 * @return an instance of <code>clazz</code>
	 * @throws MembershipFunctionInstantiationException
	 */
	private static MembershipFunction defaultInstantiation(Class<? extends MembershipFunction> clazz, List<FuzzyCoordinate> params) throws MembershipFunctionInstantiationException {
		Class<?>[] classes = new Class[params.size()];
		Value[] values = new Value[params.size()];
		for (FuzzyCoordinate param : params) {
			classes[params.indexOf(param)] = Value.class;
			values[params.indexOf(param)] = new Value(param.getX());
		}
		
		try {
			return clazz.getConstructor(classes).newInstance((Object[])values);
		} catch (Exception ex) {
			throw new MembershipFunctionInstantiationException(ex.getMessage());
		}
	}
	
	/*Getters & Setters*/
	public int getParamsNumber() {
		return paramsNumber;
	}
	
}