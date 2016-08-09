/* Program: ReadGettysburgAddress 
 * File:    ReadGettysburgAddress.java
 * Summary: Exercise 12.19, A program that reads the G.Address from a text file. Prints how many words are in it. Then creates two copies of the file
 *          one with all lowercase letters, the other without any punctuation. All words with less than three letters are stored in an array, and the size of the 
 *          array is printed. 
 * Author: Lee Tompkins 
 * Date:   August 8 2016
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadGettysburgAddress {

	public static void main(String[] args) throws FileNotFoundException{
		String sourceFileName = "GettysburgAddress.txt";
		ArrayList<String> gAddressWords = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();
		File sourceFile = new File("GettysburgAddress.txt");
		File sourceFile1 = new File("GettysburgAddressToLowercase.txt");
		File sourceFile2 = new File("GettysburgAddressNoPunctuation.txt");
		if (sourceFile.exists()) {
		Scanner input = new Scanner(new File("GettysburgAddress.txt"));
		while (input.hasNext()) {
			gAddressWords.add(input.next());
		}
		
		} else {
			System.out.println("File not Found");
		}
		System.out.println("The Gettysburg Address contains " + gAddressWords.size() + " words");
		// Write the G.Address in all lowercase to a new txt file
		if (sourceFile1.exists()) {
			System.out.println("The two lowercase file already exists");
		} else { 
			PrintWriter writeToLower = new PrintWriter("GettysburgAddressToLowercase.txt");
			for (int i = 0; i < gAddressWords.size(); i++) {
			writeToLower.print(gAddressWords.get(i).toLowerCase() + " ");
			}
			writeToLower.close();
		}
		// Write the G.Adress with no punctuation to a new txt file
		if (sourceFile2.exists()) {
			System.out.println("The no punctuation text file already exists");
		} else {
			PrintWriter writeWOPunctuations  = new PrintWriter("GettysburgAddressNoPunctuation.txt");
			for (int i = 0; i < gAddressWords.size(); i++) {
				writeWOPunctuations.print(gAddressWords.get(i).replaceAll("[^a-zA-Z0-9]"," ") + " ");
			}
			writeWOPunctuations.close();
		}
		// Store all words with less than three letters in an ArrayList 
		if (sourceFile.exists()) {
			ArrayList<String> lessThanThreeLetters = new ArrayList<String>();
			Scanner lessThanThreeInput = new Scanner(new File("GettysburgAddress.txt"));
			while(lessThanThreeInput.hasNext()) {
				if (lessThanThreeInput.next().replaceAll("[^a-zA-Z0-9]"," ").length() < 3) {
					lessThanThreeLetters.add(lessThanThreeInput.next().replaceAll("[^a-zA-Z0-9]"," "));
				}
			}
			System.out.println("In the whole address, there are " + lessThanThreeLetters.size() + " words with less than three letters");
		} else {
			System.out.println("The Gettysburg address file cannont be found");
		} 
	
		

	}

}
