package com.demo.engine.model;

/**
 * Base class representing a Promotion
 * @author mitaly
 *
 */
public abstract class Promotion {
	protected Item item;
	protected Integer price;
	
	public Promotion(Integer price) {
		super();
		this.price = price;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
