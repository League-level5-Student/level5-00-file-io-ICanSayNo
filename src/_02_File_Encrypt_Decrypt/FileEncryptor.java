package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) throws IOException {
		String fileText = JOptionPane.showInputDialog("Hello yes what would you like the file text to be?");
		System.out.println(fileText);
		String fileText_Encrypted = "";
		char currentChar = 'a';
		String str = "";
		int asciiCode = 0;
		for (int i = 0; i < fileText.length(); i++) {
			currentChar = fileText.charAt(i);
			asciiCode = (int) currentChar;
			asciiCode += 25;
			System.out.println(asciiCode);
			if(asciiCode>255) {
				asciiCode-=255;
			}
			str = Character.toString((char)asciiCode);
			fileText_Encrypted=(fileText_Encrypted+str);
		}
		FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/FileEncryptor-Decryptor_TestFile", true);
		if (fileText_Encrypted != null) {
			fw.write(fileText_Encrypted);

		}
		fw.write("\n");
		fw.close();
	}
}
