package zigzag;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class T4_main{
	public T4_main() {		//Constructor to set up components for GUIs
		frame();	//Calling the method frame
	}
	
	public static void frame() {	//Method used to construct frame
		JFrame Zigzag = new JFrame("Task 4: Zigzag");	//Creates a frame and sets its title
		Zigzag.setSize(450,350);	//Setting GUI frame size
		Zigzag.setLayout(null);	//Ensures no default layout is used hence nothing will interfere with the layout I create
		Zigzag.setResizable(false);	//Removes the user's ability to change the size of the GUI frame
		length_label(Zigzag);	//Passing the variable "Zigzag" to the method length_label
		//Zigzag.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	//Used to ensure the integration GUI is not closed when zigzag GUI is closed
	}
	
	private static void length_label(JFrame Zigzag) {	//Method used to create and position a label
		Label length = new Label("Lenght of each section:");	//Creates a label and sets the text for it
		length.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the label "length"
		length.setBounds(5,25,180,45);	//Setting the position and size of the label "length"
		Zigzag.add(length);	//Adding the label "length" to the fame "Zigzag"
		sections_label(Zigzag);	//Passing the variable "Zigzag" to the method sections_label
	}
	
	private static void sections_label(JFrame Zigzag) {	//Method used to create and position a label
		Label sections = new Label("Number of sections:");	//Creates a label and sets its text
		sections.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the label "sections"
		sections.setBounds(5,150,180,45);	//Setting the position and size of the label "sections"
		Zigzag.add(sections);	//Adding the label "sections" to the frame "Zigzag"
		cm_lable(Zigzag);	//Passing the variable "Zigzag" to the method cm_lable
	}
	
	private static void cm_lable(JFrame Zigzag) {	//Method used to create and position a label
		Label cm = new Label("cm");	//Creates a label and sets the text for it
		cm.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the label "cm"
		cm.setBounds(280,25,50,45);	//Setting the position and size of the label "cm"
		Zigzag.add(cm);	//Adding the label "cm" to the frame "Zigzag"
		cancel_button(Zigzag);	//Passing the variable "Zigzag" to the method cancel_button
	}
	
	private static void cancel_button(JFrame Zigzag) {	//Method used to create and position a button
		Button cancel = new Button("Cancel");	//Creates a button and sets its text
		cancel.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the button "cancel"
		cancel.setBounds(50,250,120,40);	//Setting the position and size for the button "cancel"
		Zigzag.add(cancel);	//Adding the button "cancel" to the frame "Zigzag"
		length_spinner(Zigzag);	//Passing the variable "Zigzag" to the method length_spinner
		cancel.addActionListener(new ActionListener() {	//Checking if the button "cancel" is clicked
			public void actionPerformed(ActionEvent arg0) {	//Giving functionality to the button
				Zigzag.dispose();	//Terminate the program
			}
		});
	}
	
	private static void length_spinner(JFrame Zigzag) {	//Method used to create and position a spinner
		JSpinner len = new JSpinner();	//Creates a spinner
		SpinnerNumberModel l = new SpinnerNumberModel(20,20,80,1);	//Creating a model "l" for the spinner "len"
		len.setModel(l);	//Setting the spinner "len" to the model "l"
		len.setBounds(200,25,50,40);	//Setting the position and size of the spinner "len"
		len.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));
		Zigzag.add(len);	//Adding the spinner "len" to the frame "zigzag"
		sections_spinner(Zigzag, len);	//Passing the variable "Zigzag" to the method sections_spinner
	}
	
	private static void sections_spinner(JFrame Zigzag, JSpinner len) {	//Method used to create and position a spinner
		JSpinner sect = new JSpinner();	//Creates a spinner
		SpinnerNumberModel s = new SpinnerNumberModel(2,2,10,2);	//Creating a model "s" for spinner "sect"
		sect.setModel(s);	//Setting the spinner "sect" to the model "s"
		sect.setBounds(200,150,50,40);	//Setting the position and size of the spinner "sect"
		sect.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));
		Zigzag.add(sect);	//Adding the spinner "sect" to the frame "Zigzag"
		confirm_button(Zigzag, len, sect);	//Passing the variable "Zigzag" to the method confirm_button
	}
	
	private static void confirm_button(JFrame Zigzag, JSpinner len, JSpinner sect) {	//Method to create and position a button
		Button confirm = new Button("Confirm");	//Creates a button and sets its text
		confirm.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the button "cancel"
		confirm.setBounds(250,250,120,40);	//Setting the position and size for the button "confirm"
		Zigzag.add(confirm);	//Adding the button "confirm" to the frame "Zigzag"
		frame_position(Zigzag);	//Passing the variable "Zigzag" to the method frame_position
		confirm.addActionListener(new ActionListener() {	//Checking if the button "confirm" is clicked
			public void actionPerformed(ActionEvent e) {	//If the button "confirm" is clicked
				int length,num_of_sections;	//Create two new integers length and num_of_sections
				length = (Integer) len.getValue();	//Set the value of the spinner "len" to the variable "length"
				num_of_sections = (Integer) sect.getValue();	//Set the value of the spinner "sect" to the variable "num_of_sections"
				@SuppressWarnings("unused")	//Removes warning from IDE
				T4_set_speed set_speed = new T4_set_speed(length,num_of_sections);	//Constructor to pass the variables "length" and "num_of_sections" to the class set_speed
			}
		});
	}
	
	private static void frame_position(JFrame Zigzag) {	//Method used to make frame appear and position it
		Zigzag.setVisible(true);	//Making the GUI visible
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	//Gets the size of the monitor the program is being run on
		Zigzag.setLocation(dim.width/2-Zigzag.getSize().width/2, dim.height/2-Zigzag.getSize().height/2);	//ensures the GUI appears on the centre of the screen
	}
}