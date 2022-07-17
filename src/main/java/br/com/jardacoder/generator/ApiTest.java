package br.com.jardacoder.generator;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jardacoder.generator.enums.AgeType;
import br.com.jardacoder.generator.enums.Sex;
import br.com.jardacoder.generator.generators.Age;
import br.com.jardacoder.generator.generators.Cnpj;
import br.com.jardacoder.generator.generators.Cpf;
import br.com.jardacoder.generator.generators.Email;
import br.com.jardacoder.generator.generators.Name;
import br.com.jardacoder.generator.generators.Rg;

@RestController
@RequestMapping("/test")
public class ApiTest {

	
	@Autowired
	ObjectMapper mapper;
	
	
	@GetMapping("/data-generation")
	public HashMap<String, Object> cpf(@RequestParam Boolean formated) throws JsonParseException, JsonMappingException, IOException {
		
		var map = new HashMap<String, Object>();
		
		var cpf = Cpf.generate(true );
		var cnpj = Cnpj.generate(true);
		var rg = Rg.generate(true);
		
		Sex sex = Sex.randomSex();
		
		var firstName = Name.generateFirstName(sex);
		var lastName = Name.generateLastName();
		
		var birthDate = Age.generateBirthDate(AgeType.OF_AGE);
		
		map.put("cpf", cpf);
		map.put("cnpj", cnpj); 
		map.put("rg", rg);
		map.put("sex", sex.shortDescription());
		map.put("name", Name.generate(firstName, lastName));
		map.put("lastName", lastName);
		map.put("firstName", firstName);
		map.put("birthDate", birthDate);
		map.put("age", Age.generate(birthDate));
		map.put("email", Email.generate(firstName));
		
		return map;
	}
}
