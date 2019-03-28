package tilit_control;
import java.util.ArrayList;
public class RecordTilt extends T7_main {
 public static int finchtilt = 1;//makes finchtilt accessable through other classes
 public static ArrayList<Integer> recording = new ArrayList<Integer>();//arraylist to store the tilt instructions
 public static void recordtilt() {
  if (myfinch.isBeakUp()) {// ==true){//all the different instructions
   finchtilt = 0;
  }
  if (myfinch.isBeakDown()) {// ==true){
   finchtilt = 1;
   ;
  }
  if (myfinch.isLeftWingDown()) {// ==true){
   finchtilt = 2;
  }
  if (myfinch.isRightWingDown()) {// ==true){
   finchtilt = 3;
  }
  if (myfinch.isFinchLevel()) {// ==true){
   finchtilt = 4;
  }
  switch (finchtilt) {
  case 0:
   finchtilt = 0;
   System.out.println("Beak Up");
   break;
  case 1:
   finchtilt = 1;
   System.out.println("Beak Down");
   break;
  case 2:
   finchtilt = 2;
   System.out.println("Left Wing Down");
   break;
  case 3:
   finchtilt = 3;
   System.out.println("Right Wing Down");
   break;
  case 4:
   finchtilt = 4;
   System.out.println("Finch Is Level");
   break;
  }
  recording.add(finchtilt);//adds tilts to the arraylist
 }
}
