package com.udacity.sandwichclub.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.udacity.sandwichclub.model.Sandwich;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich;

        try {
            JSONObject sandwichJSON = new JSONObject(json);
            JSONObject name = sandwichJSON.getJSONObject("name");

            String mainName = name.getString("mainName");

            JSONArray alsoKnownAsJSON = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; alsoKnownAsJSON.length() > i; i++) {
                alsoKnownAs.add(alsoKnownAsJSON.getString(i));
            }

            String placeOfOrigin = sandwichJSON.getString("placeOfOrigin");

            String description = sandwichJSON.getString("description");

            String image = sandwichJSON.getString("image");

            JSONArray ingredientsJSON = sandwichJSON.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; ingredientsJSON.length() > i; i++) {
                ingredients.add(ingredientsJSON.getString(i));
            }

            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
            sandwich = null;
        }

        return sandwich;
    }
}
