package com.dbserver.dbbeer.container.sensor;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Data;

@Data
public class Sensor {

	BigDecimal temperature;

	public Sensor() {
		this.temperature = new BigDecimal(5);
	}

	public BigDecimal getTemperature() {
		this.temperature = this.temperature.add(checkTemperatureChange());

		return this.temperature;
	}

	private BigDecimal checkTemperatureChange() {
		double upper = 0.1;
		double lower = -0.1;
		return new BigDecimal(Math.random() * (upper - lower) + lower).setScale(2, RoundingMode.CEILING);
	}
}
