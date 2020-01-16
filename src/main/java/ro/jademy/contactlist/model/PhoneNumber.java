package ro.jademy.contactlist.model;

public class PhoneNumber {

    private String countryCode; // ex: +40
    private String number; // ex: 740123456


    public PhoneNumber(String countryCode, String number) {
        this.countryCode = countryCode;
        this.number = number;
    }

//    public String getNumber() {
//        return String.format("%s %s", countryCode, number);
//    }
//
//    public void setNumber(String number) {
//        this.number = String.format("%s %s", this.countryCode, number);
//    }


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.countryCode + " " + this.number;
    }
}
