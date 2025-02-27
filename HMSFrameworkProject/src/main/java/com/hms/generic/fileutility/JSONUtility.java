package com.hms.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {
	public String getJSONData(String key) throws IOException, ParseException {
		FileReader file=new FileReader("./configAppData/hmsProjectCommonData.json");
		JSONParser parser=new JSONParser();
		Object object = parser.parse(file);
		JSONObject jObjMap=(JSONObject)object;
		String value = jObjMap.get(key).toString();
		return value;
	}

}
