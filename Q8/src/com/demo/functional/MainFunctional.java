package com.demo.functional;

public class MainFunctional {
    public static void main(String[] args) {

        // Anonymous Class
        Calculator sub = new Calculator() {
            @Override
            public int operate(int a, int b) {
                return a - b;
            }
        };

        // Lambda Expression
        Calculator div = (a, b) -> a / b;

        System.out.println("Subtraction (Anonymous): " + sub.operate(20, 10));
        System.out.println("Division (Lambda): " + div.operate(20, 10));
    }
}
