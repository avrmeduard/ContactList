package ro.jademy.contactlist.service;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    List<User> getContacts();

    Optional<User> getContactById(int userId);

    void addContact(User contact);

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

//    List<User> search(String query);
//
//
//    public List<User> getContacts();
//    public void addContact(User contact);
//    public User getContact(int userId);
//    void editContact(User contact);
//    void editContact(int userId);
//    void removeContact(User contact);
//    void removeContact(int userId);
//
//    public List<User> search (String query);
}

