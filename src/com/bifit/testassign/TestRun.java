package com.bifit.testassign;

import java.util.Date;

public class TestRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   Client newClient = new Client("Ivanov","Ivan","Ivanovich",new Date());
	   Client oldClient = new Client("Petrov","Vasily","Petrovich",new Date());
	   Client existintClient = new Client("Pupkin","Vasiliy","Victorovich",new Date());
	   
	   
	   
	   
	   

	}

	/**
	* Метод добавляет счет для клиента clientFio
	*/
	public void addAccount(String clientFio, String Account, String currency) {
	
	}
	
	/**
	* Метод выводит на консоль результаты поиска счетов и карт по заданной валюте. Формат вывода:
	* <ФИО клиента> <Номер счета> <Валюта>
	* <ФИО клиента> <Тип карты> <Номер карты> <Валюта>
	*/
	public void findAccountsAndCardsClients(String currency) {
		
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
		
	}
	
	/* Метод осуществляет импорт данных из заданного файла */
	public void importData(String path){
		
	}
	/* Метод осуществляет экспорт данных в заданный файл */
	public void exportData(String path){
		
	}
}
