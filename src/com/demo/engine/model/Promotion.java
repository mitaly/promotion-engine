package com.demo.engine.model;

public abstract class Promotion {
	public Promotion(Integer price) {
		super();
		this.price = price;
	}

	protected Integer price;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
}
