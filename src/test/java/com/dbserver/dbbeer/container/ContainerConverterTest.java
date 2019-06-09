package com.dbserver.dbbeer.container;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.dbserver.dbbeer.beer.Beer;

public class ContainerConverterTest {

	private Container container;

	@Before
	public void createContainer() {
		Integer id = 1;
		String name = "IPA";
		Integer minTemp = 3;
		Integer maxTemp = 4;
		Beer beer = new Beer(id, name, minTemp, maxTemp);
		this.container = Container.loadContainer(beer);
	}

	@Test
	public void shouldCreateDto() {
		ContainerDTO dto = ContainerConverter.createFrom(container);

		assertEquals(container.getBeerType().getId(), dto.getBeerType());
	}

}
