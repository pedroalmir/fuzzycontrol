/**
 * 
 */
package com.fuzzycontrol.core.model.fuzzy;

import java.util.ArrayList;
import java.util.List;

import com.fuzzycontrol.core.model.fuzzy.enums.MembershipFunctionEnum;

/**
 * @author Pedro Almir
 *
 */
public class FuzzyTerm {
	private String name;
	private MembershipFunctionEnum function;
	private List<FuzzyCoordinate> params;
	
	/**
	 * Default constructor
	 */
	public FuzzyTerm() {
		this.params = new ArrayList<FuzzyCoordinate>();
	}
	
	/**
	 * @param name
	 * @param function
	 * @param params
	 */
	public FuzzyTerm(String name, MembershipFunctionEnum function, List<FuzzyCoordinate> params) {
		this.name = name;
		this.function = function;
		this.params = params;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the function
	 */
	public MembershipFunctionEnum getFunction() {
		return function;
	}
	
	/**
	 * @param function the function to set
	 */
	public void setFunction(MembershipFunctionEnum function) {
		this.function = function;
	}
	
	/**
	 * @return the params
	 */
	public List<FuzzyCoordinate> getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(List<FuzzyCoordinate> params) {
		this.params = params;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FuzzyTerm [name=" + name + ", function=" + function + ", params=" + params + "]";
	}
}