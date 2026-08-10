package com.demo.functional;

public class LambdaDemo {
    public static void main(String[] args) {

        Calculator multiply = (a, b) -> a * b;

        System.out.println("Multiplication (Lambda): " + multiply.operate(10, 5));
    }
}
