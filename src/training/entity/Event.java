package training.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
	private Date date;
	private Place place;
	private String summary;
	private List<Performer> listOfPerformers;
	private List<Participant> listOfParticipants;
	private Date registrationDate;
	
	public Event() {
		listOfPerformers = new ArrayList();
		listOfParticipants = new ArrayList();
	}
	
	
	protected Date getDate() {
		return date;
	}
	
	protected void setDate(Date date) {
		this.date = date;
	}

	protected String getSummary() {
		return summary;
	}

	protected void setSummary(String summary) {
		this.summary = summary;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public List<Performer> getListOfPerformers() {
		return listOfPerformers;
	}

	public void setListOfPerformers(List<Performer> listOfPerformers) {
		this.listOfPerformers = listOfPerformers;
	}

	public List<Participant> getListOfParticipants() {
		return listOfParticipants;
	}

	public void setListOfParticipants(List<Participant> listOfParticipants) {
		this.listOfParticipants = listOfParticipants;
	}



	public Date getRegistrationDate() {
		return registrationDate;
	}



	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
	
	
}
