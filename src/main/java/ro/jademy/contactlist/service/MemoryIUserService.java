package ro.jademy.contactlist.service;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;

import java.util.*;

public class MemoryUserService implements UserService{

    Scanner scanner = new Scanner(System.in);
    private List<User> contacts = new ArrayList<>();


    @Override
    public List<User> getContacts() {

        // check if contacts is empty and init the contact list only if this is true
        if(contacts.isEmpty()) {
            contacts.addAll(initContacts()); // get the contacts from the init method and add them to the contacts list, which should be used through the program
        }

        // else return the current list of contacts
        return contacts;
    }

    @Override
    public Optional<User> getContactById(int userId) {
        return contacts.stream().filter(u -> u.getUserID() == userId).findFirst();
    }

    @Override
    public void addContact(User contact) {
        // add user to contact list
        contacts.add(contact);
    }

    @Override
    public void editContact(int userId, String firstName, String lastName, String email, Integer age, Map<String, PhoneNumber> phoneNumber, Address address, String jobTitle, Company company, boolean isFavorite) {
        Optional<User> userOpt = getContactById(userId);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            // TODO: use setters and update the user
        }

    }

    @Override
    public void removeContact(int userId) {
        Optional<User> userOpt = getContactById(userId);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            contacts.remove(user);
        }

    }

    @Override
    public List<User> search(String query) {

//        query = scanner.findInLine()
        for (User user : contacts) {

        }
        // TODO: implement method

        return new ArrayList<>();
    }

    private List<User>  initContacts() {

        User user1 = new User(1,"Dwayne", "Mitch", "dwayneMitch@msn.com", 22, new HashMap<>(),
                new Address("15 Washington", 27, 13, "first", "CA 80474", "San Francisco", "United States"),"Web Designer",
                new Company("Big Drop Inc, Web Design and Developer Company", new Address("Montgomery St", 8, 1, "9th", "CA 94011", "San Francisco", "United States")), false);

        user1.getPhoneNumbers().put("mobil", new PhoneNumber("01", "415-775-6643"));
        user1.getPhoneNumbers().put("work", new PhoneNumber("01", "225-211-1661"));



        User user2 = new User(2,"Bruce", "Tyron", "brucetyron@aol.org", 33, new HashMap<>(),
                new Address("T15 John Eliot", 15, 723, "5th", "CA 45574", "San Diego", "United States"),"Barber",
                new Company("Barber's Shop", new Address("Daemon St", 11, 12, "6th", "LV 22014", "San Diego", "United States")), false);

        user2.getPhoneNumbers().put("mobil", new PhoneNumber("01", "233-008-8423"));
        user2.getPhoneNumbers().put("work", new PhoneNumber("01", "362-751-4832"));



        User user3 = new User(3,"Andy", "Kane", "andykane@msn.com", 27, new HashMap<>(),
                new Address("Edgar Hoover", 30, 56, "second", "DC 4936", "Washington", "United States"),"Tailor",
                new Company("Tailor's", new Address("Place Northwest", 11, 12, "6th", "DC 1229", "Washington", "United States")),false);

        user3.getPhoneNumbers().put("mobil", new PhoneNumber("01", "432-574-0032"));
        user3.getPhoneNumbers().put("work", new PhoneNumber("01", "115-550-8455"));



        User user4 = new User(4,"Bruce", "Andrew", "bruceandrewn@aol.org", 29, new HashMap<>(),
                new Address("T15 John Eliot", 15, 713, "4th",
                        "CA 45574", "San Diego", "United States"),"Chef",
                new Company("Burger Twist", new Address("Abraham Lincoln St", 41, 7, "3th", "LV 71153", "San Diego", "United States")),true);

        user4.getPhoneNumbers().put("mobil", new PhoneNumber("01", "105-9528-8300"));
        user4.getPhoneNumbers().put("work", new PhoneNumber("01", "360-177-2722"));




        Map<String, PhoneNumber> firstUSerPhoneNumbers = new HashMap<>();
        firstUSerPhoneNumbers.put("home", new PhoneNumber("740123456"));
        firstUSerPhoneNumbers.put("work", new PhoneNumber("740111222"));

        Address firstUserAddress = new Address("Some Street", 1, "Bucharest", "Romania");
        Company firstUserCompany = new Company("Some Company");

        // using the complete constructor
        User firstUser = new User(1, "John", "Doe", "jonh.doe@example.com", 33, firstUSerPhoneNumbers, firstUserAddress, "programmer", firstUserCompany, false);

        // using one of the simpler constructors
        User secondUser = new User(2, "Jane", "Doe", new PhoneNumber("072098765"));

        // using the simplest constructor
        User thirdUser = new User(3, "Fred", "Bloggs", "072023232");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);

        return users;
    }






}
