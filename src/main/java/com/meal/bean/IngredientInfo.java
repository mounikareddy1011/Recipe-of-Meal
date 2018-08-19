package com.meal.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IngredientInfo {
	/*
	 * Processing the JSON response from API by taking ingredient name as "text" and
	 * weight as "weight"
	 */
	private String text;
	private double weight;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "IngredientInfo [text=" + text + ", weight=" + weight + "]";
	}

}
