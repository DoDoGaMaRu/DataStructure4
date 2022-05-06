package treeModels;

public interface BinaryTree<E> {
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    // Position<E> sibling(Position<E> p) throws IllegalArgumentException; // 형제노드 리턴인데 부모를 알아야함으로 추천하지 않는 방법이라고 생각함
}