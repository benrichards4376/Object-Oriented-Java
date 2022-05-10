import java.util.Calendar;
import java.util.GregorianCalendar;
// Write a test program that 
// creates two MyDate objects (using new MyDate() and new MyDate(34355555133101L)) 
// and displays their year, month, and day.
// (Hint: The first two constructors will extract the year, month, and day from the elapsed time. 
// For example, if the elapsed time is 561555550000 milliseconds, the year is 1987, the month 
// is 9, and the day is 18. You may use the GregorianCalendar class discussed in Programming 
// Exercise 9.5 (in the text) to simplify coding.)
public class DateCreator {
	public static void main(String[] args) {
		
		
		MyDate current = new MyDate();
		MyDate specified = new MyDate(34355555133101L);
		
		System.out.printf("Current Date (MM/DD/YYYY): %d/%d/%d\n", current.getMonth(), current.getDay(), current.getYear());
		System.out.printf("Specified Date (MM/DD/YYYY): %d/%d/%d\n", specified.getMonth(), specified.getDay(), specified.getYear());		
	}
	
	
}

class MyDate {
	
	private int year;
	private int month;
	private int day;
	
	MyDate() {
		Calendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		this.year = cal.get(Calendar.YEAR);
		this.month = cal.get(Calendar.MONTH) + 1;
		this.day = cal.get(Calendar.DAY_OF_MONTH);
		
	}
	
	MyDate(long elapsedTime) {
		
		Calendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		cal.setTimeInMillis(elapsedTime);
		this.year = cal.get(Calendar.YEAR);
		this.month = cal.get(Calendar.MONTH);
		this.day = cal.get(Calendar.DAY_OF_MONTH);
		
	}
	
	MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;		
	}
	
	int getYear() {
		
		return this.year;
		
	}
	
	int getMonth() {
		
		return this.month;
		
	}
	
	int getDay() {
		
		return this.day;
		
	}
	
	void setDate(long elapsedTime) {
		
		Calendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
		calendar.setTimeInMillis(elapsedTime);
		this.year = calendar.get(Calendar.YEAR);
		this.month = calendar.get(Calendar.MONTH);
		this.day = calendar.get(Calendar.DAY_OF_MONTH);
		
	}
}