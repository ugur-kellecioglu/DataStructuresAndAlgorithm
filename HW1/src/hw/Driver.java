/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

import java.util.Scanner;

/**
 * Title: Stack implementation with custom linked list implementation Part 2
 *
 * @author Uğur Kellecioğlu ID: *** CLASS: CMPE 242 SECTION: 1
 * Assignment: 1 Description: This class is a driver to run the program.
 *
 */
public class Driver {

    public static void main(String[] args) {
        //--------------------------------------------------------------
        // Summary: Takes the input and based on choice stock may created and pushed or stock may deleted from stack.
        // Precondition: there are no pre condition
        // Postcondition: stack may have vaccinestock or not
        //--------------------------------------------------------------
        Scanner scan = new Scanner(System.in);
        VaccineStock vs = new VaccineStock();
        int action = 0;
        while (action != 2) {
            action = vs.action();
            if (action == 99) {
                continue;
            } else if (action == 2) {
                vs.getStock().print();
                break;
            } else if (action == 0) {
                System.out.println("Enter ITEM DATA?");
                vs.setSerialNumber(scan.nextInt());
                scan.nextLine();
                vs.setCountryName(scan.nextLine());
                vs.setNumberOfVaccines(scan.nextInt());
                scan.nextLine();
                vs.pushItem();
            } else if (action == 1) {
                vs.popItem();
            }

        }

    }
}
