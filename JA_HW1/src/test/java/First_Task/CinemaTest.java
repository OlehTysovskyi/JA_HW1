package First_Task;

import org.junit.*;
import org.junit.rules.TestWatcher;

public class CinemaTest {
	
	private Cinema c;
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};
		
		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEEDED--> " + description.getMethodName());
		};
	};
	
	@Before
	public void beforeTest() {
		c = new Cinema();
	}
	
	@Test
	public void removeMovieTest() {
		c.addMovie();
		c.removeMovie();
		Assert.assertTrue(c.moviesLibrary.isEmpty());
	}
	
	@Test
	public void addMovieTest(){
		Movie expectedMovie = new Movie("Avengers", 48, 2);
		c.addMovie();
		Assert.assertEquals(expectedMovie.toString(), c.moviesLibrary.get(0).toString());
	}
	
	@After
	public void afterTest() {
		c = null;
	}
}
