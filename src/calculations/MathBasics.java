package calculations;

import gui.ExampleApplication;

public class MathBasics {
    public float valueOne = 0;
    public float valueTwo = 0;
    public float result = 0;
    public char operator;

    public void setValueOne(int value) {
        if(result != 0) {

            valueOne = (float) value;
        } else {
            result = (float) value;
        }
    }
    public float getValueOne() {
        return valueOne;
    }

    public float getValueTwo() {
        return valueTwo;
    }

    public void setOperator(char op) {
        operator = op;
    }

    public char getOperator() {
        return operator;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public float getResult() {
        return result;
    }

    public void addition() {
        if(getResult()== 0) {
            result = valueOne;
        } else {
            result += valueOne;
        }
    }

    public void minus() {
        if(getResult()== 0) {
            result = valueOne;
        } else {
            result -= valueOne;
        }
    }

    public void mult() {
        if(getResult()== 0 || getValueOne() == 0) {
            result = 0;
        } else {
            result *= valueOne;
        }
    }

    public void divide() {
        if(getResult()== 0) {
            result = 0;
        } else if (getValueOne() == 0) {
            System.out.println("Wer durch Null teilt, isst auch Kinder");
        } else {
            result = result/valueOne;
        }
    }

    public void calculate(String slice) {
        if(slice.equals("+")) {
            addition();
        } else if(slice.equals("-")) {
            minus();
        } else if(slice.equals("*")) {
            mult();
        } else if (slice.equals("/")) {
            divide();
        }
    }
}
