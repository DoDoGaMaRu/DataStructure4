package 과제2;

import tree.CircularQueue;
import java.util.NoSuchElementException;

public class Calculator {
    private CircularQueue<Token> postfix;
    private Stack<Position<Token>> opdStack;


    public Calculator() {
        postfix = new CircularQueue<Token>();
        opdStack = new Stack<Position<Token>>();
    }



    public void inputExpression(String expression) throws Exception {
        try {
            CircularQueue<Token> infix = new InfixCreator(expression).create();
            postfix = new PostfixConverter(infix).convert();
        }
        catch (NoSuchElementException e) {
            invalidExpressionErr();
        }
    }

    public double calculate() throws Exception{
        Stack<Token> tempOprStack = new Stack<Token>();
        opdStack.clear();
        Token token;

        while (!postfix.isEmpty()) {
            token = postfix.dequeue();

            if (token.isOperator()) {
                tempOprStack.push(token);
                opdStack.push(operation(token));
            }
            else {
                opdStack.push(new Position<Token>(token));
            }
        }

        LinkedBinaryTree<Token> tree = new LinkedBinaryTree<Token>(opdStack.pop());

        if (!opdStack.isEmpty()) {
            invalidExpressionErr();
        }

        printCalc(tree, tempOprStack);

        return (double)Math.round(tree.root().getData().getOperand() * 100) / 100;
    }

    public void printCalc(LinkedBinaryTree<Token> tree, Stack<Token> tempOprStack) {
        System.out.print("후위계산식은 : ");
        tree.postorder();
        System.out.println();

        System.out.print("전위계산식은 : ");
        tree.preorder();
        System.out.println();

        while (!tempOprStack.isEmpty()) {
            tempOprStack.pop().setPrintResult(true);
        }

        tree.printTree();
        System.out.println();
    }



    public Position<Token> operation(Token token) throws Exception {
        try {
            if (token.isUnaryOperator()) {
                Position<Token> opd = opdStack.pop();
                double answerOpd = unaryOperation(token.getOperator(), opd.getData().getOperand());

                token.setOperand(answerOpd);
                return new Position<Token>(token, opd, null);
            }
            else {
                Position<Token> opd2 = opdStack.pop();
                Position<Token> opd1 = opdStack.pop();
                double answerOpd = binaryOperation(token.getOperator(), opd1.getData().getOperand(), opd2.getData().getOperand());

                token.setOperand(answerOpd);
                return new Position<Token>(token, opd1, opd2);
            }
        }
        catch (NoSuchElementException e) {
            invalidExpressionErr();
            return null;
        }
    }



    public double unaryOperation(char operator, double opd) throws Exception {
        switch (operator) {
            case 'm':
                return -opd;

            case '@':
                return Math.abs(opd);

            default:
                invalidExpressionErr();
                return 0;
        }
    }

    public double binaryOperation(char operator, double opd1, double opd2) throws Exception {
        switch (operator) {
            case '+':
                return opd1 + opd2;

            case '-':
                return opd1 - opd2;

            case '*':
                return opd1 * opd2;

            case '/':
                if (opd2 == 0) {
                    divideByZeroErr();
                }
                else {
                    return opd1 / opd2;
                }

            case '^':
                return Math.pow(opd1, opd2);

            default :
                invalidExpressionErr();
                return 0;
        }
    }



    public void invalidExpressionErr() throws Exception {
        throw new Exception("[오류] 이해할 수 없는 수식입니다.");
    }

    public void divideByZeroErr() throws Exception {
        throw new Exception("[오류] 나누는 수가 0이 될 수 없습니다.");
    }
}