package zigzag;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class T4_movement {
	public T4_movement(int length, int num_of_sections, int motor_speed, int Duration, Finch myFinch) {	//Constructor to receive the variables "length", "num_of_sections", "motor_speed", "Duration" and "myFinch" from the class set_speeds
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");	//Format for time recording
		Date start = new Date();	//Record first time stamp
		run(num_of_sections, motor_speed, Duration, myFinch);	//Calling the method run and passing the variables "num_of_sections", "motor_speed", "Duration", "myFinch" to it
		Date end = new Date();	//Record second time stamp
		@SuppressWarnings("unused")	//Removes warning from IDE
		T4_display_details display_details = new T4_display_details(length,num_of_sections,start,end,format);	// Constructor to pass the variables "length", "num_of_sections", "start", "end" and "format" to the class display_details
	}
	
	private static void run(int num_of_sections, int motor_speed, int Duration, Finch myFinch) {	//method to make the finch follow a zigzag
		int sound1 = 1100;	//Setting the value for sound1
		int sound2 = 1600;	//Setting the value for sound2
		Color color1 = Color.GREEN;	//Setting color1 to green
		Color color2 = Color.RED;	//Setting color2 to red
		for (int x=num_of_sections;x>0;x=x-2) {	//Set x=i then as long as x is more than 0 loop the following code reducing x by 2 each iteration
			zig(sound1, color1, motor_speed, Duration, myFinch);	//Constructor to pass the variables "sound1", "color1", "motor_speed", "Duration" and "myFinch" to the method zig
			zag(sound2, color2, motor_speed, Duration, myFinch);	//Constructor to pass the variables "sound2", "color2", "motor_speed", "Duration" and "myFinch" to the method zag
		}
		retrace(num_of_sections, motor_speed, Duration, myFinch, sound1, sound2, color1, color2);	//passing the variables "num_of_sections", "motor_speed", "Duration", "myFinch", "sound1", "sound2", "color1", "color2" to the method retrace
	}
	
	private static void retrace(int num_of_sections, int motor_speed, int Duration, Finch myFinch, int sound1, int sound2, Color color1, Color color2) {	//Method to retrace the path of the run
		myFinch.setLED(0, 0, 0);	//Turning off the LED while turning for retrace
		myFinch.setWheelVelocities(100,-100,1250);	//The finch will rotate an additional 90 degrees to retrace its path (totalling a 180 degree turn as at the end of zag there is already a 90 dgree turn)
		for (int x=0;x<num_of_sections;x=x+2) {	//Set x=0 then as long as x is less than num_of_sections loop the following code increasing x by 2 each iteration
			zag(sound2, color2, motor_speed, Duration, myFinch);	//Constructor to pass the variables "sound2", "color2", "motor_speed", "Duration" and "myFinch" to the method zag 
			zig(sound1, color1, motor_speed, Duration, myFinch);	//Constructor to pass the variables "sound1", "color1", "motor_speed", "Duration" and "myFinch" to the method zig
		}
		myFinch.setLED(0, 0, 0);	//Turning off the LED while turning
		myFinch.setWheelVelocities(100,-100,1250);	//The finch will rotate an additional 90 degrees (totalling a 180 degree turn) so that it faces the way it was before the start of the run
		myFinch.saySomething("Run complete", 2500);
		myFinch.quit();	//Ends connection with the finch
	}
	
	private static void zig(int sound1, Color color1, int motor_speed, int Duration, Finch myFinch) {	//zig method constructor to receive the variables "sound1", "color1", "motor_speed", "Duration" and "myFinch"
		myFinch.setLED(color1);	//Setting finch LED
		myFinch.buzz(sound1,Duration);	//Setting finch buzzer
		myFinch.setWheelVelocities(motor_speed,motor_speed,Duration);	//Setting finch wheel speed
		myFinch.setWheelVelocities(-100,100,1250);	//Setting finch wheel speed for 90 degree turn
	}
	private static void zag(int sound2, Color color2, int motor_speed, int Duration, Finch myFinch) {	//zag method constructor to receive the variables "sound2", "color2", "motor_speed", "Duration" and "myFinch"
		myFinch.setLED(color2);	//Setting finch LED
		myFinch.buzz(sound2,Duration);	//Setting finch buzzer
		myFinch.setWheelVelocities(motor_speed,motor_speed,Duration);	//Setting finch wheel speed
		myFinch.setWheelVelocities(100,-100,1250);	//Setting finch wheel speed for 90 degree turn
	}
}