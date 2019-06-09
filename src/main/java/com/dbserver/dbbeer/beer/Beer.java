package com.dbserver.dbbeer.beer;

import lombok.Data;

@Data
public class Beer {

	private Integer id;

	private String type;

	private Integer minTemperature;

	private Integer maxTemperature;

	public Beer(Integer id, String type, Integer minTemperature, Integer maxTemperature) {
		this.id = id;
		this.type = type;
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
	}

}
