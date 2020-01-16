package ro.jademy.contactlist;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {


        // create a contact list of users

        User user1     =    new User("Dwayne", "Mitch", "dwayneMitch@msn.com", 22, new HashMap<>(),
                                     "Web Designer", false);

        user1.setAddress(new Address("15 Washington", 27, 13, "first",
                                     "CA 80474","San Francisco", "United States"));
        user1.setCompany(new Company("Big Drop Inc, Web Design and Developer Company", new Address("Montgomery St",
                                     8, 1, "9th", "CA 94011",
                                     "San Francisco", "United States")));

        user1.getPhoneNumbers().put("mobil", new PhoneNumber("01", "415-775-6643"));
        user1.getPhoneNumbers().put("work", new PhoneNumber("01", "225-211-1661"));




        User user2     =    new User("Bruce", "Tyron", "brucetyron@aol.org", 33, new HashMap<>(),
                                     "Barber", false);
        user2.setAddress(new Address("T15 John Eliot", 15, 723, "5th",
                                     "CA 45574","San Diego", "United States"));
        user2.setCompany(new Company("Barber's Shop", new Address("Daemon St",
                                     11, 12, "6th", "LV 22014",
                                     "San Diego", "United States")));

        user2.getPhoneNumbers().put("mobil", new PhoneNumber("01", "233-008-8423"));
        user2.getPhoneNumbers().put("work", new PhoneNumber("01", "362-751-4832"));




        User user3     =    new User("Andy", "Kane", "andykane@msn.com", 27, new HashMap<>(),
                                     "Tailor", false);
        user3.setAddress(new Address("Edgar Hoover", 30, 56, "second",
                                     "DC 4936","Washington", "United States"));
        user3.setCompany(new Company("Tailor's", new Address("Place Northwest",
                                     11, 12, "6th", "DC 1229",
                                     "Washington", "United States")));

        user3.getPhoneNumbers().put("mobil", new PhoneNumber("01", "432-574-0032"));
        user3.getPhoneNumbers().put("work", new PhoneNumber("01", "115-550-8455"));



        User user4     =    new User("Bruce", "Andrew", "bruceandrewn@aol.org", 29, new HashMap<>(),
                                     "Chef", true);
        user4.setAddress(new Address("T15 John Eliot", 15, 713, "4th",
                                     "CA 45574","San Diego", "United States"));
        user4.setCompany(new Company("Burger Twist", new Address("Abraham Lincoln St",
                                     41, 7, "3th", "LV 71153",
                                     "San Diego", "United States")));

        user4.getPhoneNumbers().put("mobil", new PhoneNumber("01", "105-9528-8300"));
        user4.getPhoneNumbers().put("work", new PhoneNumber("01", "360-177-2722"));


        // list contact list in natural order

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);


        // list contact list in natural order
        users.stream().sorted(Comparator.comparing(User::getFirstName).thenComparing(User::getLastName))
                .forEach(System.out::println);


        // list contact list by a given criteria
        users.stream().filter((User u1) -> u1.getAge() < 30).forEach(System.out::println);            // .collect(Collectors.groupingBy(user -> user.getAge() < 88)).forEach();


        // display a favorites list
        users.stream().filter(User::isFavorite).forEach(System.out::println);


        // search by a given or multiple criteria
        users.stream()
                /*.filter(User::)*/
                .map(user -> user.getAddress().getCity().toLowerCase().startsWith("s"))
                .forEach(System.out::println);


        // display some statistics for the contact list

        /*IntSummaryStatistics ageAverage =*/
//        users.stream().collect(Collectors.averagingInt(value -> value.getAge()));
//        System.out.println();
        IntSummaryStatistics ageSummary = users.stream().collect(Collectors.summarizingInt(User::getAge));
        System.out.println("Sumary age : " + ageSummary);

    }

}
