package org.ven.json;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.json.JSONObject;
import org.ven.json.parser.ArrayJsonParser;
import org.ven.json.parser.IJsonParser;
import org.ven.json.parser.ObjectJsonParser;
import org.ven.json.parser.model.AbstractJsonPath;
import org.ven.json.parser.model.ArrayJsonPath;
import org.ven.json.parser.model.ObjectJsonPath;

public class FlexiJsonParserImpl implements IFlexiJsonParser {

	Logger logger = Logger.getLogger(FlexiJsonParserImpl.class.getName());
	
	public JSONObject parseDocument(JSONObject jsonDocument, List<AbstractJsonPath> jsonPaths) {
		JSONObject result = jsonDocument;
		for (AbstractJsonPath path : jsonPaths) {
			IJsonParser jsonParser;
			if (path instanceof ObjectJsonPath) {
				jsonParser = new ObjectJsonParser();
			} else {
				jsonParser = new ArrayJsonParser();
			}
			result = jsonParser.get(result, path);
		}
		return result;	
	}

	/**
	 * 
	 * Eg jsonPath : $.quiz.sport.q1.options-2
	 */
	public JSONObject parseDocument(JSONObject jsonDocument, String jsonPath) {
		String[] locations = jsonPath.split("\\.");
		List<AbstractJsonPath> jsonPaths = new ArrayList<AbstractJsonPath>();
		for (String location : locations) {
			logger.info("Executing the location : " + location);			
			if (!location.equals("$")) {
				if (location.contains("-")) {
					ArrayJsonPath arrayJsonPath = new ArrayJsonPath();
					arrayJsonPath.setKey(location.split("-")[0]);
					arrayJsonPath.setIndex(Integer.parseInt(location.split("-")[1]));
					jsonPaths.add(arrayJsonPath);
				} else {
					ObjectJsonPath objectJsonPath = new ObjectJsonPath();
					objectJsonPath.setKey(location);
					jsonPaths.add(objectJsonPath);
				}
			}
		}
		JSONObject result = parseDocument(jsonDocument, jsonPaths);
		return result;
	}

	public JSONObject parseDocument(String jsonDocument, String jsonPath) {
		JSONObject jsonObj = new JSONObject(jsonDocument);
		JSONObject result = parseDocument(jsonObj, jsonPath);
		return result;
	}

}
