// Design a class named Location for locating a maximal value and its 
// location in a two-dimensional array. The class contains public data fields row, column, and 
// maxValue that store the maximal value and its indices in a two-dimensional array with row 
// and column as int types and maxValue as a double type.
// Write the following method that returns the location of the largest element in a
// two-dimensional array:
// public static Location locateLargest(double[][] a)

// The return value is an instance of Location. Write a test program that prompts the user to 
// enter a two-dimensional array and displays the location of the largest element in the array. 
import java.util.Scanner;
public class LargestArrValLocator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i, j;
		int rows, columns;
		
		System.out.printf("Enter the number of rows and columns in the array: ");
		rows = input.nextInt();
		columns = input.nextInt();
		
		// Creates a simple 2d array of doubles
		double[][] array = new double[rows][columns];
		System.out.printf("Enter the array: ");
		for (i = 0; i < rows; i++) 
			for (j = 0; j < columns; j++)
				array[i][j] = input.nextDouble();
			
		Location location = locateLargest(array);
		
		System.out.printf("The location of the largest element, %.1f, is at (%d, %d)\n", location.maxValue, location.row, location.column);
		
		
		
	}
	
	// Iterates through a 2D array and returns the maximum value as a 'Location'
	public static Location locateLargest(double[][] a) {
		Location location = new Location();
		int i, j;
		
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a[0].length; j++) {
				if (a[i][j] > location.maxValue) {
					
					location.maxValue = a[i][j];
					location.row = i;
					location.column = j;
					
				}
				
			}
			
		}
		
		return location;
	}
	
}

class Location {
	
	public int row, column;
	public double maxValue;
	
	Location() {
		
		this.row = -1;
		this.column = -1;
		this.maxValue = 0;
		
	}	
}