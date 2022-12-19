package org.example.myQueue;

import java.util.*;

public class PriorityQueueClass<T extends Comparable> implements MyPriorityQueue {

    private Object[] queue;
    private final int size = 10;
    private Comparator<T> comparator;

    private void sort() {
        Object[] list = new Object[size()];
        int i = 0;
        while (i < this.queue.length && this.queue[i] != null) {
            list[i] = this.queue[i];
            i++;
        }
        if (comparator == null) {
            Arrays.sort(list);
        } else {
            ArrayList<T> arr = new ArrayList<>();
            for (Object elQueue :
                    list) {
                arr.add((T) elQueue);
            }
            Collections.sort(arr, comparator);
        }
        setQueue(list);
    }

    @Override
    public void add(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (size() == this.queue.length - 1) {
            grow();
        }
        this.queue[size()] = element;
        sort();
    }

    public PriorityQueueClass() {
        this.queue = new Object[size];
    }

    public PriorityQueueClass(Comparator<T> comparator) {
        this.comparator = comparator;
        this.queue = new Object[size];
    }

    public PriorityQueueClass(int initialCopacity) throws Exception {
        if (initialCopacity < 1) {
            throw new Exception("Size can't be 0 or less");
        }
        this.queue = new Object[initialCopacity];
    }

    public PriorityQueueClass(int initialCopacity, Comparator<T> comparator) throws Exception {
        if (initialCopacity < 1) {
            throw new Exception("Size can't be 0 or less");
        }
        this.comparator = comparator;
        this.queue = new Object[initialCopacity];
    }

    private void setQueue(Object[] queue) {
        System.arraycopy(queue, 0, this.queue, 0, queue.length);
    }

    private void grow() {
        this.queue = Arrays.copyOf(this.queue, this.queue.length + 10);
    }

    public boolean isEmpty() {
        return this.queue[0] == null && this.queue.length > 0;
    }

    @Override
    public void clear() {
        this.queue = new Object[10];
    }

    @Override
    public Comparator<T> comparator() {
        return this.comparator;
    }

    @Override
    public boolean contains(Object element) {
        int i = 0;
        boolean result = false;
        while (i < this.queue.length && this.queue[i] != null) {
            if (this.queue[i].equals(element)) {
                result = true;
                break;
            }
            i++;
        }
        return result;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            int pointer = 0;

            @Override
            public boolean hasNext() {
                if (pointer < getQueue().length) {
                    if (getQueue()[pointer] != null) {
//                        pointer++;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Object next() {
                if (hasNext()) {
                    return getQueue()[pointer++];
                }
                return null;
            }
        };
    }

    private Object[] getQueue() {
        return queue;
    }

    @Override
    public boolean offer(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
        add(element);
        return true;
    }

    @Override
    public Object peek() {
        if (!isEmpty()) {
            return this.queue[0];
        }
        return null;
    }

    private Object[] copyArray() {
        Object[] newArray = new Object[this.queue.length - 1];
        int i = 0;
        while (i < queue.length && this.queue[i] != null) {
            newArray[i] = this.queue[i + 1];
            i++;
        }
        return newArray;
    }

    @Override
    public Object poll() {
        if (!isEmpty()) {
            Object tmp = this.queue[0];
            int i = 0;
            setQueue(copyArray());
            return tmp;
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        Object[] newArray = new Object[queue.length - 1];
        boolean found = false;
        for (int i = 0, j = 0; i < newArray.length && j < this.queue.length && this.queue[j] != null; i++, j++) {
            if (found || !this.queue[j].equals(element)) {
                newArray[i] = this.queue[j];
            } else if (!found) {
                newArray[i] = this.queue[++j];
                found = true;
            }
        }
        if (found) {
            setQueue(newArray);
            return true;
        } else return false;
    }

    @Override
    public int size() {
        if (this.queue.length == 0) {
            return 0;
        }
        int i = 0;
        while (this.queue[i] != null && i < this.queue.length) {
            i++;
        }
        return i;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.queue[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        if (this.queue.length == 0) return "[]";
        String str = "";
        str += ("[");
        int i = 0;
        while (i < this.queue.length && this.queue[i] != null) {
            if (str.length() > 1) {
                str += "," + this.queue[i];
            } else str += this.queue[i];
            i++;
        }
        str += "]";
        return str;
    }

}
