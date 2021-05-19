/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

import java.util.Scanner;

/**
 * Title: Stack implementation with custom linked list implementation 
 * Part 2
 * @author Uğur Kellecioğlu
 * ID: ***
 * CLASS: CMPE 242
 * SECTION: 1
 * Assignment: 1
 * Description: This class define a vaccine stock item 
 * 
 */
public class VaccineStock {
    
    private int serialNumber; //An integer which holds the vaccine serial number
    private String countryName; //A string that holds the name of the country that vaccine was manufactured.
    private int numberOfVaccines; //An integer that holds the number of vaccines produced.
    private MyStack stock;
    private Scanner scan = new Scanner(System.in);

    public VaccineStock() {
       stock = new MyStack();
    }
   
    
    public void popItem(){
        System.out.println(stock.pop().toString());;
    }
    
    public void pushItem(){
        VaccineStock vs = new VaccineStock();
        vs.setCountryName(countryName);
        vs.setNumberOfVaccines(numberOfVaccines);
        vs.setSerialNumber(serialNumber);
        stock.push(vs);
    }
    public int action(){
        int cmd = 0;
        System.out.println("Enter COMMAND?");
        String command = scan.nextLine();
        if (command.equalsIgnoreCase("add")) {
            cmd = 0;
        }
        else if(command.equalsIgnoreCase("delete")){
            cmd = 1;
        }
        else if (command.equalsIgnoreCase("exit")) {
            cmd = 2;
        }
        else{
            System.out.println("WRONG COMMAND. YOU MUST TYPE ADD OR DELETE AT THIS POINT");
            cmd = 99;
        }
        
        return cmd;
    }
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getNumberOfVaccines() {
        return numberOfVaccines;
    }

    public void setNumberOfVaccines(int numberOfVaccines) {
        this.numberOfVaccines = numberOfVaccines;
    }

    @Override
    public String toString() {
        return serialNumber + ", " + countryName.toUpperCase() + ", " + numberOfVaccines;
    }

    public MyStack getStock() {
        return stock;
    }
    
    
}
