package 과제1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("입력 : ");
        int num = Integer.parseInt(br.readLine());

        String[] tree = new String[num + 1];
        for (int i = 1; i < num+1; i++) {
            tree[i] = convert26(i-1);
        }

        print(tree, 1, new Stack<String>(), true);
    }




    public static String convert26(int num) {
        StringBuilder sb = new StringBuilder();

        while (num != -1) {
            sb.append((char)(num % 26 + 'A'));
            num = num / 26 - 1;
        }

        return sb.reverse().toString();
    }




    public static void print(String[] tree, int index, Stack<String> st, boolean ab) {
        StringBuilder x = new StringBuilder();

        if (ab) {
            System.out.print(st.toString(""));
        }
        System.out.print("+--" + tree[index]);


        if (index * 2 < tree.length) {
            x.append('|');
            for (int i = 0; i < tree[index].length() + 2; i++) {
                x.append(' ');
            }

            st.push(x.toString());

            print(tree, index * 2, st, false);
            System.out.println();
        }

        if (index * 2 + 1 < tree.length) {
            st.pop();
            print(tree, index * 2 + 1, st, true);
        }
    }
}