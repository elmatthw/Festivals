package training.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Musician extends Performer {
	private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		Pattern pattern = Pattern.compile("\\b([A-Z]\\w+(-|\\040)?\\w*|[�-ߨ][�-��]+(-|\\040)?([�-ߨ][�-��]*)*)\\b");
		Matcher matcher = pattern.matcher(genre);
		if (matcher.matches())
			this.genre = genre;
		else
			throw new IllegalArgumentException();
	}

}
