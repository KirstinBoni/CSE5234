package com.chase.payment;

public class PaymentProcessor {
	public String ping() {
		return "Bank ready for business";
	}
	
	public String processPayment(CreditCardPayment card) {
		return "124";
	}
}
