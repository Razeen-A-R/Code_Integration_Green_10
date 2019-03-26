package tilit_control;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class Translation extends T7_main {
 static void Translation() throws InterruptedException {
  myfinch.setLED(0, 0, 0, 2000);//break of 2 seconds between execution and recording
  for (int i = 0; i < RecordTilt.recording.size(); i++) {//runs for as long as the length of the array stored
   int translate = RecordTilt.recording.get(i);
   // RecordTilt.recording.get(i);
   System.out.println(translate);
   decisions(translate);
  }
 }
 static int F = (int) ((Math.random() * ((255 - 10) + 1)) + 10);//randomises the forward motion
 static int R = (int) ((Math.random() * ((-255 + 10) + 1)) + 10);//randomises the backward motion
 public static void decisions(int translate) {
  myfinch.setLED(0, 255, 0);//sets LED to green
  if (translate == 0) {//all instructions for the different inputs
   myfinch.setWheelVelocities(F, F, 500);
   myfinch.sleep(500);
   System.out.println("Finch moves forward");
  }
  if (translate == 1) {
   myfinch.setWheelVelocities(R, R, 500);
   myfinch.sleep(500);
   System.out.println("Finch moves Backward");
  }
  if (translate == 2) {
   myfinch.setWheelVelocities(0, F, 500);
   myfinch.sleep(500);
   System.out.println("Finch turns left");
  }
  if (translate == 3) {
   myfinch.setWheelVelocities(F, 0, 500);
   myfinch.sleep(500);
   System.out.println("Finch turns right");
  }
  if (translate == 4) {
   myfinch.setWheelVelocities(0, 0, 500);
   myfinch.sleep(500);
   System.out.println("Finch doesnt move");
  }
  }
 }
