package com.demo.multilevel;

public class MainMultilevel {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // from Animal
        d.walk();  // from Pet
        d.bark();  // from Dog
    }
}
