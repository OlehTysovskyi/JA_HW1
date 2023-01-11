package First_Task;

public class Time {
	
	private int min;
	private int hour;

	public Time(int min, int hour) {
		super();
		try {
			if((min>=0 && min<60) && (hour>=0 && hour<24)) {
				this.min = min; 
				this.hour = hour;
			}
			else if (min>=60 && min<120) {
				this.min = min-60;
				this.hour = hour+1;
			}
			else if (min>=120 && min<180) {
				this.min = min-120;
				this.hour = hour+2;
			}
			else if(min > 180) throw new IndexOutOfBoundsException();
			else if (hour > 24) throw new IndexOutOfBoundsException();
			else throw new IndexOutOfBoundsException();
		}
		catch(IndexOutOfBoundsException e) {
			System.err.println("!-You entered wrong number for time-!");
		}	
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		if(min<10) {
			return "[-" + hour + ":0" + min + "-]";
		}
		else return "[-" + hour + ":" + min + "-]";
	}
	
	
}
