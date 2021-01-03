package com.demo.engine;

import java.util.HashSet;
import java.util.Set;

import com.demo.engine.model.Item;
import com.demo.engine.util.PriceCalculator;

public class EngineMain {
	// Test data
	private Set<Item> itemsToBuy = new HashSet<Item>();

	private PriceCalculator priceCalculator;

	{
		priceCalculator = new PriceCalculator();

		itemsToBuy.add(new Item('A', 3));
		itemsToBuy.add(new Item('B', 5));
		itemsToBuy.add(new Item('C', 1));
		itemsToBuy.add(new Item('D', 1));
	}

	public static void main(String[] args) {
		EngineMain engine = new EngineMain();
		engine.run();
	}

	private void run() {
		System.out.println(priceCalculator.calculateTotalPrice(itemsToBuy));
	}
}
