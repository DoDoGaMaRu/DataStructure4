package 과제1;

import java.util.NoSuchElementException;

public class Stack<E> {
    private LinkedList<E> list;


    public Stack() {
        list = new LinkedList<E>();
    }




    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }




    public void push(E data) {
        list.addFirst(data);
    }

    public E pop() {
        E Data = peek();
        list.removeFirst();

        return Data;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            return list.getHead().getData();
        }
    }




    public String toString() {
        return toString(" ");
    }

    public String toString(String delimiter) {
        return list.toString(delimiter);
    }
}