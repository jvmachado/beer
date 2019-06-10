package com.dbserver.dbbeer.container;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dbserver.dbbeer.beer.Beer;

@Component
public class ContainerRepository {

	public List<Container> loadContainers(List<Beer> beers) {
		return beers.stream().map(Container::loadContainer).collect(Collectors.toList());
	}
}
