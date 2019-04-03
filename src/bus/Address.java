package bus;

import data.OnlyAlphabets;
import data.PostalCodeException;
import data.Validation;

import java.io.Serializable;

public class Address implements Serializable
{
    private int StrNum;
    private String StrName;
    private String City;
    private String Province;
    private String PostCode;
    private String Country;

    public int getStrNum() {
        return StrNum;
    }

    public void setStrNum(int strNum) {
        StrNum = strNum;
    }


    public String getStrName() {
        return StrName;
    }

    public void setStrName(String strName) throws OnlyAlphabets {
        if (Validation.IsOnlyAlphabets(strName)) {
            StrName = strName;
        }
    }


    public String getCity() {
        return City;
    }

    public void setCity(String city) throws OnlyAlphabets {
        if (Validation.IsOnlyAlphabets(city)) {
            City = city;
        }
    }



    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) throws OnlyAlphabets {
        if (Validation.IsOnlyAlphabets(province))
        {
            Province = province;
    }
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode)throws PostalCodeException {
        if (Validation.PostCode(postCode)) {
            PostCode = postCode;
        }
    }



    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) throws OnlyAlphabets {
        if(Validation.IsOnlyAlphabets(country))
        {
        Country = country;
        }
    }



    public Address()
    {
        this.StrNum=0000;
        this.StrName="";
        this.Province="";
        this.PostCode="";
        this.Country="";
        this.City="";
    }
    public Address(int str,String StrN,String P,String Post,String Ctry,String Cty)
    {
        this.StrNum=str;
        this.StrName=StrN;
        this.Province=P;
        this.PostCode=Post;
        this.City=Cty;
        this.Country=Ctry;
    }

    @Override
    public String toString() {
        return "\n"+this.getStrNum()+"-"+this.getStrName()+"\n"+this.getPostCode()+","+this.getCity()+"\n"+this.getProvince()+","+this.getCountry();
    }
}
