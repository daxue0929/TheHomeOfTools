package org.daxue.mail.day1;

import lombok.extern.slf4j.Slf4j;
import org.daxue.App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Slf4j
public class Test {

    @org.junit.Test
    public void test1() {

        ArrayList<Apple> inventory = new ArrayList<>();
        Apple a = new Apple(); a.setWeight(12);
        Apple b = new Apple(); b.setWeight(15);
        Apple c = new Apple(); c.setWeight(2);

        inventory.add(b);
        inventory.add(a);
        inventory.add(c);

//        Collections.sort(inventory, new Comparator<Apple>() {
//            public int compare(Apple a1, Apple a2){
//                return a1.getWeight() - a2.getWeight();
//            }
//        });

        inventory.sort(Comparator.comparing(Apple::getWeight));

        log.info("Test Apple sort {}", inventory);



    }
    class Apple implements Comparator{
        public int weight;

        public int getWeight() {
            return weight;
        }

        public void setWeight(final int weight) {
            this.weight = weight;
        }


        @Override
        public int compare(final Object o1, final Object o2) {
            return ((Apple) o1).getWeight() - ((Apple) o2).getWeight();
        }
    }
}
