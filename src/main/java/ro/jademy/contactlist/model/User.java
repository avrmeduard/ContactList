package ro.jademy.contactlist.model;

import java.util.Map;

public class User /*implements Comparator<User> */{

    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

    private Map<String, PhoneNumber> phoneNumbers;
    private Address address;

    private String jobTitle;
    private Company company;

    private boolean isFavorite;


    public User(String firstName, String lastName, String email, Integer age, Map<String, PhoneNumber> phoneNumbers, String jobTitle, boolean isFavorite) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.phoneNumbers = phoneNumbers;
        this.address = null;
        this.jobTitle = jobTitle;
        this.company = null;
        this.isFavorite = isFavorite;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }


    @Override
    public String toString() {
        return  "\n"+ firstName + " " +lastName +
                ", email : " + email +
                ", age " + age +
                ", phoneNumbers : " + phoneNumbers +
                ", " + address +
                ", jobTitle='" + jobTitle + '\'' +
                ", company=" + company +
                ", isFavorite=" + isFavorite;
    }

//    public int compare(User o1, User o2) {
//        return o1.getFirstName().compareTo(o2.getFirstName());
//    }


//        Comparator<User> comparator = (u1, u2) -> u1.getFirstName().compareTo(u2.getFirstName());

}
