package integration;
import javax.swing.*;
import navigate.T3_main;
import search_for_light.T1_main;
import tilit_control.T7_main;
import zigzag.T4_main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Code_Integration {
	public static void code_integration() {	//Constructor to set up components for GUI
		window();	//Calling the method frame
	}
	
	public static void window() {	//Method used to construct frame
		JFrame GUI = new JFrame("Green: Group 10");	//Creates a frame and sets its title
		GUI.setSize(500,365);	//Setting GUI frame size
		GUI.setLayout(null);	//Ensures no default layout is used hence nothing will interfere with the layout I create
		GUI.setResizable(false);	//Removes the user's ability to change the size of the GUI frame
		label(GUI);	//Passing the variable "Code_integration" to the method label
	}
	
	private static void label(JFrame GUI) {
		Label heading = new Label("please select a task to execute:");	//Creates a label and sets the text for it
		heading.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,26));	//Setting the font for the label "heading"
		heading.setBounds(55, 0, 500, 40);	//Setting the position and size of the label "length"
		GUI.add(heading);	//Adding the label "heading" to the fame "GUI"
		task_1_button(GUI);	//Passing the variable "Code_integration" to the method task_1_button
	}
	
	private static void task_1_button(JFrame GUI) {	//Method used to create and position a button
		Button task_1 = new Button("Task 1: Search for Light");	//Creates a button and sets its text
		task_1.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the button "task_1"
		task_1.setBounds(20,40,450,40);	//Setting the position and size for the button "task_1"
		GUI.add(task_1);	//Adding the button "task_1" to the frame "GUI"
		task_2_button(GUI);	//Passing the variable "GUI" to the method task_2_button
		task_1.addActionListener(new ActionListener() {	//Checking if the button "task_1" is clicked
			public void actionPerformed(ActionEvent arg0) {	
				T1_main.main(null);
			}
		});
	}
	
	private static void task_2_button(JFrame GUI) {	//Method used to create and position a button
		Button task_2 = new Button("Task 2: Draw Shape");	//Creates a button and sets its text
		task_2.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the button "task_2"
		task_2.setBounds(20,80,450,40);	//Setting the position and size for the button "task_2"
		GUI.add(task_2);	//Adding the button "task_2" to the frame "GUI"
		task_3_button(GUI);	//Passing the variable "GUI" to the method task_3_button
		task_2.addActionListener(new ActionListener() {	//Checking if the button "task_2" is clicked
			public void actionPerformed(ActionEvent arg0) {	//Giving functionality to the button
				//Uncomment the next two lines if you have not made a GUI
				//Component frame = null;	//Create an empty frame
				//JOptionPane.showMessageDialog(frame,"PLease interact with the console","No GUI", JOptionPane.INFORMATION_MESSAGE);	//information for user
				task2.picasso.Picasso.main(null);
			}
		});
	}
	
	private static void task_3_button(JFrame GUI) {	//Method used to create and position a button
		Button task_3 = new Button("Task 3: Navigate");	//Creates a button and sets its text
		task_3.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the button "task_3"
		task_3.setBounds(20,120,450,40);	//Setting the position and size for the button "task_3"
		GUI.add(task_3);	//Adding the button "task_3" to the frame "GUI"
		task_4_button(GUI);	//Passing the variable "GUI" to the method task_4_button
		task_3.addActionListener(new ActionListener() {	//Checking if the button "task_3" is clicked
			public void actionPerformed(ActionEvent arg0) {	//Giving functionality to the button
				//Uncomment the next two lines if you have not made a GUI
				Component frame = null;	//Create an empty frame
				JOptionPane.showMessageDialog(frame,"PLease interact with the console","No GUI", JOptionPane.INFORMATION_MESSAGE);	//information for user
				//add your class.method here to start your program
				new T3_main();
			}
		});
	}
	
	private static void task_4_button(JFrame GUI) {	//Method used to create and position a button
		Button task_4 = new Button("Task 4: Zigzag");	//Creates a button and sets its text
		task_4.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the button "task_4"
		task_4.setBounds(20,160,450,40);	//Setting the position and size for the button "task_4"
		GUI.add(task_4);	//Adding the button "task_4" to the frame "GUI"
		task_5_button(GUI);	//Passing the variable "GUI" to the method task_5_button
		task_4.addActionListener(new ActionListener() {	//Checking if the button "task_4" is clicked
			public void actionPerformed(ActionEvent arg0) {	//Giving functionality to the buttons
				new T4_main();
			}
		});
	}
	
	private static void task_5_button(JFrame GUI) {	//Method used to create and position a button
		Button task_5 = new Button("Task 5: Detect Object");	//Creates a button and sets its text
		task_5.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the button "task_5"
		task_5.setBounds(20,200,450,40);	//Setting the position and size for the button "task_5"
		GUI.add(task_5);	//Adding the button "task_5" to the frame "GUI"
		task_6_button(GUI);	//Passing the variable "GUI" to the method task_6_button
		task_5.addActionListener(new ActionListener() {	//Checking if the button "task_5" is clicked
			public void actionPerformed(ActionEvent arg0) {	//Giving functionality to the button
				//Uncomment the next two lines if you have not made a GUI
				//Component frame = null;	//Create an empty frame
				//JOptionPane.showMessageDialog(frame,"PLease interact with the console","No GUI", JOptionPane.INFORMATION_MESSAGE);	//information for user
				//add your class.method here to start your program
			}
		});
	}
	
	private static void task_6_button(JFrame GUI) {	//Method used to create and position a button
		Button task_6 = new Button("Task 6: Dance");	//Creates a button and sets its text
		task_6.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the button "task_6"
		task_6.setBounds(20,240,450,40);	//Setting the position and size for the button "task_6"
		GUI.add(task_6);	//Adding the button "task_6" to the frame "GUI"
		task_7_button(GUI);	//Passing the variable "GUI" to the method task_7_button
		task_6.addActionListener(new ActionListener() {	//Checking if the button "task_6" is clicked
			public void actionPerformed(ActionEvent arg0) {	//Giving functionality to the button
				//Uncomment the next two lines if you have not made a GUI
				//Component frame = null;	//Create an empty frame
				//JOptionPane.showMessageDialog(frame,"PLease interact with the console","No GUI", JOptionPane.INFORMATION_MESSAGE);	//information for user
				//add your class.method here to start your program
			}
		});
	}
	
	private static void task_7_button(JFrame GUI) {	//Method used to create and position a button
		Button task_7 = new Button("Task 7: Tilt Control");	//Creates a button and sets its text
		task_7.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the button "task_7"
		task_7.setBounds(20,280,450,40);	//Setting the position and size for the button "task_7"
		GUI.add(task_7);	//Adding the button "task_7" to the frame "GUI"
		window_position(GUI);	//Passing the variable "GUI" to the method "window_position"
		task_7.addActionListener(new ActionListener() {	//Checking if the button "task_7" is clicked
			public void actionPerformed(ActionEvent arg0) {	//Giving functionality to the button
				Component frame = null;	//Create an empty frame
				JOptionPane.showMessageDialog(frame,"PLease interact with the console","No GUI", JOptionPane.INFORMATION_MESSAGE);	//information for user
				new T7_main();
			}
		});
	}
	
	private static void window_position(JFrame GUI) {	//Method used to make frame appear and position it
		GUI.setVisible(true);	//Making the GUI visible
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	//Gets the size of the monitor the program is being run on
		GUI.setLocation(dim.width/2-GUI.getSize().width/2, dim.height/2-GUI.getSize().height/2);	//ensures the GUI appears on the centre of the screen
	}
	
	public static void main(String[] args) {	//Code begins to run from here
	      code_integration();	//Runs the method code_integration
	}
}
