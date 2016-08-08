
/* Program: Write Read Data
 * File: WriteReadData.java
 * Summary: Week 7 Exercise12.15 
 *          This prgogram creates a file is the file with the given name does not exist. 
 *          The file is then filled with 100 integers created randomly and seperated by spaces
 *          The data is then read back and displayed in increasing order 
 * Author: Lee Tompkins 
 * Date: August 6 2016
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class WriteReadData {

	public static void main(String[] args) throws FileNotFoundException {
		// create string for file name 
	    String sourceFileName = "Exercise12_15.txt";
				
		// create 100 random int array 
		ArrayList<Integer> randomArray = new ArrayList<Integer>();
		// create empty array for 100 read ints from file 
		ArrayList<Integer> readArray = new ArrayList<Integer>();
		// populate randomArray
		for (int i = 0; i < 100; i++) {
			randomArray.add((int) ((Math.random())*100));
			
		}
		// Create file if file does not exist 
		File sourceFile = new File("Exercise12_15.txt");
		if (sourceFile.exists()) {
			System.out.println("The file already exists");
		} else {
			PrintWriter writer = new PrintWriter("Exercise12_15.txt");
			for (int i = 0; i < 100; i++) {
				writer.print(" " + randomArray.get(i));
				
			}
			writer.close();
			
				}
		// Temp array for string values
		ArrayList<String> temp = new ArrayList<String>();
		// new Scanner for the created file 
		Scanner input = new Scanner(new File("Exercise12_15.txt"));
		while (input.hasNext()) {
			
			temp.add(input.next());
		}
		// parse from string to an int for correct sorting 
		for (int j = 0; j < 100; j++) {
			readArray.add(Integer.parseInt(temp.get(j)));
		}
		// Sorts the read data 
		//for (int j = 0; j < 100; j++) {
		//	readArray. = Integer.parseInt(readArray.get(j));
		//}
		Collections.sort(readArray);
		// iterate through array and print value 
		for (int j = 0; j < 100; j++) {
			System.out.print(readArray.get(j) + " ");
		}
			
			}
		

	
	

}
