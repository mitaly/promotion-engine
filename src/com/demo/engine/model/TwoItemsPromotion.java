package com.demo.engine.model;

/**
 * Promotion class representing - Buy 'A' and 'B' for 'x' price
 * @author mitaly
 *
 */
public class TwoItemsPromotion extends Promotion {
	private Item secondItem;

	public TwoItemsPromotion(Integer price, Item secondItem) {
		super(price);
		this.secondItem = secondItem;
	}

	public Item getSecondItem() {
		return secondItem;
	}

	public void setSecondItem(Item secondItem) {
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
