package org.example;

import org.example.myQueue.PriorityQueueClass;
import org.example.myQueue.QueueClass;
import org.example.myQueue.StackClass;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Танец на костылях, но зато самостоятельно)
        QueueClass<String> myQueue = new QueueClass<>();
        StackClass<Integer> myStack = new StackClass<>();
        Queue<Integer> qwe = new PriorityQueue<>();
        PriorityQueueClass<Integer> prior = new PriorityQueueClass<>();
//        System.out.println(prior.isEmpty());
//        System.out.println(prior);
//        System.out.println(prior.size());
        prior.add(5);
        prior.add(4);
        prior.add(3);
        prior.add(2);
        prior.add(1);
        System.out.println(prior);
        System.out.println(Arrays.toString(prior.toArray()));
//        System.out.println(prior.contains(6));
//        System.out.println(prior.isEmpty());
//        System.out.println(prior.iterator());
//        prior.offer(1);
//        System.out.println(prior.peek());
//        System.out.println(prior.poll());
//        System.out.println(prior.remove(4));
//        prior.clear();
//        prior.add(6);
//        prior.add(8);
//        prior.add(2);
//        prior.offer(2);
////        prior.offer(2);
////        prior.offer(2);
//        System.out.println(prior);
//        prior.remove(2);
//        System.out.println(prior);
    }
}