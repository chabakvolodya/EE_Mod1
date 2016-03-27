package com.goit.ee.module1.testers;

import com.goit.ee.module1.api.Collector;
import com.goit.ee.module1.collectors.CollectionCollector;
import com.goit.ee.module1.tests.list.*;
import com.goit.ee.module1.tests.set.TestSetAdd;
import com.goit.ee.module1.tests.set.TestSetContains;
import com.goit.ee.module1.tests.set.TestSetPopulate;
import com.goit.ee.module1.tests.set.TestSetRemove;

import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TesterSet {

    private Collector<String, Long> collector;
    private Set<Integer> collection;
    private int iterations;

    public TesterSet(String name, Set<Integer> collection, int iterations) {
        this.collector = new CollectionCollector(name);
        this.collection = collection;
        this.iterations = iterations;
        tests();
    }

    private void tests() {
        collector.collect("Add", new TestSetAdd(collection, iterations).run());
        collector.collect("Remove", new TestSetRemove(collection, iterations).run());
        collector.collect("Contains", new TestSetContains(collection, iterations).run());
        collector.collect("Populate", new TestSetPopulate(collection, iterations).run());
    }

    public Collector<String, Long> getCollector() {
        return collector;
    }

}
