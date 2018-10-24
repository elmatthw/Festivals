package training.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalInfo {
    private int age;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String phoneNumber;
    private User userAuthorization;
    private UserStatus userStatus;
    private Pattern pattern;
    private Matcher matcher;


    public PersonalInfo(String firstName, String lastName, String fatherName, String phoneNumber, int age) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        pattern = Pattern.compile("^(80|\\+375)\\(?(29|33|44)\\)?(\\d{7}|(\\d{3}-\\d{2}-\\d{2}))");
        matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            this.phoneNumber = phoneNumber;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        pattern = Pattern.compile("\\b([A-Z]\\w+|[А-ЯЁ][а-яё]+)\\b");
        matcher = pattern.matcher(fatherName);
        if (matcher.matches())
            this.fatherName = fatherName;
        else
            throw new IllegalArgumentException();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        pattern = Pattern.compile("\\b([A-Z]\\w+(-|\\040)?\\w*|[А-ЯЁ][а-яё]+(-|\\040)?([А-ЯЁ][а-яё]*)*)\\b");
        matcher = pattern.matcher(lastName);
        if (matcher.matches())
            this.lastName = lastName;
        else
            throw new IllegalArgumentException();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        pattern = Pattern.compile("\\b([A-Z]\\w+(-|\\040)?\\w*|[А-ЯЁ][а-яё]+(-|\\040)?([А-ЯЁ][а-яё]*)*)\\b");
        matcher = pattern.matcher(firstName);
        if (matcher.matches())
            this.firstName = firstName;
        else
            throw new IllegalArgumentException();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        pattern = Pattern.compile("[1-9][0-9]?");
        matcher = pattern.matcher(Integer.toString(age));
        if (matcher.matches())
            this.age = age;
        else
            throw new IllegalArgumentException();
    }

    public User getUserAuthorization() {
        return userAuthorization;
    }

    public void setUserAuthorization(User userAuthorization) {
        this.userAuthorization = userAuthorization;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
