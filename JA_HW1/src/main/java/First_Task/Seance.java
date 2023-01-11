package First_Task;

import java.util.Objects;

public class Seance {
	
	private Movie movie;
	private Time startTime, endTime;
	private Days day;
	
	public Seance(Movie movie, int min, int hour, Days day) {
		super();
		this.movie = movie;
		this.startTime = new Time(min, hour);
		this.endTime = new Time(min + movie.getDuration().getMin(), hour + movie.getDuration().getHour());
		this.day = day;
	}
	
	@Override
	public String toString() {
		return "Seance : " + movie.toString() + " day=" + day + ", startTime=" + startTime + ", endTime=" + endTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Days getDay() {
		return day;
	}

	public void setDay(Days day) {
		this.day = day;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(day, endTime, movie, startTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		return day == other.day && Objects.equals(endTime, other.endTime) && Objects.equals(movie, other.movie)
				&& Objects.equals(startTime, other.startTime);
	}
}
