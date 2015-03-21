/**
 * 
 */
package com.fuzzycontrol.core.model.fuzzy;

import java.util.ArrayList;
import java.util.List;

import com.fuzzycontrol.core.model.fuzzy.put.Input;
import com.fuzzycontrol.core.model.fuzzy.put.Output;

/**
 * @author Pedro Almir
 *
 */
public class FuzzyControl {
	private String name;
	private String description;
	private List<Input> inputs;
	private List<Output> outputs;
	
	/**
	 * Default constructor
	 */
	public FuzzyControl() {
		this.inputs = new ArrayList<Input>();
		this.outputs = new ArrayList<Output>();
	}
	
	/**
	 * @param name
	 * @param description
	 */
	public FuzzyControl(String name, String description) {
		this.name = name;
		this.description = description;
		this.inputs = new ArrayList<Input>();
		this.outputs = new ArrayList<Output>();
	}
	
	/**
	 * @param input
	 */
	public void addInput(Input input){
		this.inputs.add(input);
	}
	
	/**
	 * @param output
	 */
	public void addOutput(Output output){
		this.outputs.add(output);
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
	/**
	 * @return the inputs
	 */
	public List<Input> getInputs() {
		return inputs;
	}
	/**
	 * @param inputs the inputs to set
	 */
	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}
	/**
	 * @return the outputs
	 */
	public List<Output> getOutputs() {
		return outputs;
	}
	/**
	 * @param outputs the outputs to set
	 */
	public void setOutputs(List<Output> outputs) {
		this.outputs = outputs;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FuzzyControl [name=" + name + ", description=" + description + ", inputs=" + inputs + ", outputs=" + outputs + "]";
	}
}
