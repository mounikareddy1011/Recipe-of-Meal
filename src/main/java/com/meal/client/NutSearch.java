package com.meal.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.meal.bean.Ingredient;

public class NutSearch {

	/*
	 * this class will hit the below URL to get the information for recipe from the
	 * API "https://www.nutritionix.com/business/api"
	 */
	static final String URL = "https://trackapi.nutritionix.com/v2/natural/nutrients";

	public Object getNutritionalValueOfIngredient(Ingredient ingredient, HttpMethod requestType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("x-app-id", "ba258671");
		headers.set("x-app-key", "474da22eb917e92ea396b8f4da034055");
		headers.set("x-remote-user-id", "0");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Ingredient> entity = new HttpEntity<Ingredient>(ingredient, headers);
		ResponseEntity<Object> responseEntity = restTemplate.exchange(URL, requestType, entity, Object.class);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			return responseEntity.getBody();
		} else {
			return null;
		}
	}
}
