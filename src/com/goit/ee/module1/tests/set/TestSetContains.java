package com.goit.ee.module1.tests.set;

import com.goit.ee.module1.tests.TestTemplate;

import java.util.Set;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TestSetContains extends TestTemplate<Set<Integer>> {
    public TestSetContains(Set<Integer> collection, int iterations) {
        super(collection, iterations);
    }

    @Override
    protected void body(int iteration) {
        int value = (int)Math.round(Math.random() * collection.size());
        collection.contains(value);
    }
}
