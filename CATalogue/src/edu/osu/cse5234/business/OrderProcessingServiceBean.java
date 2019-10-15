package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {
    public boolean validateItemAvailability(Order order) {
    	return ServiceLocator.getInventoryService().validateQuantity();
    }
    
    public String processOrder(Order order) {
    	ServiceLocator.getInventoryService().validateQuantity();
    	ServiceLocator.getInventoryService().updateInventory(order.getItems());
    	return "test confirmation code";
    }

}
