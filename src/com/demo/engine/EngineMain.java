package com.demo.engine;

import java.util.HashMap;
import java.util.Map;

import com.demo.engine.util.PriceCalculator;

public class EngineMain {
	private Map<Character, Integer> itemsToBuy = new HashMap<Character, Integer>();

	private PriceCalculator priceCalculator;
	
	{
		priceCalculator = new PriceCalculator();
		
//		itemsToBuy.put('A', 1);
//		itemsToBuy.put('B', 1);
//		itemsToBuy.put('C', 1);
		
//		itemsToBuy.put('A', 5);
//		itemsToBuy.put('B', 5);
//		itemsToBuy.put('C', 1);
		
		itemsToBuy.put('A', 3);
		itemsToBuy.put('B', 5);
		itemsToBuy.put('C', 1);
		itemsToBuy.put('D', 1);
	}
	public static void main(String[] args) {
		EngineMain engine = new EngineMain();
		engine.run();
	}
	
	private void run() {
		System.out.println(priceCalculator.calculateTotalPrice(itemsToBuy));
	}
}
