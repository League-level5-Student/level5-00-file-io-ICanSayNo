package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList extends JFrame implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JPanel panel;

	public ToDoList() {
		button1 = new JButton("Add task");
		button2 = new JButton("View Tasks");
		button3 = new JButton("Remove Task");
		button4 = new JButton("save List");
		button5 = new JButton("Load List");
		panel = new JPanel();

		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);

		this.add(panel);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
	}

	public static void main(String[] args) {

		ToDoList list = new ToDoList();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button1)) {
			String newTask = JOptionPane.showInputDialog("Input a task to be completed");
			System.out.println(newTask);
			FileWriter fw;
			try {
				fw = new FileWriter("src/_03_To_Do_List/To_Do_List.txt", true);
				if (newTask != null) {
					fw.write(newTask);

				}
				fw.write("\n");
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource().equals(button2)) {
			String fileTextTotal = "";
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader("src/_03_To_Do_List/To_Do_List.txt"));

				String fileText = br.readLine();
				while (fileText != null) {
					System.out.println(fileText);

					fileTextTotal = (fileTextTotal + "\n" + fileText);
					fileText = br.readLine();
				}
				JOptionPane.showMessageDialog(null, fileTextTotal);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource().equals(button3)) {
			long lineCount = 0;
			String line = "";
			try {
				
				FileWriter fw = new FileWriter("src/_03_To_Do_List/test.txt", true);
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/To_Do_List.txt"));
				Path path = Paths.get("src/_03_To_Do_List/To_Do_List.txt");
				
				lineCount = Files.lines(path).count();

				System.out.println(lineCount);
				String number = JOptionPane.showInputDialog("Input task number to be deleted within 1 - " + lineCount);
				int deleteNumber = Integer.parseInt(number);
				if(deleteNumber>lineCount) {
					deleteNumber=(int)lineCount;
				}
				for (int i = 0; i < lineCount; i++) {
					line = br.readLine();
					if((int)deleteNumber!=i+1) {
						System.out.println(line);
						System.out.println(i);
						fw.write(line + "\n");
					}
				}
				
				File file = new File("src/_03_To_Do_List/To_Do_List.txt");
				file.delete();
				File file2 = new File("src/_03_To_Do_List/test.txt");
				file2.renameTo(file);
				fw.close();
				br.close();
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource().equals(button4)) {
			File file = new File("src/_03_To_Do_List/To_Do_List.txt");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Saved!");
		} else if (e.getSource().equals(button5)) {
			JOptionPane.showInputDialog("Input a task to be completed");
		}
	}
}
