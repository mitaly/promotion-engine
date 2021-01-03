package com.demo.engine.strategy;

import java.util.Map;
import java.util.Set;

import com.demo.engine.model.Item;
import com.demo.engine.model.Promotion;
import com.demo.engine.model.TwoItemsPromotion;

public class TwoItemsPromotionStrategy extends PromotionStrategy {
	private Set<Character> itemsBought;
	
	public TwoItemsPromotionStrategy(Map<Character, Item> dbItems, Set<Character> itemsBought) {
		super.dbItems = dbItems;
		this.itemsBought = itemsBought;
	}
	
	@Override
	public int applyPromotion(Item item, Promotion promotion) {
		TwoItemsPromotion twoItemsPromotion = (TwoItemsPromotion)promotion; 
		int currentPrice = 0;
		Item secondItem = twoItemsPromotion.getSecondItem();
		
		if (secondItem != null) {
			int minQuantity = Math.min(item.getQuantity(), secondItem.getQuantity());
			currentPrice += minQuantity * twoItemsPromotion.getPrice();
			currentPrice += (item.getQuantity() - minQuantity) * getDbItem(item.getId()).getPrice();
			currentPrice += (secondItem.getQuantity() - minQuantity) * getDbItem(secondItem.getId()).getPrice();
			itemsBought.add(secondItem.getId());
		} else {
			currentPrice += item.getQuantity() * getDbItem(item.getId()).getPrice();
		}
		return currentPrice;
	}

}
