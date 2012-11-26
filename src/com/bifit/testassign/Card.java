package com.bifit.testassign;
///класс Карта
public class Card {

	private StringBuffer type = new StringBuffer(30);
	private StringBuffer cardNumber = new StringBuffer(16);
	private StringBuffer cardCurrency = new StringBuffer(3);

	
	public StringBuffer getType() {
		return type;
	}
	public void setType(String type) {
		this.type = new StringBuffer(type);
	}
	public StringBuffer getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = new StringBuffer(cardNumber);
	}
	public StringBuffer getCardCurrency() {
		return cardCurrency;
	}
	public void setCardCurrency(String cardCurrency) {
		this.cardCurrency = new StringBuffer(cardCurrency);
	}

    public Card() {
        super();
    }

    @Override
    public int hashCode() {
        return this.cardNumber.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof Card) & ((Card) o).getCardNumber().toString().equals(this.cardNumber.toString())){
            return true;
        }
        else {return false;}

    }
}


