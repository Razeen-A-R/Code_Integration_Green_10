
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.util.ArrayList;
public class FinchLight {
	private static Finch myFinch = null;
	
	public static int MaxLightSensor;
	static ArrayList<Long>TStart = new ArrayList<Long>();
	public static int LeftLightSensor;
	public static int RightLightSensor;
	public static int MinLightSensor;
	public static int noLight = 100;
	public static int delay = 5000;
	public static int LightCounter;
	public static long start;
	public static int LightSensorLeft;
	public static int LightSensorRight;

	public static void main(String[] args) {
		
		long start_time = System.currentTimeMillis();
		TStart.add(start_time);

		myFinch = new Finch();

		MinLightSensor = getMinLightSensor();
		finchstart();
		
	}
	public static int getRightLightSensor() {
		int LeftLightSensor = myFinch.getLeftLightSensor();
		return LeftLightSensor;
		}
	
	public static int getLeftLightSensor() {
		int RightLightSensor = myFinch.getRightLightSensor();
		return RightLightSensor;
		}

		

	public static int getMinLightSensor() {
		int LeftLightSensor = myFinch.getLeftLightSensor();
		int RightLightSensor = myFinch.getRightLightSensor();
		int min;
		if (LeftLightSensor < RightLightSensor) {
			min = LeftLightSensor;
		} else {
			min = RightLightSensor;
		}

		return min;
		

	}
	public static int getMaxLightSensor() {
		int LeftLightSensor = myFinch.getLeftLightSensor();
		int RightLightSensor = myFinch.getRightLightSensor();
		int max;
		if (LeftLightSensor > RightLightSensor) {
			max = LeftLightSensor;
		} else {
			max = RightLightSensor;
		}

		return max;
		

	}


	public static void finchstart() throws InterruptedException {
		if (myFinch.isFinchLevel()== false) {
			myFinch.quit();
		}
		while (myFinch.isFinchLevel() == false || myFinch.isBeakUp() == false) {
			long start = System.currentTimeMillis();
			TStart.add(start);
			if (myFinch.getLeftLightSensor() < noLight || myFinch.getRightLightSensor() < noLight) {
				
				myFinch.setLED(255, 0, 0, 2000);
				myFinch.setLED(125, 125, 0, 2000);
				myFinch.setLED(125, 0, 125, 3000);
				lightsearch();
			} else {
				lightfound();
			}
		}
		logs();
	}

	public static void lightsearch() throws InterruptedException {
		while (myFinch.isFinchLevel() == true || myFinch.isBeakUp() == false) {
			long time = System.currentTimeMillis();
			myFinch.setLED(0, 255, 0);
			while (System.currentTimeMillis() - time < delay) {
				myFinch.setWheelVelocities(125, 125);
				int LightSensorLeft = myFinch.getLeftLightSensor();
				int LightSensorRight = myFinch.getRightLightSensor();
				if (LightSensorLeft > noLight | LightSensorRight > noLight) {
					LightCounter++;
					myFinch.buzz(255,1000);
					
					lightfound();
				}
			}
			myFinch.stopWheels();
			myFinch.sleep(1000);
			myFinch.setLED(0,0,255);
			myFinch.setWheelVelocities(255, 0,2000);
			myFinch.setWheelVelocities(200, 0, 1000);
		
		
			lightsearch();

		}
		logs();
	}

	public static void lightfound() throws InterruptedException {

		while (myFinch.isFinchLevel() == false || myFinch.isBeakUp() == false) {
			MaxLightSensor = getMaxLightSensor();
			MinLightSensor = getMinLightSensor();
			LeftLightSensor = getLeftLightSensor();
			RightLightSensor= getRightLightSensor();
			whichside();
			if (MinLightSensor < noLight) {
				lightsearch();
			}

		}
		logs();

	}

	public static void whichside() throws InterruptedException { 
		while (true) {
		
			int LightSensorLeft = myFinch.getLeftLightSensor();
			int LightSensorRight = myFinch.getRightLightSensor();
			int average = (LightSensorLeft + LightSensorRight) / 2;
			myFinch.setLED(average, 0, 0);

			if (myFinch.getLeftLightSensor() > 100 || myFinch.getRightLightSensor() > 100) {

				if (myFinch.getLeftLightSensor() > myFinch.getRightLightSensor()) {
					myFinch.setWheelVelocities(0, 100);
				} else {
					myFinch.setWheelVelocities(100, 0);
				}

			} else if (myFinch.getLeftLightSensor() < noLight) {
				myFinch.buzz(1, 1000);
				

				lightsearch();
			}

		}

	}

	public static void logs() {
		myFinch.quit();
		long end = System.currentTimeMillis();
		long start = TStart.get(0);
		long TotalDuration = (end - start) / 1000;
		Scanner reader = new Scanner(System.in);
		System.out.println("Do you want to see the logs? (1 = Yes, 2 = No): ");
		int UserInput = reader.nextInt();
		if (UserInput == 1) {
			System.out.println("The minimum amount of light sensed is " + MinLightSensor);
			System.out.println("The maximum amount of light sensed is " + MaxLightSensor);
			System.out.println("The amount of times light was detected " + LightCounter);
			System.out.println("The  left light sensor value is " + LeftLightSensor);
			System.out.println("The  right light sensor value is " + RightLightSensor);
			System.out.println("The total duration is " +TotalDuration + " seconds");
			System.out.println("Sorry to see you go :C");

		} else if (UserInput == 2) {
			System.out.println("Sorry to see you go :C");
			System.exit(0);
		} else {
			System.out.println("Invalid input!");
			logs();
		}
		System.exit(0);
	}

}
