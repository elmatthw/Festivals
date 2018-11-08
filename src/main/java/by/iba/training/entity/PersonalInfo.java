package by.iba.training.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "userInfo")
public class PersonalInfo implements Serializable {

    public PersonalInfo() {
    }

    public PersonalInfo(String firstName, String lastName, String fatherName, String phoneNumber, int age) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.phoneNumber = phoneNumber;
    }

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

    @Column(name = "firstName")
    private String firstName;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (new InputValidation().validateName(firstName))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException();
    }

    @Column(name = "lastName")
    private String lastName;
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (new InputValidation().validateName(lastName))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException();

    }

    @Column(name = "fatherName")
    private String fatherName;
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        if (new InputValidation().validateFatherName(fatherName))
            this.fatherName = fatherName;
        else
            throw new IllegalArgumentException();
    }

    @Column(name = "phoneNumber")
    private String phoneNumber;
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (new InputValidation().validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    @Column(name = "age")
    private int age;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (new InputValidation().validateAge(age))
            this.age = age;
        else
            throw new IllegalArgumentException();
    }

    @ManyToMany
    @JoinTable(name = "user_on_event", joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<Event> listOfEvents;

    public Set<Event> getListOfEvents() {
        return listOfEvents;
    }

    public void setListOfEvents(Set<Event> listOfEvents) {
        this.listOfEvents = listOfEvents;
    }

    @OneToOne
    @JoinColumn(name = "userAuthorization_id")
    private User userAuthorization;
    public User getUserAuthorization() {
        return userAuthorization;
    }

    public void setUserAuthorization(User userAuthorization) {
        this.userAuthorization = userAuthorization;
    }

    @JoinColumn(name = "userStatus_id")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
