package br.com.jardacoder.generator.generators;


import static br.com.jardacoder.generator.utils.CpfCnpjUtils.getSumOfNumbers;
import static br.com.jardacoder.generator.utils.CpfCnpjUtils.getVerificator;
import static br.com.jardacoder.generator.utils.NumberUtils.generateRandomNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cnpj {
	
	private static List<Integer> CNPJ_WEIGHTS = Arrays.asList(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2);
	
	public static String generate(boolean withPoints) {
		
		List<Integer> firstTwelve = generateRandomNumbers(7);
		firstTwelve.addAll(Arrays.asList(0, 0, 0, 1));
		
		List<Integer> weightForSecondDigit = new ArrayList<Integer>(CNPJ_WEIGHTS);
		
		Integer sumResultForFirst = getSumOfNumbers(firstTwelve, CNPJ_WEIGHTS);
		Integer firstVerificator = getVerificator(sumResultForFirst);

		weightForSecondDigit.add(0, 6);
		firstTwelve.add(firstVerificator);
		
		Integer sumResultForSecond = getSumOfNumbers(firstTwelve, weightForSecondDigit);
		Integer secondVerificator = getVerificator(sumResultForSecond);
		
		firstTwelve.add(secondVerificator);
		
		return  formatCnpj(firstTwelve, withPoints);
	}
	
	public static String generate() {
		return generate(false);
	}
	
	private static String formatCnpj(List<Integer>numbers, boolean withPoints) {
		
		List<String> cnpj = numbers.stream()
				.map(number -> {return number.toString();})
				.collect(Collectors.toList());
		
		if(withPoints) {
			cnpj.add(2, ".");
			cnpj.add(6, ".");
			cnpj.add(10, "/");
			cnpj.add(15, "-");
		}
		
		return cnpj.stream()
				.collect(Collectors.joining());
	}

}
