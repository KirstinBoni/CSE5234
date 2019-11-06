/**
 * 
 */
package edu.osu.cse5234.business.view;

import java.util.ArrayList;
import java.util.List;

import edu.osu.cse5234.model.Item;


public class Inventory implements java.io.Serializable {
	private static final long serialVersionUID = 1892074706075089697L;
	private List<Item> items = new ArrayList<>();
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
