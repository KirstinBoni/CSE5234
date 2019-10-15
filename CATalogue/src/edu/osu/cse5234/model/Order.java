package edu.osu.cse5234.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private ArrayList<Item> items = new ArrayList<>();

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
