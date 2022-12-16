package org.example.myQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackClass<T> implements MyStack<T> {
    ArrayList<T> stackList = new ArrayList<>();

    public StackClass() {
    }

    @Override
    public String toString() {
        return stackList.toString();
    }

    @Override
    public boolean empty() {
        return this.stackList.size() == 0;
    }

    @Override
    public T peek() throws Exception {
        if (!empty()) {
            return this.stackList.get(this.stackList.size() - 1);
        } else throw new EmptyStackException();
    }

    @Override
    public T pop() throws Exception {
        if (!empty()) {
            return this.stackList.remove(this.stackList.size() - 1);
        } else throw new EmptyStackException();
    }

    @Override
    public T push(T value) {
        this.stackList.add(value);
        return value;
    }

    @Override
    public int search(T element) {
        for (int i = 0; i < this.stackList.size(); i++) {
            if (this.stackList.get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }
}
