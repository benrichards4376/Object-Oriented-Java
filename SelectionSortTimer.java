 // Design a class named StopWatch. The class contains:
// ■ Private data fields startTime and endTime with getter methods.
// ■ A no-arg constructor that initializes startTime with the current time.
// ■ A method named start() that resets the startTime to the current time.
// ■ A method named stop() that sets the endTime to the current time.
// ■ A method named getElapsedTime() that returns the elapsed time for the
// stopwatch in milliseconds.
// Draw the UML diagram for the class and then implement the class. Write a test program 
// that measures the execution time of sorting 100,000 numbers using selection sort
import java.util.Random;
import java.util.Scanner;
public class SelectionSortTimer {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		StopWatch stopWatch = new StopWatch();
		
		int i;
		char c;
		int[] array = new int[100000];
		for (i = 0; i < array.length; i++) 
			array[i] = random.nextInt(array.length);
		
		stopWatch.start();
		SelectionSort(array);
		stopWatch.stop();
		System.out.printf("Selection sort time taken: %d\n", stopWatch.getElapsedTime(stopWatch.getStartTime(), stopWatch.getEndTime()));
		// for (i = 0; i < array.length; i++)
			// System.out.printf("%d%c", array[i], c = (i == array.length - 1)? '\n': ' ');
		
	}
	public static void SelectionSort(int[] array) {
		
		int i, j, n = array.length;
		int temp;
		int arrayMinIndex;
		
		for (i = 0; i < n - 1; i++) {
			
			arrayMinIndex = i;
			
			for (j = i + 1; j < n; j++) 
				if (array[j] < array[arrayMinIndex])
						arrayMinIndex = j;
				
			temp = array[arrayMinIndex];
			array[arrayMinIndex] = array[i];
			array[i] = temp;
			
		}
	}
	
}
class StopWatch {
	
	private long startTime;
	private long endTime;
	
	StopWatch() {
		startTime = System.currentTimeMillis();	
	}
	
	long getStartTime() {
		
		return this.startTime;
		
	}
	
	long getEndTime() {
		
		return this.endTime;
		
	}
	
	void start() {
		
		this.startTime = System.currentTimeMillis();
		
	}
	
	void stop() {
		
		this.endTime = System.currentTimeMillis();
		
	}
	
	public long getElapsedTime(long startTime, long endTime) {
		
		long elapsedTime = endTime - startTime;
		return elapsedTime;
		
	}
}