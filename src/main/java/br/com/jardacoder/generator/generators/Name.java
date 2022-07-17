package br.com.jardacoder.generator.generators;


import static br.com.jardacoder.generator.utils.NumberUtils.getRandom;
import static br.com.jardacoder.generator.utils.ResourceFileUtils.getJsonFromResourceFile;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jardacoder.generator.enums.DataType;
import br.com.jardacoder.generator.enums.Sex;

public class Name {
	
	
	public static String generate(String fisrtName, String lastName) throws JsonParseException, JsonMappingException, IOException {
		return String.format("%s %s", fisrtName, lastName);
	}
	
	public static String generate(Sex sex) throws JsonParseException, JsonMappingException, IOException {
		return generate(getFirstName(sex), getLastName());
	}
	
	public static String generate(Sex sex, String lastName) throws JsonParseException, JsonMappingException, IOException {
		return generate(getFirstName(sex), lastName);
	}
	
	public static String generate() throws JsonParseException, JsonMappingException, IOException {
		return generate(getFirstName(Sex.randomSex()), getLastName());
	}
	
	public static String generateLastName() throws JsonParseException, JsonMappingException, IOException {
		return  getLastName();
	}
	
	public static String generateFirstName(Sex sex) throws JsonParseException, JsonMappingException, IOException {
		return  getFirstName(sex);
	}
	
	public static String generateFirstName() throws JsonParseException, JsonMappingException, IOException {
		return  getFirstName(Sex.randomSex());
	}
	
	
	private static String getFirstName(Sex sex) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String[] names = mapper.readValue(getNamesList(sex), String[].class);
		
		return names[getRandom(names.length)];
	}
	
	private static String getLastName() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String[] names = mapper.readValue(getLastNamesList(), String[].class);
		
		return names[getRandom(names.length)];
	}
	
	private static String getNamesList(Sex sex) throws JsonParseException, JsonMappingException, IOException {
		  return getJsonFromResourceFile(String.format("names_%s.json", sex.toString()), DataType.NAME);
	}

	private static String getLastNamesList() throws JsonParseException, JsonMappingException, IOException {
		  return getJsonFromResourceFile("last_name.json", DataType.LAST_NAME);
	}
	
}
