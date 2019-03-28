package detect_object;
import javax.swing.JOptionPane;

public class T5_fmenu { //start of class

	public static String FinchMenu() //method for the first menu
	{
		Object[] possibilities = {"Curious Finch", "Scaredy Finch", "Spinning Finch", "Exit"}; //the options that are available for in the dropdown
		String m = (String)JOptionPane.showInputDialog(null,"Choose one of the modes","Assignment 2 - Task 5",JOptionPane.PLAIN_MESSAGE, null,possibilities,"Curious Finch"); //dialog box which asks the user to choose one of the modes
		if (m == null || m.length() == 0) m = "Exit"; //if m = null or is empty then m = "Exit"
		return(m); //returns m
	} //end of method
		
	public static String FinchMenu2() //method for second menu
	{
		
		Object[] possibilities = {"Yes", "No / Exit"}; //the options that are available for in the dropdown
		String n = (String)JOptionPane.showInputDialog(null,"Would you like to view the execution log?","Assignment 2 - End Menu",JOptionPane.QUESTION_MESSAGE, null,possibilities,"Yes"); //dialog box which asks the user to choose one of the options
		if (n == null || n.length() == 0) n = "No / Exit"; //if n = null or is empty then n = "Exit"
		return n; //returns n
	} //end of method
	
	@SuppressWarnings("deprecation")
	public static void ExitMenu() //method for ExitMenu
	{
		JOptionPane.showMessageDialog(null, "Exiting Program", "Assignment 2 - Exit", JOptionPane.INFORMATION_MESSAGE, null); //dialog box displays exiting program
		Thread.currentThread().stop();
	} //end of method
	
} //end of class
