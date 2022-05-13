package 과제2;

import tree.CircularQueue;

public class InfixCreator {
    private String infixStr;
    private CircularQueue<Token> infix;
    private Double operand;
    private Token prevToken;


    public InfixCreator(String infixStr) {
        this.infixStr = infixStr;
        infix = new CircularQueue<Token>();
        operand = null;
    }




    public CircularQueue<Token> create() throws Exception {
        prevToken = new Token('+');

        for (int i = 0; i < infixStr.length(); i++) {
            if (infixStr.charAt(i) == ' ') {
                continue;
            }

            if (Character.isDigit(infixStr.charAt(i))) {
                buildOperand(infixStr.charAt(i));
            }
            else {
                enqueueOperand();
                enqueueOperator(infixStr.charAt(i));
            }
        }
        enqueueOperand();
        checkLastToken();
        return infix;
    }

    private void buildOperand(char opdChar) {
        if (operand == null) {
            operand = 0.0;
        }
        operand = (operand * 10) + (opdChar - '0');
    }



    private void enqueueOperand() {
        if (operand != null) {
            Token newToken = new Token(operand);
            operand = null;

            infix.enqueue(newToken);
            prevToken = newToken;
        }
    }

    private void enqueueOperator(char operator) throws Exception {
        Token newToken;

        if (operator == '-' && prevToken.getIsp() != -1) {
            newToken = new Token('m');
        }
        else {
            newToken = new Token(operator);
            checkWithPrevToken(newToken);
        }

        infix.enqueue(newToken);
        prevToken = newToken;
    }




    private void checkLastToken() throws Exception {
        if (prevToken.getIsp() != -1) {
            throw new Exception("[오류] 식의 마지막에 연산자가 올 수 없습니다.");
        }
    }

    private void checkWithPrevToken(Token crntToken) throws Exception {
        if (prevToken.isUnaryOperator() && crntToken.isBinaryOperator()) {
            throw new Exception("[오류] 단항연산자 뒤에 이항연산자가 올 수 없습니다.");
        }

        if (prevToken.getOperator() == '(') {
            if (crntToken.getOperator() == ')') {
                throw new Exception("[오류] 빈 괄호는 올 수 없습니다.");
            }
            if (crntToken.isBinaryOperator()) {
                throw new Exception("[오류] 여는 괄호 뒤에 이항연산자가 올 수 없습니다.");
            }
        }
    }
}