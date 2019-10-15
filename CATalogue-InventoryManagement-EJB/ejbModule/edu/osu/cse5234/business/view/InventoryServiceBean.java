package edu.osu.cse5234.business.view;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import edu.osu.cse5234.model.Item;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless(mappedName="InventoryServiceBean")
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		ArrayList<Item> items = new ArrayList<>();
		Inventory inventory = new Inventory();
		Item cat_1 = new Item();
		cat_1.setName("Extra fluffy cat");
		cat_1.setPrice("5.00");
		
		items.add(cat_1);

		Item cat_2 = new Item();
		cat_2.setName("Extra extra fluffy cat");
		cat_2.setPrice("5.50");
		items.add(cat_2);
		
		Item cat_3 = new Item();
		cat_3.setName("Soft cat");
		cat_3.setPrice("3.00");
		items.add(cat_3);
		
		Item cat_4 = new Item();
		cat_4.setName("Super soft cat");
		cat_4.setPrice("3.50");
		items.add(cat_4);

		Item cat_5 = new Item();
		cat_5.setName("Nice cat");
		cat_5.setPrice("1.00");
		items.add(cat_5);
		
		
		inventory.setItems(items);
		
		return inventory;
	}

	@Override
	public boolean validateQuantity() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

}
