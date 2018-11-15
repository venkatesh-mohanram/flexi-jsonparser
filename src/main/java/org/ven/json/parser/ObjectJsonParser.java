package org.ven.json.parser;

import java.util.logging.Logger;

import org.json.JSONObject;
import org.ven.json.parser.model.AbstractJsonPath;

public class ObjectJsonParser implements IJsonParser {
	Logger logger = Logger.getLogger(ObjectJsonParser.class.getName());
	
	public JSONObject get(JSONObject jsonDocument, AbstractJsonPath path) {
		logger.info("Path Key is :" + path.getKey());
		JSONObject result = null;
		if (jsonDocument != null) {
			result = jsonDocument.getJSONObject(path.getKey());
		}
		return result;
	}

}
