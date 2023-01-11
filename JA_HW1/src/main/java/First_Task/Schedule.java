package First_Task;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Schedule {
	
	Set <Seance> seances = new LinkedHashSet<>();
	Scanner scn = new Scanner(System.in);
	
	public void addSeance() {
		System.out.print("-Adding new seance: \n -Enter movie`s name: ");
		String movieName = scn.next();
		System.out.print(" -Enter hour duration of movie: ");
		int movieHourDur = scn.nextInt();
		System.out.print(" -Enter minutes duration of movie: ");
		int movieMinuteDur = scn.nextInt();
		System.out.print(" -Enter movie`s day: ");
		String day = scn.next().toUpperCase();
		Days enumDay = Days.valueOf(day);
		int movieHourStartTime = 0;
		int movieMinuteStartTime = 0;
		boolean flag = true;
		while(flag) {
			System.out.print(" -Enter movie`s start time \n  -hours: ");
			movieHourStartTime = scn.nextInt();
			System.out.print("  -minutes: ");
			movieMinuteStartTime = scn.nextInt();
			flag = checkCinemaWorkHour(enumDay, movieHourStartTime, movieMinuteStartTime, movieHourDur, movieMinuteDur);
			if(flag == true) {
				System.out.println("\n!-You entered time of seance when \n the cinema will be closed,\n try another-!\n");
			}
		}
		
		seances.add(new Seance(new Movie(movieName, movieMinuteDur, movieHourDur), movieMinuteStartTime, movieHourStartTime, enumDay));
		System.out.println("-Seance was added sucesfully: \n" + seances);
	}
	
	public void removeSeance() {
		System.out.println(seances + "\n-Enter movies`s name from seance to remove: ");
		String seanceName = scn.next();
		
		List <Seance> removeSeance = seances.stream().filter(s -> s.getMovie().getTitle().equals(seanceName)).collect(toList());
		seances.removeAll(removeSeance);
		System.out.println(seances);
	}
	
	public boolean checkCinemaWorkHour(Days day, int movieHourStartTime, int movieMinuteStartTime, int movieHourDur, int movieMinuteDur) {
		boolean flag = false;
		if (day.equals(Days.MONDAY) || day.equals(Days.TUESDAY) || day.equals(Days.WEDNESDAY)
				|| day.equals(Days.THURSDAY) || day.equals(Days.FRIDAY)) {
			if ((movieHourStartTime + movieHourDur) > 20) {
				flag = true;
			} else if ((movieHourStartTime + movieHourDur) == 20) {
				if ((movieMinuteStartTime + movieMinuteDur) > 30) {
					flag = true;
				}
			}
		} else if (day.equals(Days.SATURDAY)) {
			if ((movieHourStartTime + movieHourDur) > 21) {
				flag = true;
				throw new IndexOutOfBoundsException();
			} else if ((movieHourStartTime + movieHourDur) == 21) {
				if ((movieMinuteStartTime + movieMinuteDur) > 30) {
					flag = true;
				}
			}
		} else if (day.equals(Days.SUNDAY)) {
			if ((movieHourStartTime + movieHourDur) > 22) {
				flag = true;
			} else if ((movieHourStartTime + movieHourDur) == 22) {
				if ((movieMinuteStartTime + movieMinuteDur) > 00) {
					flag = true;
				}
			}
		}
		return flag;
	}
	
}
