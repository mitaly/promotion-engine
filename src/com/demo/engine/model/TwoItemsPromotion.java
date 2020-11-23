package com.demo.engine.model;

import java.util.Set;

public class TwoItemsPromotion extends Promotion {
	private Set<Character> itemKeys;

	public Set<Character> getItemKeys() {
		return itemKeys;
	}

	public void setItemKeys(Set<Character> itemKeys) {
		this.itemKeys = itemKeys;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TwoItemsPromotion [itemKeys=");
		builder.append(itemKeys);
		builder.append("]");
		return builder.toString();
	}

}
