package training.entity;

import javax.persistence.*;

@Entity
@Table(name = "userAuthorization")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "login")
	private String login;
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        if (new InputValidation().validateLogin(login))
            this.login = login;
        else {
            throw new IllegalArgumentException();
        }
    }
    @Column(name = "password")
	private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if (new InputValidation().validatePassword(password))
            this.password = password;
        else
            throw new IllegalArgumentException();
    }

    @Column(name = "email")
	private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        if (new InputValidation().validateEmail(email))
            this.email = email;
        else
            throw new IllegalArgumentException();
    }
}
