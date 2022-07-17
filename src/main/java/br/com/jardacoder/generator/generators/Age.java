package br.com.jardacoder.generator.generators;


import static br.com.jardacoder.generator.utils.DateUtils.generateRandomDate;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.jardacoder.generator.enums.AgeType;

public class Age {
	
	public static Long generate(LocalDate birthDate) throws JsonParseException, JsonMappingException, IOException {
		return birthDate.until(LocalDate.now(), ChronoUnit.YEARS);
	}
	
	public static Long generate() throws JsonParseException, JsonMappingException, IOException {
		return generate(generateBirthDate(AgeType.randomAgeType()));
	}
	
	public static LocalDate generateBirthDate(AgeType ageType) throws JsonParseException, JsonMappingException, IOException {
		
		var currentDate = LocalDate.now();
		
		if(ageType.equals(AgeType.OF_AGE)) {
			return generateRandomDate(currentDate.minusYears(60).getYear(), currentDate.minusYears(19).getYear());
		}else {
			return generateRandomDate(currentDate.minusYears(17).getYear(), currentDate.minusYears(10).getYear());
		}
	}

}
