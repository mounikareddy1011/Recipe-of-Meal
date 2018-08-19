package com.meal.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.meal.bean.Recipe;

public class RecipeSearch {

	/*
	 * this class will hit the below URL to get the information for recipe from the
	 * API "https://developer.edamam.com/edamam-docs-recipe-api"
	 */
	static String URL = "https://api.edamam.com/search?app_id=7f4ef677&app_key=\n" + "4d2714939bfa7e4b19386965657e60f9";

	public Recipe getRestRequestForReciepe(String mealName, String urlappend, HttpMethod requestType) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(URL + urlappend);
		ResponseEntity<Recipe> responseEntity = restTemplate.exchange(URL + urlappend, requestType, null, Recipe.class);

		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			return responseEntity.getBody();
		} else {
			return null;
		}
	}
}
