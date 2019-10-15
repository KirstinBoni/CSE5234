package edu.osu.cse5234.business.view;

import java.util.List;

import edu.osu.cse5234.model.Item;

public interface InventoryService {
	public Inventory getAvailableInventory();
	
	public boolean validateQuantity();
	
	public boolean updateInventory(List<Item> items);
}
