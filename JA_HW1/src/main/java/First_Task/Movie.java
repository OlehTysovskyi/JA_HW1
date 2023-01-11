package First_Task;

public class Movie {

	private String title;
	private Time duration;
	
	public Movie(String title, int min, int hour) {
		super();
		this.title = title;
		this.duration = new Time(min, hour);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "<" + title + "> - duration=[" + duration.getHour() + " hours : " + duration.getMin() + " min]";
	}
	
	
}
