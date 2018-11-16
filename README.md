# flexi-jsonparser
**Flexible JSON parser**

A flexible JSON parser where we need to provide only the json document and jsonpath into it. 

[![Build Status](https://travis-ci.org/venkatesh-mohanram/flexi-jsonparser.svg?branch=master)](https://travis-ci.org/venkatesh-mohanram/flexi-jsonparser)

## Getting started

This project is built as a jar file. You can find the jar file inside target\ folder. Add the jar as your dependencies and add below code in your class

```java
    // Initialize the object
    IFlexiJsonParser flexiParser = new FlexiJsonParserImpl();		
    // Get the desired JSON object	
    JSONObject result = flexiParser.parseDocument(jsonStr, "$.quiz.sport.q1.options-1");
```

## Build

In order build your own jar, run below maven command

```
    mvn package
```

## Running unit tests

```
    mvn test
```

## Limitations

At present, not all the json path patterns are supported. We need to provide the complete JSON path. And for array index, we need to seperate it with an -

## Authors

* **Venkatesh Mohanram** - *Initial work* - [venkatesh-mohanram](https://github.com/venkatesh-mohanram)
