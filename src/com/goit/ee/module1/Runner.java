package com.goit.ee.module1;

/**
 * Created by Администратор on 26.03.2016.
 */
public class Runner {
    public static void main(String[] args) {

        new TestSpeedCollections(100, 10_000, 100_000, 1_000_000).run();

    }
}
