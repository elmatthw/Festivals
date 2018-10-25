package training.entity;

import javax.persistence.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "performer")
public class Performer{
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

    @Column(name = "name")
    private String performerName;
    public String getPerformerName() {
        return performerName;
    }
    public void setPerformerName(String performerName) {
        if (new InputValidation().validateName(performerName))
            this.performerName = performerName;
        else
            throw new IllegalArgumentException();
    }

    @Column(name = "summary")
	private String summary;
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		Pattern pattern = Pattern.compile("\\w{,1000}");
		Matcher matcher = pattern.matcher(summary);
		if (matcher.matches())
			this.summary = summary;
		else
			throw new IllegalArgumentException();
	}

}
