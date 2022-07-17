package br.com.jardacoder.generator.enums;


import static br.com.jardacoder.generator.utils.NumberUtils.getRandom;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum Sex {

	MALE(0, "male", "M"), FEMALE(1, "female", "F");

	Sex(int id, String description, String shortDescription) {
		this.id = id;
		this.description = description;
		this.shortDescription = shortDescription;
	}

	private Integer id;

	private String description;

	private String shortDescription;

	public static Sex randomSex() {
		return fromId(getRandom(Sex.values().length));
	}

	public static Sex fromId(Integer id) {
		return Arrays.asList(Sex.values()).stream()
				.filter(sex -> sex.getId().equals(id))
				.findFirst().orElseGet(null);
	}

	public String shortDescription() {
		return this.shortDescription;
	}

	@Override
	public String toString() {
		return this.description;
	}
}
