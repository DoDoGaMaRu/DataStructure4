package 과제3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = getInput(sc);

        while (!input.equals("quit")) {
            BinarySearchTree<String> bst = new BinarySearchTree<String>();
            String[] strArr = input.split(" ");

            for(String a : strArr) {
                bst.insert(a);
            }

            bst.printTree();
            System.out.println();

            input = getInput(sc);
        }
    }

    public static String getInput(Scanner sc) {
        System.out.print("문자열들을 입력하세요 (마지막은 quit) : ");
        return sc.nextLine();
    }
}