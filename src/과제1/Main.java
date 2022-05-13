package 과제1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("노드 개수를 입력하시오 : ");
        int size = sc.nextInt();

        CompleteBinaryTree<String> tree = makeTree(size);
        print(tree);
    }



    public static CompleteBinaryTree makeTree(int size) {
        CompleteBinaryTree<String> tree = new CompleteBinaryTree<>();
        for (int i = 0; i < size; i++) {
            tree.insert(convert26(i));
        }

        return tree;
    }

    public static String convert26(int num) {
        StringBuilder sb = new StringBuilder();

        while (num != -1) {
            sb.append((char)(num % 26 + 'A'));
            num = num / 26 - 1;
        }

        return sb.reverse().toString();
    }



    public static void print(CompleteBinaryTree<String> tree) {
        System.out.print("\n<트리 출력>\n");
        tree.printTree();

        System.out.print("\n전위 순회 : ");
        tree.preorder();
        System.out.print("\n중위 순회 : ");
        tree.inorder();
        System.out.print("\n후위 순회 : ");
        tree.postorder();
        System.out.print("\n레벨 순회 : ");
        tree.levelOrder();
    }
}