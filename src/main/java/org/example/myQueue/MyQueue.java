package org.example.myQueue;

public interface MyQueue <T> {
    void add(T value);
    T remove() throws Exception;
    boolean isEmpty();
}
