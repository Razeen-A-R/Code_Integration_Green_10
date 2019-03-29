/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task2.picasso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ashish Menghani
 */
public class Quitmethod {

    static ArrayList<String> Triarray = new ArrayList<String>();
    static ArrayList<String> Recarray = new ArrayList<String>();
    static ArrayList<Integer> Recarea = new ArrayList<Integer>();
    static ArrayList<Integer> Triarea = new ArrayList<Integer>();

    public static void quitfunction() throws IOException {

        File Textfile = new File("ExecutionLog.txt");
        FileWriter file27 = new FileWriter(Textfile);
        try (PrintWriter write = new PrintWriter(file27)) {

            write.println("===List of shapes drawn===");
            write.println();

            write.println("Triangle Section;");
            write.println();
            for (int i = 0; i < Triarray.size();i++) {
                write.println(Triarray.get(i));
            }
            write.println("===================================");
            write.println("Rectangle Section;");
            write.println();
            for (int i = 0; i < Recarray.size(); i++) {
                write.println(Recarray.get(i));
            }

            write.println("===================================");
            write.println("Largest shape drawn");
            write.println();

            Collections.reverse(Recarea);
            Collections.reverse(Triarea);
            if (Recarray.isEmpty()) {

                write.println("Triangle: " + Triarea.get(0) + " cm^2");
            } else if (Triarray.isEmpty()) {
                write.println("Rectangle: " + Recarea.get(0) + " cm^2");
            } else if (Recarea.get(0) > Triarea.get(0)) {
                write.println("Rectangle: " + Recarea.get(0) + " cm^2");
            } else {
                write.println("Triangle: " + Triarea.get(0) + " cm^2");
            }

            write.println("===================================");
            write.println("Most Frequently drawn shape");
            write.println();

            if (TriangleMethods.tricount > RectangleMethods.reccount) {
                write.println("Triangle");
            }

            if (TriangleMethods.tricount < RectangleMethods.reccount) {
                write.println("Rectangle");
            }

            if (TriangleMethods.tricount == RectangleMethods.reccount) {
                write.println("Rectangle and Triangle were drawn equal number of times");
            }
        }
    }
}
