package navigate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.Stack; // for the stacks
import java.time.LocalDateTime; //for the time 
import java.io.IOException; //file writer
import edu.cmu.ri.createlab.terk.robot.finch.Finch; //finch
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class T3_main {

	
	public T3_main(){    //the ioexception is for the logging of the s
		
		
        Finch myfinch = new Finch();

        // Welcome Message
        System.out.println("welcome to finch navigation");
        System.out.println();

        // Instructions
        System.out.println("These are the instructions on how to navigate the finch:");
        System.out.println("To move forward type in 'F' and you will then be asked to enter the speed and the duration, no faster than 200 and no longer than 6000");
        System.out.println("To move left or right type in 'L' or 'R' and you will then be asked to enter the speed and the duration, no faster than 200 and no longer than 6000 ");
        System.out.println("To backtrack type in 't' and it will backtrack your previous steps.");
        System.out.println("To stop the program type in 'q'.");
        System.out.println();

        // Rules
        System.out.println("Rules for commands and values entered:");
        System.out.println("You can only enter 'F,L,R,B,T and q' as commands.");
        System.out.println("You can only enter a 'duration' value which is less than or equal to 6000.");
        System.out.println("You can only enter a 'speed' value between -200 and 200.");
        System.out.println();
      
        //stacks
        Stack<Character> Function_stack = new Stack<Character>();
        Stack<Integer> Speed_stack = new Stack<Integer>();
        Stack<Integer> Duration_stack = new Stack<Integer>();
        
        
       //Enter Command
        System.out.println("Enter your command below:");
        Scanner scan = new Scanner(System.in);
        char ccmmand = scan.next().charAt(0);
       
        
        
        
        if (ccmmand == 'q' && ccmmand != 'b' && ccmmand != 'l' && ccmmand != 'f' && ccmmand != 't' && ccmmand !='d' && ccmmand !='r')
   		{
   			System.exit(0);
   		}

        //Forward
        //if the 'f' key is pressed, it will add the char to a stack, then it will ask the user for the speed and duration, then it will execute, otherwise it will ask for a nother set of numbers which are allowed by the program.
        
       if(ccmmand == 'f' && ccmmand != 'b' && ccmmand != 'l' && ccmmand != 'r' && ccmmand != 't' && ccmmand !='d' && ccmmand !='q')
       {
    	   Function_stack.push('f'); 
    	   
       }
       else
       {
    	   System.out.println("you have not entered a valid command, please try again: ");
    	   ccmmand = scan.next().charAt(0);
       }
       //Start of the scan to find the users input for the speed and duration
       
       System.out.println("please enter the speed you would like the finch to go: ");
       	
       int speed = scan.nextInt();
       Speed_stack.push(speed);
       
       System.out.println("Please enter the duration of the finch's movment: ");
       
       int duration = scan.nextInt();
       Duration_stack.push(duration);
      
       
       //if the speed is less than or equal to 200 and the duration is less than or equal to 6000 then it will set the wheels to the given speed and duration otherwise it will ask for diffrent values.
       if(speed <= 200 && duration <= 6000 )
       {
    	  myfinch.setWheelVelocities(speed,speed,duration);
    	  
    	  System.out.println("please enter a new charecter: ");
       	scan.next().charAt(0);
    	   
       }
       else
       {
    	   System.out.println("the speed or duration is too high please enter the speed: ");
     		int speed1 = scan.nextInt();
     		
     System.out.println("Now enter the new duration");
     		int duration1 = scan.nextInt();
     		
     	myfinch.setWheelVelocities(speed1, speed1, duration1);
     	
     	System.out.println("please enter a new charecter: ");
     	ccmmand = scan.next().charAt(0);
       }
       
      
       //Back
       
       if(ccmmand == 'b' && ccmmand != 'f' && ccmmand != 'l' && ccmmand != 'r' && ccmmand != 't' && ccmmand !='d' && ccmmand !='q');
       
       	{
    	   Function_stack.push('b');
       	}
       
       System.out.println("please enter the speed you would like the finch to go: ");
      	
       speed = scan.nextInt();
       Speed_stack.push(speed);
       
       System.out.println("Please enter the duration of the finch's movment: ");
       
       duration = scan.nextInt();
       Duration_stack.push(duration);
       
       if(speed >= -200 && duration <= 6000 )
       {
    	   myfinch.setWheelVelocities(-speed,-speed,duration);
    	   
    	   System.out.println("please enter a new charecter: ");
        	scan.next().charAt(0);
    	   
       }
       
       else
       {
    	   System.out.println("the speed or duration is too high please enter the speed: ");
     		int speed1 = scan.nextInt();
     		
     System.out.println("Now enter the new duration");
     		int duration1 = scan.nextInt();
     		
     	myfinch.setWheelVelocities(-speed1, -speed1, duration1);
     	
     	System.out.println("please enter a new charecter: ");
     	ccmmand = scan.next().charAt(0);
       }
        
       //left
       
       if(ccmmand == 'l' && ccmmand != 'b' && ccmmand != 'f' && ccmmand != 'r' && ccmmand != 't' && ccmmand !='d' && ccmmand !='q');
       	{
    	   Function_stack.push('l');
    	   
    	   
       	}	
       
       	System.out.println("please enter the speed you would like the finch to go: ");
      	
        speed = scan.nextInt();
        Speed_stack.push(speed);
        
        System.out.println("Please enter the duration of the finch's movment: ");
        
        duration = scan.nextInt();
        Duration_stack.push(duration);
        
        if(speed <= 200 && duration <= 6000 )
        {
     	   myfinch.setWheelVelocities(0,speed,duration); 
     	  
     	   System.out.println("please enter a new charecter: ");
     	  ccmmand = scan.next().charAt(0);
        }
        
        else
        {
     	   System.out.println("the speed or duration is too high please enter the speed: ");
      		int speed1 = scan.nextInt();
      		
      System.out.println("Now enter the new duration");
      		int duration1 = scan.nextInt();
      		
      	myfinch.setWheelVelocities(speed1, speed1, duration1);
      	
      	System.out.println("please enter a new charecter: ");
      	ccmmand = scan.next().charAt(0);
        }
        
        //right
        
        if(ccmmand == 'r' && ccmmand != 'b' && ccmmand != 'l' && ccmmand != 'f' && ccmmand != 't' && ccmmand !='d' && ccmmand !='q');
       	{
    	   Function_stack.push('r');
       	}	
       
       	System.out.println("please enter the speed you would like the finch to go: ");
      	
        speed = scan.nextInt();
        Speed_stack.push(speed);
        
        System.out.println("Please enter the duration of the finch's movment: ");
        
        duration = scan.nextInt();
        Duration_stack.push(duration);
        
        if(speed <= 200 && duration <= 6000 )
        {
     	   myfinch.setWheelVelocities(speed,0,duration); 
     	   
     	  System.out.println("please enter a new charecter: ");
     	 ccmmand = scan.next().charAt(0);
        }
        
        else
        {
     	   System.out.println("the speed or duration is too high please enter the speed: ");
      		int speed1 = scan.nextInt();
      		
      System.out.println("Now enter the new duration");
      		int duration1 = scan.nextInt();
      		
      	myfinch.setWheelVelocities(speed1, speed1, duration1);
      	
      	System.out.println("please enter a new charecter: ");
      	ccmmand = scan.next().charAt(0);
        }
             
        
       
        
        
       //Date and time command 
        if(ccmmand == 'D')
        {
        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        	   LocalDateTime now = LocalDateTime.now();  
        	   System.out.println(dtf.format(now));
        	   
        	   System.out.println("please enter a new charecter: ");
            	scan.next().charAt(0);

        }
        
        
       
            

      
    	   
        //Retrace
        char Fs0 = (Function_stack.get(0));
    	int Ss0 = (Speed_stack.get(0));
    	int Ds0 = (Duration_stack.get(0));
    	
    	char Fs1 = (Function_stack.get(1));
    	int Ss1 = (Speed_stack.get(1));
    	int Ds1 = (Duration_stack.get(1));
    	
    	char Fs2 = (Function_stack.get(2));
    	int Ss2 = (Speed_stack.get(2));
    	int Ds2 = (Duration_stack.get(2));
    	
    	char Fs3 = (Function_stack.get(3));
    	int Ss3 = (Speed_stack.get(3));
    	int Ds3 = (Duration_stack.get(3));
    	
    	char Fs4 = (Function_stack.get(4));
    	int Ss4 = (Speed_stack.get(4));
    	int Ds4 = (Duration_stack.get(4));
       
       
       
        	
    	//here it is checking how many steps the user wants to retrace and if there are functions in the stack, otherwise it will as the user to input some more functions
        if (ccmmand == 't')
        {
        	System.out.println("How many steps would you like to retrace? ");
        	scan.next().charAt(0);
        	
        }
        else 
        {
        	System.out.println("there are not any steps to retrace, please enter some functions");
        }
        	
        	
     
        
        
        //while the command is t, it will go through the stacks and find the right functions, so if the top function was 'f' then it would get the speed and duraition from f
    	while (ccmmand == 't' && ccmmand != 'b' && ccmmand != 'l' && ccmmand != 'r' && ccmmand != 'q' && ccmmand != 'f' && ccmmand !='d' && ccmmand !='q');
    	
    		
    			
       
       		
       		switch (Fs0) {
       		
       			case 'f': 
       			
       				myfinch.setWheelVelocities(Ss0, Ss0, Ds0);
       				
       			case 'B':
       				
       				myfinch.setWheelVelocities(Ss0, Ss0, Ds0);
       				
       			case'l':
       				
       				myfinch.setWheelVelocities(Ss0, Ss0, Ds0);
       				
       			case'R':
       				
       				myfinch.setWheelVelocities(Ss0, Ss0, Ds0);
       		}
       		
       		switch (Fs1) {
       		
       			case 'f': 
   			
       				myfinch.setWheelVelocities(Ss1, Ss1, Ds1);
   				
       			case 'B':
   				
       				myfinch.setWheelVelocities(Ss1, Ss1, Ds1);
   				
       			case'l':
   				
       				myfinch.setWheelVelocities(Ss1 - (Ss1*2), Ss1, Ds1);
   				
       			case'R':
   				
       				myfinch.setWheelVelocities(Ss1, Ss1-(Ss1*2), Ds1);
   		}
       				
       		switch (Fs2) {
       		
       			case 'f': 
			
       				myfinch.setWheelVelocities(Ss2, Ss2, Ds2);
				
       			case 'B':
				
       				myfinch.setWheelVelocities(Ss2, Ss2, Ds2);
				
       			case'l':
				
       				myfinch.setWheelVelocities(Ss2 - (Ss2*2), Ss2, Ds2);
				
       			case'R':
				
       				myfinch.setWheelVelocities(Ss2, Ss2-(Ss2*2), Ds2);
		}
       			
       		switch (Fs3) {
       		
   				case 'f': 
			
   					myfinch.setWheelVelocities(Ss3, Ss3, Ds3);
				
   				case 'B':
				
   					myfinch.setWheelVelocities(Ss3, Ss3, Ds3);
				
   				case'l':
				
   					myfinch.setWheelVelocities(Ss3 - (Ss3*2), Ss3, Ds3);
				
   				case'R':
				
   					myfinch.setWheelVelocities(Ss3, Ss3-(Ss3*2), Ds3);
		}
       			
       		switch (Fs4) {
       		
       			case 'f': 
			
       				myfinch.setWheelVelocities(Ss4, Ss4, Ds4);
					
	   			case 'B':
				
	   				myfinch.setWheelVelocities(Ss4, Ss4, Ds4);
				
	   			case'l':
				
	   				myfinch.setWheelVelocities(Ss4 - (Ss4*2), Ss4, Ds4);
				
	   			case'R':
	   				
	   				myfinch.setWheelVelocities(Ss4, Ss4-(Ss4*2), Ds4);
		}
       			
       		
       		
       		
       		
       		
       		
       		
       		
       		System.out.println("please enter a new charecter: ");
         	scan.next().charAt(0);
       			
       		myfinch.quit();
             
 
       		}
       		
     
}
