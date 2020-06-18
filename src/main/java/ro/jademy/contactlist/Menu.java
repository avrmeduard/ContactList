package ro.jademy.contactlist;

import static ro.jademy.contactlist.edit.Validate.*;
import ro.jademy.contactlist.model.User;
import ro.jademy.contactlist.service.FileIUserService;

import java.util.*;
import java.util.stream.Collectors;


public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static List<User> users = new ArrayList<>();
    FileIUserService fileIUserService = new FileIUserService("contactsFile.txt");



    public void printActionMenu() {

        printMenu();
        boolean quit = false;
        while (!quit) {

            int action = scanner.nextInt();
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
                    editContact();
                    printMenu();
                    break;
                case 5:

            }
        }
    }

    public void editContact() {


        // editezi contact :
        // gasesti userul dupa user id si il editezi

        System.out.println("Select customer id to edit : ");

        int id = scanner.nextInt();
        User u = getContactById(id);

        //Optional<User> userOpt = getContactById(userId);


        for (User u : contacts) {

            if( u.getUserID() == userId ) {

                switch (scanner.nextLine()) {
                    case "first name" :
                        String name = scanner.nextLine();
                          if(isName(name) ){
                           u.setFirstName(name); }
                        break;
                    case "last name" :
                        u.setLastName( editName(scanner.nextLine()) );
                        break;
                    case "email" :
                        u.setEmail( editEmail(scanner.nextLine()) );
                        break;
                    case "age" :
                        u.setAge( editAge(scanner.nextInt()) );
                        break;
                    case "phone" :
                        u.setPhoneNumbers(editPhone(scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
                        break;
                    case "adress" :
                        u.setAddress(editAddress(scanner.nextLine(), scanner.nextInt(), scanner.nextInt(), scanner.nextLine(),
                                scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
                        break;
                    case "job" :

                        u.setJobTitle(editJob(scanner.nextLine()));
                        break;
                    case "company" :
                        u.setCompany( editCompany(scanner.nextLine(), scanner.nextLine(), scanner.nextInt(),
                                scanner.nextInt(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine() ));
                        break;
                    case "favorite" :
                        u.setFavorite(isFavorite(scanner.hasNextBoolean()));
                        break;
                    default:
                        System.out.println("Invalid input.");
                        // metoda recursiva, se cheama singura
                        // editContact


                }
            }
        }
        // input scanner -> make switch




        System.out.println("Contact not found.");

    }

    public void printMenu() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to print contacts details\n" +
                "3 - to print favorite list\n" +
                "4 - to print a list of available actions.");
        System.out.println("Choose your actions: "); }

    public void startPhone() { System.out.println("Starting phone ..."); }

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
        userList.stream().filter(User::isFavorite).map(u-> u.getFirstName() + " " + u.getLastName() ).forEach(System.out::println);
        System.out.println("Choose your actions: ");

//        for (int i = 0; i < userList.size(); i++) {
//            if (userList.get(i).isFavorite()) {
//                System.out.println("Your favorite contacts are : \n" + userList.get(i).getFirstName() + " " + userList.get(i).getLastName());
//            }
//        }
    }




}
