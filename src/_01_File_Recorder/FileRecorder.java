package _01_File_Recorder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String fileText = JOptionPane.showInputDialog("Hello yes what would you like the file text to be?");
		System.out.println(fileText);
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/WrittenFile.txt", true);
			if (fileText != null) {
				fw.write(fileText);
			}
			fw.write("\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
