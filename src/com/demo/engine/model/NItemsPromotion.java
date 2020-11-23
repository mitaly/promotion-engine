package com.demo.engine.model;

public class NItemsPromotion extends Promotion{
	private Integer quantity;
	
	public NItemsPromotion(Integer quantity, Integer price) {
		super(price);
		this.quantity = quantity;
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
		builder.append("NItemsPromotion [quantity=");
		builder.append(quantity);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
	
	
}
