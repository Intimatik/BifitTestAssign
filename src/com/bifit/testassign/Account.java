package com.bifit.testassign;

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
