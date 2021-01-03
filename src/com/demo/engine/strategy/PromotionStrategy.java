package com.demo.engine.strategy;

import java.util.Map;

import com.demo.engine.model.Item;
import com.demo.engine.model.Promotion;

public abstract class PromotionStrategy {
	protected Map<Character, Item> dbItems;
	public abstract int applyPromotion(Item item, Promotion promotion);
	
	protected Item getDbItem(char id) {
		return dbItems.get(id);
	}
}
