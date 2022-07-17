package br.com.jardacoder.generator.enums;

import lombok.Getter;

@Getter
public enum DataType {

	NAME("/json/names/"),
	LAST_NAME("/json/names/")
	;
	
	
	private String basePath;

	private DataType(String basePath) {
		this.basePath = basePath;
	}
}
