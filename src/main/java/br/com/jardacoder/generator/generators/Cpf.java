package br.com.jardacoder.generator.generators;

import static br.com.jardacoder.generator.utils.CpfCnpjUtils.getSumOfNumbers;
import static br.com.jardacoder.generator.utils.CpfCnpjUtils.getVerificator;
import static br.com.jardacoder.generator.utils.NumberUtils.generateRandomNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Cpf {
	
	private static List<Integer> CPF_WEIGHTS = Arrays.asList(10, 9, 8 ,7, 6, 5, 4, 3, 2);
	
	
	public static String generate(boolean withPoints) {
		
		List<Integer> firstNine = generateRandomNumbers(9);
		List<Integer> listForSecondDigit = new ArrayList<Integer>(firstNine);
		
		Integer sumResultForFirst = getSumOfNumbers(firstNine, CPF_WEIGHTS);
		Integer firstVerificator = getVerificator(sumResultForFirst);

		listForSecondDigit.add(firstVerificator);
		listForSecondDigit.remove(0);
		
		Integer sumResultForSecond = getSumOfNumbers(listForSecondDigit, CPF_WEIGHTS);
		Integer secondVerificator = getVerificator(sumResultForSecond);
		
		firstNine.addAll(Arrays.asList(firstVerificator, secondVerificator));
		
		return  formatCpf(firstNine, withPoints);
	}
	
	public static String generate() {
		return generate(false);
	}
	
	private static String formatCpf(List<Integer>numbers, boolean withPoints) {
		
		List<String> cpf = numbers.stream()
				.map(number -> {return number.toString();})
				.collect(Collectors.toList());
		
		if(withPoints) {
			cpf.add(3, ".");
			cpf.add(7, ".");
			cpf.add(11, "-");
		}
		
		return cpf.stream()
				.collect(Collectors.joining());
	}
}
