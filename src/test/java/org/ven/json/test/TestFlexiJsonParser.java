package org.ven.json.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.ven.json.FlexiJsonParserImpl;
import org.ven.json.IFlexiJsonParser;



public class TestFlexiJsonParser {
	@Test
	public void test1() throws IOException {
		// Get the document
		String jsonFile = System.getProperty("user.dir") + "\\src\\test\\resources\\documents\\test1.json";
		String jsonStr = FileUtils.readFileToString(new File(jsonFile), "UTF-8");
		IFlexiJsonParser flexiParser = new FlexiJsonParserImpl();
		
		// Perform the test		
		JSONObject result = flexiParser.parseDocument(jsonStr, "$.quiz.sport.q1.options-1");
		
		// Expected result
		JSONObject expectedJson = new JSONObject("{\"value\":\"Los Angeles Kings\"}");
		
		// Assert the result
		Assert.assertEquals(expectedJson.toString(), result.toString());		
	}
}
