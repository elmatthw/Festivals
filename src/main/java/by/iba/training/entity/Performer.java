package by.iba.training.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "performer")

public class Performer implements Serializable {

    public Performer() {
        listOfEvents = new HashSet<Event>();
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

    @Column(name = "performerName")
    private String performerName;
    public String getPerformerName() {
        return performerName;
    }
    public void setPerformerName(String performerName) {
        if (new InputValidation().validateName(performerName))
            this.performerName = performerName;
        else
            throw new IllegalArgumentException();
    }

    @Column(name = "summary")
	private String summary;
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
        this.summary = summary;
	}

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(name = "performer_on_event", joinColumns = {@JoinColumn(name = "performer_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_ID")})
    private Set<Event> listOfEvents;

    public Set<Event> getListOfEvents() {
        return listOfEvents;
    }

    public void setListOfEvents(Set<Event> listOfEvents) {
        this.listOfEvents = listOfEvents;
    }
}
