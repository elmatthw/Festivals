package training.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {
    public Event() {
        listOfPerformers = new ArrayList();
        listOfParticipants = new ArrayList();
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
    protected Date getDate() {
        return date;
    }

    protected void setDate(Date date) {
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
    protected String getSummary() {
        return summary;
    }

    protected void setSummary(String summary) {
        this.summary = summary;
    }

    @OneToOne
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
	private List<Performer> listOfPerformers;
    public List<Performer> getListOfPerformers() {
        return listOfPerformers;
    }
    public void setListOfPerformers(List<Performer> listOfPerformers) {
        this.listOfPerformers = listOfPerformers;
    }

    @ManyToMany
    @JoinTable(name = "user_on_event", joinColumns = {@JoinColumn(name = "user_id")},
                inverseJoinColumns = {@JoinColumn(name = "event_id")})
	private List<PersonalInfo> listOfParticipants;
	public List<PersonalInfo> getListOfParticipants() {
		return listOfParticipants;
	}

	public void setListOfParticipants(List<PersonalInfo> listOfParticipants) {
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
