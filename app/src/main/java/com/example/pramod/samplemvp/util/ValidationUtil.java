package com.example.pramod.samplemvp.util;

/**
 * Created by pramod on 12/01/18.
 */

public class ValidationUtil {

    private static final String REGEX_EMAIL = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+";

    /**
     * Method to validate email id
     *
     * @param email user email
     * @return whether email is valid
     */
    public static boolean checkEmail(final String email) {
        return !(email.isEmpty() || (!email.matches(REGEX_EMAIL)));
    }
}
