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

    public void addition(float value) {
        if(getResult()== 0) {
            result = value;
        } else {
            result += value;
        }
        setValueOne(0);

    }
}
