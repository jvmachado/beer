package com.dbserver.dbbeer.container;

import java.math.BigDecimal;

import com.dbserver.dbbeer.beer.Beer;
import com.dbserver.dbbeer.container.sensor.Sensor;

import lombok.Data;

@Data
public class Container {

	private Sensor sensor;

	private Beer beerType;

	private Container() {
	}

	private Container(Beer beerType) {
		this.beerType = beerType;
		this.sensor = new Sensor();
	}

	public static Container loadContainer(Beer beerType) {
		return new Container(beerType);
	}

	public Boolean isOutOfRange() {
		BigDecimal actualTemperature = sensor.getTemperature();
		return actualTemperature.doubleValue() > beerType.getMaxTemperature()
				|| actualTemperature.doubleValue() < beerType.getMinTemperature();
	}
}
