package by.iba.training.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "event")
@JsonIgnoreProperties(value={"user", "listOfParticipants", "listOfPerformers"})
@Proxy(lazy = false)

public class Event implements Serializable {
    public Event() {
        listOfPerformers = new HashSet<Performer>();
        listOfParticipants = new HashSet<User>();
    }

    public Event(String eventName, Date date, Date deadlineDate, String summary, Place place, EventType eventType) {
        this.eventName = eventName;
        this.date = date;
        this.deadlineDate = deadlineDate;
        this.summary = summary;
        this.place = place;
        this.eventType = eventType;
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

    @Column(name = "nameOfEvent")
    private String eventName;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "deadlineDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadlineDate;

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    @Column(name = "summary")
	private String summary;
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private EventType eventType;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "place_id")
    private Place place;
    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }


    @ManyToMany(fetch =  FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "performer_on_event", joinColumns = {@JoinColumn(name = "event_ID")},
                inverseJoinColumns = {@JoinColumn(name = "performer_id")})
	private Set<Performer> listOfPerformers;
    public Set<Performer> getListOfPerformers() {
        return listOfPerformers;
    }
    public void setListOfPerformers(Set<Performer> listOfPerformers) {
        this.listOfPerformers = listOfPerformers;
    }

    @ManyToMany(fetch =  FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "userOnEvent", joinColumns = {@JoinColumn(name = "event_ID")},
                inverseJoinColumns = {@JoinColumn(name = "user_id")})
	private Set<User> listOfParticipants;
	public Set<User> getListOfParticipants() {
		return listOfParticipants;
	}

	public void setListOfParticipants(Set<User> listOfParticipants) {
		this.listOfParticipants = listOfParticipants;
	}

	@ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "user")
	private User userAuthorization;

	@Transient
	public String placeName;
	@Transient
    public String type;

    public User getUser() {
        return userAuthorization;
    }

    public void setUser(User userAuthorization) {
        this.userAuthorization = userAuthorization;
    }

    private int currentNumberOfParticipants;

    public int getCurrentNumberOfParticipants() {
        return listOfParticipants.size();
    }

    public void setCurrentNumberOfParticipants() {
        this.currentNumberOfParticipants = listOfParticipants.size();
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
