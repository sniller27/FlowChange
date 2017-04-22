/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Soren
 */
public class Filehandler {

    public static ArrayList<String> ReadFromFile(String name) {

        Scanner scan = null;
        ArrayList<String> scorelist = new ArrayList<>();

        try {
            scan = new Scanner(new java.io.File(name));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error in ReadFromFile() in FileHandler: " + ex.toString());

        }

        while (scan.hasNext()) {

            String str = scan.nextLine();

          //  String test[] = str.split(" ");

          //  int number = Integer.parseInt(test[1]);
           
            scorelist.add(str);

        }
        scan.close();


        return scorelist;
    }

    public static void SaveToFile(ArrayList<String> list, String file) {

        PrintWriter pw = null;

        try {

            pw = new PrintWriter(new File(file));

        } catch (FileNotFoundException ex) {
            System.out.println("Error: ");
            JOptionPane.showMessageDialog(null, "Error in SaveToFile() in FileHandler: " + ex.toString());

        }

        for (String p : list) {
            pw.println(p.toString());
        }

//        for(Person p : persons){
//        writer.println(p.toString());
//        }
        pw.close();

    }
}
