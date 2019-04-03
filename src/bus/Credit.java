package bus;

import java.util.List;

public class Credit extends Account {
    private double cardLimit;
    private Integer CardNumber;

    public Integer getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        CardNumber = cardNumber;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(double cardLimit) {
        this.cardLimit = cardLimit;
    }




    private double calculateCrditAmountLeft()
    {
        if(this.getCardLimit()-super.calculateBalanceForCredit()<=this.getCardLimit())
        {
            return (this.getCardLimit()-super.calculateBalanceForCredit());
        }
        else
        {
            return (this.getCardLimit());
        }
    }
    public Credit()
    {
        super();
        this.CardNumber=000;


    }
    public Credit(Integer ID, Double B, Date OpenD, Integer P, AccountType ty, List<Transaction> trs, Integer CardNum, double Limit, Customer cid)
    {
        super(ID,B,OpenD,P,ty,trs,cid);
        this.CardNumber=CardNum;
        this.cardLimit=Limit;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCredit Card No.: "+this.getCardNumber()+"\nAvailable Credit: "+this.calculateCrditAmountLeft()+"\nLimit: "+this.getCardLimit();
    }
}
