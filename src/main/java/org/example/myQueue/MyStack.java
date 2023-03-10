package org.example.myQueue;
/*
Modifier and Type	Method and Description
boolean	            empty()
                    Tests if this stack is empty.

E	                peek()
                    Looks at the object at the top of this stack without removing it from the stack.

E	                pop()
                    Removes the object at the top of this stack and returns that object as the value of this function.

E	                push(E item)
                    Pushes an item onto the top of this stack.

int	                search(Object o)
                    Returns the 1-based position where an object is on this stack.
 */

public interface MyStack<T> {
    boolean empty();
    T peek() throws Exception;
    T pop() throws Exception;
    T push(T value);
    int search(T element);
}
