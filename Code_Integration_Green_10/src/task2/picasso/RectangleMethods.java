/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.picasso;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;
import java.util.ArrayList;
import static task2.picasso.Quitmethod.Recarea;
import static task2.picasso.Quitmethod.Recarray;

/**
 *
 * @author Ashish Menghani
 */
public class RectangleMethods {

    static Finch myf = null;
    static int reccount;

    public static void Rectangle(int x, int y) {
        myf = new Finch();

        myf.saySomething("Touch to start");
        while (myf.isObstacle() == false) {
            myf.sleep(500);
        }

        myf.buzz(3000, 1000);
        myf.setLED(Color.blue);
        RecMove(x);
        myf.setLED(Color.green);
        RecMove(y);
        myf.setLED(Color.magenta);
        RecMove(x);
        myf.setLED(Color.red);
        RecMove(y);
        myf.buzz(3000, 1000);
        myf.quit();
        
        // Save into text file
        Recarray.add("Rectangle: " + " Height: " + x + " Width: " + y);
        Recarray.add("");
        int s = x * y;
        Recarea.add(s);

        // Add rectangle counter
        reccount++;
    }

    public static void RecMove(int x) {
        myf.setWheelVelocities(80, 80, 125 * x); // Move forward
        myf.setWheelVelocities(-83, 83, 990); // Make a 90 degree angle
        myf.sleep(1); 
    }

}
