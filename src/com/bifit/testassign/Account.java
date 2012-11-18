package com.bifit.testassign;

public class Account {
	private StringBuffer accountNumber= new StringBuffer(20);
	private StringBuffer accountCurrency= new StringBuffer(3);
	
	public Account(StringBuffer accountNumber, StringBuffer accountCurrency) {
		super();
		this.accountNumber = accountNumber;
		this.accountCurrency = accountCurrency;
	}
	
	public StringBuffer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(StringBuffer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public StringBuffer getAccountCurrency() {
		return accountCurrency;
	}
	public void setAccountCurrency(StringBuffer accountCurrency) {
		this.accountCurrency = accountCurrency;
	}
	
	

}
