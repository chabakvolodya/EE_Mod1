package com.goit.ee.module1;

import com.goit.ee.module1.api.Collector;

import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 26.03.2016.
 */
public class CollectorUtils {

    private static Map<String, Long> map;

    static void print(List<Collector> collectors, int size) {

        System.out.printf("+----------------------------------------------------[%10d ]---------------------------------------------------------+\n", size);

        System.out.printf("|     [ %4s ]         [ %3s ]        [ %3s ]      [ %6s ]    [ %8s]   [ %8s]      [ %8s]   [ %8s]  |\n", "Name", "Add", "Get", "Remove", "Contains", "Populate", "Iter.Add", "Iter.Rem");

        System.out.printf("+--------------------------------------------------------------------------------------------------------------------------+\n");


        for (Collector c : collectors) {

            map = c.getResults();

            System.out.printf("| %-15s ", c.getNameCollector());
            System.out.printf("| %12.2f ", getValue("Add"));
            System.out.printf("| %12.2f ", getValue("Get"));
            System.out.printf("| %12.2f ", getValue("Remove"));
            System.out.printf("| %12.2f ", getValue("Contains"));
            System.out.printf("| %12.2f ", getValue("Populate"));
            System.out.printf("| %12.2f ", getValue("Iter.Add"));
            System.out.printf("| %12.2f |\n", getValue("Iter.Rem"));
        }

        System.out.printf("+--------------------------------------------------------------------------------------------------------------------------+\n\n", size);

    }

    static double getValue(String str) {
        double result = 0;

        if (map.containsKey(str)) {
            return convertNSToMs(map.get(str));
        } else {
            return -1;
        }
    }

    static double convertNSToMs(Long input) {

        return Math.round(input / 1_000_000) ;
    }

}
