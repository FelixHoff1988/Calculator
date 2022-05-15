package calculations;

import java.util.ArrayList;

public class Parser {
    public MathBasics basics = new MathBasics();
    public Parser() {

    }
    public String echo(String input) {
        String[] slices = slicer(input);
        int start = lastOpenBracket(slices)+1;
        int end = firstCloseBracket(slices)-1;
        float result = 0;
        sliceCheck(slices[start]);
        sliceCheck(slices[end]);
        sliceCheck(slices[start+1]);
        String bracketContent = input.replaceAll(" ","").substring(start-1,end);
        orderOperations(bracketContent);
        result = basics.getResult();

        String answer = Float.toString(result);
        basics.setResult(0);
        return answer;
    }
    public String[] slicer(String input) {
        String transcript = "( " + input.replaceAll("\\( - ", "(- ").replaceAll("\\(", "( ").replaceAll("\\)", " )") + " )";
        String[] slices = transcript.split(" ");
        int len = slices.length;
        for (int i = 0; i <len; i++){
            System.out.println(slices[i]);
        }

        return slices;
    }
    public int lastOpenBracket(String[] slices) {
        int Brackets = 0;
        int equalizer = 0;
        int Position = 0;
        int lengthSplices = slices.length;
        for(int i = 0; i<lengthSplices;i++) {
            if (slices[i].equals("(")) {
                Brackets++;
            }
        }
        for(int j = 0; j<lengthSplices;j++) {
            if (slices[j].equals("(")) {
                equalizer++;
            }
            if (equalizer == Brackets) {
                Position = j;
                break;
            }
        }
        return Position;
    }

    public int firstCloseBracket(String[] slices) {
        int Position = 0;
        int len = slices.length;
        for (int i = 0; i<len; i++){
            if(slices[i].equals(")")) {
                Position = i;
                break;
            }
        }
        return Position;
    }
    public void sliceCheck(String slice) {
        char firstChar = slice.charAt(0);
        int num = 0;
        float number = 0;
        int value = 0;
        if(firstChar =='0') {
            number = Float.parseFloat(slice);
            basics.setValueOne(number);
        } else if (firstChar == '1') {
            number = Float.parseFloat(slice);
            basics.setValueOne(number);
        } else if (firstChar == '2') {
            number = Float.parseFloat(slice);
            basics.setValueOne(number);
        } else if (firstChar == '3') {
            number = Float.parseFloat(slice);
            basics.setValueOne(number);
        } else if (firstChar == '4') {
            number = Float.parseFloat(slice);
            basics.setValueOne(number);
        } else if (firstChar == '5') {
            number = Float.parseFloat(slice);
            basics.setValueOne(number);
        } else if (firstChar == '6') {
            number = Float.parseFloat(slice);
            basics.setValueOne(number);
        } else if (firstChar == '7') {
            number = Float.parseFloat(slice);
            basics.setValueOne(number);
        } else if (firstChar == '8') {
            number = Float.parseFloat(slice);
            basics.setValueOne(number);
        } else if (firstChar == '9') {
            number = Float.parseFloat(slice);
            basics.setValueOne(number);
        } else {
            basics.calculate(slice);
        }
    }
    public String order(String slice) {
        char firstChar = slice.charAt(0);
        if(firstChar =='*') {
            return "*";
        } else if (firstChar == '/') {
            return "/";
        } else if (firstChar == '+') {
            return "+";
        } else if (firstChar == '-') {
            return "-";
        }
        return "bracket";
    }
    public void orderOperations(String bracketContent){
        bracketContent = bracketContent.replaceAll("\\+", " + ").replaceAll("-", " - ").replaceAll("\\*", " * ").replaceAll("/", " / ");
        String[] slices = slicer(bracketContent);
        float result = 0;
        for (int i = 0; i<slices.length; i++){
            System.out.println(slices[i]);
        }
        while(slices.length>3) {
            for (int i = 0; i<slices.length; i++){
                if(slices[i].equals("*") || slices[i].equals("/") || slices[i].equals("+") || slices[i].equals("-")){
                    basics.setResult(0);
                    sliceCheck(slices[i-1]);
                    sliceCheck(slices[i+1]);
                    basics.calculate(slices[i]);
                    result = basics.getResult();
                    String res = Float.toString(result);
                    slices = removeElement(slices,i-1);
                    slices = removeElement(slices,i-1);
                    slices = removeElement(slices,i-1);
                    slices = insertElement(slices, res, i-1);
                }
            }
        }
        int check = 1;
        System.out.println(check);

    }
    public String[] removeElement(String[] slices, int index) {
        String[] newSlices = new String[slices.length-1];
        for(int i = 0, k = 0; i < slices.length; i++) {
            if(i == index) {
                continue;
            }
            newSlices[k++] = slices[i];
        }
        return newSlices;
    }
    public String[] insertElement(String[] slices, String newSlice, int index) {
        String[] newSlices = new String[slices.length+1];
        for (int i = 0; i < newSlices.length; i++) {
            if(i<index) {
                newSlices[i] = slices[i];
            } else if (i == index) {
                newSlices[i] = newSlice;
            } else {
                newSlices[i] = slices[i-1];
            }
        }
        return newSlices;
    }
}
