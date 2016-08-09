
/* Program: ReplaceWords 
 * File:    ReplaceWords.java
 * Summary: Exercise 12.27, A program that goes looks at all exercise files in a directory and pads the numbers with a 0 if the number is single digit
 *          For example, file: Exercise2_9 would become Exercise02_09
 * Author:  Lee Tompkins 
 * Date:    August 8 2016
 * 
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
public class ReplaceWords {

	public static void main(String[] args) throws IOException {
		// Create array for files with .txt extenstions 
		ArrayList<File> txtFiles = new ArrayList<File>();
		// Create console scanner
		Scanner inputConsole = new Scanner(System.in);
		// Request input
		System.out.print("Enter in the Directory path to pad .txt file names.      ");
		// Save input
		String inputPath = inputConsole.nextLine();
		// Create file array
		File[] folderFiles = new File(inputPath).listFiles();
		for(int i = 0; i < folderFiles.length; i++) {
			// add files with .txt extension
			if (folderFiles[i].getName().endsWith(".txt")) {
				txtFiles.add(folderFiles[i]);
			}
		}
		// Go though files and replace names if parameters met 
		for (int i = 0; i < txtFiles.size(); i++) {
			String fileName = txtFiles.get(i).getName();
			String ints[] = fileName.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
			if (ints[1].length() < 2) {
				ints[1] = "0" + ints[1];
			}
			if (ints[3].length() < 2) {
				ints[3] = "0" + ints[3];
			}
			// Replace the file name 
			String newfileName = ints[0] + ints[1] + ints[2] + ints[3] + ints[4];
			Path newFilePath = Paths.get(txtFiles.get(i).getAbsolutePath());
			try {
			Files.move(newFilePath, newFilePath.resolveSibling(newfileName));
			// Catch exception 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}

}
