package training.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "place")
public class Place {

    public Place() {
        this.eventSet = new HashSet<Event>();
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

    @Column(name = "address")
    private String placeName;
    public String getPlaceName() {
        return placeName;
    }
    public void setPlaceName(String placeName) {
        Pattern pattern = Pattern.compile("(([A-Za-z0-9]+,?\\.?\\040?-?)+-?(\\\"?([A-Za-z0-9]+,?\\.?\\040?-?)+\\\"?)?|([А-ЯЁа-яё0-9]+,?\\.?\\040?-?)+-?(\\\"?([А-ЯЁа-яё0-9]+,?\\.?\\040?-?)+\\\"?)?)");
        Matcher matcher = pattern.matcher(placeName);
        if (matcher.matches())
            this.placeName = placeName;
        else
            throw new IllegalArgumentException();
    }

    @Column(name = "numberOfParticipants")
    private int numberOfParticipants;

	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}
	public void setNumberOfParticipants(int numberOfParticipants) {
		Pattern pattern = Pattern.compile("[1-9][0-9]*");
		Matcher matcher = pattern.matcher(Integer.toString(numberOfParticipants));
		if (matcher.matches())
			this.numberOfParticipants = numberOfParticipants;
		else
			throw new IllegalArgumentException();
	}

    @OneToMany
    private Set<Event> eventSet;

    public Set<Event> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }
}
