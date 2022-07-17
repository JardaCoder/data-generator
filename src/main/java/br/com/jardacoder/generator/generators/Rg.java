package br.com.jardacoder.generator.generators;

import static br.com.jardacoder.generator.utils.NumberUtils.generateRandomNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class Rg {
	
	public static String generate(boolean withPoints) {
		
		List<Integer> rgNumbers =  generateRandomNumbers(7);
		
		return  formatRg(rgNumbers, withPoints);
	}
	
	public static String generate() {
		return generate(false);
	}
	
	public static String formatRg(List<Integer>numbers, boolean withPoints) {
		
		List<String> cpfString = numbers.stream()
				.map(number -> {return number.toString();})
				.collect(Collectors.toList());
		
		if(withPoints) {
			 cpfString.add(1, ".");
			 cpfString.add(5, ".");
		}
		
		return cpfString.stream()
				.collect(Collectors.joining());
		
	}

}
