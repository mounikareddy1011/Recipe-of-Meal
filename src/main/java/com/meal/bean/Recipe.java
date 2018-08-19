package com.meal.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

public class Recipe {
	/*
	 * Processing the JSON response from API
	 */

	private String q;
	private List<Object> hits;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public List<Object> getHits() {
		return hits;
	}

	public void setHits(List<Object> hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "Recipe [q=" + q + ", hits=" + hits + "]";
	}

}
