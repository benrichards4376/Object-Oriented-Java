// Recreate the StringBuilder class with the following methods
// ■public MyStringBuilder2(); Construct string builder with no characters and 16 capacity
// ■public MyStringBuilder2(char[] chars);construct string builder given a char array
// ■public MyStringBuilder2(String s); construct string builder given a string
// ■public MyStringBuilder2 insert(int offset, MyStringBuilder2 s); inserts the contents of another stringBuilder within the first one
// ■public MyStringBuilder2 reverse(); reverses StringBuilder
// ■public MyStringBuilder2 substring(int begin); returns a new StringBuilder that is a substring of the first StringBuilder
// ■public MyStringBuilder2 toUpperCase(); Converts all character in the StringBuilder to Uppercase

// Tests creation and prints various methods
public class NewStringBuilder {
	public static void main(String[] args) {
		String message = new String("hello");
		char[] test = new char[6];
		for (int i = 0; i < 3; i++)
			test[i] = 'h';
		for (int i = 3; i < 6; i++)
			test[i] = 'e';
		
		MyStringBuilder2 charTest = new MyStringBuilder2(test);
		
		charTest.printString();
		
		charTest.reverse();
		
		charTest.printString();
		
		MyStringBuilder2 sb = new MyStringBuilder2(message);
		
		sb.printString();
		
		MyStringBuilder2 sb2 = new MyStringBuilder2("run");
		
		sb.insert(2, sb2);
		
		sb.printString();
		
		sb.reverse();
		
		sb.printString();
		
		MyStringBuilder2 sb3 = sb.substring(4);
		
		sb3.printString();
		
		sb3.toUpperCase();
		
		sb3.printString();
		
	}
	
}
class MyStringBuilder2 {
	
	private String string = new String("");
	private String copyString = new String("");
	
	
	MyStringBuilder2() {
		
		
	}
	
	MyStringBuilder2(char[] chars) {
		
		this.string = new String(chars);
		
	}
	
	MyStringBuilder2(String s) {
		
		this.string = s;
		
	}
	
	MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
		
		int i;
		this.copyString = "";
		
		// Creates a buffer that stores the part of the string before insertion
		for (i = 0; i < offset; i++) {
			
			this.copyString += this.string.charAt(i);
			
		}
		
		// Adds the stringBuilder to the buffer
		for (i = 0; i < s.string.length(); i++) {
			
			this.copyString += s.string.charAt(i);
			
		}
		
		// Adds the rest of the original stringBuilder back on to the buffer
		for (i = offset; i < this.string.length(); i++) {
			
			this.copyString += this.string.charAt(i);
			
		}
		
		this.string = this.copyString;
			
		
		return this;
	}
	
	// Reverses the string
	public MyStringBuilder2 reverse() {
		
		int i, j;
		
		this.copyString = "";
		
		for (j = this.string.length() - 1; j >= 0; j--) 
			this.copyString += this.string.charAt(j);
		
		this.string = this.copyString;
	
		return this;
		
	}
	
	// returns a new StringBuilder representing the substring of the original
	// stringBuilder starting at 'begin'
	public MyStringBuilder2 substring(int begin) {
		int i = 0;
		this.copyString = "";
		
		for (i = begin; i < this.string.length(); i++)
			this.copyString += this.string.charAt(i);
		
		return new MyStringBuilder2(this.copyString);
		
		
	}
	
	public MyStringBuilder2 toUpperCase() {
		
		this.string = string.toUpperCase();
			
		return this;
		
	}
	
	public void printString() {
		
		System.out.printf("%s\n", this.string);
		
	}
	
}