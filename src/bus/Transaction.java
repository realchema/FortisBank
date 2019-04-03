package bus;

import java.io.Serializable;

public class Transaction implements Serializable
{
    private Integer TransactionNumber;
    private String Description;
    private Date TransactionDate;
    private Double Amount;
    private TransactionType type;




    public Integer getTransactionNumber() {
        return TransactionNumber;
    }

    public void setTransactionNumber(Integer transactionNumber) {
        TransactionNumber = transactionNumber;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }


    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }


    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }


    public Transaction()
    {
        this.TransactionNumber=000;
        this.Amount=00.00;
        this.Description="";
        this.TransactionDate=new Date();
        this.type=TransactionType.Unknown;
    }
    public Transaction(Integer ID, Double A,String des,Date date,TransactionType ty)
    {
        this.TransactionNumber=ID;
        this.Amount=A;
        this.Description=des;
        this.TransactionDate=date;
        this.type=ty;
    }

    @Override
    public String toString() {
        return "\n"+this.getTransactionNumber()+": "+this.getAmount()+", "+this.getDescription()+", "+this.getTransactionDate()+", "+this.getType()+"\n";
    }
}
