package com.demo.engine.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.demo.engine.model.Item;
import com.demo.engine.model.NItemsPromotion;
import com.demo.engine.model.Promotion;
import com.demo.engine.model.TwoItemsPromotion;
import com.demo.engine.strategy.NItemsPromotionStrategy;
import com.demo.engine.strategy.PromotionStrategy;
import com.demo.engine.strategy.TwoItemsPromotionStrategy;

/**
 * Class for applying promotions and calculating the final price of items to be
 * bought
 * 
 * @author mitaly
 *
 */
public class PriceCalculator {
	// Data structure holding item keys with their prices
	private Map<Character, Item> dbItems = new HashMap<Character, Item>();
	// Data structure holding item keys with the promotion available on them
	private Map<Character, Promotion> promotions = new HashMap<Character, Promotion>();

	// initializing with sample data
	{
		dbItems.put('A', new Item('A', 50));
		dbItems.put('B', new Item('B', 30));
		dbItems.put('C', new Item('C', 20));
		dbItems.put('D', new Item('D', 15));

		promotions.put('A', new NItemsPromotion(3, 130));
		promotions.put('B', new NItemsPromotion(2, 45));
		promotions.put('C', new TwoItemsPromotion(30, new Item('D')));
		promotions.put('D', new TwoItemsPromotion(30, new Item('C')));

	}

	/**
	 * Applies promotions on items to buy and calculates the total amount
	 * 
	 * @param itemsToBuy
	 * @return
	 */
	public int calculateTotalPrice(Set<Item> itemsToBuy) {
		int totalAmount = 0;
		Set<Character> itemsBought = new HashSet<Character>();

		for (Item item : itemsToBuy) {
			char key = item.getId();
			if (!itemsBought.contains(key)) {
				Promotion promotion = promotions.get(key);

				if (promotion instanceof NItemsPromotion) {
					PromotionStrategy strategy = new NItemsPromotionStrategy(dbItems);
					totalAmount += strategy.applyPromotion(item, promotion);
				} else if (promotion instanceof TwoItemsPromotion) {
					PromotionStrategy strategy = new TwoItemsPromotionStrategy(dbItems, itemsBought);
					totalAmount += strategy.applyPromotion(item, promotion);
				} else {
					totalAmount += dbItems.get(key).getPrice() * item.getQuantity();
				}
				itemsBought.add(key);
			}
		}
		return totalAmount;
	}

}
