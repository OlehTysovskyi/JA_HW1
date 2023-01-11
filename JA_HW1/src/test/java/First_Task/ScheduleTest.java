package First_Task;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.*;
import org.junit.rules.TestWatcher;

public class ScheduleTest {

	Schedule s;
	
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
		s = new Schedule();
	}
	
	@Test
	public void addSeanceTest(){
		s.addSeance();
		Assert.assertNotNull(s.seances);
	}
	
	@Test
	public void removeSeanceTest(){
		s.addSeance();
		s.removeSeance();
		Set <Seance> seances2 = new LinkedHashSet<>();
        Assert.assertEquals(seances2.toString(), s.seances.toString());
	}
	
	@Test
	public void checkCinemaWorkHourTest() {
		Assert.assertFalse(s.checkCinemaWorkHour(Days.SATURDAY, 19, 0, 2, 20));
	}
	
	@After
	public void afterTest() {
		s = null;
	}
}
