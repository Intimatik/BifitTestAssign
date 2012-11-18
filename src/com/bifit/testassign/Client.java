package com.bifit.testassign;

import java.util.ArrayList;
import java.util.Calendar;

public class Client {
	
	private StringBuffer lastName;
	private StringBuffer firstName;
	private StringBuffer surName;
	private Calendar dateOfBirth; 
	private ArrayList<Account> accountList;
	private ArrayList<Card> cardList;
	public StringBuffer getLastName() {
		return lastName;
	}
	public void setLastName(StringBuffer lastName) {
		this.lastName = lastName;
	}
	public StringBuffer getFirstName() {
		return firstName;
	}
	public void setFirstName(StringBuffer firstName) {
		this.firstName = firstName;
	}
	public StringBuffer getSurName() {
		return surName;
	}
	public void setSurName(StringBuffer surName) {
		this.surName = surName;
	}
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	public ArrayList<Card> getCardList() {
		return cardList;
	}
	public void setCardList(ArrayList<Card> cardList) {
		this.cardList = cardList;
	}
	
	
	

}
