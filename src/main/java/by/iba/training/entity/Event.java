package by.iba.training.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "event")
@JsonIgnoreProperties(value={"user", "listOfParticipants", "listOfPerformers"})
@Proxy(lazy = false)
public class Event {
    public Event() {
        listOfPerformers = new HashSet<Performer>();
        listOfParticipants = new HashSet<PersonalInfo>();
    }

    public Event(String eventName, Date date, Date deadlineDate, String summary, Place place, Festival eventType) {
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

    @Column(name = "eventName")
    private String eventName;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "deadlineDate")
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

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "place_id")
    private Place place;
    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }

    @Transient
    private transient Festival eventType;
        @JoinColumn(name = "eventType_id")
    public int eventType_id;
        @PrePersist
        void populateDBFields(){
            eventType_id = eventType.getCode();
        }
        @PostPersist
        void populateTransientFields() {
            eventType = Festival.valueOf(eventType_id);
        }

    public Festival getEventType() {
        return eventType;
    }

    public void setEventType(Festival eventType) {
        this.eventType = eventType;
    }

    @ManyToMany(fetch =  FetchType.LAZY)
    @JoinTable(name = "performer_on_event", joinColumns = {@JoinColumn(name = "event_id")},
                inverseJoinColumns = {@JoinColumn(name = "performer_id")})
	private Set<Performer> listOfPerformers;
    public Set<Performer> getListOfPerformers() {
        return listOfPerformers;
    }
    public void setListOfPerformers(Set<Performer> listOfPerformers) {
        this.listOfPerformers = listOfPerformers;
    }

    @ManyToMany(fetch =  FetchType.LAZY)
    @JoinTable(name = "user_on_event", joinColumns = {@JoinColumn(name = "user_id")},
                inverseJoinColumns = {@JoinColumn(name = "event_id")})
	private Set<PersonalInfo> listOfParticipants;
	public Set<PersonalInfo> getListOfParticipants() {
		return listOfParticipants;
	}

	public void setListOfParticipants(Set<PersonalInfo> listOfParticipants) {
		this.listOfParticipants = listOfParticipants;
	}

	@ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "userAuthorization_id")
	private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private int currentNumberOfParticipants;

    public int getCurrentNumberOfParticipants() {
        return currentNumberOfParticipants;
    }

    public void setCurrentNumberOfParticipants(int currentNumberOfParticipants) {
        this.currentNumberOfParticipants = currentNumberOfParticipants;
    }
}
