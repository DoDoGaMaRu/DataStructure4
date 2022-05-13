package 과제2;

public class Token {
    private double operand;
    private char operator;
    private int isp;
    private int icp;
    private boolean isOperator;
    private boolean printResult;


    public Token(double operand) {
        this.operand = operand;
        isOperator = false;
        isp = -1;
        icp = -1;
    }

    public Token(char operator) throws Exception {
        this.operator = operator;
        isp = isp(operator);
        icp = icp(operator);

        checkValidOperator();

        printResult = false;
        isOperator = true;
    }




    public double getOperand() {
        return operand;
    }

    public char getOperator() {
        return operator;
    }



    public void setPrintResult(boolean printResult) {
        this.printResult = printResult;
    }

    public void setOperand(double operand) {
        this.operand = operand;
    }



    public boolean isOperator() {
        return isOperator;
    }

    public boolean isUnaryOperator() {
        if (isOperator) {
            return isp == 4;
        }
        else {
            return false;
        }
    }

    public boolean isBinaryOperator() {
        if (isOperator) {
            return isp >= 1 && isp <= 3;
        }
        else {
            return false;
        }
    }




    public int getIsp() {
        return isp;
    }

    public int getIcp() {
        return icp;
    }

    public int isp(char operator) {
        switch (operator) {
            case '(':
                return 0;

            case '+': case '-':
                return 1;

            case '*': case '/':
                return 2;

            case '^':
                return 3;

            case 'm': case '@':
                return 4;

            default:
                return -1;
        }
    }

    public int icp(char operator) {
        switch (operator) {
            case '+': case '-': case ')':
                return 1;

            case '*': case '/':
                return 2;

            case '^':
                return 3;

            case 'm': case '@':
                return 5;

            case '(':
                return 6;

            default:
                return -1;
        }
    }




    public String toString() {
        if (isOperator) {
            if (printResult) {
                double tempOpd = (double)Math.round(operand * 100) / 100;
                return operator + "[" + tempOpd + "]";
            }
            else {
                return String.valueOf(operator);
            }
        }
        else {
            return String.valueOf((int)operand);
        }
    }

    private void checkValidOperator() throws Exception {
        if (icp == -1) {
            throw new Exception("[오류] 이해할 수 없는 연산자입니다.");
        }
    }
}