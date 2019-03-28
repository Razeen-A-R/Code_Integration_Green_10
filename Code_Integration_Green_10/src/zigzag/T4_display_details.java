package zigzag;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class T4_display_details {
	public T4_display_details(int length, int num_of_sections, Date start, Date end, SimpleDateFormat format) {	//Constructor to receive the variables "length", "num_of_sections", "start", "end" and "format" from the class movements
		calculations(length, num_of_sections, start, end, format);	//Calling the method calculations and passing the variables "length", "num_of_sections", "start", "end" and "format"
	}
	
	private static void calculations(int length, int num_of_sections, Date start, Date end, SimpleDateFormat format) {	//Method to perform calculations for the details of the run
		int path_traversed = (length*num_of_sections);	//Calculates the distance in cm of the journey one way
		String pt = path_traversed+" cm (distance to the nearest centimeter)";	//String for traversed path to be used in GUI label
		int straight_line = (int) Math.sqrt((Math.pow(length, 2)+Math.pow(length, 2))*(num_of_sections/2));	//Calculates the straight line distance between the start and end point to the nearest cm
		String sl = straight_line+" cm (distance to the nearest cenitmeter)";	//String for straight line distance to be used in GUI label
		String s_time = format.format(start);	//Formats the first time stamp into a string
		String e_time =format.format(end);	//Formats the second time stamp into a string
		long time_d = end.getTime()-start.getTime();	//Calculates the time taken using the two time stamps
		long min = time_d/60000;	//Time taken to the nearest minute
		String m = min+" minutes (to the nearest minute)";	//String for the time taken in minutes to be used in GUI label
		long sec = time_d/1000;	//Time taken to the nearest second
		String se = sec+" seconds (to the nearest second)";	//String for the time taken in seconds to be used in GUI label
		frame(sl, s_time, e_time, m, se, pt);	//Passing the variables "sl", "s_time", "e_time", "m", "se" and "pt" to the method frame
		@SuppressWarnings("unused")	//Removes waring from IDE
		T4_text text = new T4_text(path_traversed, straight_line, min, sec, s_time, e_time);	//Constructor to pass the variables "path_traversed", "straight_line", "min", "sec", "s_time", "e_time" to the class text
	}
	
	private static void frame(String sl, String s_time, String e_time, String m, String se, String pt) {	//Method to construct the window to display the run details
		JFrame Details = new JFrame("Task 4: Zigzag Details");	//Creates a frame and sets its title
		Details.setSize(600,350);	//Sets the GUI frame size
		Details.setLayout(null);	//Ensures no default layout is used hence nothing will interfere with the layout I create
		Details.setResizable(false);	//Removes the user's ability to change the size of the GUI frame
		path_traversed_label(Details, sl, s_time, e_time, m, se, pt);	//Passing the variables "Details", "sl", "s_time", "e_time", "m", "se" and "pt" to the method path_travesed_label
	}
	
	private static void path_traversed_label(JFrame Details, String sl, String s_time, String e_time, String m, String se, String pt) {	//Method to add the path traversed value label to the GUI
		Label path_t = new Label(pt);	//Creates a label and sets its text
		path_t.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Sets the label font
		path_t.setBounds(220,5,340,30);	//Sets the size and position of the label
		Details.add(path_t);	//Adding the label "path_t" to the frame Details
		time_taken_sec_label(Details, sl, s_time, e_time, m, se);	//Passing the variables "Details", "sl", "s_time", "e_time", "m" and "se" to the method time_taken_sec_label
	}
	
	private static void time_taken_sec_label(JFrame Details, String sl, String s_time, String e_time, String m, String se) {	//Method to add time taken in seconds value to the GUI
		Label t_sec = new Label(se);	//Creates a label and sets its text
		t_sec.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the label font
		t_sec.setBounds(220,165,340,30);	//Sets the size and position of the label
		Details.add(t_sec);	//Adding the label "t_sec" to the frame Details
		time_taken_min_label(Details, sl, s_time, e_time, m);	//Passing the variables "Details", "sl", "s_time", "e_time" and "m" to the method time_taken_min_label
	}
	
	private static void time_taken_min_label(JFrame Details, String sl, String s_time, String e_time, String m) {	//Method to add the time taken in minutes value to the GUI
		Label t_min = new Label(m);	//Creates a label and sets its text
		t_min.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the label font
		t_min.setBounds(220,200,340,30);	//Sets the size and position of the label
		Details.add(t_min);	//Adding the label "t_min" to the frame Details
		straight_line_distance(Details, sl, s_time, e_time);	//Passing the variables "Details", "sl", "s_time" and "e_time" to the method straight_line_distance
	}
	
	private static void straight_line_distance(JFrame Details, String sl, String s_time, String e_time) {	//Method to add the straight line distance value to the GUI
		Label straight_l = new Label(sl);	//Creates a label and sets its text
		straight_l.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the label font
		straight_l.setBounds(220,60,340,30);	//Sets the size and position of the label
		Details.add(straight_l);	//Adding the label "straight_l" to the frame Details
		start_time_label(Details, s_time, e_time);	//Passing the variables "Details", "s_time" and "e_time" to the method start_time_label
	}
	
	private static void start_time_label(JFrame Details, String s_time, String e_time) {	//Method to add the start time value to GUI
		Label s_t = new Label(s_time);	//Creates a label and sets its text
		s_t.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting label font
		s_t.setBounds(90,110,70,30);	//Sets the position and size of the label
		Details.add(s_t);	//Adding the label "s_t" to the frame Details
		end_time_label(Details, e_time);	//Passing the values "Details" and "e_time" to the method end_time_label
	}
	
	private static void end_time_label(JFrame Details, String e_time) {	//Method to add the end time value to the GUI
		Label e_t = new Label(e_time);	//Creates a label and sets its text
		e_t.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting label font
		e_t.setBounds(300,110,70,30);	//Sets the position and size of the label
		Details.add(e_t);	//Adding the label "e_t" to the frame Details
		path_label(Details);	//Passing the variable "Details" to the method path_label
	}
	
	private static void path_label(JFrame Details) {	//Method to add the length of path traversed text to the GUI
		Label path = new Label("Length of path traversed:");	//Creates a label and sets its text
		path.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Sets the label font
		path.setBounds(5,5,200,30);	//Setting the position and size of the label
		Details.add(path);	//Adding the label "path" to the frame Details
		one_way_label(Details);	//Passing the variable "Details" to the method one_way_label
	}
	
	private static void one_way_label(JFrame Details) {
		Label one = new Label("(One way)");	//Creates a label and sets its text
		one.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,8));	//Setting the label font
		one.setBounds(5,40,50,15);	//Setting the position and size of the label
		Details.add(one);	//Adding the label "one" to the frame Details
		straight_label(Details);	//Passing the variable "Details" to the method straight_label
	}
	
	private static void straight_label(JFrame Details) {
		Label straight = new Label("Straight line distance:");	//Creates a label and sets its text
		straight.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Sets label font
		straight.setBounds(5,60,200,30);	//Sets position and size of the label
		Details.add(straight);	//Adds the label "straight" to the frame Details
		one_way_label_2(Details);	//Passing the variable "Details" to the method one_way_label_2
	}
	
	private static void one_way_label_2(JFrame Details) {
		Label one_ = new Label("(One way)");	//Creates a label and sets its text
		one_.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,8));	//Setting the label font
		one_.setBounds(5,90,50,15);	//Setting the position and size of the label
		Details.add(one_);	//Adding the label "one" to the frame Details
		start_time_label(Details);	//Passing the variable "Details" to the method start_time_label
	}
	
	private static void start_time_label(JFrame Details) {
		Label s = new Label("Start time:");	//Creates a label and sets its text
		s.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting label font
		s.setBounds(5,110,80,30);	//Sets the position and size of the label
		Details.add(s);	//Adding the label "s_time" to the frame Details
		time_format_label(Details);	//Passing the variable "Details" to the method time_format_label
	}
	
	private static void time_format_label(JFrame Details) {
		Label fmat = new Label("HH:MM:SS");	//Creates a label and sets its text
		fmat.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,8));	//Setting the label font
		fmat.setBounds(5,140,50,15);	//Setting the position and size of the label
		Details.add(fmat);	//Adding the label "fmat" to the frame Details
		end_time_label(Details);	//Passing the variable "Details" to the method end_time_label
	}
	
	private static void end_time_label(JFrame Details) {
		Label e = new Label("End time:");	//Creates a label and sets its text
		e.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting label font
		e.setBounds(220,110,80,30);	//Sets the position and size of the label
		Details.add(e);	//Adding the label "e_time" to the frame Details
		time_format_label_2(Details);	//Passing the variable "Details" to the method time_format_label_2
	}
	
	private static void time_format_label_2(JFrame Details) {
		Label fmat_ = new Label("HH:MM:SS");	//Creates a label and sets its text
		fmat_.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,8));	//Setting the label font
		fmat_.setBounds(220,140,50,15);	//Setting the position and size of the label
		Details.add(fmat_);	//Adding the label "fmat_" to the frame Details
		time_taken_sec(Details);	//Passing the variable "Details" to the method time_taken_sec
	}
	
	private static void time_taken_sec(JFrame Details) {
		Label time_t_s = new Label("Time taken in seconds:");	//Creates a label and sets its text
		time_t_s.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Sets the label font
		time_t_s.setBounds(5,165,200,30);	//Setting the position and size of the label
		Details.add(time_t_s);	//Adding the label "time_t_s" to the frame Details
		time_taken_min(Details);	//Passing the variable "Details" to the method time_taken_min
	}
	
	private static void time_taken_min(JFrame Details) {
		Label time_t_m = new Label("Time taken in minutes:");	//Creates a label and sets its text
		time_t_m.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Sets the label font
		time_t_m.setBounds(5,200,200,30);	//Setting the position and size of the label
		Details.add(time_t_m);	//Adding the label "time_t_m" to the frame Details
		close_button(Details);	//Passing the variable "Details" to the method close_button
	}
	
	private static void close_button(JFrame Details) {
		Button close = new Button("Close");	//Creates a button and sets its text
		close.setFont(new java.awt.Font("Segoe UI",Font.CENTER_BASELINE,16));	//Setting the font for the button "close"
		close.setBounds(225,250,120,40);	//Setting the position and size for the button "close"
		Details.add(close);	//Adding the button "close" to the frame Details
		frame_position(Details);	//Passing the variable "Details" to the method frame_position
		close.addActionListener(new ActionListener() {	//Checking if the button "close" is clicked
			@Override
			public void actionPerformed(ActionEvent arg0) {	//If the button "close" is clicked
				Details.dispose();	//Close the GUI
			}
		});
	}
	
	private static void frame_position(JFrame Details) {
		Details.setVisible(true);	//Making the GUI visible
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();	//Gets the size of the monitor the program is being run on
		Details.setLocation(dim.width/2-Details.getSize().width/2, dim.height/2-Details.getSize().height/2);	//ensures the GUI appears on the centre of the screen
	}
}