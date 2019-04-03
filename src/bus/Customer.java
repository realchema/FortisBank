package bus;


import data.EmailException;
import data.OnlyAlphabets;
import data.SSNException;
import data.Validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable
{
    private Integer IdentificationNumber;
    private String SIN;
    private Title title;
    private String FirstName;
    private String LastName;
    private Address address;
    private String Email;
    private Phone PhoneNumber;
    private Date BirthDay;
    private List<Account> accounts;

    public Integer getIdentificationNumber() {
        return IdentificationNumber;
    }

    public void setIdentificationNumber(Integer identificationNumber) {
        IdentificationNumber = identificationNumber;
    }



    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }



    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) throws OnlyAlphabets {
        if (Validation.IsOnlyAlphabets(firstName)) {

            FirstName = firstName;
        }
    }



    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) throws OnlyAlphabets{
        if (Validation.IsOnlyAlphabets(lastName)) {

            LastName = lastName;

        }
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) throws EmailException {
        if (Validation.IsOnlyEmail(email)) {
            Email = email;
        }
    }



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Phone getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Phone phoneNumber) {
        PhoneNumber = phoneNumber;
    }


    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date birthDay) {
        BirthDay = birthDay;
    }



    public String getSIN() {
        return SIN;
    }

    public void setSIN(String SIN) throws SSNException {
        if (Validation.IsOnlySSN(SIN)) {
            this.SIN = SIN;
        }
    }



    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Customer()
    {
        this.title=Title.UNKNOWN;
        this.SIN="0000";
        this.PhoneNumber=new Phone();
        this.IdentificationNumber=00000;
        this.FirstName="";
        this.LastName="";
        this.Email="";
        this.BirthDay=new Date();
        this.address=new Address();
        this.accounts=new ArrayList<>();

    }
    public Customer(Integer id, String S, Title typ, String fn, String ln, Date bd, Phone p, Address ad, String em, List<Account> accs)
    {
        this.IdentificationNumber=id;
        this.SIN=S;
        this.title=typ;
        this.PhoneNumber=p;
        this.FirstName=fn;
        this.LastName=ln;
        this.Email=em;
        this.BirthDay=bd;
        this.address=ad;
        this.accounts=accs;
    }

    @Override
    public String toString() {
        String state;
        state= "Customer: "+"\n"+this.getTitle()+"."+this.getFirstName()+","+this.getLastName()+"\n- Birthdate: "+this.getBirthDay()+"\n- Phone: "+this.getPhoneNumber()+"\n- Address: "+this.getAddress()+"\n- Email: "+this.getEmail()+"\nAccounts: "+this.getAccounts();
        return  state;
    }
}
