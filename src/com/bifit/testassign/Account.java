package com.bifit.testassign;
///Класс Счета
public class Account {
	private StringBuffer accountNumber= new StringBuffer(20);
	private StringBuffer accountCurrency= new StringBuffer(3);

	public Account(String accountNumber, String accountCurrency) {
		super();
		this.accountNumber = new StringBuffer(accountNumber);
		this.accountCurrency = new StringBuffer(accountCurrency);
	}
	
	public StringBuffer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = new StringBuffer(accountNumber);
	}
	public StringBuffer getAccountCurrency() {
		return accountCurrency;
	}
	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = new StringBuffer(accountCurrency);
	}

    @Override
    public int hashCode() {
        return this.accountNumber.hashCode();
    }

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Account & ((Account) o).getAccountNumber().toString().equals(this.accountNumber.toString())){
            return true;
        }
        else {return false;}


    }

}
