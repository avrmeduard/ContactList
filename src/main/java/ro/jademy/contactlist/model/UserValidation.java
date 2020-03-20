package ro.jademy.contactlist.model;

import java.util.regex.Pattern;

public class UserValidation extends Exception {

    private boolean isWord(String word) {
        return Pattern.matches("[a-zA-z]+",word);
    }

    private boolean isNumber(String num) {
        return Pattern.matches("[0-9]+", num);
    }

    private boolean isEmail(String email) {
        return Pattern.matches("", email);
    }

}
