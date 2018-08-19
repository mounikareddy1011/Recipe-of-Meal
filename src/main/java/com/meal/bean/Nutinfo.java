package com.meal.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nutinfo {
	/*
	 * Processing the JSON response from API
	 */
	private float nf_calories;
	private float nf_total_fat;
	private float nf_saturated_fat;
	private float nf_cholesterol;
	private float nf_sodium;
	private float nf_total_carbohydrate;
	private float nf_dietary_fiber;
	private float nf_sugars;
	private float nf_protein;
	private float nf_potassium;
	private float nf_p;
	private float serving_weight_grams;

	public float getNf_calories() {
		return nf_calories;
	}

	public void setNf_calories(float nf_calories) {
		this.nf_calories = nf_calories;
	}

	public float getNf_total_fat() {
		return nf_total_fat;
	}

	public void setNf_total_fat(float nf_total_fat) {
		this.nf_total_fat = nf_total_fat;
	}

	public float getNf_saturated_fat() {
		return nf_saturated_fat;
	}

	public void setNf_saturated_fat(float nf_saturated_fat) {
		this.nf_saturated_fat = nf_saturated_fat;
	}

	public float getNf_cholesterol() {
		return nf_cholesterol;
	}

	public void setNf_cholesterol(float nf_cholesterol) {
		this.nf_cholesterol = nf_cholesterol;
	}

	public float getNf_sodium() {
		return nf_sodium;
	}

	public void setNf_sodium(float nf_sodium) {
		this.nf_sodium = nf_sodium;
	}

	public float getNf_total_carbohydrate() {
		return nf_total_carbohydrate;
	}

	public void setNf_total_carbohydrate(float nf_total_carbohydrate) {
		this.nf_total_carbohydrate = nf_total_carbohydrate;
	}

	public float getNf_dietary_fiber() {
		return nf_dietary_fiber;
	}

	public void setNf_dietary_fiber(float nf_dietary_fiber) {
		this.nf_dietary_fiber = nf_dietary_fiber;
	}

	public float getNf_sugars() {
		return nf_sugars;
	}

	public void setNf_sugars(float nf_sugars) {
		this.nf_sugars = nf_sugars;
	}

	public float getNf_protein() {
		return nf_protein;
	}

	public void setNf_protein(float nf_protein) {
		this.nf_protein = nf_protein;
	}

	public float getNf_potassium() {
		return nf_potassium;
	}

	public void setNf_potassium(float nf_potassium) {
		this.nf_potassium = nf_potassium;
	}

	public float getNf_p() {
		return nf_p;
	}

	public void setNf_p(float nf_p) {
		this.nf_p = nf_p;
	}

	public float getServing_weight_grams() {
		return serving_weight_grams;
	}

	public void setServing_weight_grams(float serving_weight_grams) {
		this.serving_weight_grams = serving_weight_grams;
	}

	@Override
	public String toString() {
		return "Nutinfo [nf_calories=" + nf_calories + ", nf_total_fat=" + nf_total_fat + ", nf_saturated_fat="
				+ nf_saturated_fat + ", nf_cholesterol=" + nf_cholesterol + ", nf_sodium=" + nf_sodium
				+ ", nf_total_carbohydrate=" + nf_total_carbohydrate + ", nf_dietary_fiber=" + nf_dietary_fiber
				+ ", nf_sugars=" + nf_sugars + ", nf_protein=" + nf_protein + ", nf_potassium=" + nf_potassium
				+ ", nf_p=" + nf_p + ", serving_weight_grams=" + serving_weight_grams + "]";
	}

}
