package by.iba.training.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Proxy(lazy = false)
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private String status;

    public UserStatus() {
        /*this.personalInfoSet = new HashSet<>();*/
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*@OneToMany(fetch = FetchType.LAZY)
    private Set<User> personalInfoSet;

    public Set<User> getPersonalInfoSet() {
        return personalInfoSet;
    }

    public void setPersonalInfoSet(Set<User> personalInfoSet) {
        this.personalInfoSet = personalInfoSet;
    }*/
}
