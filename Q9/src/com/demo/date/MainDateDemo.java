package com.demo.date;

import java.time.LocalDate;

public class MainDateDemo {
    public static void main(String[] args) {

        LocalDate date1 = DateManipulator.stringToDate("28-04-2026", "dd-MM-yyyy");
        LocalDate date2 = DateManipulator.stringToDate("05-05-2026", "dd-MM-yyyy");

        String formatted = DateManipulator.dateToString(date1, "yyyy/MM/dd");

        long days = DateManipulator.daysBetween(date1, date2);

        System.out.println("Converted Date1: " + date1);
        System.out.println("Formatted Date1: " + formatted);
        System.out.println("Days between: " + days);
    }
}
