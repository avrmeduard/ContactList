package ro.jademy.contactlist.service;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

    List<User> getContacts();

    User getContactById(int userId);

    void addContact(User contact);

    //void editContact(int userID);

    void editContact(int userId, String firstName,
                     String lastName,
                     String email,
                     Integer age, Map<String, PhoneNumber> phoneNumber,
                     Address address,
                     String jobTitle,
                     Company company,
                     boolean isFavorite);

    void removeContact(int userId);

    List<User> search(String query);

}

