package 과제2;

import tree.AbstractBinaryTree;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<Position<E>, E> {
    private Position<E> root;


    public LinkedBinaryTree() {}

    public LinkedBinaryTree(Position root) {
        this.root = root;
    }



    public void setRoot(Position<E> root) {
        this.root = root;
    }

    @Override
    public Position left(Position<E> position) throws IllegalArgumentException {
        return position.getLeftChild();
    }

    @Override
    public Position right(Position<E> position) throws IllegalArgumentException {
        return position.getRightChild();
    }

    @Override
    public boolean hasLeft(Position<E> position) throws IllegalArgumentException {
        return position.getLeftChild() != null;
    }

    @Override
    public boolean hasRight(Position<E> position) throws IllegalArgumentException {
        return position.getRightChild() != null;
    }

    @Override
    public Position<E> root() {
        return root;
    }


    @Override
    public E getElement(Position<E> position) throws IllegalArgumentException {
        return (E)position.getData();
    }

    @Override
    public boolean isValid(Position<E> position) throws IllegalArgumentException {
        return position != null;
    }
}
