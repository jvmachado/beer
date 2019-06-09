package com.dbserver.dbbeer.container;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.dbserver.dbbeer.beer.Beer;
import com.dbserver.dbbeer.container.sensor.Sensor;

public class ContainerTest {

	private Container container;

	private Beer beer;

	@Before
	public void createContainer() {
		Integer id = 1;
		String name = "IPA";
		Integer minTemp = 3;
		Integer maxTemp = 4;

		this.beer = new Beer(id, name, minTemp, maxTemp);

		this.container = Container.loadContainer(this.beer);
	}

	@Test
	public void shouldCreateANewContainerWithSpecificTypeOfBeer() {
		assertEquals(beer, container.getBeerType());
	}

	@Test
	public void shouldReturnTrueWhenGreaterThanMaxTemp() {
		Sensor mock = Mockito.mock(Sensor.class);
		Mockito.when(mock.getTemperature()).thenReturn(new BigDecimal(5));
		container.setSensor(mock);

		assertTrue(container.isOutOfRange());
	}

	@Test
	public void shouldReturnTrueWhenLesserThanMaxTemp() {
		Sensor mock = Mockito.mock(Sensor.class);
		Mockito.when(mock.getTemperature()).thenReturn(new BigDecimal(2));
		container.setSensor(mock);

		assertTrue(container.isOutOfRange());
	}

	@Test
	public void shouldReturnFalseWhenInRange() {
		Sensor mock = Mockito.mock(Sensor.class);
		Mockito.when(mock.getTemperature()).thenReturn(new BigDecimal(3));
		container.setSensor(mock);

		assertFalse(container.isOutOfRange());
	}

}
