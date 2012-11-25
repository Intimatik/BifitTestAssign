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
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int hashCode() {
        return this.cardNumber.hashCode();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof Card) & ((Card) o).getCardNumber().toString().equals(this.cardNumber.toString())){
            return true;
        }
        else {return false;}

    }
}


