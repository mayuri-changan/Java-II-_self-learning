package com.demo.hierarchical;

public class MainHierarchical {
    public static void main(String[] args) {
        Circle c = new Circle();
        Rectangle r = new Rectangle();

        c.draw();
        c.area();

        r.draw();
        r.area();
    }
}
