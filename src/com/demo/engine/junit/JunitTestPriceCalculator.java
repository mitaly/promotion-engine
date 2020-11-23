package com.demo.engine.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.demo.engine.util.PriceCalculator;

class JunitTestPriceCalculator {
	private static PriceCalculator calculator;
	
	@BeforeAll
	public static void before() {
		calculator = new PriceCalculator();
	}

	@Test
	void testNoPromotions() {
		assertEquals(100, calculator.calculateTotalPrice(testDataHavingNoPromotions()));
	}

	@Test
	void testNTypePromotion() {
		assertEquals(370, calculator.calculateTotalPrice(testDataHaving_NTypePromotion()));
	}

	@Test
	void testTwoAndNTypePromotion() {
		assertEquals(280, calculator.calculateTotalPrice(testDataHaving_TwoAndNTypePromotion()));
	}

	Map<Character, Integer> testDataHavingNoPromotions() {
		Map<Character, Integer> itemsToBuy = new HashMap<Character, Integer>();
		itemsToBuy.put('A', 1);
		itemsToBuy.put('B', 1);
		itemsToBuy.put('C', 1);
		return itemsToBuy;
	}

	Map<Character, Integer> testDataHaving_NTypePromotion() {
		Map<Character, Integer> itemsToBuy = new HashMap<Character, Integer>();
		itemsToBuy.put('A', 5);
		itemsToBuy.put('B', 5);
		itemsToBuy.put('C', 1);
		return itemsToBuy;
	}

	Map<Character, Integer> testDataHaving_TwoAndNTypePromotion() {
		Map<Character, Integer> itemsToBuy = new HashMap<Character, Integer>();
		itemsToBuy.put('A', 3);
		itemsToBuy.put('B', 5);
		itemsToBuy.put('C', 1);
		itemsToBuy.put('D', 1);
		return itemsToBuy;
	}
}
