package training.entity;

public class Concert extends Event{
	private String agencyName;
	private String typeOfTicket;
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getTypeOfTicket() {
		return typeOfTicket;
	}
	public void setTypeOfTicket(String typeOfTicket) {
		this.typeOfTicket = typeOfTicket;
	}


}
