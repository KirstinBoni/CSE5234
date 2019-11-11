package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.CreditCardPayment;
import com.chase.payment.PaymentProcessorService;
import com.ups.shipping.client.ShippingInitiationClient;

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
	@WebServiceRef(wsdlLocation = "http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
	private PaymentProcessorService service;
	@PersistenceContext
	EntityManager entityManager;
	
	private static String uri = "http://localhost:9080/UPS/jaxrs";
	
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
    	CreditCardPayment creditCard = new CreditCardPayment();
    	creditCard.setId(order.getPayment().getId());
    	creditCard.setCardHolderName(order.getPayment().getCardHolderName());
    	creditCard.setCreditCardNumber(order.getPayment().getCreditCardNumber());
    	creditCard.setExpirationDate(order.getPayment().getExpirationDate());
    	creditCard.setCvvCode(order.getPayment().getCvvCode());

    	
    	String confirmationNumber = service.getPaymentProcessorPort().processPayment(creditCard);
    	
    	if(confirmationNumber.equals("0")) {
    		return "failure";
    	}

    	order.getPayment().setConfirmationNumber(confirmationNumber);
    	
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
    	
		JsonObject requestJson = Json.createObjectBuilder()
				.add("Organization", "CATalogue INC.")
				.add("OrderRefId", order.getId())
				.add("Zip", order.getShipping().getZip())
				.add("ItemsNumber", order.getItems().size())
				.build();
		
		ShippingInitiationClient shippingClient = new ShippingInitiationClient(uri);
		JsonObject responseJson = shippingClient.invokeInitiateShipping(requestJson);
		System.out.println("UPS accepted request? " + responseJson.getBoolean("Accepted"));
		System.out.println("Shipping Reference Number: " +  responseJson.getInt("ShippingReferenceNumber"));
		
		order.getShipping().setUpsShippingRef(Integer.toString(responseJson.getInt("ShippingReferenceNumber")));
    	entityManager.persist(order);
    	entityManager.flush();
		return order.getShipping().getUpsShippingRef();
    }

}
