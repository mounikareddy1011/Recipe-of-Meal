package com.meal.bean;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/*
 * gets the requested meal information by mapping it
 *  	 */
@JsonInclude(Include.NON_NULL)
public class MealInfo {
	private HashMap<String, Object> recipe;
}
