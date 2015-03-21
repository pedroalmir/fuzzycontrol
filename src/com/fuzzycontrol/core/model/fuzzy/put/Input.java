/**
 * 
 */
package com.fuzzycontrol.core.model.fuzzy.put;

import java.util.ArrayList;
import java.util.List;

import com.fuzzycontrol.core.model.fuzzy.FuzzyTerm;
import com.fuzzycontrol.core.model.fuzzy.enums.VariableType;

/**
 * @author Pedro Almir
 */
public class Input {
	private String name;
	private VariableType type;
	private List<FuzzyTerm> terms;
	
	/**
	 * Default constructor
	 */
	public Input() {
		this.terms = new ArrayList<FuzzyTerm>();
	}
	
	/**
	 * @param name
	 * @param type
	 * @param terms
	 */
	public Input(String name, VariableType type, List<FuzzyTerm> terms) {
		this.name = name;
		this.type = type;
		this.terms = terms;
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
	 * @return the type
	 */
	public VariableType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(VariableType type) {
		this.type = type;
	}
	/**
	 * @return the terms
	 */
	public List<FuzzyTerm> getTerms() {
		return terms;
	}
	/**
	 * @param terms the terms to set
	 */
	public void setTerms(List<FuzzyTerm> terms) {
		this.terms = terms;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Input [name=" + name + ", type=" + type + ", terms=" + terms + "]";
	}
}
