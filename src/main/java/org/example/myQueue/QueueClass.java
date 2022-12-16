package org.example.myQueue;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
public class QueueClass<T> implements MyQueue<T> {
    List<T> queueList = new ArrayList<>();
    public QueueClass() {
    }

    @Override
    public String toString() {
        return queueList.toString();
    }

    @Override
    public void add(T value) {
        this.queueList.add(value);
    }

    public T element() throws Exception {
        if (!isEmpty()) {
            return this.queueList.get(0);
        } else throw new Exception("The queue is empty");
    }

    public T peek() {
        if (!isEmpty()) {
            return this.queueList.get(0);
        } else return null;
    }

    @Override
    public T remove() throws Exception {
        if (!isEmpty()) {
            return this.queueList.remove(0);
        } else throw new Exception("The queue is empty");
    }

    public T poll() throws Exception {
        if (!isEmpty()) {
            return this.queueList.remove(0);
        } else return null;
    }

    @Override
    public boolean isEmpty() {
        return this.queueList.size() == 0;
    }
}
