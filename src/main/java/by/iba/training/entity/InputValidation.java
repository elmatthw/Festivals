package by.iba.training.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean validateEmail(String email){
        pattern = Pattern.compile("[a-z0-9_]{5,}@[a-z]{3,10}\\.[a-z]{2,3}");
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePassword(String password){
        pattern = Pattern.compile("([A-Za-z0-9-_]|[А-ЯЁа-яё0-9-_]){8,25}");
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validateLogin(String login){
        pattern = Pattern.compile("[A-Za-z0-9]+\\.?_?[A-Za-z0-9]+");
        matcher = pattern.matcher(login);
        return matcher.matches();
    }

    boolean validateName(String name){
        pattern = Pattern.compile("\\b([A-Z]\\w+(-|\\040)?\\w*|[А-ЯЁ][а-яё]+(-|\\040)?([А-ЯЁ][а-яё]*)*)\\b");
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    boolean validateFatherName(String fatherName){
        pattern = Pattern.compile("\\b([A-Z]\\w+|[А-ЯЁ][а-яё]+)\\b");
        matcher = pattern.matcher(fatherName);
        return matcher.matches();
    }

    boolean validatePhoneNumber(String phoneNumber){
        pattern = Pattern.compile("^(80|\\+375)\\(?(29|33|44)\\)?(\\d{7}|(\\d{3}-\\d{2}-\\d{2}))");
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    boolean validateAge(int age){
        pattern = Pattern.compile("[1-9][0-9]?");
        matcher = pattern.matcher(Integer.toString(age));
        return matcher.matches();
    }
}
