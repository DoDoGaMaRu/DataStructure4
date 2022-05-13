package tree;

public interface BinaryTree<T, E> {
    T left(T position) throws IllegalArgumentException;
    T right(T position) throws IllegalArgumentException;
    boolean hasLeft(T position) throws IllegalArgumentException;
    boolean hasRight(T position) throws IllegalArgumentException;
}