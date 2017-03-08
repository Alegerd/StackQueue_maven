package com.app.mainPackage.Classes;

import com.app.mainPackage.Exceptions.OutOfBordersException;

/**
 * Created by alegerd on 08.03.17.
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue<String, Integer> queue = new PriorityQueue<String, Integer>();
        queue.enqueue("A", 1);
        queue.enqueue("C", 3);
        queue.enqueue("D", 4);
        queue.enqueue("B", 2);


        while (!queue.isEmpty()) {
            String val = "";
            try {
                val = queue.dequeue();
            }
            catch (OutOfBordersException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(val);
        }
    }
}
