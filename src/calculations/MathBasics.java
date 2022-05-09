package calculations;
import gui.ExampleApplication;

public class MathBasics {
    public float valueOne = 0;
    public float valueTwo = 0;
    public float result = 0;
    public char operator;

    public void setValueOne(float value) {
        if(result != 0) {
            valueOne = value;
        } else {
            result = value;
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

    public String calculate() {
        String res;
        if(getOperator() == '+') {
            addition();
        } else if(getOperator() == '-') {
            minus();
        } else if(getOperator() == '*') {
            mult();
        } else if (getOperator() == '/') {
            divide();
        }
        res = Float.toString(result);
        return res;
    }

    public String clear() {
        result = 0;
        String res = Float.toString(result);
        return res;
    }
}
