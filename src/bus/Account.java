package bus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements ITransactions, IAccount, Serializable
{
    private Integer AccountNumber;
    private Integer PIN;
    private AccountType type;
    private Date OpenedDate;
    private double balance;
    private List<Transaction> transactions;
    private Customer customer;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




    public Integer getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        AccountNumber = accountNumber;
    }



    public Integer getPIN() {
        return PIN;
    }

    public void setPIN(Integer PIN) {
        this.PIN = PIN;
    }



    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }



    public Date getOpenedDate() {
        return OpenedDate;
    }

    public void setOpenedDate(Date openedDate) {
        OpenedDate = openedDate;
    }



    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }





    public Account()
    {
        this.AccountNumber=0000;
        this.balance=0.0;
        this.OpenedDate=new Date();
        this.PIN=0000;
        this.type=AccountType.Unknown;
        this.transactions=new ArrayList<Transaction>();
        this.customer=new Customer();
    }
    public Account(Integer ID, double balance, Date OpenD, Integer P, AccountType ty, List<Transaction> trs, Customer cust)
    {
        this.AccountNumber=ID;
        this.balance=balance;
        this.OpenedDate=OpenD;
        this.PIN=P;
        this.type=ty;
        this.transactions=trs;
        this.customer=cust;
    }
    @Override
    public double calculatefees(int size) {
        double f=0.0;
        int count=0;
        if(size>4)
        {
            count=this.getTransactions().size()-4;
            for (int i =1;i<=count;i++)
            {
                f=f+.50;
            }

        }

        return f;
    }

    @Override
    public double calculateBalanceForCheque() {
        double minus=0.0;
        double plus=00.0;
        double fees=this.calculatefees(this.getTransactions().size());
        for (Transaction ele:this.getTransactions()) {
            if(ele.getType()== TransactionType.Withdraw) {
                minus += ele.getAmount();
            }
            if(ele.getType()== TransactionType.Deposit) {
                plus+=ele.getAmount();
            }
        }

        minus+=fees;

//        this.setBalance(this.getBalance()-minus);
//        return this.getBalance();
        return this.getBalance()-minus+plus;
    }

    @Override
    public double calculateBalanceForSaving() {
        return 0;
    }

    @Override
    public double calculateBalanceForCredit() {
        double minus =0.0;
        double plus=0.0;
        for (Transaction ele:this.getTransactions()) {
            if(ele.getType()== TransactionType.Withdraw)
            {
                minus += ele.getAmount();
            }
            if(ele.getType()== TransactionType.Deposit)
            {
                plus+=ele.getAmount();
            }
        }

        return minus-plus;
    }

    @Override
    public String toString() {
        String state="\n\n\tCustomer ID: "+this.getCustomer().getIdentificationNumber()+","+this.getCustomer().getFirstName()+"'s";
        if (this.getType()==AccountType.Cheque)
        {
            state += "\nAccount Number: " + this.getAccountNumber() + ": Balance: " + this.calculateBalanceForCheque() + ", Creation date of account" + this.getOpenedDate() + ", " + this.getType()+" Account";

        }
        if (this.getType()==AccountType.Credit)
        {
            state += "\nAccount Number: " + this.getAccountNumber() + ": Balance: " + this.calculateBalanceForCredit() + ", Creation date of account" + this.getOpenedDate() + ", " + this.getType()+" Account";

        }
        return state.concat("\nTransactions: "+getTransactions().toString());

    }

}
