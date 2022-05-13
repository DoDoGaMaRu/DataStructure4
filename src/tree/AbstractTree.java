package tree;

public abstract class AbstractTree<T, E> implements Tree<T, E>{
    public boolean isInternal(T position) {
        return numChildren(position) > 0;
    }

    public boolean isExternal(T position) {
        return numChildren(position) == 0;
    }

    public boolean isRoot(T position) {
        return position == root();
    }

    public boolean isEmpty() {
        return root() == null;
    }
}