package com.demo.hybrid;

public class AllInOne extends Printer implements Scanner, Fax {

    public void scan() {
        System.out.println("Scanning...");
    }

    public void fax() {
        System.out.println("Faxing...");
    }
}
