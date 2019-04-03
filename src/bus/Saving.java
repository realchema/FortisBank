package bus;

import java.util.List;

public class Saving extends Account {
    private double annualInterestRate;
    private double annualGain;
    private double fees;

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getAnnualGain() {

        return annualGain;
    }

    public void setAnnualGain(double annualGain) {
        this.annualGain = annualGain;
    }

    public double getAnnualInterestRate() {

        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public Saving()
    {
        super();
        this.annualInterestRate=00.0;
        this.annualGain=0.0;
        this.fees=0.0;
    }
    public Saving(Integer ID, Double B, Date OpenD, Integer P, AccountType ty, List<Transaction> trs, double annualInterestRate, double annualgain, double fees, Customer cid)
    {
        super(ID,B,OpenD,P,ty,trs,cid);
        this.annualInterestRate=annualInterestRate;
        this.annualGain=annualgain;
        this.fees=fees;
    }

    @Override
    public String toString() {
        String state="";

            state += super.toString()+"Annual Interest Rate: "+this.getAnnualInterestRate()+"Annual Gain: "+this.getAnnualGain()+"\nFees: "+this.getFees();


        return state;
    }
}
