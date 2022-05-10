import java.util.Calendar;
import java.util.GregorianCalendar;

// Creates various classes and subclasses
public class InheritancePractice {
	public static void main(String[] args) {
		
		Person jake = new Person("Jake", "154 ave", "123-456-7654", "a@email.com");
		Student john = new Student("John", 3);
		Employee beth = new Employee("Beth", "0-24", 45000);
		Faculty joan = new Faculty("Joan", "8am - 5pm", "Professor");
		Staff evan = new Staff("Evan", "Janitor");
		
		
		jake.toString();
		john.toString();
		beth.toString();
		joan.toString();
		evan.toString();
		
	}
}

// Superclass of all other classes, containing personal information
class Person {
	
	private String name = new String("");
	private String address = new String("");
	private String phoneNumber = new String("");
	private String emailAddress = new String("");
	
	Person() {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.emailAddress = emailAddress;
		
	}
	
	Person(String name, String address, String phoneNumber, String emailAddress) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.emailAddress = emailAddress;
		
	}
	
	String getName() {
		
		return this.name;
		
	}
	void setName(String name) {
		
		this.name = name;
		
	}
	
	String getPhoneNumber() {
		
		return this.phoneNumber;
		
	}
	
	String getAddress() {
		
		return this.address;
		
	}
	
	String getEmailAddress() {
		
		return this.emailAddress;
		
	}
	
	@Override
	public String toString() {
		
		System.out.printf("Person: %s\n", this.getName());
		return this.getName();
	}
	
}

// Students contain a class name
class Student extends Person {
	
	private final String className;
	
	
	Student(String name, int schoolYear)  {
		
		this.setName(name);
		
			
			if (schoolYear == 1) {
				
				this.className = "Freshman";
				
			}
			else if (schoolYear == 2) {
				
				this.className = "Sophomore";
				
			}
			else if (schoolYear == 3) {
				
				this.className = "Junior";
				
			}
			else if (schoolYear == 4) {
				
				this.className = "Senior";
				
			}
			else {
				
				this.className = "Invalid Year";
				
			}
			
	}
	
	String getClassName() {
		
		return this.className;
		
	}
	
	@Override
	public String toString() {
		
		System.out.printf("Student: %s\n", this.getName());
		return this.getName();
	}
	
}

// Employees have an office, salary, and hire date
class Employee extends Person {
	
	private String office = new String("");
	private double salary = 0;
	private MyDate dateHired = new MyDate();
	
	Employee() {
		
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
		
	}
	
	Employee(String name, String office, double salary, MyDate dateHired) {
		
		this.setName(name);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
		
	}
	Employee(String name, String office, double salary) {
		
		this.setName(name);
		this.office = office;
		this.salary = salary;
		this.dateHired = new MyDate();
		
	}
	
	String getOffice() {
		
		return this.office;
		
	}
	
	double getSalary() {
		
		return this.salary;
		
	}
	
	MyDate getDateHired() {
		
		return this.dateHired;
		
	}
	
	@Override
	public String toString() {
		
		System.out.printf("Employee: %s\n", this.getName());
		return this.getName();
	}
	
}

// Faculty have office hours and rank
class Faculty extends Employee {
	
	private String officeHours;
	private String rank;
	
	Faculty(String name, String officeHours, String rank) {
		
		this.setName(name);
		this.officeHours = officeHours;
		this.rank = rank;
		
	}
	
	String getOfficeHours() {
		
		return this.officeHours;
		
	}
	
	String getRank() {
		
		return this.rank;
		
	}
	
	@Override
	public String toString() {
		
		System.out.printf("Faculty: %s\n", this.getName());
		return this.getName();
	}
	
}

// Employees have a title
class Staff extends Employee {
	
	private String title;
	
	Staff(String name, String title) {
		
		this.setName(name);
		this.title = title;
		
	}
	
	@Override
	public String toString() {
		
		System.out.printf("Staff: %s\n", this.getName());
		return this.getName();
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