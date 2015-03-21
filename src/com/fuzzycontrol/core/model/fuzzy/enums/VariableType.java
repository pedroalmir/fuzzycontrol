package com.fuzzycontrol.core.model.fuzzy.enums;

/**
 * @author Pedro Almir
 *
 */
public enum VariableType {
	REAL("Real");
	/**
	 * 
	 */
	private String description;

	/**
	 * @param description
	 */
	private VariableType(String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
