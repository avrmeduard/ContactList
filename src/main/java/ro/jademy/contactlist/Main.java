package ro.jademy.contactlist;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;
import ro.jademy.contactlist.model.User;
import ro.jademy.contactlist.service.FileIUserService;
import ro.jademy.contactlist.service.MemoryIUserService;

import java.util.HashMap;
import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MemoryIUserService memoryUserService = new MemoryIUserService();

    public static void main(String[] args) {

        Menu menu = new Menu();
        FileIUserService fileUserService = new FileIUserService("contactsFile.txt");

        HashMap<String, PhoneNumber> ph = new HashMap<>();
        ph.put("home",new PhoneNumber ("07", "676655544"));

        fileUserService.addContact(new User(1,"Noon", "Mitch", "dwayneMitch@msn.com", 22,
                ph,
                new Address("15 Washington", 27, 13, "first", "CA 80474", "San Francisco", "United States"),
                "Web Designer",
                new Company("Big Drop Inc, Web Design and Developer Company",
                        new Address("Montgomery St", 8, 1, "9th", "CA 94011", "San Francisco", "United States")),
                false));


        HashMap<String, PhoneNumber> pt = new HashMap<>();
        pt.put("home",new PhoneNumber ("05", "00086755544"));
        pt.put("work", new PhoneNumber("34","4534554545"));

        fileUserService.addContact(new User(7,"Hugo", "Mitch", "dwayneMitch@msn.com", 22,
                pt,
                new Address("16 Washington", 27, 13, "first", "CA 80474", "San Francisco", "United States"),"Web Designer",
                new Company("Web Design and Developer Company", new Address("Montgomery St", 8, 1, "9th", "CA 94011", "San Francisco", "United States")), false));


        HashMap<String, PhoneNumber> gg = new HashMap<>();
        gg.put("home",new PhoneNumber ("22", "3096755544"));
        gg.put("work", new PhoneNumber("01","8888884545"));

        fileUserService.addContact(new User(109,"Michal", "Antony", "michAnt@msn.com", 44,
                pt,
                new Address("136 DC", 47, 13, "second", "DC 80474", "Washington", "United States"),"Fashion Designer",
                new Company("Nails and CO", new Address("Red St", 8, 1, "6th", "DC 11011", "Washington", "United States")), false));    // initialized contacts
        menu.printActionMenu();
    }
}


/*fileUserService.getContacts().forEach(System.out::println);
        fileUserService.search("Michal").stream().map(User::getUserID).forEach(System.out::println);
        System.out.println("People searched whit 'Mit' :");
        fileUserService.search("Michal");*/










// incercari ...

//        //print of first character
//        users.stream().flatMap(user -> Stream.of(user.getFirstName().charAt(0))).distinct().sorted(Comparator.naturalOrder()).forEachOrdered(System.out::println);



// display a favorites list
//        users.stream().filter(User::isFavorite).forEach(System.out::println);
//
//
//        // search by a given or multiple criteria
//        users.stream()
//                /*.filter(User::)*/
//                .map(user -> user.getAddress().getCity().toLowerCase().startsWith("s"))
//                .forEach(System.out::println);


//        // list contact list in natural order
//        users.stream()
//                .sorted(Comparator.naturalOrder())
//                /*.sorted(Comparator.comparing(User::getFirstName).thenComparing(User::getLastName))*/
//                .forEach(System.out::println);
//
//
//        // list contact list by a given criteria
//        users.stream().filter((User u1) -> u1.getAge() < 30).forEach(System.out::println);
//        // .collect(Collectors.groupingBy(user -> user.getAge() < 88)).forEach();
//
//
//        // display a favorites list
//        users.stream().filter(User::isFavorite).forEach(System.out::println);
//
//
//        // search by a given or multiple criteria
//        users.stream()
//                /*.filter(User::)*/
//                .map(user -> user.getAddress().getCity().toLowerCase().startsWith("s"))
//                .forEach(System.out::println);
//
//
//        // display some statistics for the contact list
//
//        /*IntSummaryStatistics ageAverage =*/
////        users.stream().collect(Collectors.averagingInt(value -> value.getAge()));
////        System.out.println();
//        IntSummaryStatistics ageSummary = users.stream().collect(Collectors.summarizingInt(User::getAge));
//        System.out.println("Sumary age : " + ageSummary);







//        users.stream().flatMap(user -> Stream.of(user.getFirstName().charAt(0))).sorted(Comparator.naturalOrder()).distinct()
//                .forEach(u -> {
//                    for (User user : users) {
//                        System.out.println(user.getFirstName());
//                    }
//                });

//
//        Map<Character, List<User>> naturalOrder = new TreeMap<>();
//        users.stream().flatMap(user -> Stream.of(user.getFirstName().charAt(0))).distinct().sorted(Comparator.naturalOrder())
////                .map((User u) -> u.getFirstName() + " " + u.getLastName())
//                .forEach(System.out::println);


//        List<String> nameList = new ArrayList<>();
//        for (int i = 0; i < users.size(); i++) {
//            String name = users.get(i).getFirstName() + " " + users.get(i).getLastName();
//            nameList.add(i, name);   /* =  */
//        }



//
//        List<String> userLinkedHashSet = users.stream().map(user -> user.getFirstName() + " " + user.getLastName()).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
//        for (String s : userLinkedHashSet) {
//            System.out.println(s.charAt(0));
//
//            if (s.charAt(0) == s.getFirstName().charAt(0)) {
//                System.out.println("\n------------\n" + s);
//            }




//


//        Map<Character, List<User>> naturalOrder = sd;

//buna
//        users.stream().map(user -> user.getFirstName() + " " + user.getLastName()).sorted(Comparator.naturalOrder()).forEach(System.out::println);


//                .collect(Collectors.groupingBy(/*, TreeMap::new, Collectors.toList()*/) );
//        System.out.println(naturalOrder.size());

//        System.out.println(users.stream().map(user -> user.getFirstName() + " " + user.getLastName())
//                        .flatMap()

//        for (Map.Entry<Character, List<User>> character : naturalOrder.entrySet()) {
//            System.out.println(character + "\n"
//                                         + users.stream().map(user -> user.getFirstName() + " " + user.getLastName())
//                                         + "\n---------");
//        }

//        users.stream().flatMap(user -> Stream.of(user.getFirstName().charAt(0))).distinct().sorted(Comparator.naturalOrder())
//                .map((User u) -> u.getFirstName() + " " + u.getLastName())
//                .forEach(System.out::println);


//        for (Map.Entry<Character, List<User>> characterListEntry : naturalOrder.entrySet()) {
//            System.out.println(characterListEntry);
//        }
    /*stream()
                .flatMap(user -> Stream.of(user.getFirstName().charAt(0)))
                *//*.distinct()*//**//*.sorted(Comparator.naturalOrder())*//*
                .sorted(Comparator.naturalOrder()).forEach(System.out::print);
//        for (Map.Entry<Character, List<User>> listEntry : naturalOrder.entrySet()) {
//            System.out.println(listEntry);*/
//        }
//    test    Map<Character, List<String>> map = list.stream().collect(Collectors.groupingBy(d -> d.charAt(0)));
//    test    Map<Character, List<String>> map = list.stream().collect(Collectors.groupingBy(d->d.charAt(0), LinkedHashMap::new, Collectors.toList()));


//        Map<Character, List<User>> naturalOrder = new TreeMap<>();
//        users.stream().sorted().sorted(Comparator
//        .comparing(User::getFirstName).thenComparing(User::getLastName))
//                .collect(Collectors.toList());



            // eroare exception ....

//            scanner.nextLine();
//                    if (phoneNumber == null || phoneNumber.length() < 13) {
//        System.out.println("Please type a valid number");
//        }
//        try {
//        int phoneNo = Integer.parseInt(phoneNumber);
//        } catch (NumberFormatException nfe) {
//        System.out.println("Please enter only numbers");
//        }
//        }
//        return firstName + " " + lastName + "\n" + phoneNumber;
//        }