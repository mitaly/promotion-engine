package com.demo.engine.model;

/**
 * Promotion class representing - Buy 'A' and 'B' for 'x' price
 * @author mitaly
 *
 */
public class TwoItemsPromotion extends Promotion {
	private Character secondItem;

	public TwoItemsPromotion(Integer price, Character secondItem) {
		super(price);
		this.secondItem = secondItem;
	}

	public Character getSecondItem() {
		return secondItem;
	}

	public void setSecondItem(Character secondItem) {
		this.secondItem = secondItem;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TwoItemsPromotion [secondItem=");
		builder.append(secondItem);
		builder.append("]");
		return builder.toString();
	}

}
