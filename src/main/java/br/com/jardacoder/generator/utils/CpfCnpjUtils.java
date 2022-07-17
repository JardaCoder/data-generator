package br.com.jardacoder.generator.utils;

import java.util.List;

/**
 * Class created to armazene common functions between Cpf e Cnpj
 * 
 * @author Jardel Schaefer
 *
 */
public class CpfCnpjUtils {
	

	/**
	 * @param sumResult - Result of all numbers summed
	 * @return the Veficator, used to CPF and CNPJ
	 */
	public static Integer getVerificator(Integer sumResult) {
		Integer verificator = 11 - (sumResult % 11);
		
		return verificator >= 10 ? 0 : verificator;
	}
	
	/**
	 * @param numbers 
	 * @return numbers added and multiplied by weight
	 */
	public static Integer getSumOfNumbers(List<Integer> numbers, List<Integer> weights){
		Integer sum = 0;
		int index = 0;
		
		for (Integer number : numbers) {
			sum += number * weights.get(index);
			
			index++;
		}
		
		return sum;
	}

}
