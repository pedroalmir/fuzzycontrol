/**
 * 
 */
package com.fuzzycontrol.core.model.fuzzy.put;

import java.util.ArrayList;
import java.util.List;

import com.fuzzycontrol.core.model.fuzzy.FuzzyTerm;
import com.fuzzycontrol.core.model.fuzzy.enums.DefuzzificationMethod;
import com.fuzzycontrol.core.model.fuzzy.enums.VariableType;

/**
 * @author Pedro Almir
 *
 */
public class Output {
	private String name;
	private VariableType type;
	private List<FuzzyTerm> terms;
	private DefuzzificationMethod defuzzificationMethod;
	private String defaultValue;
	
	/**
	 * Default constructor
	 */
	public Output() {
		this.terms = new ArrayList<FuzzyTerm>();
	}
	
	/**
	 * @param name
	 * @param type
	 * @param terms
	 * @param defuzzificationMethod
	 * @param defaultValue
	 */
	public Output(String name, VariableType type, List<FuzzyTerm> terms, DefuzzificationMethod defuzzificationMethod, String defaultValue) {
		this.name = name;
		this.type = type;
		this.terms = terms;
		this.defuzzificationMethod = defuzzificationMethod;
		this.defaultValue = defaultValue;
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
	/**
	 * @return the defuzzificationMethod
	 */
	public DefuzzificationMethod getDefuzzificationMethod() {
		return defuzzificationMethod;
	}
	/**
	 * @param defuzzificationMethod the defuzzificationMethod to set
	 */
	public void setDefuzzificationMethod(DefuzzificationMethod defuzzificationMethod) {
		this.defuzzificationMethod = defuzzificationMethod;
	}
	/**
	 * @return the defaultValue
	 */
	public String getDefaultValue() {
		return defaultValue;
	}
	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Output [name=" + name + ", type=" + type + ", terms=" + terms
				+ ", defuzzificationMethod=" + defuzzificationMethod
				+ ", defaultValue=" + defaultValue + "]";
	}
}
