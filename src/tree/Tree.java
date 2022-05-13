package tree;

public interface Tree<T, E> {
    T root();
    boolean isEmpty();

    E getElement(T position) throws IllegalArgumentException;
    int numChildren(T position) throws IllegalArgumentException;

    boolean isInternal(T position) throws IllegalArgumentException;
    boolean isExternal(T position) throws IllegalArgumentException;
    boolean isRoot(T position) throws IllegalArgumentException;
    boolean isValid(T position) throws IllegalArgumentException;
}