/*8. Implemention of functional Interface with anonymous class and lamda
expression*/

package com.demo.functional;

public class AnonymousDemo {
    public static void main(String[] args) {

        Calculator add = new Calculator() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        System.out.println("Addition (Anonymous Class): " + add.operate(10, 5));
    }
}
