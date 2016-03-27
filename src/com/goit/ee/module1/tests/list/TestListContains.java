package com.goit.ee.module1.tests.list;

import com.goit.ee.module1.tests.TestTemplate;

import java.util.List;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TestListContains extends TestTemplate<List<Integer>> {
    public TestListContains(List<Integer> collection, int iterations) {
        super(collection, iterations);
    }

    @Override
    protected void body(int iteration) {
        int value = (int)Math.round(Math.random() * collection.size());
        collection.contains(value);
    }
}
