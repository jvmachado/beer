package com.dbserver.dbbeer.beer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BeerTest {

	@Test
	public void shouldCreateABeerWithAllValues() {
		Integer id = 1;
		String name = "IPA";
		Integer minTemp = 3;
		Integer maxTemp = 4;

		Beer beer = new Beer(id, name, minTemp, maxTemp);

		assertEquals(id, beer.getId());
		assertEquals(name, beer.getType());
		assertEquals(minTemp, beer.getMinTemperature());
		assertEquals(maxTemp, beer.getMaxTemperature());
	}

}
