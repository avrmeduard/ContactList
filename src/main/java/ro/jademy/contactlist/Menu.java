package ro.jademy.contactlist;

import ro.jademy.contactlist.model.User;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static List<User> users = new ArrayList<>();

    public int printActionMenu(int action) {

        boolean quit = false;
        while (!quit) {
            action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Shutting down ...");
                    quit = true;
                    break;
                case 1:
                    contactsList(users);
                    break;
                case 2:
                    contactsDetails(users);
                    break;
                case 3:
                    favoriteContacts(users);
                    break;
                case 4:
                    printMenu();
                    break;
            }
        }
        return action;
    }

    public void printMenu() {

        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to print contacts details\n" +
                "3 - to print favorite list\n" +
                "4 - to print a list of available actions.");
        System.out.println("Choose your actions: ");

    }



    /**
     * Create user list from file.
     *
     * @param file the file containing the users
     * @return a User list
     */




    private static void writeUserToFile(String s, File file) {

    }


//    public static String createUser(String name1, String name2, String phoneNo) throws Exception{
//        name1 = "";
//        name2 = "";
//        phoneNo = "";
//
//
//        System.out.println("Create a new user : \n");
//
//        try {
//
//            System.out.print("Enter your first name : ");
//            String firstName = scanner.next();
//            if (firstName.length() <= 1 || !firstName.matches("^[a-zA-Z]*$")) {
//                return name1 += firstName;
//            }
//        } catch (Exception e) {
//            System.out.println("Invalid first name, please try one more time. " + e);
//        }
//
//        try {
//
//            System.out.print("Enter your last name : ");
//            String lastName = scanner.next();
//            if(lastName.length() <= 1 || !lastName.matches("^[a-zA-Z]*$")) {
//                name2 += lastName;
//            }
//        } catch (Exception e) {
//            System.out.println("Invalid second name, please try one more time. " + e);
//        }
//
//        try {
//            System.out.print("Enter your no : ");
//            String phoneNumber = scanner.next();
//            if (phoneNumber.matches(".*[^0-9].*")) {
//                phoneNo += phoneNumber;
//                /*throw new ("Please enter a valid number phone.");*/
//            }
//        } catch (Exception e) {
//            System.out.println("Invalid phone number, please try one more time. " + e);
//        }
//
//        return new User(name1, name2, phoneNo);
//    }




    public void startPhone() {
        System.out.println("Starting phone ...");
    }



    private static void contactsList(List<User> userList) {
        Map<Character, List<User>> naturalOrder = userList.stream().sorted(Comparator.comparing(User::getFirstName).thenComparing(User::getLastName))
                .collect(Collectors.groupingBy(u -> u.getFirstName().charAt(0)));

        int index = 1;
        for (Map.Entry<Character, List<User>> listEntry : naturalOrder.entrySet()) {
            System.out.println("\n" + listEntry.getKey() + "\n" + "---------------");
            for (User header : listEntry.getValue()) {
                System.out.println(index++ + ". " + header.getFirstName() + " " + header.getLastName());
            }
            System.out.println("---------------");
        }
        System.out.println("Choose your actions: ");
    }


    private static void contactsDetails(List<User> users) {
        System.out.println("Select an index to print his contact details ");
        int indexContacts = scanner.nextInt();
        scanner.nextLine();
        System.out.println(users.get(indexContacts));
        System.out.println("Choose your actions: ");
    }


    private static void favoriteContacts(List<User> userList) {
        System.out.println("Favorite contacts : ");
        userList.stream().filter(u -> u.isFavorite()).map(u-> u.getFirstName() + " " + u.getLastName() ).forEach(System.out::println);
        System.out.println("Choose your actions: ");

//        for (int i = 0; i < userList.size(); i++) {
//            if (userList.get(i).isFavorite()) {
//                System.out.println("Your favorite contacts are : \n" + userList.get(i).getFirstName() + " " + userList.get(i).getLastName());
//            }
//        }
    }




}
