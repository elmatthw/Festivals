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
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile("^(80|\\+375)\\(?(29|33|44)\\)?(\\d{7}|(\\d{3}-\\d{2}-\\d{2}))");
		Matcher matcher = pattern.matcher(phoneNumber);
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
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		Pattern pattern = Pattern.compile("^(\\w{5,15})");
		Matcher matcher = pattern.matcher(login);
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
		this.fatherName = fatherName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
