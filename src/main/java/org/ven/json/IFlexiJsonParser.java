package org.ven.json;

import java.util.List;

import org.json.JSONObject;
import org.ven.json.parser.model.AbstractJsonPath;

public interface IFlexiJsonParser {
	public JSONObject parseDocument(JSONObject jsonDocument, List<AbstractJsonPath> jsonPaths);
	public JSONObject parseDocument(JSONObject jsonDocument, String jsonPath);
	public JSONObject parseDocument(String jsonDocument, String jsonPath);
}
