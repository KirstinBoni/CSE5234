package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;
import edu.osu.cse5234.util.ServiceLocator;


@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = new Order();
		order.setItems(ServiceLocator.getInventoryService().getAvailableInventory().getItems());
		request.setAttribute("order", order);
		return "OrderEntryForm"; 
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		request.getSession().setAttribute("error", null);

		if(ServiceLocator.getOrderProcessingService().validateItemAvailability(order)) {
			request.getSession().setAttribute("order", order);
			return "redirect:/purchase/paymentEntry";
		} else {
			request.getSession().setAttribute("error", "Please enter a valid amount");
			return "redirect:/purchase";
		}
	}


	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("paymentInfo", new PaymentInfo());	
		return "PaymentEntryForm";
	}

	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String shippingEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("shippingInfo", new ShippingInfo());	
		return "ShippingEntryForm"; 
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shippingInfo") ShippingInfo shippingInfo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().setAttribute("shippingInfo", shippingInfo);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderEntry(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return "ViewOrder"; 
	}

	@RequestMapping(path = "confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Order order = (Order) request.getSession().getAttribute("order");
		request.getSession().setAttribute("confirmation", ServiceLocator.getOrderProcessingService().processOrder(order));
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "ViewConfirmation"; 
	}
}