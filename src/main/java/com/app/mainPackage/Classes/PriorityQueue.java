package com.app.mainPackage.Classes;

import com.app.mainPackage.Exceptions.NullObjectSendedException;
import com.app.mainPackage.Exceptions.OutOfBordersException;
import com.app.mainPackage.Interfaces.IPriorityQueue;

import java.util.ArrayList;
import java.util.List;

class Node<T,T2 extends Comparable> {
    T value;
    T2 priority;

    public Node(T value,T2 priority) {
        this.value = value;
        this.priority = priority;
    }
}

public class PriorityQueue<T, T2 extends Comparable> implements IPriorityQueue<T,T2>{

    List<Node> list = new ArrayList<Node>();

    public void enqueue(T value, T2 priority){
        Node node = new Node(value, priority);
        list.add(node);
        up(list.size() - 1);
    }

    public T dequeue() throws OutOfBordersException{
        if (list.size() == 0) {
            throw new OutOfBordersException("Queue is empty");
        }
        else {
            swap(0,list.size() - 1);
            T element = (T)list.get(list.size() - 1).value;
            list.remove(list.size() - 1);
            down(0);
            return element;
        }
    }

    public boolean isEmpty() {
        return (list.isEmpty());
    }

    int parent(int index) {
        return (index - 1)/2;
    }

    int leftChild(int index) {
        return (2 * index + 1);
    }

    int rightChild(int index) {
        return (2 * index + 2);
    }

    void up(int index) {
        while (index != 0 && compareListElements(index, parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    void down(int index) {
        while (index < list.size()/2) {
            int maxI = leftChild(index);
            if(rightChild(index) < list.size() && compareListElements(rightChild(index),leftChild(index)))
            {
                maxI = rightChild(index);
            }

            if(compareListElements(index, maxI)) {
                return;
            }

            swap(index, maxI);
            index = maxI;
        }
    }

    boolean compareListElements(int index1, int index2) {
        return list.get(index1).priority.compareTo(
                list.get(index2).priority) >= 0;
    }

    void swap(int index1, int index2) {
        Node node = list.get(index1);
        list.set(index1,list.get(index2));
        list.set(index2, node);
    }

}
