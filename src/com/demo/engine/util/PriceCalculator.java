package com.demo.engine.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.demo.engine.model.NItemsPromotion;
import com.demo.engine.model.Promotion;
import com.demo.engine.model.TwoItemsPromotion;

/**
 * Class for applying promotions and calculating the final price of items to be
 * bought
 * 
 * @author mitaly
 *
 */
public class PriceCalculator {
	// Data structure holding item keys with their prices
	private Map<Character, Integer> itemPrices = new HashMap<Character, Integer>();
	// Data structure holding item keys with the promotion available on them
	private Map<Character, Promotion> promotions = new HashMap<Character, Promotion>();

	// initializing with sample data
	{
		itemPrices.put('A', 50);
		itemPrices.put('B', 30);
		itemPrices.put('C', 20);
		itemPrices.put('D', 15);

		promotions.put('A', new NItemsPromotion(3, 130));
		promotions.put('B', new NItemsPromotion(2, 45));
		promotions.put('C', new TwoItemsPromotion(30, 'D'));
		promotions.put('D', new TwoItemsPromotion(30, 'C'));

	}

	/**
	 * Applies promotions on items to buy and calculates the total amount
	 * 
	 * @param itemsToBuy
	 * @return
	 */
	public int calculateTotalPrice(Map<Character, Integer> itemsToBuy) {
		int totalAmount = 0;
		Set<Character> itemsBought = new HashSet<Character>();

		for (Map.Entry<Character, Integer> entry : itemsToBuy.entrySet()) {
			Character key = entry.getKey();
			if (!itemsBought.contains(key)) {
				Integer quantity = entry.getValue();
				Integer actualPrice = itemPrices.get(key);

				Promotion promotion = promotions.get(key);
				if (promotion instanceof NItemsPromotion) {
					totalAmount += calculatePriceForNItemsPromotion(promotion, quantity, actualPrice);
				} else if (promotion instanceof TwoItemsPromotion) {
					totalAmount += calculatePriceForTwoItemsPromotion(promotion, quantity, actualPrice, itemsToBuy,
							itemsBought);
				} else {
					totalAmount += actualPrice * quantity;
				}
				itemsBought.add(key);
			}
		}
		return totalAmount;
	}

	/**
	 * calculates the price for NItems promotion type
	 * 
	 * @param promotion
	 * @param quantity
	 * @param actualPrice
	 * @return
	 */
	private int calculatePriceForNItemsPromotion(Promotion promotion, int quantity, int actualPrice) {
		int currentPrice = 0;
		int promotionPrice = promotion.getPrice();
		int promotionQuantity = ((NItemsPromotion) promotion).getQuantity();
		currentPrice += (quantity / promotionQuantity) * promotionPrice;

		currentPrice += (quantity % promotionQuantity) * actualPrice;
		return currentPrice;
	}

	/**
	 * calculates the price for TwoItems promotion type
	 * 
	 * @param promotion
	 * @param quantity
	 * @param actualPrice
	 * @param itemsToBuy
	 * @param itemsBought
	 * @return
	 */
	private int calculatePriceForTwoItemsPromotion(Promotion promotion, int quantity, int actualPrice,
			Map<Character, Integer> itemsToBuy, Set<Character> itemsBought) {
		int currentPrice = 0;
		Character secondItemKey = ((TwoItemsPromotion) promotion).getSecondItem();
		Integer secondItemQuantity = itemsToBuy.get(secondItemKey);
		if (secondItemQuantity != null) {
			int minQuantity = Math.min(quantity, secondItemQuantity);
			currentPrice += minQuantity * promotion.getPrice();
			currentPrice += (quantity - minQuantity) * actualPrice;
			currentPrice += (secondItemQuantity - minQuantity) * itemPrices.get(secondItemKey);
			itemsBought.add(secondItemKey);
		} else {
			currentPrice += quantity * actualPrice;
		}
		return currentPrice;
	}
}
