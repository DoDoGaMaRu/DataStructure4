package 과제1;

import tree.AbstractBinaryTree;
import java.util.NoSuchElementException;

public class CompleteBinaryTree<E> extends AbstractBinaryTree<Integer, E> {
    private E[] treeArr;
    private int size;


    public CompleteBinaryTree () {
        treeArr = (E[])new Object[4];
        size = 0;
    }



    public void insert(E element) {
        if (size + 1 == treeArr.length) {
            resize(treeArr.length * 2);
        }
        treeArr[++size] = element;
    }

    public void resize(int newSize) {
        E[] newTreeArr = (E[])new Object[newSize];

        for (int i = 1; i <= size; i++) {
            newTreeArr[i] = treeArr[i];
        }
        treeArr = newTreeArr;
    }



    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer left(Integer elementIdx) {
        if (!isValid(elementIdx)) {
            throw new IllegalArgumentException();
        }
        return elementIdx * 2;
    }

    @Override
    public Integer right(Integer elementIdx) {
        if (!isValid(elementIdx)) {
            throw new IllegalArgumentException();
        }
        return elementIdx * 2 + 1;
    }

    @Override
    public boolean hasLeft(Integer elementIdx) {
        if (!isValid(elementIdx)) {
            throw new IllegalArgumentException();
        }
        return elementIdx * 2 <= size;
    }

    @Override
    public boolean hasRight(Integer elementIdx) {
        if (!isValid(elementIdx)) {
            throw new IllegalArgumentException();
        }
        return elementIdx * 2 + 1 <= size;
    }

    @Override
    public Integer root() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return 1;
    }



    @Override
    public boolean isValid(Integer elementIdx) {
        return elementIdx <= size;
    }

    @Override
    public E getElement(Integer p) {
        if (p > size) {
            throw new NoSuchElementException();
        }
        return treeArr[p];
    }
}
