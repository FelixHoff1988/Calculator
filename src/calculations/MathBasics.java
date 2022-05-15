package calculations;

public class MathBasics {
    public float valueOne = 0;
    public float valueTwo = 0;
    public String nullDivider = "Wer durch Null teilt, isst auch kleine Kinder!";
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

    public void subtraction() {
        if(getResult()== 0) {
            result = valueOne;
        } else {
            result -= valueOne;
        }
    }

    public void multiply() {
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
        if(slice.equals("*")) {
            multiply();
        } else if(slice.equals("/")) {
            divide();
        } else if(slice.equals("+")) {
            addition();
        } else if (slice.equals("-")) {
            subtraction();
        }
    }
}
