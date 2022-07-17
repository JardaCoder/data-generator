package br.com.jardacoder.generator.generators;

import static br.com.jardacoder.generator.utils.DateUtils.currentTimeStamp;
import static br.com.jardacoder.generator.utils.NumberUtils.getRandom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class Email {
	
	
	private static final ArrayList<String> DOMAINS = 
			new ArrayList<String>(Arrays.asList("alegre.com", "casanossa.com", "belaflor.com", "dominio1.com", "dominio2.com", "dominio3.com", "dominio4.com"));

	public static String generate(String name, String domain)  {
		return String.format("%s_%s@%s", formatEmailPrefix(name), currentTimeStamp(), domain);
	}
	
	public static String generate(String name) throws JsonParseException, JsonMappingException, IOException {
		return generate(name, randomDomain());
	}
	
	public static String generate() throws JsonParseException, JsonMappingException, IOException {
		return generate(Name.generate(), randomDomain());
	}
	
	public static String generateWithDomain(String domain) throws JsonParseException, JsonMappingException, IOException {
		return generate(Name.generate(), domain);
	}
	
	private static String randomDomain() {
		return DOMAINS.get(getRandom(DOMAINS.size()));
	}
	
	private static String formatEmailPrefix(String prefix) {
		String[] prefixParts = prefix.split(" ");
		
		return Arrays.asList(prefixParts).stream().collect(Collectors.joining("_")).toLowerCase();
	}
}
