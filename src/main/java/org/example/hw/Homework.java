package org.example.hw;

import org.example.hw.annotation.SomeEventFactory;

public class Homework {

    public static void main(String[] args) {

        SomeEvent se = SomeEventFactory.createObj(SomeEvent.class);
        System.out.println("se = " + se);
    }
}
