package 과제3;

import 과제2.LinkedBinaryTree;
import 과제2.Position;

public class BinarySearchTree<E extends Comparable<E>> extends LinkedBinaryTree<E> {
    public void insert(E element) {
        Position<E> newP = new Position<>(element, null, null);

        if (isEmpty()) {
            setRoot(newP);
        }
        else {
            insert(root(), newP);
        }
    }

    public void insert(Position<E> crntP, Position<E> newP) {
        if (newP.getData().compareTo(crntP.getData()) < 0) {
            if (hasLeft(crntP)) {
                insert(crntP.getLeftChild(), newP);
            }
            else {
                crntP.setLeftChild(newP);
            }
        }
        else if (newP.getData().compareTo(crntP.getData()) > 0) {
            if (hasRight(crntP)){
                insert(crntP.getRightChild(), newP);
            }
            else {
                crntP.setRightChild(newP);
            }
        }
    }



    public Position<E> search(E target) {
        return search(root(), target);
    }

    public Position<E> search(Position<E> position, E target) {
        Position<E> answer = null;

        if (isValid(position)) {
            if (target.compareTo(position.getData()) == 0) {
                answer = position;
            }
            else if (target.compareTo(position.getData()) > 0) {
                answer = search(position.getRightChild(), target);
            }
            else {
                answer = search(position.getLeftChild(), target);
            }
        }

        return answer;
    }
}