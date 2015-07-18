/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rng;

import java.io.*;
import static java.lang.Math.floor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wolf
 */
public class RNG {

    //each variable
    final static double a = 16807.0;
    final static double m = 2147483647.0;
    final static double q = 127773.0;
    final static double r = 2836.0;
    static double x_div_q;
    static double rndm;
    static double x;
    static double x_mod_q;
    static double x_new;
    static int u;
    static int size;

    //studd I dont know how to do
    //static FileOutputStream fop;
    //static File file;
    public static void main(String[] args) throws FileNotFoundException {

        x = Double.parseDouble(JOptionPane.showInputDialog("Enter x(seed): "));
        size = Integer.parseInt(JOptionPane.showInputDialog("Enter # of randoms: "));
        BufferedWriter writer = null;
        String randomNumber;
        String fileName = "random numbers for seed " + x + ", with number of randoms " + size + ".txt";

        System.out.println(fileName);
        
        try {
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream(fileName), "utf-8"));
            
            for (u = 1; u < size; u++) {
                x_div_q = floor(x / q);
                x_mod_q = x - q * x_div_q;
                x_new = a * x_mod_q - r * x_div_q;
                if (x_new > 0.0) {
                    x = x_new;
                } else {
                    x = x_new + m;
                }
                rndm = x / m;
                
                randomNumber = Double.toString(rndm);
                System.out.println(rndm);
                System.out.println(randomNumber);
                
                writer.write(randomNumber);
                writer.newLine();
            }
            
            }  catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }


    }
}

