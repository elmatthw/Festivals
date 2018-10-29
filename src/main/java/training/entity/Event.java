package training.entity;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "event")
public class Event {
    public Event() {
        listOfPerformers = new HashSet<Performer>();
        listOfParticipants = new HashSet<PersonalInfo>();
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

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }

    @JoinColumn(name = "eventType_id")
    @Enumerated(EnumType.STRING)
    private Festival eventType;
    public Festival getEventType() {
        return eventType;
    }

    public void setEventType(Festival eventType) {
        this.eventType = eventType;
    }

    @ManyToMany
    @JoinTable(name = "performer_on_event", joinColumns = {@JoinColumn(name = "event_id")},
                inverseJoinColumns = {@JoinColumn(name = "performer_id")})
	private Set<Performer> listOfPerformers;
    public Set<Performer> getListOfPerformers() {
        return listOfPerformers;
    }
    public void setListOfPerformers(Set<Performer> listOfPerformers) {
        this.listOfPerformers = listOfPerformers;
    }

    @ManyToMany
    @JoinTable(name = "user_on_event", joinColumns = {@JoinColumn(name = "user_id")},
                inverseJoinColumns = {@JoinColumn(name = "event_id")})
	private Set<PersonalInfo> listOfParticipants;
	public Set<PersonalInfo> getListOfParticipants() {
		return listOfParticipants;
	}

	public void setListOfParticipants(Set<PersonalInfo> listOfParticipants) {
		this.listOfParticipants = listOfParticipants;
	}

	@ManyToOne
    @JoinColumn(name = "userAuthorization_id")
	private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
