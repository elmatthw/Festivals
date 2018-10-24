package training.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	private int id;
	private String login;
	private String password;
	private String email;

	private Pattern pattern;
	private Matcher matcher;



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		pattern = Pattern.compile("([A-Za-z0-9-_]|[А-ЯЁа-яё0-9-_]){8,25}");
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
