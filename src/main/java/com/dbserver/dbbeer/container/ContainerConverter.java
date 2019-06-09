package com.dbserver.dbbeer.container;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerConverter {

	public static ContainerDTO createFrom(Container container) {
		ContainerDTO dto = new ContainerDTO();

		dto.setBeerType(container.getBeerType().getId());
		dto.setTemperature(container.getSensor().getTemperature());
		dto.setIsOutRange(container.isOutOfRange());

		return dto;
	}

	public static List<ContainerDTO> createFromEntities(final Collection<Container> entities) {
		return entities.stream().map(ContainerConverter::createFrom).collect(Collectors.toList());
	}
}
