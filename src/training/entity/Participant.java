package training.entity;

import java.util.Date;

public class Participant extends User {
	private User user;
	private Date currentDate;
	private Event event;
	
	public Participant() {
		
	}
	
	public void showFestivalList() {
		
	}
	
	public void register() {
		
	}
	
	public void showPerformers(Festival festival) {
		
	}
	
	public void registerOnEvent() throws MyException {
		currentDate = new Date();
		if(currentDate.after(event.getDate())) {
			throw new MyException();
		}
		else {
			event.getListOfParticipants().add(this);
		}
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Event getEvent() {
		return event;
	}

}
