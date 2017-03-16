package com.app.mainPackage.Classes;

import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.app.mainPackage.Exceptions.OutOfBordersException;

import java.lang.reflect.Array;

/**
 * Created by alegerd on 08.03.17.
 */
public class Test {
    public static void main(String[] args) {
        Integer a = 0;
        String b = "";
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(a.getClass());
        ArrayQueue<String> queue1 = new ArrayQueue<String>(b.getClass());

        ArrayStack<Integer> stack = new ArrayStack<Integer>(a.getClass());
        ArrayStack<String> stack1 = new ArrayStack<String>(b.getClass());

        LinkedQueue<Integer> queue2 = new LinkedQueue<Integer>();
        LinkedQueue<String> queue3 = new LinkedQueue<String>();

        LinkedStack<Integer> stack2 = new LinkedStack<Integer>();
        LinkedStack<String> stack3 = new LinkedStack<String>();
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);

            queue1.enqueue("A");
            queue1.enqueue("B");
            queue1.enqueue("C");
            queue1.enqueue("D");

            queue2.enqueue(1);
            queue2.enqueue(2);
            queue2.enqueue(3);
            queue2.enqueue(4);

            queue3.enqueue("A");
            queue3.enqueue("B");
            queue3.enqueue("C");
            queue3.enqueue("D");
        } catch (NullObjectSendedException e) {

        }

        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);

            stack1.push("A");
            stack1.push("B");
            stack1.push("C");
            stack1.push("D");

            stack2.push(1);
            stack2.push(2);
            stack2.push(3);
            stack2.push(4);

            stack3.push("A");
            stack3.push("B");
            stack3.push("C");
            stack3.push("D");
        } catch (NullObjectSendedException e) {

        }
        while (!queue.isEmpty()) {
            Integer val = 0;
            try {
                val = queue.dequeue();
                System.out.println(val);
            }
            catch (OutOfBordersException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("-------------------------");

        while (!queue1.isEmpty()) {
            String val = "";
            try {
                val = queue1.dequeue();
                System.out.println(val);
            }
            catch (OutOfBordersException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("-------------------------");

        while (!queue2.isEmpty()) {
            Integer val = 0;
            try {
                val = queue2.dequeue();
                System.out.println(val);
            }
            catch (OutOfBordersException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("-------------------------");

        while (!queue3.isEmpty()) {
            String val = "";
            try {
                val = queue3.dequeue();
                System.out.println(val);
            }
            catch (OutOfBordersException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("-------------------------");

        while (!stack.isEmpty()) {
            Integer val = 0;
            try {
                val = stack.pop();
                System.out.println(val);
            }
            catch (OutOfBordersException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("-------------------------");

        while (!stack1.isEmpty()) {
            String val = "";
            try {
                val = stack1.pop();
                System.out.println(val);
            }
            catch (OutOfBordersException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("-------------------------");

        while (!stack2.isEmpty()) {
            Integer val = 0;
            try {
                val = stack2.pop();
                System.out.println(val);
            }
            catch (OutOfBordersException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("-------------------------");

        while (!stack3.isEmpty()) {
            String val = "";
            try {
                val = stack3.pop();
                System.out.println(val);
            }
            catch (OutOfBordersException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
