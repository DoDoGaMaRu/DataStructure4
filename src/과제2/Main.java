package 과제2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        run(calc, sc);
    }



    public static void run(Calculator calc, Scanner sc) {
        String expression = getExpression(sc);

        while (!expression.equals("quit")) {
            calculate(calc, expression);
            System.out.println();

            expression = getExpression(sc);
        }

        System.out.println("***종료합니다***");
    }

    public static String getExpression(Scanner sc) {
        System.out.print("식을 입력하세요(종료는 quit) : ");
        return sc.nextLine();
    }

    public static void calculate(Calculator calc, String expression) {
        try {
            calc.inputExpression(expression);
            System.out.println("결과는 : " + calc.calculate());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}