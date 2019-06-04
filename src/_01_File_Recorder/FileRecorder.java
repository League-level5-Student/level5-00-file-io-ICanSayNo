package _01_File_Recorder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
	String fileText = JOptionPane.showInputDialog("Hello yes what would you like the file text to be?");	
	//Read from a file one line at a time
	try {
		BufferedReader br = new BufferedReader(new FileReader("src/_01_File_Recorder/shrekfile.txt"));
		
		String line = br.readLine();
		while(line != null){
			System.out.println(line);
			line = br.readLine();
			try {
		FileWriter fw = new FileWriter("src/_01_File_Recorder/WrittenFile.txt", true);
		if(line != null) {
			fw.write(line);
		}
		fw.write("\n");
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
		
		br.close();
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
