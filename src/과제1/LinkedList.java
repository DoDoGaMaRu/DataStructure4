package 과제1;

public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
        head = null;
        tail = null;
    }


    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return head == null;
    }




    public void addFirst(E data) {
        head = new Node<E>(data, head);

        if (head.getNext() == null) {
            tail = head;
        }
    }

    public void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        }
        else {
            addNext(tail, data);
        }
    }

    public void addNext(Node<E> temp, E data) {
        Node<E> newNode = new Node<E>(data, temp.getNext());
        temp.setNext(newNode);

        if (temp == tail) {
            tail = newNode;
        }
    }




    public void removeNext(Node<E> target) {
        if (target != tail) {
            if (target.getNext() == tail) {
                tail = target;
            }
            Node<E> temp = target.getNext();
            target.setNext(temp.getNext());
        }
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (head == tail) {
                tail = null;
            }
            head = head.getNext();
        }
    }

    public void removeLast() {
        Node<E> temp = head;

        if (temp == tail) {
            removeFirst();
            tail = null;
        }
        else {
            while (temp.getNext() != tail) {
                temp = temp.getNext();
            }
            removeNext(temp);
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }




    public String toString() {
        return toString(" ");
    }

    public String toString(String delimiter) {
        StringBuilder str = new StringBuilder();
        Node<E> temp = head;

        while (temp != null) {
            str.append(temp.toString() + delimiter);
            temp = temp.getNext();
        }

        return str.toString();
    }
}
