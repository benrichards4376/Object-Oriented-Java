import java.util.Scanner;
// Design a class Linear Equation that contains:
 // Private data fields a, b, c, d, e, and f.
// ■ A constructor with the arguments for a, b, c, d, e, and f.
// ■ Six double getter methods for a, b, c, d, e, and f.
// ■ A method named isSolvable() that returns true if ad - bc is not 0.
// ■ Methods double getX() and double getY() that return the solution for the equation.

public class LinearEquationSolver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double x, y;
		double a, b, c, d, e, f;
		System.out.printf("Enter a, b, c, d, e, f: ");
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		d = input.nextDouble();
		e = input.nextDouble();
		f = input.nextDouble();
		
		LinearEquation linearEquation = new LinearEquation(a, b, c, d, e, f);
		a = linearEquation.getA();
		b = linearEquation.getB();
		c = linearEquation.getC();
		d = linearEquation.getD();
		e = linearEquation.getE();
		f = linearEquation.getF();

		if (linearEquation.isSolvable(linearEquation.getA(), linearEquation.getB(), linearEquation.getC(), linearEquation.getD())) {
			
			System.out.printf("x is %.1f and y is %.1f\n", linearEquation.getX(a, b, c, d, e, f), linearEquation.getY(a, b, c, d, e, f));
			
		}
		else {
			
			System.out.printf("The equation has no solution\n");
			
		}
		
	}
	
	
}
class LinearEquation {
		
	private double a, b, c, d, e, f;
	
	LinearEquation(double a, double b, double c, double d, double e, double f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}
	double getA() {
		return this.a;
	}
	double getB() {
		return this.b;
	}
	double getC() {
		return this.c;
	}
	double getD() {
		return this.d;
	}
	double getE() {
		return this.e;
	}	
	double getF() {
		return this.f;
	}
	
	boolean isSolvable(double a, double b, double c, double d) {
		
		
		return ((a * d) - (b * c) == 0)? false: true;
		
	}
	double getX(double a, double b, double c, double d, double e, double f) {
		
		return ((e * d - b * f) / (a * d - b * c));
		
	}
	double getY(double a, double b, double c, double d, double e, double f) {
		
		return ((a * f - e * c) / (a * d - b * c));
		
	}
	
	
	
}