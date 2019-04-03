package bus;

import java.util.List;

public class Cheque extends Account
{

    public Cheque()
    {
        super();


    }
    public Cheque(Integer ID,double b,Date OpenD,Integer P,AccountType ty,List<Transaction> trs,Customer cid)
    {
        super(ID,b,OpenD,P,ty,trs,cid);
    }



    @Override
    public String toString() {
        String state="";
        if(this.getTransactions().size()>4)
        {
            state += super.toString()+"\nFees: "+this.calculatefees(super.getTransactions().size())+"\nAdditional charges of .50$ for every transaction above the limit. This fee has already been redacted in your balance.";

        }
        else
        {
           state += super.toString();
        }
        return state;
    }
}
