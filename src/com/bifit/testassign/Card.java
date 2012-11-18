package com.bifit.testassign;

public class Card {

	private StringBuffer type = new StringBuffer(30);
	private StringBuffer cardNumber = new StringBuffer(16);
	private StringBuffer cardCurrency = new StringBuffer(3);
	
	public Card(StringBuffer type, StringBuffer cardNumber,
			StringBuffer cardCurrency) {
		super();
		this.type = type;
		this.cardNumber = cardNumber;
		this.cardCurrency = cardCurrency;
	}
	
	public StringBuffer getType() {
		return type;
	}
	public void setType(StringBuffer type) {
		this.type = type;
	}
	public StringBuffer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(StringBuffer cardNumber) {
		this.cardNumber = cardNumber;
	}
	public StringBuffer getCardCurrency() {
		return cardCurrency;
	}
	public void setCardCurrency(StringBuffer cardCurrency) {
		this.cardCurrency = cardCurrency;
	}
}
