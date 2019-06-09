package com.dbserver.dbbeer.container;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbserver.dbbeer.beer.Beer;

import reactor.core.publisher.Flux;

@RestController
@SpringBootApplication
public class ContainerController {

	@CrossOrigin
	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/containers")
	public Flux<List<ContainerDTO>> getContainers() {

		// Mock values
		Beer beer1 = new Beer(1, "Pilsner", 4, 6);
		Beer beer2 = new Beer(2, "IPA", 5, 6);
		Beer beer3 = new Beer(3, "Lager", 4, 7);
		Beer beer4 = new Beer(4, "Stout", 6, 8);
		Beer beer5 = new Beer(5, "Wheat beer", 3, 5);
		Beer beer6 = new Beer(6, "Pale Ale", 4, 6);
		// End of Mock value

		List<Container> containers = Arrays.asList(Container.loadContainer(beer1), Container.loadContainer(beer2),
				Container.loadContainer(beer3), Container.loadContainer(beer4), Container.loadContainer(beer5),
				Container.loadContainer(beer6));

		Flux<List<ContainerDTO>> eventFlux = Flux
				.fromStream(Stream.generate(() -> ContainerConverter.createFromEntities(containers)));
		Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(1));
		return Flux.zip(eventFlux, durationFlux, (key, value) -> key);
	}
}
