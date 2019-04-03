package prod;

import bus.*;
import data.EmailException;
import data.OnlyAlphabets;
import data.PostalCodeException;
import data.SSNException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Tester2 {

    public static Customer CreateCustomer(List<Account> accs, Cheque cheq, Customer aCust, String out, Date aBd, Phone aP, Address ad, Scanner scanner, int count, List<Customer> customers)throws OnlyAlphabets, EmailException, PostalCodeException, SSNException
    {

        out="";

        System.out.println("Customer ID:");
        int CustID=scanner.nextInt();
        aCust.setIdentificationNumber(CustID);
        System.out.println("Customer's SIN:");
        aCust.setSIN(scanner.next());
        while(!(out.equals("male")||out.equals("female"))) {

            System.out.println("Customer's gender (male/female):");
            String s = scanner.next();

            if (s.equals("male"))
            {
                aCust.setTitle(Title.Mr);
                out="male";
            }
            if (s.equals("female"))
            {
                aCust.setTitle(Title.Mrs);
                out="female";
            }
            if(!(s.equals("male")||s.equals("female")))
            {
                System.out.println("If male type \"male\" or if female type \"female\"");
            }
        }

        System.out.println("First Name:");
        aCust.setFirstName(scanner.next());
        System.out.println("Last Name:");
        aCust.setLastName(scanner.next());
        System.out.println("Birth Day:");
        aBd.setDay(scanner.nextInt());
        System.out.println("Birth Month:");
        aBd.setMonth(scanner.nextInt());
        System.out.println("Birth Year:");
        aBd.setYear(scanner.nextInt());
        aCust.setBirthDay(aBd);
        System.out.println("City code:");
        aP.setCityCode(scanner.nextInt());
        System.out.println("Cell phone:");
        aP.setCellCode(scanner.nextInt());
        aCust.setPhoneNumber(aP);
        System.out.println("Street Number:");
        ad.setStrNum(scanner.nextInt());
        System.out.println("Street Name:");
        ad.setStrName(scanner.next());
        System.out.println("Postal Code/ Zip Code:");
        ad.setPostCode(scanner.next());
        System.out.println("City:");
        ad.setCity(scanner.next());
        System.out.println("Province:");
        ad.setProvince(scanner.next());
        System.out.println("Country:");
        ad.setCountry(scanner.next());
        aCust.setAddress(ad);
        System.out.println("Email:");
        aCust.setEmail(scanner.next());
        count=10000+customers.size()+CustID;
        cheq.setAccountNumber(count);
        System.out.println("Amount to deposit:");
        cheq.setBalance(scanner.nextDouble());
        cheq.setCustomer(aCust);
        cheq.setOpenedDate(new Date(java.time.LocalDate.now().getDayOfMonth(),java.time.LocalDate.now().getMonthValue(),java.time.LocalDate.now().getYear()));
        System.out.println("PIN:");
        cheq.setPIN(scanner.nextInt());
        cheq.setType(AccountType.Cheque);
        cheq.setTransactions(new ArrayList<>());
        accs.add(cheq);
        aCust.setAccounts(accs);
        System.out.println("Customer created!");

        return aCust;

    }
    public static void Display(List<Customer> customers)
    {
        for (Customer elemet:customers)
        {
            System.out.println(elemet);
        }
    }
    public static void TrType(String out, Scanner scanner, Transaction aT)
    {

        while (!(out.equals("deposit") || out.equals("withdrawal"))) {

            System.out.println("Transaction Type(deposit/withdrawal):");
            String s = scanner.next();

            if (s.equals("deposit")) {
                aT.setType(TransactionType.Deposit);
                out = "deposit";
            }
            if (s.equals("withdrawal")) {
                aT.setType(TransactionType.Withdraw);
                out = "withdrawal";
            }
            if (!(s.equals("deposit") || s.equals("withdrawal"))) {
                System.out.println("If it is a deposit type \"deposit\" or if it is a withdrawal type \"withdrawal\"");
            }
        }

    }
    public static void Remove(Scanner scanner,List<Customer> customers){
        System.out.println("Customer id:");
        int id=scanner.nextInt();
        for (Customer ele:customers)
        {
            if (id==ele.getIdentificationNumber())
            {
                customers.remove(ele);
                break;
            }
        }

    }
    public static Customer Search(List<Customer> customers, int id)
    {
        Customer aTemp=new Customer();
        for (Customer ele:customers)
        {
            if (id==ele.getIdentificationNumber())
            {
                aTemp=ele;
                System.out.println("found");

            }
        }
        return aTemp;
    }
    public static void CreateTrCheq(Transaction aT, int rand, Scanner scanner, Customer aTemp, String out)
    {
        TrType(out,scanner,aT);
        aT.setTransactionNumber(rand);
        aT.setTransactionDate(new Date(java.time.LocalDate.now().getDayOfMonth(), java.time.LocalDate.now().getMonthValue(), java.time.LocalDate.now().getYear()));
        System.out.println("Amount:");
        aT.setAmount(scanner.nextDouble());
        System.out.println("Transaction Description:");
        aT.setDescription(scanner.next());
        for (Account ele:aTemp.getAccounts())
        {
            if (ele.getType()== AccountType.Cheque)
            {
                ele.getTransactions().add(aT);
                break;
            }
        }

    }
    public static void CreateTrCredit(Transaction aT, int rand, Scanner scanner, Customer aTemp, String out)
    {
        TrType(out,scanner,aT);
        aT.setTransactionNumber(rand);
        aT.setTransactionDate(new Date(java.time.LocalDate.now().getDayOfMonth(), java.time.LocalDate.now().getMonthValue(), java.time.LocalDate.now().getYear()));
        System.out.println("Amount:");
        aT.setAmount(scanner.nextDouble());
        System.out.println("Transaction Description:");
        aT.setDescription(scanner.next());
        for (Account ele:aTemp.getAccounts())
        {
            if (ele.getType()== AccountType.Credit)
            {
                ele.getTransactions().add(aT);
                break;
            }
        }

    }
    public static String menu(Scanner scan)
    {
        String opt="";
        System.out.println("1.Create Customer");
        //DONE
        System.out.println("2.Display Customers");
        //DONE
        System.out.println("3.Remove Customer");
        //DONE
        System.out.println("4.Read from file");
        System.out.println("5.Search Customer");
        //DONE
        System.out.println("6.Accounts");
        //DONE
        System.out.println("7.Transactions");
        //DONE
        System.out.println("8.Write to file");
        System.out.println("Choose an option: ");
        opt=scan.next();

      return opt;

    }

    public static void main(String[] args){
      String out="";
      int id=0;
      int count=0;
      int rand=0;







        List<Customer> customers=new ArrayList<>();
        List<Account> accs;
        Scanner scanner=new Scanner(System.in);
        Customer aCust;
        Customer aTemp=new Customer();
        Date aBd;
        Phone aP;
        Address ad;
        Cheque cheq;
        Credit credit;
        Transaction aT;
        do {




                String opt = menu(scanner);
            try {

                switch (opt) {
                    case "1":
                        accs = new ArrayList<>();
                        cheq = new Cheque();
                        aCust = new Customer();
                        aBd = new Date();
                        aP = new Phone();
                        ad = new Address();
                        aCust = CreateCustomer(accs, cheq, aCust, out, aBd, aP, ad, scanner, count, customers);
                        customers.add(aCust);
                        break;
                    case "2":
                        Display(customers);
                        break;
                    case "3":

                        Remove(scanner, customers);
                        break;
                    case "5":
                        System.out.println("Customer id:");
                        id = scanner.nextInt();
                        aTemp = Search(customers, id);
                        System.out.println("5.1 Display Chequing");
                        System.out.println("5.2 Display Saving");
                        System.out.println("5.3 Display Credit");
                        System.out.println("Choose an option: ");
                        String opt2 = scanner.next();
                        switch (opt2) {
                            case "5.1":
                                for (Account ele : aTemp.getAccounts()) {
                                    if (ele.getType() == AccountType.Cheque) {
                                        System.out.println(ele);
                                    }
                                }
                                break;
                            case "5.2":
                                for (Account ele : aTemp.getAccounts()) {
                                    if (ele.getType() == AccountType.Saving) {
                                        System.out.println(ele);
                                    } else {
                                        System.out.println("No Saving Account");
                                    }
                                }
                                break;
                            case "5.3":
                                for (Account ele : aTemp.getAccounts()) {
                                    if (ele.getType() == AccountType.Credit) {
                                        System.out.println(ele);
                                    } else {
                                        System.out.println("No Credit Account");
                                    }
                                }
                                break;

                        }
                        break;
                    case "6":
                        System.out.println("Customer id:");
                        id = scanner.nextInt();
//                          for (Customer ele:customers)
//                          {
//                              if (id==ele.getIdentificationNumber())
//                              {
//                                  aTemp=ele;
//                                  System.out.println("found");
//                              }
//                          }
                        aTemp = Search(customers, id);
                        System.out.println("6.1 Create a Credit account");
                        System.out.println("6.2 Create a Saving account");
                        System.out.println("Choose an option: ");
                        String opt3 = scanner.next();
                        switch (opt3) {
                            case "6.1":
                                rand = Integer.parseInt(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1))))))));
                                credit = new Credit();
                                //Account credit = new Credit(5431, 1000.0, new Date(1, 11, 2018), 1335, AccountType.Credit, new ArrayList<>(), 4728456, 1000.0, aTemp);
                                //aTemp.getAccounts().add(credit);
                                System.out.println("Card Limit:");
                                credit.setCardLimit(scanner.nextDouble());
                                credit.setCustomer(aTemp);
                                credit.setCardNumber(rand);
                                credit.setAccountNumber(aTemp.getIdentificationNumber() + rand);
                                credit.setBalance(0);
                                credit.setType(AccountType.Credit);
                                credit.setTransactions(new ArrayList<>());
                                System.out.println("PIN:");
                                credit.setPIN(scanner.nextInt());
                                credit.setOpenedDate(new Date(java.time.LocalDate.now().getDayOfMonth(), java.time.LocalDate.now().getMonthValue(), java.time.LocalDate.now().getYear()));
                                aTemp.getAccounts().add(credit);
                                System.out.println("COMPLETED");
                                break;
                        }
                        break;
                    case "7":
                        aT = new Transaction();
                        rand = Integer.parseInt(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1)).concat(Integer.toString((int) (Math.random() * 9 + 1)))))))));
                        System.out.println("Customer id:");
                        id = scanner.nextInt();
                        out = "";
//                  for (Customer ele:customers)
//                  {
//                      if (id==ele.getIdentificationNumber())
//                      {
//                          aTemp=ele;
//                          System.out.println("found");
//                      }
//                  }
                        aTemp = Search(customers, id);
                        System.out.println("7.1 Add a transaction to Cheque");
                        System.out.println("7.2 Add a transaction to Credit");
                        System.out.println("Choose an option:");
                        String trsopt = scanner.next();
                        switch (trsopt) {
                            case "7.1":

                                CreateTrCheq(aT, rand, scanner, aTemp, out);

                                break;
                            case "7.2":

                                CreateTrCredit(aT, rand, scanner, aTemp, out);
                                break;
                        }
                        break;


                }


            }
            catch (Exception e)
            {
               System.out.println(e.getMessage());
            }
        }
       while (true);



    }
}
