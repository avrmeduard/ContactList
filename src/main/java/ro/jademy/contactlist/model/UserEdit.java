package ro.jademy.contactlist.model;

public interface UserEdit {


    default String editName(String input) {
        String name = null;
        System.out.print("Edit name : ");

        do {
            try {
                if( input.matches("[a-zA-z]") & input.length() > 1)
                    name = input;
            } catch (RuntimeException e) {
                System.out.print("Invalid input : ");
                e.getStackTrace();
            }
        } while (name == null);

        return name;
    }


    default String editEmail(String input) {
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


    default int editAge (int input) {
        int age = 0;
        do {
            try {
                System.out.print("Edit age : ");
                if (input > 0 && input < 105)
                    age = input;
            } catch (RuntimeException e) {
                System.out.println("Age doesn't fit.");
                e.getStackTrace();
            }
        } while (age == 0);

        return age;
    }

}
