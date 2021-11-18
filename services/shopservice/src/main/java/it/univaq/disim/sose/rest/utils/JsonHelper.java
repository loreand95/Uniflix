package it.univaq.disim.sose.rest.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class JsonHelper {

	
	public static void Add(JsonObject jo, String property, String[] values) {
	    JsonArray array = new JsonArray();
	    for (String value : values) {
	        array.add(new JsonPrimitive(value));
	    }
	    jo.add(property, array);
	}
	
}
