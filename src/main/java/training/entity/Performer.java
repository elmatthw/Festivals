package training.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Performer{
	private String performerName;
	private String summary;
	
	public String getPerformerName() {
		return performerName;
	}
	public void setPerformerName(String performerName) {
		Pattern pattern = Pattern.compile("\\b([A-Z]\\w+(-|\\040)?\\w*|[А-ЯЁ][а-яё]+(-|\\040)?([А-ЯЁ][а-яё]*)*)\\b");
		Matcher matcher = pattern.matcher(performerName);
		if (matcher.matches())
			this.performerName = performerName;
		else
			throw new IllegalArgumentException();
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		Pattern pattern = Pattern.compile("\\w{,200}");
		Matcher matcher = pattern.matcher(summary);
		if (matcher.matches())
			this.summary = summary;
		else
			throw new IllegalArgumentException();
	}

}
