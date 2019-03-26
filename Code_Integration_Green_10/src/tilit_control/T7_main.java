package tilit_control;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.io.IOException;
import java.util.Scanner;
public class T7_main { 
 static Finch myfinch = new Finch();//initialises the finch
 public T7_main(){//allows for breaks in the program for delays
 while(myfinch.isFinchLevel()==true){
  RecordTilt RecordTiltObject = new RecordTilt();// calls record tilt
  int T, C = 0; //sets variable type
  Scanner input = new Scanner(System.in);//prompts user input
  System.out.println("Enter a value from 1 up to 20.");//text used in the prompt
  myfinch.saySomething("Please enter a time from one to twenty");//audio prompt for the user to hear
  T = input.nextInt();//gets input
  while (T < 1 || T > 20) {//makes sure input is valid with or statement
   System.out.println("Error!, please input a valid runtime from 1 to 20");//error message to display if wrong input is used
   myfinch.saySomething("ERROR Please enter a time from one to twenty");//audio error message
   T = input.nextInt();//gets input
  }
  C = (T * 1000);//converter to make the time in milliseconds
  myfinch.setLED(255, 0, 0);//sets LED to red
  while (C > 0) {//timer to start
   C = C - 500;//makes it so timer decreases after each input
   RecordTilt.recordtilt();//calls record tilt within the loop
   try {
	Thread.sleep(500);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}//makes sure that there are 500 milliseconds between each recording
   // }
  }
  System.out.println(RecordTilt.recording);//shows the arraylist and its stored values
  myfinch.buzz(100, 500);//buzz to show the stop of the recording
  @SuppressWarnings("unused")
  Translation TranslationObject = new Translation();//calls translation
  try {
	Translation.Translation();
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  myfinch.buzz(100, 500);//first beep
  myfinch.sleep(1000);//break in-between
  myfinch.buzz(100, 500);//second beep this marks the end of the translation
  
 }
 if(myfinch.isFinchLevel()==false){
  System.out.println("error");
 }
 }
}

