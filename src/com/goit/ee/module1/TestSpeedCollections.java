package com.goit.ee.module1;

import com.goit.ee.module1.api.Collector;
import com.goit.ee.module1.collectors.CollectionCollector;
import com.goit.ee.module1.providers.list.ProviderArrayList;
import com.goit.ee.module1.providers.list.ProviderLinkedList;
import com.goit.ee.module1.providers.set.ProviderHashSet;
import com.goit.ee.module1.providers.set.ProviderTreeSet;
import com.goit.ee.module1.testers.TesterList;
import com.goit.ee.module1.testers.TesterSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Администратор on 26.03.2016.
 */
public class TestSpeedCollections {

    private int[] sizes;
    private int iterations;
    private List<Collector> collectors = new ArrayList<>();

    public TestSpeedCollections(int iterations, int... sizes) {
        this.sizes = sizes;
        this.iterations = iterations;
    }

    public void run() {

        for (int size : sizes) {
            test(size);
            CollectorUtils.print(collectors, size);
            collectors.clear();
        }
    }

    private void test(int size) {
        for (int i = 0; i < 4; i++) {

            switch (i) {
                case 0:
                    List<Integer> arrayList = new ProviderArrayList().get(size);
                    collectors.add(new TesterList("ArrayList", arrayList, iterations).getCollector());
                    break;

                case 1:
                    List<Integer> linkedList = new ProviderLinkedList().get(size);
                    collectors.add(new TesterList("LinkedList", linkedList, iterations).getCollector());
                    break;

                case 2:
                    Set<Integer> treeSet = new ProviderTreeSet().get(size);
                    collectors.add(new TesterSet("TreeSet", treeSet, iterations).getCollector());
                    break;

                case 3:
                    Set<Integer> hashSet = new ProviderHashSet().get(size);
                    collectors.add(new TesterSet("HashSet", hashSet, iterations).getCollector());
                    break;
            }
        }
    }

//    private void printCollectors(int size) {
//
//        System.out.printf("+------------------------------------------------[%10d ]-----------------------------------------------------+\n", size);
//        for (Collector c : collectors) {
//            System.out.printf("| %15 ", c.getNameCollector());
//            System.out.printf("| %d");
//        }
////        System.out.println(c.getNameCollector());
//
//        System.out.printf("+------------------------------------------------------------------------------------------------------------------+\n", size);
//
//
//
//    }
}
