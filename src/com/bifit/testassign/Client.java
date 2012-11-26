package com.bifit.testassign;
 ///Класс клиент
import java.util.*;

public class Client {
	
	private StringBuffer lastName = new StringBuffer(30);
	private StringBuffer firstName = new StringBuffer(30);
	private StringBuffer surName = new StringBuffer(30);
	private Date dateOfBirth; 
	private HashSet<Account> accountList;
	private HashSet<Card> cardList;
	public StringBuffer getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = new StringBuffer(lastName);
	}
	public StringBuffer getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = new StringBuffer(firstName);
	}
	public StringBuffer getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = new StringBuffer(surName);
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Set<Account> getAccountList() {
		return Collections.unmodifiableSet(this.accountList);
	}
	public void setAccountList(HashSet<Account> accountList) {
		this.accountList = accountList;
	}
	public Set<Card> getCardList() {
		return Collections.unmodifiableSet(this.cardList);
	}
	public void setCardList(HashSet<Card> cardList) {
		this.cardList = cardList;
	}
	
	public void addAccount(Account acc) {
		this.accountList.add(acc);		
	}
	

    public Client() {
    }
}
