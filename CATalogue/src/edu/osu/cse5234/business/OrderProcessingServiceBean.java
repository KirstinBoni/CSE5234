package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
	@PersistenceContext
	EntityManager entityManager;
	
    public boolean validateItemAvailability(Order order) {
    	List<Item> i1 = new ArrayList<>();
    	for(LineItem i : order.getItems()) {
    		Item item = new Item();
    		item.setAvailableQuantity(i.getQuantity());
    		item.setId(i.getId()); 
    		item.setItemNumber(i.getItemNumber());
    		item.setName(i.getItemName());
    		item.setUnitPrice(i.getPrice());
			i1.add(item);
    	}
    	return ServiceLocator.getInventoryService().validateQuantity(i1);
    }
    
    public String processOrder(Order order) {
    	
    	List<Item> i1 = new ArrayList<>();
    	for(LineItem i : order.getItems()) {
    		Item item = new Item();
    		item.setAvailableQuantity(i.getQuantity());
    		item.setId(i.getId()); 
    		item.setItemNumber(i.getItemNumber());
    		item.setName(i.getItemName());
    		item.setUnitPrice(i.getPrice());
			i1.add(item);
    	}
    
    	ServiceLocator.getInventoryService().validateQuantity(i1);
    	ServiceLocator.getInventoryService().updateInventory(i1);
    	entityManager.persist(order);
    	entityManager.flush();
    	return "test confirmation code";
    }

}
