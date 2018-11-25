package by.iba.training.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
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
        if (InputValidation.validateLogin(username))
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
        if (InputValidation.validateEmail(email))
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

    @ManyToMany(fetch =  FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_on_event", joinColumns = {@JoinColumn(name = "event_ID")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<Event> listOfEvents;

    public Set<Event> getListOfEvents() {
        return listOfEvents;
    }

    public void setListOfEvents(Set<Event> listOfEvents) {
        this.listOfEvents = listOfEvents;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserStatus userStatus;

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
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
