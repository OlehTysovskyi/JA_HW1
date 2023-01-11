package First_Task;

import static java.util.stream.Collectors.*;

import java.util.*;

public class Cinema {

	Schedule sch = new Schedule();
	TreeMap<Days, Schedule> schedules = new TreeMap<>();
	ArrayList<Movie> moviesLibrary = new ArrayList<>();
	Time openTime, closeTime;
	
	Scanner scn = new Scanner(System.in);

	public void addMovie() {
		System.out.print("-Adding new movie: \n -Enter movie`s name: ");
		String movieName = scn.next();
		System.out.print(" -Enter hour duration of movie: ");
		int movieHourDur = scn.nextInt();
		System.out.print(" -Enter minutes duration of movie: ");
		int movieMinuteDur = scn.nextInt();
		
		moviesLibrary.add(new Movie(movieName, movieMinuteDur, movieHourDur)); 
		System.out.println("-Movie was added sucesfully: \n" + moviesLibrary);
	}

	public void removeMovie() {
		System.out.println(moviesLibrary + "\n-Enter movies`s name from seance to remove: ");
		String movieName = scn.next();
		
		List <Movie> removeMovie = moviesLibrary.stream().filter(m -> m.getTitle().equals(movieName)).collect(toList());
		moviesLibrary.removeAll(removeMovie);
		System.out.println(moviesLibrary);
	}

	public void addSeance() {
		sch.addSeance();
	}

	public void removeSeance() {
		sch.removeSeance();
	}

}
