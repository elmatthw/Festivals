package training.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private int age;
	private String firstName;
	private String lastName;
	private String fatherName;
	private String login;
	private String password;
	private String phoneNumber;
	private String email;
	private Pattern pattern;
	private Matcher matcher;
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		pattern = Pattern.compile("([A-Za-z0-9-_]|[À-ß¨à-ÿ¸0-9-_]){8,25}");
		matcher = pattern.matcher(password);
		if (matcher.matches())
			this.password = password;
		else
			throw new IllegalArgumentException();
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		pattern = Pattern.compile("[A-Za-z0-9]+\\.?_?[A-Za-z0-9]+");
		matcher = pattern.matcher(login);
		if (matcher.matches())
			this.login = login;
		else {
			throw new IllegalArgumentException();
		}
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		pattern = Pattern.compile("\\b([A-Z]\\w+|[À-ß¨][à-ÿ¸]+)\\b");
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
		pattern = Pattern.compile("\\b([A-Z]\\w+(-|\\040)?\\w*|[À-ß¨][à-ÿ¸]+(-|\\040)?([À-ß¨][à-ÿ¸]*)*)\\b");
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
		pattern = Pattern.compile("\\b([A-Z]\\w+(-|\\040)?\\w*|[À-ß¨][à-ÿ¸]+(-|\\040)?([À-ß¨][à-ÿ¸]*)*)\\b");
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		pattern = Pattern.compile("[a-z0-9_]{5,}@[a-z]{3,10}\\.[a-z]{2,3}");
		matcher = pattern.matcher(email);
		if (matcher.matches())
			this.email = email;
		else
			throw new IllegalArgumentException();
	}
}
