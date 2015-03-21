package com.fuzzycontrol.core.model.result;

import java.io.Serializable;

import com.fuzzycontrol.common.util.StringCompressor;

public class ResultVO implements Serializable{
	/** */
	private static final long serialVersionUID = -763508002759360825L;
	/** */
	private final Long id;
	/** */
	private final String fcl;
	/** */
	private final float quality;
	
	/**
	 * 
	 */
	public ResultVO(Long id, Result result) {
		this.id = id;
		this.fcl = StringCompressor.decompress(result.getFcl()).replaceAll("\n", "<br/>");
		this.quality = result.getQuality();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the fcl
	 */
	public String getFcl() {
		return fcl;
	}

	/**
	 * @return the quality
	 */
	public float getQuality() {
		return quality;
	}
}
