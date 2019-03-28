package detect_object;
import java.util.Random;

import javax.swing.JOptionPane;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class T5_main{ //start of class
		
		static Finch myf = null; //initialise the finch as null
		
		static String modeChosen; //initialise modeChosen as string (stores the mode chosen by the user)
		
		static long duration; //initialise duration as long (used to calculate how long the program has been executing for)
		static long start; //initialise start as long (this starts the timer when the program begins and is used to calculate the duration)
		static long end; //initialise end as long (this ends the timer when the program finishes and is used to calculate the duration)
		
		static int objectcounter; //initialise objectcounter as int
			
		static int timer = 5000; //initialise timer as int and set it to 5000 (timer for the curious finch when it hasn't detect an object)
		
		public static void main(String args[]) throws InterruptedException 
		
		{
			start = System.nanoTime(); //timer has been started in nanoseconds
			
			
			
			String m = ""; //empty string
			myf = new Finch(); //declare myf as new finch
			
			System.out.println("*********************************************************INSTRUCTIONS*********************************************************"); //start of instructions
			System.out.println("1) Place Finch level with the ground");
			System.out.println("2) Select either Curious Finch/Scaredy Finch to execute these modes or select Exit/click the cancel button to exit the program");
			System.out.println("3) If you have chosen either Curious Finch/Scaredy Finch and would like to end the mode then place the finch on it's tail");
			System.out.println("4) Select Yes if you would like view the execution log otherwise select No to exit the program");
			System.out.println("*****************************************************END OF INSTRUCTIONS******************************************************"); //end of instructions
			
			while (!myf.isFinchLevel()) //while the finch is not level
			{
				JOptionPane.showMessageDialog(null, "Place the Finch level with the ground", "Assignment 2 - Finch Not Level", JOptionPane.ERROR_MESSAGE, null); //dialog box displays place the finch level with the ground
				Thread.sleep(1000); //this will stop the execution of the program for 2 seconds
			}
			 
			
			m = T5_fmenu.FinchMenu(); //m is set to the FinchMenu method
			if (m.equals("Curious Finch")) //if statement to check which option the user has chosen
			{
				myf.saySomething("Curious Finch Mode has started");
				modeChosen = "Curious Finch"; //the user has chosen "Curious Finch" 
				CuriousFinch(); //CuriousFinch method will be executed
			}
					
				
			if (m.equals("Scaredy Finch"))	//if statement to check which option the user has chosen
			{
				myf.saySomething("Scaredy Finch Mode has started");
				modeChosen = "Scaredy Finch"; //the user has chosen "Scaredy Finch" 
				ScaredyFinch(); //ScaredyFinch method will be executed
			}
			
			
			if (m.equals("Spinning Finch"))	//if statement to check which option the user has chosen
			{
				myf.saySomething("Spinning Finch Mode has started");
				modeChosen = "Spinning Finch"; //the user has chosen "Scaredy Finch" 
				SpinningFinch(); //ScaredyFinch method will be executed
			}
					
		
			if (m.equals("Exit")) //if statement to check which option the user has chosen
			{	
				myf.quit(); //quit the finch
				T5_fmenu.ExitMenu(); //ExitMenu method is executed
			}
				
				
		}
		
			
		private static void CuriousFinch() throws InterruptedException //method the for the curious finch mode
		{
			while (!myf.isBeakUp()) //while the finches beak is not up
			{
				long currenttime = System.currentTimeMillis(); //stores currenttime as the system's current time
				
				while (System.currentTimeMillis() - currenttime <= timer) //while the system's current timer minus currenttime is less than or equal to the timer
				{
					StopFinch(); //StopFinch method is executed
					myf.setWheelVelocities(75, 75); //finch moves forward	
					myf.setLED(255, 0, 0); //set the finch's LED to red
					
					
					while (myf.isObstacleRightSide()) //while the finch detects an object on the right side
					{				
						myf.setLED(0, 255, 0);	//set the finch's LED to green
						myf.buzz(300, 1000);	//finch makes a buzzing noise
						myf.setWheelVelocities(150, 75); //the finch turns right
						
						if (!myf.isObstacleRightSide()) //if the finch doesn't detect an an object on the right side
						{
							objectcounter++; //increment objectcounter by 1
							CuriousFinch(); //CuriousFinch method is executed
						}
						
					}
					
					while (myf.isObstacleLeftSide()) //while the finch detects an object on the left side
					{
						myf.setLED(0, 255, 0);	//set the finch's LED to green
						myf.buzz(300, 1000);	//finch makes a buzzing noise	
						myf.setWheelVelocities(75, 150); //the finch turns left
						
						if (!myf.isObstacleLeftSide()) //if the finch doesn't detect an an object on the left side
						{
							objectcounter++; //increment objectcounter by 1
							CuriousFinch(); //CuriousFinch method is executed
						}
						
					}
					
					while (myf.isObstacle()) //while the finch detects an object on the left side or the right side
					{
						Thread.sleep(200); //stops executing the program for 0.2 seconds
						myf.stopWheels(); //finch's wheel stops
						myf.setLED(255, 0, 0); //set the finch's LED to red
						
						if (!myf.isObstacle()) //if the finch doesn't detect an object on the left side or the right side
						{
							CuriousFinch(); //CuriousFinch method is executed
						}
		
					}

				}
				
				myf.setWheelVelocities(0, 0, 500); //finch's wheels stop moving for 0.5 seconds
				myf.setWheelVelocities(150, 75, 1000); //finch turns right 
				myf.setLED(255, 0, 0); //set the finch's LED to red
				
			}
			
		} //end of method
					
		
		private static void ScaredyFinch() //method for ScaredyFinch
		{
			while (!myf.isBeakUp()) //while the finch's beak is not up
			{

				if (myf.isObstacleRightSide()) //if the finch detects an object on the right side
				{
					scaredyfinchmovement(); //scaredyfinchmovement method is executed
					
				}else if (myf.isObstacleLeftSide()) //else if the finch detects on the left side
				{
					scaredyfinchmovement(); //scaredyfinchmovement method is executed
				}
				
				else{ //else
					myf.setWheelVelocities(75, 75); //finch moves forward
					myf.setLED(0, 255, 0); //set finch's LED to green
				}
				
			}
			
			StopFinch(); //StopFinch method is executed		
		} //end of method
		
		private static void scaredyfinchmovement() //method for scaredyfinchmovement
		{
			Random finchspeed = new Random();
			int randomspeedx; //initialise randomspeedx as int
			int randomspeedy; ////initialise randomspeedy as int
			
			objectcounter++; //increment objectounter by 1
			myf.setLED(255, 0, 0); //set finch's LED to red
			myf.buzz(200, 100); //finch makes buzzing noise 
			myf.setWheelVelocities(-100, -100, 2000); //finch moves backwards for 2 seconds
			randomspeedx = finchspeed.nextInt(150)+1; //randomly generates a number and stores it in randomspeedx
			randomspeedy = finchspeed.nextInt(75)+1; //randomly generates a number and stores it in randomspeedy
			myf.setWheelVelocities(randomspeedx, randomspeedy, 2000); //set the wheel velocties to randomspeedx and randomspeedy which will make the finch move for 2 seconds
		}
		
		
		private static void SpinningFinch() //method for SpinningFinch
		{
			while (!myf.isBeakUp()) //while the finch's beak is not up
			{

				if (myf.isObstacleRightSide()) //if the finch detects an object on the right side
				{
					spinningfinchmovement(); //spinningfinchmovement method is executed
					
				}else if (myf.isObstacleLeftSide()) //else if the finch detects on the left side
				{
					spinningfinchmovement(); //spinningfinchmovement method is executed
				}
				
				else{ //else
					myf.setWheelVelocities(75, 75); //finch moves forward
					myf.setLED(0, 255, 0); //set finch's LED to green
				}
				
			}
			
			StopFinch(); //StopFinch method is executed	
		} //end of method
		
		
		private static void spinningfinchmovement() //method for spinningfinchmovement
		{
			objectcounter++; //increment objectounter by 1
			myf.setLED(0, 0, 255); //set finch's LED to blue
			myf.buzz(200, 100); //finch makes buzzing noise 
			myf.setWheelVelocities(255, 10, 4000); //makes the finch spin
		} //end of method
		
		private static void StopFinch() //method for StopFinch
		{
			
			while (myf.isBeakUp()) //while the finch's beak is up
			{
				myf.saySomething("The Finch mode has ended");
				myf.stopWheels(); //stops the finch's wheels
				myf.setLED(0, 255, 0); //sets finch's LED to green
				EndMethod(); //EndMenu method is executed
			}
			
		} //end of method
		
		private static void EndMethod() //method for EndMethod
		{
			myf.quit(); //quits finch
			end = System.nanoTime(); //end is set to system nanotime
			String n = ""; //empty string
			n = T5_fmenu.FinchMenu2(); //n is set to the FinchMenu2 method
			
			if (n.equals("Yes")) //if statement to check which option the user has chosen
				{
				duration = end-start; //set duration to end - start
				duration = duration/1000000000; //set duration to duration/1000000000
				JOptionPane.showMessageDialog(null, "The chosen mode was " + modeChosen + " \nThe execution duration was " + duration + " seconds" + " \nThe amount of objects encountered was " + objectcounter, "Assignment 2 - Execution Log", JOptionPane.INFORMATION_MESSAGE, null); //dialog box displays the mode chosen, the duration and the amount of objects encountered by the finch
				T5_fmenu.ExitMenu(); //ExitMenu is executed
				}
			
			if (n.equals("No / Exit")) //if statement to check which option the user has chosen
			{
				T5_fmenu.ExitMenu(); //ExitMenu is executed
			}
		} //end of method
		
			
		
        } //end of class


