package com.dbserver.dbbeer.beer;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dbserver.dbbeer.beer.Beer;

@Component
public class BeerRepository {

	public List<Beer> getAllBeers() {

		// Mock values
		Beer beer1 = new Beer(1, "Pilsner", 4, 6);
		Beer beer2 = new Beer(2, "IPA", 5, 6);
		Beer beer3 = new Beer(3, "Lager", 4, 7);
		Beer beer4 = new Beer(4, "Stout", 6, 8);
		Beer beer5 = new Beer(5, "Wheat beer", 3, 5);
		Beer beer6 = new Beer(6, "Pale Ale", 4, 6);
		// End of Mock value

		return Arrays.asList(beer1, beer2, beer3, beer4, beer5, beer6);
	}
}
