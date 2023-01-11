package First_Task;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Cinema c = new Cinema();
		Scanner scn = new Scanner(System.in);
		int consoleKey = 0;

		while (true) {
			System.out.print("======================================" + 
								"\n-Enter '1' to add a new movie" + 
								"\n-Enter '2' to remove a movie" + 
								"\n-Enter '3' to add a new seance" + 
								"\n-Enter '4' to remove seance" + 
								"\n-Enter '0' to exit" + 
								"\n-Type here -> ");
			
			consoleKey = scn.nextInt();
			
			switch (consoleKey) {
			case 1: {
				c.addMovie();
				break;
			}
			case 2: {
				c.removeMovie();
				break;
			}
			case 3: {
				c.addSeance();
				break;
			}
			case 4: {
				c.removeSeance();
				break;
			}
			case 0: {
				System.exit(consoleKey);
			}
			}

		}

	}

}
