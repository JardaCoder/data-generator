package br.com.jardacoder.generator.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class DateUtils {

	
	/**
	 * @param minYear
	 * @param maxYear
	 * @return  LocalDate between years
	 */
	public static LocalDate generateRandomDate(Integer minYear, Integer maxYear) {
		
		
		long minDay = LocalDate.of(minYear, 1, 1).toEpochDay();
		long maxDay = LocalDate.of(maxYear, 12, 31).toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		
		return LocalDate.ofEpochDay(randomDay);
	}
	
	
	public static Long currentTimeStamp() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime();
	}
}
