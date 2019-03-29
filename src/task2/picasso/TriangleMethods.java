/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.picasso;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;
import java.util.ArrayList;
import static task2.picasso.Quitmethod.Triarea;
import static task2.picasso.Quitmethod.Triarray;

/**
 *
 * @author Ashish Menghani
 */
public class TriangleMethods {

    static Finch myf = null;
    private static double aa, bb, cc;
    static int tricount;

    public static void Triangle(int x, int y, int z) {
        myf = new Finch();

        myf.saySomething("Touch to start");
        while (myf.isObstacle() == false) {
            myf.sleep(500);
        }

        myf.buzz(3000, 1000);
        TriConv(x, y, z); // Convert distances into angles

        if (aa + bb + cc != 180) {
            Invalid4UI.main(null);  // If inputs are invalid
        } else {
            myf.setLED(Color.blue);
            Turn(x, aa); // Make first angle
            myf.setLED(Color.magenta);
            Turn(y, bb); //  Make second angle
            myf.setLED(Color.green);
            Turn(z, cc); //  Make third angle
            
            // Save into text file
            Triarray.add("Triangle: " + "Side A: " + x + " Side B: " + y + " Side C: " + z);
            Triarray.add("          " + "Angle A: " + aa + " Angle B: " + bb + " Angle C: " + cc);
            Triarray.add("");

            // Make necessary calculations
            int test;
            double s = (x + y + z) / 2;
            double area = Math.sqrt(s * (s - x) * (s - y) * (s - z));
            System.out.println(area);
            test = (int) area;
            Triarea.add(test);

            // Add to triangle counter
            tricount++;
        }
        myf.buzz(3000, 1000);
        myf.quit();
        
    }

    public static void TriConv(double x, double y, double z) {
        // Turn distances into angles
        aa = Math.toDegrees(Math.acos((((y * y) + (z * z)) - (x * x)) / (2 * y * z)));
        bb = Math.toDegrees(Math.acos((((x * x) + (z * z)) - (y * y)) / (2 * x * z)));
        cc = Math.toDegrees(Math.acos((((x * x) + (y * y)) - (z * z)) / (2 * x * y)));

        // Trim them upto two decimal places
        aa = Math.round(aa * 100.00) / 100.00;
        bb = Math.round(bb * 100.00) / 100.00;
        cc = Math.round(cc * 100.00) / 100.00;
    }

    public static void Turn(int x, double y) {
        int c = (int) (180 - y);
        myf.sleep(1);
        myf.setWheelVelocities(80, 80, 125 * x); // Move 'side' cms
        myf.setWheelVelocities(-83, 83, 11 * c); // Turn Finch each angle
    }
}
