package com.meal.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meal.bean.Ingredient;
import com.meal.bean.IngredientInfo;
import com.meal.bean.Nutinfo;
import com.meal.bean.Recipe;
import com.meal.client.NutSearch;
import com.meal.client.RecipeSearch;

@RestController
@RequestMapping("/menu")
public class Controller {

	RecipeSearch foodSearchRestClient = new RecipeSearch();
	NutSearch nutritionalRestClient = new NutSearch();

	/*
	 * Controller which takes input of "mealname" and will return
	 * "list of ingradients along with their respective weights"
	 *
	 */
	@RequestMapping(value = "/findmeal", method = RequestMethod.GET)
	public ResponseEntity<List<IngredientInfo>> foodsearch(@RequestParam String mealName) {
		try {
			Recipe mealrespnse = foodSearchRestClient.getRestRequestForReciepe(mealName, "&q=" + mealName,
					HttpMethod.GET);
			Object obj = mealrespnse.getHits().get(0);
			HashMap<String, Object> test = (HashMap<String, Object>) obj;
			ObjectMapper objectMapper = new ObjectMapper();
			HashMap<String, Object> test1 = (HashMap<String, Object>) test.get("recipe");
			List<IngredientInfo> recipe = objectMapper.readValue(
					objectMapper.writeValueAsString(test1.get("ingredients")),
					new TypeReference<List<IngredientInfo>>() {
					});
			return new ResponseEntity<>(recipe, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	/*
	 * Controller which takes input of "mealname" and will return
	 * "list of nutrients along with their nutritional information"
	 *
	 */
	@RequestMapping(value = "/findnutrient", method = RequestMethod.GET)
	public ResponseEntity<Nutinfo> getCompleteNutrientValue(@RequestParam String mealName) {
		try {
			List<IngredientInfo> ingredient = foodsearch(mealName).getBody();
			Nutinfo totalCal = new Nutinfo();
			for (IngredientInfo ingredient2 : ingredient) {
				Ingredient ind = new Ingredient();
				ind.setQuery(ingredient2.getText());
				Nutinfo cal = getIngredientNutrient(ind);
				addCalories(totalCal, cal);
			}
			return new ResponseEntity<>(totalCal, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}

	private void addCalories(Nutinfo totalCal, Nutinfo cal) {
		totalCal.setNf_calories(totalCal.getNf_calories() + cal.getNf_calories());
		totalCal.setNf_total_fat(totalCal.getNf_total_fat() + cal.getNf_total_fat());
		totalCal.setNf_saturated_fat(totalCal.getNf_saturated_fat() + cal.getNf_saturated_fat());
		totalCal.setNf_cholesterol(totalCal.getNf_cholesterol() + cal.getNf_cholesterol());
		totalCal.setNf_sodium(totalCal.getNf_sodium() + cal.getNf_sodium());
		totalCal.setNf_total_carbohydrate(totalCal.getNf_total_carbohydrate() + cal.getNf_total_carbohydrate());
		totalCal.setNf_dietary_fiber(totalCal.getNf_dietary_fiber() + cal.getNf_dietary_fiber());
		totalCal.setNf_sugars(totalCal.getNf_sugars() + cal.getNf_sugars());
		totalCal.setNf_protein(totalCal.getNf_protein() + cal.getNf_protein());
		totalCal.setNf_potassium(totalCal.getNf_potassium() + cal.getNf_potassium());
		totalCal.setNf_p(totalCal.getNf_p() + cal.getNf_p());
		totalCal.setServing_weight_grams(totalCal.getServing_weight_grams() + cal.getServing_weight_grams());
	}

	@SuppressWarnings("unchecked")
	public Nutinfo getIngredientNutrient(Ingredient ingredient) {
		try {
			HashMap<String, Object> mealResponse = (HashMap<String, Object>) nutritionalRestClient
					.getNutritionalValueOfIngredient(ingredient, HttpMethod.POST);

			if (mealResponse != null && mealResponse.get("foods") != null) {
				List<Object> obj = (List<Object>) mealResponse.get("foods");
				ObjectMapper objectMapper = new ObjectMapper();
				Nutinfo calories;
				calories = objectMapper.readValue(objectMapper.writeValueAsString(obj.get(0)), Nutinfo.class);
				return calories;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
