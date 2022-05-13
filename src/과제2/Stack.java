package 과제2;

import java.util.NoSuchElementException;

public class Stack<E> {
    private E[] arr;
    private int rear;


    public Stack() {
        arr = (E[])new Object[4];
        rear = 0;
    }



    public boolean isEmpty() {
        return rear == 0;
    }

    public void push(E data) {
        if (rear >= arr.length) {
            resize(arr.length * 2);
        }

        arr[rear++] = data;
    }

    public E pop() {
        E Data = peek();

        if (--rear <= arr.length / 4 && arr.length > 4) {
            resize(arr.length / 2);
        }

        return Data;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            return arr[rear - 1];
        }
    }



    public void clear() {
        rear = 0;
    }

    public void resize(int newSize) {
        E[] newArr = (E[])new Object[newSize];

        for (int i = 0; i < rear; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < rear; i++) {
            sb.append(arr[i].toString());
            sb.append(' ');
        }

        return sb.toString();
    }
}