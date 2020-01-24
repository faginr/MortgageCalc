package com.webdevrex;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//      Add constants for months in years = 12
//      Add constant for percent = 100

//      Get Principal from user
        Scanner principalScan = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = principalScan.nextInt();

//      Get Interest Rate from user and convert to months
        Scanner rateScan = new Scanner(System.in);
        System.out.print("Annual Interest Rate: ");
        float rate = rateScan.nextFloat();
        float monthRate = (rate / 100) / 12;

//      Get Period from user and convert to months
        Scanner periodScan = new Scanner(System.in);
        System.out.print("Period (Years): ");
        byte period = periodScan.nextByte();
        int monthPeriod = period * 12;

//      Create numerator and denominator
        double numerator = monthRate * (double)Math.pow((1 + monthRate), monthPeriod);
        double denominator = (double)Math.pow((1 + monthRate), monthPeriod) - 1;

//      Calculate raw result
        double result = (double)principal * (numerator / denominator);

//      Convert to Currency and print final output
//      Look at refactoring this to make it more concise
        NumberFormat money = NumberFormat.getCurrencyInstance();
        String total = money.format(result);
        System.out.println("Mortgage: " + total);

    }
}
