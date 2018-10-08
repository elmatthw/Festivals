package training.entity;

import java.util.Date;

<<<<<<< HEAD
public class Participant extends User {
=======
public class Participant extends User{
>>>>>>> a811717493e71ec15bbae65652443bb294eaca0e
	private User user;
	private Date currentDate;
	private Event event;
	
<<<<<<< HEAD
	public Participant() {
		
	}
	
	public void showFestivalList() {
		
	}
	
	public void register() {
		
	}
	
	public void showPerformers(Festival festival) {
		
=======
	Participant (){
		super();
>>>>>>> a811717493e71ec15bbae65652443bb294eaca0e
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
