/**
 * 
 */
package com.fuzzycontrol.core.model.fuzzy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pedro Almir
 *
 */
public class FuzzySystem {
	private String name;
	private String description;
	private List<FuzzyControl> controls;
	
	/**
	 * Default constructor
	 */
	public FuzzySystem() {
		this.controls = new ArrayList<FuzzyControl>();
	}
	
	/**
	 * @param name
	 * @param description
	 */
	public FuzzySystem(String name, String description) {
		this.name = name;
		this.description = description;
		this.controls = new ArrayList<FuzzyControl>();
	}
	
	/**
	 * @param fuzzyControl
	 */
	public void addFuzzyControl(FuzzyControl fuzzyControl){
		this.controls.add(fuzzyControl);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FuzzySystem [name=" + name + ", description=" + description + "]";
	}

	/**
	 * @return the controls
	 */
	public List<FuzzyControl> getControls() {
		return controls;
	}

	/**
	 * @param controls the controls to set
	 */
	public void setControls(List<FuzzyControl> controls) {
		this.controls = controls;
	}
}
