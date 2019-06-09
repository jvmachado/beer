package com.dbserver.dbbeer.container.sensor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class SensorTest {

	@Test
	public void shouldCreateWithInitialTemperatureOf5() {
		Sensor sensor = new Sensor();

		assertEquals(5, sensor.temperature.intValue());
	}

	@Test
	public void shouldChangeTemperatureOnGet() {
		Sensor sensor = new Sensor();
		BigDecimal temperature = sensor.getTemperature();

		assertEquals(temperature, sensor.temperature);
		assertNotEquals(new BigDecimal(5), temperature);
	}

}
