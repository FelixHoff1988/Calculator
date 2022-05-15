package calculations;

public class Parser {
    public MathBasics basics = new MathBasics();
    String error = "OK";
    public Parser() {

    }
    public String echo(String input) {
        String[] slices = slicer(input);
        String answer ="";
        float result = 0;
        while (slices.length>1){
            String[] bracketSlices = new String[firstCloseBracket(slices)+1-lastOpenBracket(slices)];
            int bracketStart = 0;
            for(int j = lastOpenBracket(slices); j<=firstCloseBracket(slices); j++){
                bracketSlices[bracketStart] = slices[j];
                bracketStart++;
            }
            int pointer = lastOpenBracket(slices);
            int p2 =firstCloseBracket(slices);
            for(int i = pointer; i<=p2; i++){
                slices = removeElement(slices,pointer);
            }
            String resolvedBracket = sortOperations(bracketSlices);
            if (error.equals("OK") == false) {
                return error;
            }
            slices = insertElement(slices, resolvedBracket, pointer);

        }
        if(slices.length==1){
            answer =slices[0];
            return answer;
        }
        result = basics.getResult();

        answer = Float.toString(result);
        basics.setResult(0);
        return answer;
    }
    public String[] slicer(String input) {
        String transcript = "( " + input.replaceAll("\\( - ", "(- ").replaceAll(",", ".").replaceAll("\\(", "( ").replaceAll("\\)", " )") + " )";
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
        float number = 0;
        number = Float.parseFloat(slice);
        basics.setValueOne(number);
    }

    public String sortOperations(String[] bracketSlices){
        String[] slices = bracketSlices;
        for (int i = 0; i<slices.length; i++){
            System.out.println(slices[i]);
        }
        while(slices.length>3) {
            boolean binder = false;
            for (int k = 0; k<slices.length;k++) {
                if(slices[k].equals("*")|| slices[k].equals("/")){
                    binder = true;
                    break;
                } else {
                    binder = false;
                }
            }
            if(binder) {
                for (int i = 0; i< slices.length;i++){
                    if(slices[i].equals("*")|| slices[i].equals("/")){
                        if(slices[i].equals("/") && slices[i+1].equals("0")){
                            error = "Wer durch null teilt, isst auch Kinder!";
                            return error;
                        }
                        slices = calcAndReplace(slices,i);
                    }
                }
            } else {
                for (int j = 0; j < slices.length; j++) {
                    if(slices[j].equals("+")|| slices[j].equals("-")) {
                        slices = calcAndReplace(slices, j);
                    }
                }
            }
        }
        String calculated = slices[1];
        return calculated;
    }

    public String[] calcAndReplace(String[] slices, int i){
        float result = 0;
        basics.setResult(0);
        if(slices[i-1].equals("(")){
            String negValue = "-" + slices[i+1];
            String[] signChange = new String[3];
            signChange[0] = "(";
            signChange[1] = negValue;
            signChange[2] = ")";
            slices = signChange;
            return slices;
        }
        sliceCheck(slices[i-1]);
        sliceCheck(slices[i+1]);
        basics.calculate(slices[i]);
        result = basics.getResult();
        String res = Float.toString(result);
        slices = removeElement(slices,i-1);
        slices = removeElement(slices,i-1);
        slices = removeElement(slices,i-1);
        slices = insertElement(slices, res, i-1);
        return slices;
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
