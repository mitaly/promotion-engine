package com.demo.engine.model;

public class NItemsPromotion extends Promotion{
	private Character itemKey;
	private Integer quantity;
	
	public Character getItemKey() {
		return itemKey;
	}
	public void setItemKey(Character itemKey) {
		this.itemKey = itemKey;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NItemsPromotion [itemKey=");
		builder.append(itemKey);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("]");
		return builder.toString();
	}
	
}
