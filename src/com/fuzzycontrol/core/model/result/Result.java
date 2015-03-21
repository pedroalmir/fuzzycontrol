package com.fuzzycontrol.core.model.result;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Embed;

@Embed
public class Result implements Comparable<Result>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -763508002759360825L;
	/** */
	private byte[] fcl;
	/** */
	private float quality;
	
	/**
	 * 
	 */
	public Result() {
		
	}
	
	/**
	 * @param fcl
	 * @param quality
	 */
	public Result(byte[] fcl, float quality) {
		super();
		this.fcl = fcl;
		this.quality = quality;
	}

	@Override
	public int compareTo(Result o) {
		return new Float(quality).compareTo(new Float(o.getQuality()));
	}

	/**
	 * @return the fcl
	 */
	public byte[] getFcl() {
		return fcl;
	}

	/**
	 * @param fcl the fcl to set
	 */
	public void setFcl(byte[] fcl) {
		this.fcl = fcl;
	}

	/**
	 * @return the quality
	 */
	public float getQuality() {
		return quality;
	}

	/**
	 * @param quality the quality to set
	 */
	public void setQuality(float quality) {
		this.quality = quality;
	}
}
