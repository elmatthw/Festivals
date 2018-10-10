package training.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Concert extends Event{
	private String agencyName;
	private String typeOfTicket;
	
	public String getAgencyName() {
		return agencyName;
	}
	
	public void setAgencyName(String agencyName) {
		Pattern pattern = Pattern.compile("(([A-Za-z]*,?\\040?)+-?(\\\"?[A-Za-z]*\\\"?)?|([À-ß¨à-ÿ¸]*,?\\040?)+-?(\\\"?[À-ß¨à-ÿ¸]*\\\"?)?)");
		Matcher matcher = pattern.matcher(agencyName);
		if (matcher.matches())
			this.agencyName = agencyName;
		else
			throw new IllegalArgumentException();
	}
	
	public String getTypeOfTicket() {
		return typeOfTicket;
	}
	
	public void setTypeOfTicket(String typeOfTicket) {
		this.typeOfTicket = typeOfTicket;
	}
}
