package com.demo.engine.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.demo.engine.model.Item;
import com.demo.engine.util.PriceCalculator;

/**
 * Class containing different scenarios to test calculation by PriceCalculator
 * class
 * 
 * @author mitaly
 *
 */
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

	private Set<Item> testDataHavingNoPromotions() {
		Set<Item> itemsToBuy = new HashSet<Item>();
		itemsToBuy.add(new Item('A', 1));
		itemsToBuy.add(new Item('B', 1));
		itemsToBuy.add(new Item('C', 1));
		return itemsToBuy;
	}

	private Set<Item> testDataHaving_NTypePromotion() {
		Set<Item> itemsToBuy = new HashSet<Item>();
		itemsToBuy.add(new Item('A', 5));
		itemsToBuy.add(new Item('B', 5));
		itemsToBuy.add(new Item('C', 1));
		return itemsToBuy;
	}

	private Set<Item> testDataHaving_TwoAndNTypePromotion() {
		Set<Item> itemsToBuy = new HashSet<Item>();
		itemsToBuy.add(new Item('A', 3));
		itemsToBuy.add(new Item('B', 5));
		itemsToBuy.add(new Item('C', 1));
		itemsToBuy.add(new Item('D', 1));
		return itemsToBuy;
	}
}
