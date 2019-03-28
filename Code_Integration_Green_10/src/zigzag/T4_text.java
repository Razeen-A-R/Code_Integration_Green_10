package zigzag;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
public class T4_text {
	public T4_text(int path_traversed, int straight_line, long min, long sec, String s_time, String e_time) {	//Constructor to receive the variables "path_traversed", "straight_line", "min", "sec", "s_time", "e_time" from the class display_detailss
		String fileName = "Run Details.txt";	//This string will be used as the file name
		try {	//Try the following in the case of no errors execute the following
			PrintWriter outputStream = new PrintWriter(fileName);	//Create a file with the name of variable "fileName"
			outputStream.print("The length of the path traversed by the finch was " + path_traversed);	//This will be printed in the text file
			outputStream.println("");	//A new line will be started in the text file
			outputStream.print("The straight line distance between the start and end of the zigzag was " + straight_line);	//This will be printed in the text file
			outputStream.println("");	//A new line will be started in the text file
			outputStream.print("The start time was " + s_time);	//This will be printed in the text file
			outputStream.println("");	//A new line will be started in the text file
			outputStream.print("The end time was " + e_time);	//This will be printed in the text file
			outputStream.println("");	//A new line will be started in the text file
			outputStream.print("Time taken in seconds was " + sec);	//This will be printed in the text file
			outputStream.println("");	//A new line will be started in the text file
			outputStream.print("Time taken in minutes was " + min);	//This will be printed in the text file
			outputStream.close();	//The output stream is closed and the file is created all details are written to the file
			Component frame = null;	//Create an empty frame
			JOptionPane.showMessageDialog(frame,"A file with the name Run Details.txt has been saved to the project root folder, this file contains details of your most previous run","File Saved", JOptionPane.INFORMATION_MESSAGE);	//information for user
		} catch (FileNotFoundException e1) {	//If there is an error then execute the following
			Component frame = null;	//Create an empty frame
			JOptionPane.showMessageDialog(frame,"Sorry an error occurred and the text file containing the latest run details could not be saved","Permission Error",JOptionPane.ERROR_MESSAGE);	//This message is displayed to notify the user of the error
			e1.printStackTrace();
		}	
	}
}