package prod;

import bus.*;
import data.FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TESTER {

 public static void main(String[] args) throws IOException, FileNotFoundException,ClassNotFoundException {
     String ans="";
     Scanner scan=new Scanner(System.in);
     ArrayList<Customer> listOfC=new ArrayList<>();

     ArrayList<Transaction> trs = new ArrayList<>();
     trs.add(new Transaction(1, 50.00, "FOOD", new Date(01, 11, 2018), TransactionType.Withdraw));
     trs.add(new Transaction(2, 50.00, "ATM", new Date(01, 11, 2018), TransactionType.Withdraw));
     trs.add(new Transaction(3, 50.00, "ATM", new Date(01, 11, 2018), TransactionType.Withdraw));
     trs.add(new Transaction(4, 50.00, "ATM", new Date(01, 11, 2018), TransactionType.Deposit));
     trs.add(new Transaction(5, 50.00, "ATM", new Date(01, 11, 2018), TransactionType.Withdraw));
     trs.add(new Transaction(6, 50.00, "ATM", new Date(01, 11, 2018), TransactionType.Withdraw));
     trs.add(new Transaction(7, 50.00, "ATM", new Date(01, 11, 2018), TransactionType.Withdraw));
     trs.add(new Transaction(8,100.00,"BarResto",new Date(12,11,2018), TransactionType.Deposit));
     ArrayList<Transaction> trs2 = new ArrayList<>();
     Address ad = new Address(303, "Rue Edmond-Larivee", "Quebec", "H7L0A4", "Canada", "Laval");

     trs2.add(new Transaction(1, 50.00, "FOOD", new Date(01, 11, 2018), TransactionType.Withdraw));
     trs2.add(new Transaction(2, 50.00, "ATM", new Date(01, 11, 2018), TransactionType.Withdraw));
     trs2.add(new Transaction(3, 100.00, "ATM", new Date(01, 11, 2018), TransactionType.Deposit));

     List<Account> accs = new ArrayList<>();

     Customer cust=new Customer(1,"476846789", Title.Mr,"Sanjeev","Tharm", new Date(21, 06, 1999),new Phone(514, 9296108),ad,"sanjeev21@icloud.com",accs);
     Account cheq = new Cheque(1234, 800.00, new Date(01, 11, 2018), 4444, AccountType.Cheque, trs, cust);
     Account credit = new Credit(5431, 1000.0, new Date(1, 11, 2018), 1335, AccountType.Credit, trs2, 4728456, 1000.0, cust);


     accs.add(cheq);
     accs.add(credit);

//     System.out.println("----------------------------------------------------------");
//     System.out.println(cust);
//        System.out.println("Do you want to delete Cheque?");
//        ans=scan.next();
//        if (ans.equals("y"))
//        {
//            System.out.println("Cannot the delete the main acount");
//        }
//     System.out.println("Do you want to delete Credit?");
//     ans=scan.next();
//     if (ans.equals("y"))
//     {
//         accs.remove(credit);
//         System.out.println("DONE");
//         System.out.println(cust);
//     }
     listOfC.add(cust);
     System.out.println(listOfC.get(0));
     FileHandler file=new FileHandler();
     file.WriteToSerializeFile(listOfC);
     System.out.println("---------------------------------------------------------------------------------------------");
     System.out.println("DONE");
     List<Customer> listFromFile=file.ReadFromSerializeFile();
     System.out.println("List from the file");
     for (Customer element:listFromFile)
     {
        System.out.println(element);
     }

 }

}
