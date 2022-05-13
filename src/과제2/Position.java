package 과제2;

public class Position<E> {
    private E data;
    private Position leftChild;
    private Position rightChild;


    public Position(E data, Position leftChild, Position rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Position(E data) {
        this(data, null, null);
    }


    public E getData() {
        return data;
    }

    public Position getLeftChild() {
        return leftChild;
    }

    public Position getRightChild() {
        return rightChild;
    }



    public void setData(E data) {
        this.data = data;
    }

    public void setLeftChild(Position leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Position rightChild) {
        this.rightChild = rightChild;
    }
}