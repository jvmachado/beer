package com.dbserver.dbbeer.container;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbserver.dbbeer.beer.BeerRepository;

import reactor.core.publisher.Flux;

@RestController
@SpringBootApplication
public class ContainerController {

	@Autowired
	private ContainerRepository repository;

	@Autowired
	private BeerRepository beerRepository;

	@CrossOrigin
	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/containers")
	public Flux<List<ContainerDTO>> getContainers() {
		
		List<Container> containers = repository.loadContainers(beerRepository.getAllBeers());

		Flux<List<ContainerDTO>> eventFlux = Flux.fromStream(
				Stream.generate(() -> ContainerConverter.createFromEntities(containers)));
		Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(1));
		return Flux.zip(eventFlux, durationFlux, (key, value) -> key);
	}
}
