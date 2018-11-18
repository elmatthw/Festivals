package by.iba.training.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "userAuthorization")
@Proxy(lazy = false)
public class User implements Serializable {
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
	private String username;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        if (new InputValidation().validateLogin(username))
            this.username = username;
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
        this.password = password;

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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userInfo_id")
    private PersonalInfo personalInfo;

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "userAuthorization",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Event> eventList;

    public Set<Event> getEventList() {
        return eventList;
    }

    public void setEventList(Set<Event> eventList) {
        this.eventList = eventList;
    }

    @Transient
    private String passwordConfirm;
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
