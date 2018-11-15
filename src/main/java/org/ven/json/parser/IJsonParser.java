package org.ven.json.parser;

import org.json.JSONObject;
import org.ven.json.parser.model.AbstractJsonPath;

public interface IJsonParser {
	public JSONObject get(JSONObject jsonDocument, AbstractJsonPath path);
}
