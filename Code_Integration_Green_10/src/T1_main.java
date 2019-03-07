
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchLight {
	private static Finch myFinch = null;
	public static int MinLightSensor;
	public static int noLight = 100;
	public static int delay = 5000;
	public static int LightCounter;
	public static long start;
	public static int LightSensorLeft;
	public static int LightSensorRight;

	public static void main(String[] args) throws InterruptedException {

		myFinch = new Finch();

		MinLightSensor = getMinLightSensor();
		finchstart();
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

	public static void finchstart() throws InterruptedException {
		while (myFinch.isFinchLevel() == false || myFinch.isBeakUp() == false) {
			long start = System.currentTimeMillis();
			if (myFinch.getLeftLightSensor() < noLight || myFinch.getRightLightSensor() < noLight) {
				myFinch.setLED(255, 0, 0, 2000);
				myFinch.setLED(125, 155, 0, 2000);
				myFinch.setLED(0, 255, 0, 3000);
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
					lightfound();
				}
			}
			/*
			 * if(MinLightSensor > noLight == true){ finchstart(); }
			 */
			myFinch.stopWheels();
			myFinch.sleep(1000);
			myFinch.setWheelVelocities(200, 0, 1000);
			lightsearch();

		}
		logs();
	}

	public static void lightfound() throws InterruptedException {
		LightCounter++;

		while (myFinch.isFinchLevel() == false || myFinch.isBeakUp() == false) {
			MinLightSensor = getMinLightSensor();

			MinLightSensor = getMinLightSensor();
			whichside();
			if (MinLightSensor < noLight) {
				lightsearch();
			}

		}
		logs();

	}

	public static void whichside() throws InterruptedException {
		while (true) {
			myFinch.setLED(255, 0, 0);

			if (myFinch.getLeftLightSensor() > 100 || myFinch.getRightLightSensor() > 100) {

				if (myFinch.getLeftLightSensor() > myFinch.getRightLightSensor()) {
					myFinch.setWheelVelocities(0, 100);
				} else {
					myFinch.setWheelVelocities(100, 0);
				}

			} else if (myFinch.getLeftLightSensor() < noLight) {
				lightsearch();
			}

		}

	}

	public static void logs() {
		myFinch.quit();
		long end = System.currentTimeMillis();
		long TotalDuration = start - end;
		Scanner reader = new Scanner(System.in);
		System.out.println("Do you want to see the logs? (1 = Yes, 2 = No): ");
		int UserInput = reader.nextInt();
		if (UserInput == 1) {
			System.out.println(MinLightSensor);
			System.out.println(LightCounter);
			System.out.println(LightSensorLeft);
			System.out.println(LightSensorRight);
			System.out.println(TotalDuration);
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
