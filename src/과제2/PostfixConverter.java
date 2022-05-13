package 과제2;

import tree.CircularQueue;

public class PostfixConverter {
    private CircularQueue<Token> infix;
    private CircularQueue<Token> postfix;
    private Stack<Token> oprStack;


    public PostfixConverter(CircularQueue<Token> infix) {
        this.infix = infix;
        postfix = new CircularQueue<Token>();
        oprStack = new Stack<Token>();
    }




    public CircularQueue<Token> convert() throws Exception {
        while (!infix.isEmpty()) {
            if (infix.peek().isOperator()) {
                addOperator(infix.dequeue());
            }
            else {
                postfix.enqueue(infix.dequeue());
            }
        }
        while (!oprStack.isEmpty()) {
            postfix.enqueue(oprStack.pop());
        }

        return postfix;
    }



    private void addOperator(Token operator) throws Exception {
        if (oprStack.isEmpty()) {
            oprStack.push(operator);
        }
        else {
            while (oprStack.peek().getIsp() >= operator.getIcp()) {
                postfix.enqueue(oprStack.pop());

                if (oprStack.isEmpty()) {
                    break;
                }
            }
            if (operator.getOperator() == ')') {
                oprStack.pop();
            }
            else {
                oprStack.push(operator);
            }
        }
    }
}