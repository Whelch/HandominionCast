package com.example.whelch.handominioncast.model.cards;

import android.util.Log;

import com.example.whelch.handominioncast.R;
import com.example.whelch.handominioncast.service.JsonService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardDefinition {

	public static Map<String, CardDefinition> dictionary;

	static {
		JSONArray cards = JsonService.readJsonArrayFromRawFile(R.raw.card_definitions);
		dictionary = new HashMap<>();
		for(int i = 0; i < cards.length(); i++) {
			try {
				JSONObject jsonCard = cards.getJSONObject(i);
				try {
					CardDefinition card = new CardDefinition(jsonCard);
					dictionary.put(card.name, card);
				} catch (JSONException e) {
					e.printStackTrace();
					Log.e("CardDefinition", "Failed to parse a valid card definition from the json: " + jsonCard.toString());
				}
			} catch (JSONException e) {
				Log.e("FUBAR", "All shit has broken loose in the CardDefinition JSON parser.");
			}
		}
	}

	public final String name;
	public final String description;
	public final String imgResourceName;
	public final String module;
	public final List<String> types;
	public final int cost;
	public final int victoryValue;

	public CardDefinition(JSONObject json) throws JSONException {
		name = json.getString("name");
		description = json.getString("description");
		imgResourceName = name.toLowerCase().replace(" ", "_");
		module = json.getString("module");
		cost = json.getInt("cost");
		victoryValue = json.getInt("victoryValue");


		JSONArray jsonTypes = json.getJSONArray("types");
		ArrayList<String> typesList = new ArrayList<String>();
		for(int i = 0; i < jsonTypes.length(); i++) {
			typesList.add(jsonTypes.getString(i));
		}
		types = Collections.unmodifiableList(typesList);
	}
}
