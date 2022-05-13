package tree;


public abstract class AbstractBinaryTree<T, E> extends AbstractTree<T, E> implements BinaryTree<T, E> {
    @Override
    public int numChildren(T position) {
        int count = 0;
        if (hasLeft(position)) {
            count++;
        }
        if (hasRight(position)) {
            count++;
        }
        return count;
    }



    public void preorder() {
        preorder(root());
    }
    public void preorder(T position) {
        if (isValid(position)) {
            System.out.print(getElement(position).toString() + ' ');
            preorder(left(position));
            preorder(right(position));
        }
    }

    public void inorder() {
        inorder(root());
    }
    public void inorder(T position) {
        if (isValid(position)) {
            inorder(left(position));
            System.out.print(getElement(position).toString() + ' ');
            inorder(right(position));
        }
    }

    public void postorder() {
        postorder(root());
    }
    public void postorder(T position) {
        if (isValid(position)) {
            postorder(left(position));
            postorder(right(position));
            System.out.print(getElement(position).toString() + ' ');
        }
    }

    public void levelOrder() {
        CircularQueue<T> queue = new CircularQueue<T>();
        T position;

        queue.enqueue(root());

        while (!queue.isEmpty()) {
            position = queue.dequeue();
            System.out.print(getElement(position).toString() + ' ');

            if (hasLeft(position)) {
                queue.enqueue(left(position));
            }
            if (hasRight(position)) {
                queue.enqueue(right(position));
            }
        }
    }



    public void printTree() {
        printTree(root(), "");
    }
    public void printTree(T position, String str) {
        if (isValid(position)) {
            String element = getElement(position).toString();

            System.out.print(element);

            if(isInternal(position)) {
                StringBuilder sb = new StringBuilder(str);
                for (int i = 0; i < element.length(); i++) {
                    sb.append(' ');
                }

                System.out.print(" ┬─ ");
                printTree(left(position), sb.toString() + " │  ");
                System.out.println();

                System.out.print(sb.toString() + " └─ ");
                printTree(right(position), sb.toString() + "    ");
            }
        }
        else {
            System.out.print('x');
        }
    }
}