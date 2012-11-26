package com.bifit.testassign;

import java.io.*;
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
//        Client newClient = new Client("Ivanov","Ivan","Ivanovich",new Date());
//        testInstance.clients.put(newClient.getFirstName()+" "+newClient.getLastName()+" "+newClient.getSurName(), newClient);
//
//        Client oldClient = new Client("Petrov","Vasily","Petrovich",new Date());
//        testInstance.clients.put(oldClient.getFirstName()+" "+oldClient.getLastName()+" "+oldClient.getSurName(), oldClient);
//        Client existingClient = new Client("Pupkin","Vasiliy","Victorovich",new Date());
//        testInstance.clients.put(existingClient.getFirstName()+" "+existingClient.getLastName()+" "+existingClient.getSurName(), existingClient);

        try{
            testInstance.importData("/Users/Intimatik/DEV/import.txt");
            testInstance.exportData("/Users/Intimatik/DEV/export.txt");
            int a=0;
            System.out.println(testInstance.clients.size());
        }
        catch (Exception e) {
             e.printStackTrace();
        }


    }

    /**
     * Метод добавляет счет для клиента clientFio
     */
    public void addAccount(String clientFio, String account, String currency) throws Exception{

        Client clientToAddInfo = clients.get(clientFio);
        if (clientToAddInfo==null) {
            throw new IllegalArgumentException("client not found");
        }

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
            Set<Card>cards =  acc.getCardList();
            Set<Account> accounts = acc.getAccountList();
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
     */    //#TODO add pattern matching
    public void findClient(String firstName) throws Exception {
        Client foundClient = clients.get(firstName);

        if (foundClient==null) {
            throw new IllegalArgumentException("client not found");
        }

        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());

        System.out.println(firstName + " " + df.format(foundClient.getDateOfBirth()));

        for (Account acc: foundClient.getAccountList()) {
            System.out.println(acc.getAccountNumber()+" "+acc.getAccountCurrency());

        }

        for (Card card: foundClient.getCardList()) {
            System.out.println(card.getType()+" "+card.getCardNumber()+" "+ card.getCardCurrency());

        }

    }

    /* Метод осуществляет импорт данных из заданного файла */
    public void importData(String path) throws Exception{
        BufferedReader scanner  =null;
        String firstName,secondName,lastname;
        Date birthDate;
        int i=0;
        String s;
        try{
            scanner = new BufferedReader(new FileReader(path));

            Client newClient=null;
            HashSet<Account> accountSet = null;
            HashSet<Card>cardSet = null;

            Card card = null;
            Account account = null;
            int accIterator =0,cardIterator=0;


            while ((s=scanner.readLine())!=null) {

                if (s.equals("")) {
                    if (newClient!=null) {
                        this.clients.put(newClient.getFirstName()+" "+newClient.getLastName()+" "+newClient.getSurName(),newClient);
                    }
                    if (account!=null && accountSet.size()!=0) {
                       accountSet.add(account);
                       newClient.setAccountList(accountSet);
                       }

                    if (card!=null && cardSet.size()!=0) {
                        cardSet.add(card);
                        newClient.setCardList(cardSet);
                    }

                        newClient = new Client();
                        accountSet = new HashSet<Account>();
                        cardSet = new HashSet<Card>();
                        card = null;
                        account = null;
                        accIterator=0;
                        cardIterator=0;
                    continue;
                }

                //fulfil it
                String[] nameValue= scanLine(s);

                System.out.println(nameValue);
                if (nameValue[0].equalsIgnoreCase("FIRST_NAME")){
                    firstName = nameValue[1];
                    newClient.setFirstName(firstName);
                    continue;
                }

                if (nameValue[0].equalsIgnoreCase("SECOND_NAME")){
                    lastname = nameValue[1];
                    newClient.setLastName(lastname);
                    continue;
                }

                if (nameValue[0].equalsIgnoreCase("MIDDLE_NAME")){
                    secondName = nameValue[1];
                    newClient.setSurName(secondName);
                    continue;

                }


                if (nameValue[0].equalsIgnoreCase("BIRTH_DATE")){
//                     #TODO add date parse
                    birthDate = new Date();
                    continue;

                }

                if (nameValue[0].contains("ACCOUNTS")) {
                    String[] tokens = nameValue[0].split("\\.");
                    if (account==null & accIterator==Integer.parseInt(tokens[1])){
                        //create first account
                        account = new Account();
                    }

                    if (account!=null & accIterator!=Integer.parseInt(tokens[1])){
                        //new account
                        accIterator++;
                        accountSet.add(account);
                        account = new Account();
                    }

                    if (tokens[2].equalsIgnoreCase("NUMBER")) {
                        account.setAccountNumber(nameValue[1]);
                    }
                    else if (tokens[2].equalsIgnoreCase("CURRENCY")){
                        account.setAccountCurrency(nameValue[1]);
                    }

                    continue;

                }

                if (nameValue[0].contains("CARDS")) {
                    String[] tokens = nameValue[0].split("\\.");
                    if (card==null & cardIterator==Integer.parseInt(tokens[1])){
                        //create first card
                        card = new Card();
                    }

                    if (card!=null & cardIterator!=Integer.parseInt(tokens[1])){
                        //new card
                        cardIterator++;
                        cardSet.add(card);
                        card = new Card();
                    }

                    if (tokens[2].equalsIgnoreCase("NUMBER")) {
                        card.setCardNumber(nameValue[1]);
                    }
                    else if (tokens[2].equalsIgnoreCase("CURRENCY")){
                        card.setCardCurrency(nameValue[1]);
                    }
                    else if (tokens[2].equalsIgnoreCase("TYPE")){
                        card.setType(nameValue[1]);
                        }



                }


            }

            if (newClient!=null) {
                this.clients.put(newClient.getFirstName()+" "+newClient.getLastName()+" "+newClient.getSurName(),newClient);
            }
            if (account!=null) {
                accountSet.add(account);
                newClient.setAccountList(accountSet);
            }

            if (card!=null) {
                cardSet.add(card);
                newClient.setCardList(cardSet);
            }
        }
        catch (IOException e) {
            throw new IllegalArgumentException("something's wrong with the file");
        }

        finally {

            scanner.close();

        }


    }

    private String[] scanLine(String s) {
        Scanner scanner = new Scanner(s);
        scanner.useDelimiter("=");
        String name="",value="";
        if ( scanner.hasNext() ){
            name = scanner.next();
            value = scanner.next();
        }

        String[] nameValue = new String[2];
        nameValue[0]= name.trim();
        nameValue[1]= value.trim();

        return  nameValue;
    }

    /* Метод осуществляет экспорт данных в заданный файл */
    public void exportData(String path){
              BufferedWriter writer=null;
       try{
          writer = new BufferedWriter(new PrintWriter(path));

           writer.write("Content-Type=client_info");
           writer.newLine();
           writer.newLine();

           for (Client client:clients.values()) {
               writer.write("FIRST_NAME="+client.getFirstName().toString());
               writer.newLine();
               writer.write("SECOND_NAME="+client.getLastName().toString());
               writer.newLine();
               writer.write("MIDDLE_NAME="+client.getSurName().toString());
               writer.newLine();
//               writer.write("BIRTH_DATE="+client.getDateOfBirth().toString());
               Set<Account> accounts= client.getAccountList();
               Iterator<Account> iterator = accounts.iterator();
               int i=0;
               while (iterator.hasNext()) {
                     Account acc = iterator.next();
                     writer.write("ACCOUNTS."+i+".NUMBER="+acc.getAccountNumber().toString());
                   writer.newLine();
                     writer.write("ACCOUNTS."+i+".CURRENCY="+acc.getAccountCurrency().toString());
                   writer.newLine();
                     i++;
                     }
               Set<Card> cards = client.getCardList();
               Iterator<Card> iteratorB = cards.iterator();
               int j=0;
               while (iteratorB.hasNext()) {
                   Card card = iteratorB.next();
                   writer.write("CARDS."+i+".TYPE="+card.getType().toString());
                   writer.newLine();
                   writer.write("CARDS."+i+".NUMBER="+card.getCardNumber().toString());
                   writer.newLine();
                   writer.write("CARDS."+i+".CURRENCY="+card.getCardCurrency().toString());
                   writer.newLine();
                   j++;
               }
             writer.newLine();
           }

       }
       catch (IOException e){
           e.printStackTrace();
       }
        finally {
           try{
           writer.close();
           }
           catch (IOException e) {}
       }
    }
}
