package ro.jademy.contactlist.edit;

import ro.jademy.contactlist.model.Address;
import ro.jademy.contactlist.model.Company;
import ro.jademy.contactlist.model.PhoneNumber;

import java.util.HashMap;
import java.util.Map;

public class Validate {

//    boolean isNumber(String input) {
//        return input.matches("\\d+");
//    }

    public static boolean ss (String input) {
        return input.matches("[a-zA-Z]");
    }

    public static void isName (String input) throws IllegalArgumentException {
        if (!input.matches("[a-zA-Z]")) throw new IllegalArgumentException("Invalid input .");
    }

    boolean isNumber(Object input) {
        return input instanceof Integer;
    }

    boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

//    int editAge (int input) {
//        int age = 0;
//        boolean quit = false;
//        do {
//            try {
//                System.out.print("Edit age : ");
//                if (input < 0 || input > 105) {
//                    age = input;
//                    quit = true;
//                }
//            } catch (RuntimeException e) {
//                System.out.println("Age doesn't fit.");
//                e.getStackTrace();
//            }
//        } while ( !quit );
//
//        return age;
//    }

//    String editName(String input) {
//        String name = null;
//        try {
//            if( isName(input) & input.length() > 1)
//                name = input;
//        } catch (RuntimeException e) {
//            e.getStackTrace();
//            System.out.print("Try again : ");
//            editName(input);
//        }
//        return name;
//    }
//
//     u.setPhoneNumbers ( editPhone(scanner.nextLine(), scanner.nextLine(), scanner.nextLine()) );

    // TODO    Menu
    Map <String, PhoneNumber> editPhone(String phoneType, String prefix, String number) {

        Map<String, PhoneNumber>  phone = new HashMap <>();
        System.out.print("Choose for home or mobile : ");

        int exit = 0;
        do {

            try {

                if(phoneType.equals("home") || phoneType.equals("mobile")) {

                    if ( (prefix.matches(".*[^0-9].*") && prefix.length() > 2) &&
                            (number.matches(".*[^0-9].*") && number.length() > 5) ) {

                        PhoneNumber phoneNumber = new PhoneNumber(prefix, number);
                        phone.put(phoneType, phoneNumber);
                        exit = 1;
                    }
                }
            } catch (RuntimeException e) {
                e.getStackTrace();
            }

        } while ( exit == 0 );

        return phone;
    }

    Address editAddress(String streetName, Integer strNr, Integer ap,
                        String fl, String zipNr, String city, String country) {

//        try {
//
//            isName(streetName);
//            isNumber(strNr);
//            isNumber(ap);
//            isNumber(fl);
//            isNumber(zipNr);
//            isName(city);
//            isName(country);
//            return new Address(streetName, strNr, ap, fl, zipNr, city, country);
//
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
        return null;
    }

    // TODO Constant - email
    String editEmail(String input) {
        String email = null;
        System.out.println("Edit email :");
        do {
            try {
                if(input.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|" +
                        "(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$"))
                    email = input;
            } catch (RuntimeException e) {
                System.out.print("Invalid input : ");
                e.getStackTrace();
            }
        } while (email == null);

        return email;
    }


    Company editCompany(String co, String streetName, Integer strNr, Integer ap,
                        String fl, String zipNr, String city, String country) {
        try {
            isName(co);
            Address address = editAddress(streetName, strNr, ap, fl, zipNr, city, country);
            return new Company(co, address);
        } catch ( Exception e) {
            e.getStackTrace();
            editCompany(co, streetName, strNr, ap, fl, zipNr, city, country);
        }
        return null;
    }


    boolean isFavorite(boolean b) {
        return b;
    }



//    String isValidName(String input) {
//        try {
//            if (isName(input)) {
//                return
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return input;
//    }



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




}
