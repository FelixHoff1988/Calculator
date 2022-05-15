package calculations;

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
        result = basics.getResult();

        String answer = Float.toString(result);
        basics.setResult(0);
        return answer;
    }
    public String[] slicer(String input) {
        String transcript = "( " + input.replaceAll("\\( - ", "(- ").replaceAll("\\(", "( ").replaceAll("\\)", " )".replaceAll("", " = \\\n")) + " )";
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
        int number = 0;
        int value = 0;
        if(firstChar =='0') {
            number = Integer.parseInt(slice);
            basics.setValueOne(number);
        } else if (firstChar == '1') {
            number = Integer.parseInt(slice);
            basics.setValueOne(number);
        } else if (firstChar == '2') {
            number = Integer.parseInt(slice);
            basics.setValueOne(number);
        } else if (firstChar == '3') {
            number = Integer.parseInt(slice);
            basics.setValueOne(number);
        } else if (firstChar == '4') {
            number = Integer.parseInt(slice);
            basics.setValueOne(number);
        } else if (firstChar == '5') {
            number = Integer.parseInt(slice);
            basics.setValueOne(number);
        } else if (firstChar == '6') {
            number = Integer.parseInt(slice);
            basics.setValueOne(number);
        } else if (firstChar == '7') {
            number = Integer.parseInt(slice);
            basics.setValueOne(number);
        } else if (firstChar == '8') {
            number = Integer.parseInt(slice);
            basics.setValueOne(number);
        } else if (firstChar == '9') {
            number = Integer.parseInt(slice);
            basics.setValueOne(number);
        } else {
            basics.calculate(slice);
        }
    }
    public void orderOperations(String slice){
        String[] operators;
        int[] operatorPositions;
    }
}
