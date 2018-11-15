package org.ven.json.parser;


import java.util.logging.Logger;

import org.json.JSONObject;
import org.ven.json.parser.model.AbstractJsonPath;
import org.ven.json.parser.model.ArrayJsonPath;

public class ArrayJsonParser implements IJsonParser {

	Logger logger = Logger.getLogger(ArrayJsonParser.class.getName());
	
	public JSONObject get(JSONObject jsonDocument, AbstractJsonPath path) {
		logger.info("Path key is : " + path.getKey() + " and its index is : " + ((ArrayJsonPath)path).getIndex());
		JSONObject result = null;
		if (jsonDocument != null) {
			ArrayJsonPath aPath = (ArrayJsonPath) path;
			result = jsonDocument.getJSONArray(aPath.getKey()).getJSONObject(aPath.getIndex());
		}
		return result;
	}

}
