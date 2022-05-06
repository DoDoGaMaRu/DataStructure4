package treeModels;

public class Node<E> {
    private E data;
    private Node leftChild;
    private Node rightChild;
    private int height;


    public Node(E data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        resetHeight();
    }



    public E getData() {
        return data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public int getHeight() {
        return height;
    }



    public void setData(E data) {
        this.data = data;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void resetHeight() {
        int leftHeight = 0;
        int rightHeight = 0;

        if (leftChild != null) {
            leftHeight = leftChild.height;
        }
        if (rightChild != null) {
            rightHeight = rightChild.height;
        }

        height = (leftHeight > rightHeight) ? leftHeight : rightHeight;
        height += 1;
    }
}