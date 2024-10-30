package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {


    static class Range {

        private int min;
        private int max;
        
        Range(final int min, final int max){
            this.min = min;
            this.max = max;
        }

        public List<Integer> listRange(){
            List<Integer> aList = new ArrayList<>();
            for(int i = min; i <= max; i++){
                aList.add(i);
            }
            return aList;
        }
        
    }

    /**
     * InnerUseListsAndMaps
     */

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        var r = new Range(1000, 2000);
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         *
         */

        List<Integer> aList = new ArrayList<Integer>(r.listRange());

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        List<Integer> lList = new LinkedList<Integer>(r.listRange());
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int temp = aList.getFirst();
        aList.set(0,aList.get(aList.size()-1));
        aList.set(aList.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for (Integer integer : aList) {
            System.out.println(integer);
        }  
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();

        for (int i = 0; i < 100.000; i++) {
            aList.addFirst(1);
        }

        System.out.println("The function fun1 with arrayList implementation fineshes in " + (System.nanoTime() - time) + "ms");
        
        time = System.nanoTime();

        for (int i = 0; i < 100.000; i++) {
            lList.addFirst(1);
        }

        System.out.println("The function fun1 with linked list implementation fineshes in " + (System.nanoTime() - time) + "ms");   

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        time = System.nanoTime();

        for (int i = 0; i < 100.000; i++) {
            aList.get(aList.size()/2);
        }

        System.out.println("The function fun2 with arrayList implementation fineshes in " + (System.nanoTime() - time) + "ms");
        
        time = System.nanoTime();

        for (int i = 0; i < 100.000; i++) {
            lList.get(aList.size()/2);
        }

        System.out.println("The function fun2 with linked list implementation fineshes in " + (System.nanoTime() - time) + "ms\n\n");   
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */

        Map<String, Long> population = new HashMap<String, Long>();
        population.put("Africa", 1_110_635_000L);
        population.put("Americas", 972_005_000L);
        population.put("Antarctica", 0L);
        population.put("Asia", 4_298_723_000L);
        population.put("Europe", 742_452_000L);
        population.put("Oceania", 38_304_000L);

        long total=0;

        for (Map.Entry<String, Long> entry : population.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
            total += entry.getValue();
        }
        System.out.println("-------------\nTotal: " + total);
    }
}