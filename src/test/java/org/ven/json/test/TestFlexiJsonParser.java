package org.ven.json.test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.ven.json.FlexiJsonParserImpl;
import org.ven.json.IFlexiJsonParser;



public class TestFlexiJsonParser {
	@Test
	public void test1() throws IOException, URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		File jsonFile = new File(classLoader.getResource("test1.json").getFile());			
		String jsonStr = FileUtils.readFileToString(jsonFile, "UTF-8");
		IFlexiJsonParser flexiParser = new FlexiJsonParserImpl();
		
		// Perform the test		
		JSONObject result = flexiParser.parseDocument(jsonStr, "$.quiz.sport.q1.options-1");
		
		// Expected result
		JSONObject expectedJson = new JSONObject("{\"value\":\"Los Angeles Kings\"}");
		
		// Assert the result
		Assert.assertEquals(expectedJson.toString(), result.toString());		
	}
	@Test
	public void test2() throws IOException, URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		File jsonFile = new File(classLoader.getResource("test1.json").getFile());			
		String jsonStr = FileUtils.readFileToString(jsonFile, "UTF-8");
		IFlexiJsonParser flexiParser = new FlexiJsonParserImpl();
		
		// Perform the test		
		JSONObject result = flexiParser.parseDocument(jsonStr, "$.quiz.maths.q1");
		
		// Expected result
		jsonFile = new File(classLoader.getResource("expected2.json").getFile());			
		jsonStr = FileUtils.readFileToString(jsonFile, "UTF-8");
		JSONObject expectedJson = new JSONObject(jsonStr);
		
		// Assert the result
		Assert.assertEquals(expectedJson.toString(), result.toString());		
	}
}
