package com.demo.engine.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.demo.engine.model.NItemsPromotion;
import com.demo.engine.model.Promotion;
import com.demo.engine.model.TwoItemsPromotion;

public class PriceCalculator {
	private Map<Character, Integer> itemsWithPrices = new HashMap<Character, Integer>();
	private Map<Character, Promotion> promotions = new HashMap<Character, Promotion>();
	{
		itemsWithPrices.put('A', 50);
		itemsWithPrices.put('B', 30);
		itemsWithPrices.put('C', 20);
		itemsWithPrices.put('D', 15);

		promotions.put('A', new NItemsPromotion(3, 130));
		promotions.put('B', new NItemsPromotion(2, 45));
		promotions.put('C', new TwoItemsPromotion(30, 'D'));
		promotions.put('D', new TwoItemsPromotion(30, 'C'));

	}

	public Integer calculateTotalPrice(Map<Character, Integer> itemsToBuy) {
		Integer totalAmount = 0;
		Set<Character> itemsBought = new HashSet<Character>();

		for (Map.Entry<Character, Integer> entry : itemsToBuy.entrySet()) {
			Character key = entry.getKey();
			if (!itemsBought.contains(key)) {
				Integer quantity = entry.getValue();
				Integer actualPrice = itemsWithPrices.get(key);

				Promotion promotion = promotions.get(key);
				if (promotion instanceof NItemsPromotion) {
					int promotionPrice = promotion.getPrice();
					int promotionQuantity = ((NItemsPromotion) promotion).getQuantity();
					totalAmount += (quantity / promotionQuantity) * promotionPrice;

					totalAmount += (quantity % promotionQuantity) * actualPrice;
				} else if (promotion instanceof TwoItemsPromotion) {
					Character secondItemKey = ((TwoItemsPromotion) promotion).getSecondItem();
					Integer secondItemQuantity = itemsToBuy.get(secondItemKey);
					if (secondItemQuantity != null) {
						int minQuantity = Math.min(quantity, secondItemQuantity);
						totalAmount += minQuantity * promotion.getPrice();
						totalAmount += (quantity - minQuantity) * actualPrice;
						totalAmount += (secondItemQuantity - minQuantity) * itemsWithPrices.get(secondItemKey);
						itemsBought.add(secondItemKey);
					} else {
						totalAmount += quantity * actualPrice;
					}
				} else {
					totalAmount += actualPrice * quantity;
				}
				itemsBought.add(key);
			}
		}
		return totalAmount;
	}
}
