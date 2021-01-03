package com.demo.engine.strategy;

import java.util.Map;

import com.demo.engine.model.Item;
import com.demo.engine.model.NItemsPromotion;
import com.demo.engine.model.Promotion;

public class NItemsPromotionStrategy extends PromotionStrategy {

	public NItemsPromotionStrategy(Map<Character, Item> dbItems) {
		super.dbItems = dbItems;
	}
	
	@Override
	public int applyPromotion(Item item, Promotion promotion) {
		NItemsPromotion nItemsPromotion = (NItemsPromotion)promotion;
		int currentPrice = 0;
		currentPrice += (item.getQuantity() / nItemsPromotion.getQuantity()) * nItemsPromotion.getPrice();
		currentPrice += (item.getQuantity() % nItemsPromotion.getQuantity()) * getDbItem(item.getId()).getPrice();
		return currentPrice;
	}
	
}
