package br.com.jardacoder.generator.enums;


import static br.com.jardacoder.generator.utils.NumberUtils.getRandom;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum AgeType {

	OF_AGE(0),

	UNDERAGE(1);

	AgeType(int id) {
		this.id = id;
	}

	private Integer id;

	public static AgeType randomAgeType() {
		return fromId(getRandom(AgeType.values().length));
	}

	public static AgeType fromId(Integer id) {
		return Arrays.asList(AgeType.values()).stream().filter(sex -> sex.getId().equals(id)).findFirst()
				.orElseGet(null);
	}
}
