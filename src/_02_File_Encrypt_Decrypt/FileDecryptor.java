package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) throws IOException {
		String fileText_Decrypted = "";
		BufferedReader br = new BufferedReader(
				new FileReader("src/_02_File_Encrypt_Decrypt/FileEncryptor-Decryptor_TestFile"));
		String fileText = br.readLine();
		while (fileText != null) {
			System.out.println(fileText);
			char currentChar = 'a';
			String str = "";
			int asciiCode = 0;
			for (int i = 0; i < fileText.length(); i++) {
				currentChar = fileText.charAt(i);
				asciiCode = (int) currentChar;
				asciiCode -= 25;
				System.out.println(asciiCode);
				if (asciiCode > 255) {
					asciiCode -= 255;
				}
				str = Character.toString((char) asciiCode);
				fileText_Decrypted = (fileText_Decrypted + str);
			}	
			fileText_Decrypted = (fileText_Decrypted + "\n");
			fileText = br.readLine();
		}
		JOptionPane.showMessageDialog(null, fileText_Decrypted);
	}
}
