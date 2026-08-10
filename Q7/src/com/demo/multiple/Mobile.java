package com.demo.multiple;

public class Mobile implements Camera, Music {

    public void click() {
        System.out.println("Photo clicked");
    }

    public void play() {
        System.out.println("Music playing");
    }
}
