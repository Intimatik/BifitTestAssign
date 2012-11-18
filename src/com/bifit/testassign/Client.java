package com.bifit.testassign;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Client {
	
	private StringBuffer lastName = new StringBuffer(30);
	private StringBuffer firstName = new StringBuffer(30);
	private StringBuffer surName = new StringBuffer(30);
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
	public List<Account> getAccountList() {
		return Collections.unmodifiableList(this.accountList);
	}
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	public List<Card> getCardList() {
		return Collections.unmodifiableList(this.cardList);
	}
	public void setCardList(ArrayList<Card> cardList) {
		this.cardList = cardList;
	}
	
	public void addAccount(Account acc) {
		this.accountList.add(acc);		
	}
	
	public void addCard(Card card) {
		this.cardList.add(card);
	}
	
	
	
}
