package ro.jademy.contactlist.service;

import ro.jademy.contactlist.model.*;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class FileIUserService implements IUserService, UserEdit {

    private boolean quit;

    private Scanner scanner = new Scanner(System.in);
    private File contactsFile;
    private List <User> contacts = new LinkedList <>();


    public FileIUserService(File contactsFile) {
        this.contactsFile = contactsFile;
    }

    public FileIUserService(String contactsFileName) {
        this(new File(contactsFileName));
    }

    @Override
    public List<User> getContacts() {

        // check if contacts is empty
        if(contacts.isEmpty()) {
            contacts.addAll(readFromFile());
        }
        // else return the curent list of contacts
        return contacts;
    }

    @Override
    public Optional <User> getContactById(int userId) {


        return contacts.stream().filter(u -> u.getUserID() == userId).findFirst();
    }

    @Override
    public void addContact(User contact) {
        // add user to contact list
        contacts.add(contact);

        // TODO : instead of rewriting hole list,
        //  we could send it to the end of a list
        //  hint : use LinkedList or Queue
        //  ??? READ MORE !

        //overwrite the whole list of contacts in the file
        writeToFile();
    }



    private User updateUser(String firstName, String lastName, String email, Integer age, Map <String,PhoneNumber> phoneNumber,
                            Address address, String jobTitle, Company company, boolean isFavorite)  {


        for (User u : contacts) {

//            try {
//                if(!(firstName.length() > 1 && firstName.matches("^[a-zA-Z]*$"))) u.setFirstName(firstName);
//                if(!(lastName.length() > 1 && lastName.matches("^[a-zA-Z]*$"))) u.setLastName(lastName);
//
//            } catch (InputNotValidException e) {
//                System.out.println("Please enter a valid last name.");
//            }


//            if(!phoneNumber.matches("^[0-9]+$")) throw new InputNotValidException("Please enter a valid number phone.");


        }


//        return new User(firstName, lastName, email, age, new HashMap<>(), address, jobTitle, company, isFavorite);
        return null;
    }


    // TODO select user first by ID and rewrite it !!!
    //  . Use Exeption !!

    @Override
    public void editContact(int userId, String firstName, String lastName, String email, Integer age, Map<String,
            PhoneNumber> phoneNumber, Address address, String jobTitle, Company company, boolean isFavorite) {

        Optional<User> userOpt = getContactById(userId);

        // edit the contact only if the user was found
        if(userOpt.isPresent()) {
            User user = userOpt.get();

            //TODO
            // .edit contact and replace it whit the old one

            contacts.remove(user);
            // TODO: use setters and update the user
            // overwrite the whole list of contacts in the file
            writeToFile();
        }
    }

    public void editContact(int userId) {

        // editezi contact :
        // gasesti userul dupa user id si il editezi

         Optional<User> userOpt = getContactById(userId);

         if (userOpt.isPresent()) {



             for (User u : contacts) {

                 if( u.getUserID() == userId ) {

                     switch (scanner.nextLine()) {
                         case "first name" :
                         case "last name" :
                             editName(scanner.nextLine());
                             break;
                         case "email" :
                             editEmail(scanner.nextLine());
                             break;
                         case "age" :
                             editAge(scanner.nextInt());
                             break;
                         case "phone" :
                             //editPhone(scanner.nextInt());
                             break;
                         case "adress" :
                             break;
                         case "job" :
                             break;
                         case "company" :
                             break;
                         case "favorite" :
                             break;
                         default:
                             System.out.println("Invalid input.");
                             // metoda recursiva, se cheama singura
                             // editContact


                 }
             }
         }
         // input scanner -> make switch



        }

        System.out.println("Contact not found.");

    }

//    private boolean isWord(String word) {
//        return Pattern.matches("[a-zA-z]+",word);
//    }

//    private boolean isNumber(String num) {
//        return Pattern.matches("[0-9]+", num);
//    }
//
//    private boolean isEmail(String email) {
//        return Pattern.matches("^[a-zA-Z0-9_+&*-] + (?:\\\\.[a-zA-Z0-9_+&*-]\n" +
//                "+ )*@(?:[a-zA-Z0-9-]+\\\\.) + [a-zA-Z]{2,7}$", email);
//    }




    @Override
    public void removeContact(int userId) {
        Optional<User> userOpt = getContactById(userId);

        // remove the contact if only if found
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            contacts.remove(user);
        }

        writeToFile();
    }


    /**
     * type an string as a
     * @param query and return
     * @return the result
     */


    // TODO something it is not working well !!!!!!

    @Override
    public List<User> search(String query) {

        List<String> result = new ArrayList<>();
        String regex = ".*" + query + ".*";

        for (String user : contactToString()) {
            boolean matches = Pattern.matches(regex, user);
            if (matches) {
                result.add(user);
            }
        }
        // TODO needs to be return a map of a result
        //  we need a new method to display the result !!!!!
        return userList(result);
    }

    // TODO Through contactToString method
    //  we will write it to DATA BASE,
    //  and read it
    private List<String> contactToString() {

        List<String> userInLine = new ArrayList<>();
        StringBuilder line = new StringBuilder();

        for (User u : contacts) {

            line.append(u.getUserID() + "|" + u.getFirstName() + "|" + u.getLastName() + "|" + u.getEmail() + "|" + u.getAge() + "|");
            int count = 1;

            for (Map.Entry<String, PhoneNumber> entry : u.getPhoneNumbers().entrySet()) {
                line.append(entry.getKey() + "_" + entry.getValue().toString());

                if (count < u.getPhoneNumbers().entrySet().size()) {
                    line.append(";");
                }
                count++;
            }

            line.append("|" + u.getAddress().toString());
            line.append("|" + u.getCompany().getName() + "_" + u.getCompany().getAddress().toString());
            line.append("|" + u.getIsFavorite());
            userInLine.add(line.toString());
            line = new StringBuilder();
        }
        return userInLine;
    }


    // from a LinkedList of Strings we return a LinkedList of Users
    private List<User> userList(List<String> stringList) {

        List<User> userList = new LinkedList <>();

        for (User u : userList) {

            for (String s : stringList) {

                String[] userProperties = s.split("\\|");

                u.setUserID(Integer.parseInt(userProperties[0]));
                u.setFirstName(userProperties[1]);
                u.setLastName(userProperties[2]);
                u.setEmail(userProperties[3]);
                u.setAge(Integer.parseInt(userProperties[4]));

                String[] phoneArr = userProperties[5].split(",");
                for (String phoneNo : phoneArr) {
                    String[] phoneNoArr = phoneNo.split("_");
                    PhoneNumber ph = new PhoneNumber(phoneNoArr[1] , phoneArr[2]);

                    u.getPhoneNumbers().put(phoneArr[0] , ph);
                }

                String[] addressProp = userProperties[6].split("_");
                Address address = new Address(addressProp[0] , Integer.parseInt(addressProp[1]) , Integer.parseInt(addressProp[2]) ,
                        addressProp[3] , addressProp[4] , addressProp[5] , addressProp[6]);


                String[] companyProp = userProperties[8].split("_");
                Company company = new Company(companyProp[0] , new Address(companyProp[1] , Integer.parseInt(companyProp[2]) ,
                        Integer.parseInt(companyProp[3]) , companyProp[4] , companyProp[5] , companyProp[6] , companyProp[7]));

                u.setAddress(address);
                u.setJobTitle(userProperties[7]);
                u.setCompany(company);


                String favorite = userProperties[9];

                boolean isFavorite = false;
                if (favorite.equals("Favorite")) {
                    isFavorite = true;
                } else if (favorite.equals("Not favorite")) {
                    isFavorite = false;
                }

                u.setFavorite(isFavorite);

                userList.add(u);
            }
        }
        return userList;
    }



    // it reads from a file and return a LinkedList of Strings.
    private List<User> readFromFile() {

        List<String> stringUsers = new LinkedList <>();

        BufferedReader bf = null;
        try {

            bf = new BufferedReader(new FileReader(contactsFile));
            String currentLine = bf.readLine();

            while(currentLine  != null ) {
                stringUsers.add(currentLine);
                currentLine = bf.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bf != null) bf.close();
            } catch (IOException e) {
                e.printStackTrace(); }
        }

        return userList(stringUsers);
    }


    // we copy data from file and save it
    private void writeToFile() {

        BufferedWriter out = null;

        try {

            // the second parameter append set to false,
            // will overwrite the file (clear it and write to it again).

            out = new BufferedWriter(new FileWriter(contactsFile, false));

            for (String s : contactToString()) {
                out.write(s + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
















}