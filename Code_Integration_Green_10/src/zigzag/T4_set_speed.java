package zigzag;
import java.awt.Component;
import java.util.Random;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import javax.swing.JOptionPane;
public class T4_set_speed {
	public T4_set_speed(int length, int num_of_sections) {	//Class constructor to receive the variables "length" and "num_of_sections" from the class mains
		validation(length, num_of_sections);	//calling method validation and passing variables "length", "num_of_sections" and "JUnit_test"
	}
	
	public static void validation(int length, int num_of_sections) {	//Receiving the variables "length" and "num_of_sections"
		if (length>19 && length<81 && length%1==0 && num_of_sections%2==0){	//Checking inputs to see if they are valid
			calculations(length, num_of_sections);	//Passing the variables "length" and "number_of_sections" to the method calculations
		}
		else {	//If inputs are invalid
			Component frame = null;	//Create an empty frame
			JOptionPane.showMessageDialog(frame,"Sorry there was an error please use the GUI properly to input the values","Unexpected Error",JOptionPane.ERROR_MESSAGE);	//Show error if inputs are invalid (only possible if the user somehow bypasses the GUI)
			throw new IllegalArgumentException("User input invalid");	//This is used to tell JUnit that the input is invalid
		}
	}
	
	private static void calculations(int length, int num_of_sections) {	//Receiving the variables "length" and "num_of_sections"
		Finch myFinch = new Finch();	//Connecting to my finch
		double v, t;	//Creating variables v and t to be used to store the finch's velocity and time taken to reach the specified distance
		int Duration;	//Creating variable duration
		Random rand = new Random();	//Creating a new random object
		int motor_speed = rand.nextInt(180)+75;	//Setting the integer "motor_speed" to a random value between 75 and 255
		v = (motor_speed * 11)/100;	//The velocity for my finch is the "motor_speed" multiplied by 0.11, this value is the gradient of a graph of velocity against motor speed for my finch
		t = (length / v)* 1000;	//Calculation to ensure the finch moves the specified length, because time = distance / speed
		Duration = (int) Math.round(t);	//Rounding calculated value to an integer because the finch only takes integer values
		level(length, num_of_sections, motor_speed, Duration, myFinch);	//Passing the variables "length", "num_of_sections", "motor_speed", "Duration" and "myFinch" to the method level
	}
	
	private static void level(int length, int num_of_sections, int motor_speed, int Duration, Finch myFinch) {	//Receiving the variables "length", "num_of_sections", "motor_speed", "Duration" and "myFinch" from the method calculations
		if (myFinch.isFinchLevel()) {	//Checking if the finch is level
			myFinch.saySomething("Lets go!", 2000);	//Finch lets user know it ready to go from the system's speakers
			@SuppressWarnings("unused")	//Removes waring from IDE
			T4_movement movement = new T4_movement(length,num_of_sections,motor_speed,Duration,myFinch);	//Class constructor to pass variables "length", "num_of_sections", "motor_speed", "Duration" and "myFinch" to the class movement
		}
		else {
			Component frame = null;	//Create an empty frame
			JOptionPane.showMessageDialog(frame,"Please ensure the finch is on a level surface","Finch Error",JOptionPane.ERROR_MESSAGE);	//Show error if finch is not level
			myFinch.quit();	//End connection with finch
		}
	}
}