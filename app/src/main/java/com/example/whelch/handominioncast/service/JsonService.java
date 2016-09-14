package com.example.whelch.handominioncast.service;

import android.app.Activity;

import com.example.whelch.handominioncast.App;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class JsonService {

	/**
	 * T is the root level JSON type. JSONObject or JSONArray.
	 */
	public static JSONArray readJsonArrayFromRawFile(int fileID) {
		try {
			InputStream inStream = 	App.getContext().getResources().openRawResource(fileID);
			String contents = IOUtils.toString(inStream);

			JSONArray jsonArray = new JSONArray(contents);

			return jsonArray;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

}
