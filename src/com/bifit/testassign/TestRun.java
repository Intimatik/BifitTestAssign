package com.bifit.testassign;

import java.text.DateFormat;
import java.util.*;
import java.util.Map.Entry;


public class TestRun {

	/**
	 * @param args
	 */
	 Map<String,Client> clients= new HashMap<String, Client>() ;
	
	public static void main(String[] args) {
	   TestRun testInstance = new TestRun();
		Client newClient = new Client("Ivanov","Ivan","Ivanovich",new Date());
		testInstance.clients.put(newClient.getFirstName()+" "+newClient.getLastName()+" "+newClient.getSurName(), newClient);
	   
	   Client oldClient = new Client("Petrov","Vasily","Petrovich",new Date());
	   testInstance.clients.put(oldClient.getFirstName()+" "+oldClient.getLastName()+" "+oldClient.getSurName(), oldClient);
	   Client existingClient = new Client("Pupkin","Vasiliy","Victorovich",new Date());
	   testInstance.clients.put(existingClient.getFirstName()+" "+existingClient.getLastName()+" "+existingClient.getSurName(), existingClient);
	   

	}

	/**
	* Метод добавляет счет для клиента clientFio
	*/
	public void addAccount(String clientFio, String account, String currency) {
	
		Client clientToAddInfo = clients.get(clientFio);
		Account newAcc = new Account(account, currency);
		clientToAddInfo.addAccount(newAcc);
		
	}
	
	/**
	* Метод выводит на консоль результаты поиска счетов и карт по заданной валюте. Формат вывода:
	* <ФИО клиента> <Номер счета> <Валюта>
	* <ФИО клиента> <Тип карты> <Номер карты> <Валюта>
	*/
	public void findAccountsAndCardsClients(String currency) {
		for (Map.Entry<String, Client> mapEntry: clients.entrySet()) {
			Client acc = mapEntry.getValue();
			List<Card>cards =  acc.getCardList();
			List<Account> accounts = acc.getAccountList();
			for (Account account : accounts) {
				if (account.getAccountCurrency().equals(currency)) {
					System.out.println(mapEntry.getKey()+ " "+ account.getAccountNumber()+ " "+ account.getAccountCurrency());
				}
				
			}
            for (Card card : cards) {
                if (card.getCardCurrency().equals(currency)) {
                    System.out.println(mapEntry.getKey()+ " "+ card.getType()+ " "+ card.getCardNumber()+ " "+card.getCardCurrency());
                }

            }

		}
	}
	
	/**
	* Метод выводит на консоль результаты поиска клиентов и карт по заданным ФИО. Формат вывода:
	* <ФИО клиента> <год рождения>
	* <Номер счета> <Валюта>
	* ......................
	* <Тип карты> <Номер карты> <Валюта>
	* .......................
	*/
	public void findClient(String firstName) {
		Client foundClient = clients.get(firstName);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());

        System.out.println(firstName+" "+ df.format(foundClient.getDateOfBirth()));




        for (Account accs: foundClient.getAccountList()) {


        }



	}
	
	/* Метод осуществляет импорт данных из заданного файла */
	public void importData(String path){
		
	}
	/* Метод осуществляет экспорт данных в заданный файл */
	public void exportData(String path){
		
	}
}
