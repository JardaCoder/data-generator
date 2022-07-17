package br.com.jardacoder.generator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberUtils {

	public static Integer getRandom(int bound) {
		var random = new Random();
		return random.nextInt(bound);
	}
	
	public static List<Integer> generateRandomNumbers(Integer number) {
		var numbers = new ArrayList<Integer>();
		
		do {
			numbers.add(getRandom(10));
			
		} while (numbers.size() < number);
		
		return numbers;
	}
	
}
