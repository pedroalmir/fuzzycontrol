package com.fuzzycontrol.core.model.base;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Id;


/**
 * 
 * @author Pedro Almir
 */
@SuppressWarnings("serial")
public class GenericEntity implements Serializable {
	
	@Id
	protected Long id;
	
	/* Getters && Setters... */
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
