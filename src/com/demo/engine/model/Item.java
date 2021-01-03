package com.demo.engine.model;

public class Item {
	private char id;
	private int quantity;
	private int price;
	
	public Item(char id) {
		super();
		this.id = id;
	}

	public Item(char id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
