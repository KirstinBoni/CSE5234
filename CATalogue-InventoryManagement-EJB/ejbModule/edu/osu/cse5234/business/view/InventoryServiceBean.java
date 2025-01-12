package edu.osu.cse5234.business.view;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.model.Item;

/**
 * Session Bean implementation class InventoryServiceBean
 */
@Stateless(mappedName="InventoryServiceBean")
@Remote(InventoryService.class)
public class InventoryServiceBean implements InventoryService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	String MY_QUERY = "Select i from Item i";

    /**
     * Default constructor. 
     */
    public InventoryServiceBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Inventory getAvailableInventory() {
		
		List<Item> items = entityManager.createQuery(MY_QUERY, Item.class).getResultList();

		Inventory inventory = new Inventory();
		
		
//		Item cat_1 = new Item();
//		cat_1.setName("Extra fluffy cat");
//		cat_1.setPrice("5.00");
//		
//		items.add(cat_1);
//
//		Item cat_2 = new Item();
//		cat_2.setName("Extra extra fluffy cat");
//		cat_2.setPrice("5.50");
//		items.add(cat_2);
//		
//		Item cat_3 = new Item();
//		cat_3.setName("Soft cat");
//		cat_3.setPrice("3.00");
//		items.add(cat_3);
//		
//		Item cat_4 = new Item();
//		cat_4.setName("Super soft cat");
//		cat_4.setPrice("3.50");
//		items.add(cat_4);
//
//		Item cat_5 = new Item();
//		cat_5.setName("Nice cat");
//		cat_5.setPrice("1.00");
//		items.add(cat_5);
		
		
		inventory.setItems(items);
		
		return inventory;
	}

	@Override
	public boolean validateQuantity(List<Item> items) {
		List<Item> available = getAvailableInventory().getItems();
		
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getAvailableQuantity() > available.get(i).getAvailableQuantity())
				return false;
		}
		// TODO Auto-generated method stub.
		return true;
	}

	@Override
	public boolean updateInventory(List<Item> items) {
		// TODO Auto-generated method stub
		return true;
	}

}
