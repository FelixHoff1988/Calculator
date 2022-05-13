package calculations;

public class Parser {
    public Parser() {

    }

    public String[] splicer(String input) {
        String transcript = input.replaceAll("\\( - ", "(- ").replaceAll("\\(", "( ").replaceAll("\\)", " )");
        String[] splices = transcript.split(" ");
        return splices;
    }
    public int lastOpenBracket(String[] splices) {
        int Brackets = 0;
        int equalizer = 0;
        int Position = 0;
        int lengthSplices = splices.length;
        for(int i = 0; i<lengthSplices;i++) {
            if(splices[i].equals("(")) {
                Brackets++;
            }
        }
        for (int i = 0; i <lengthSplices; i++) {
            if(splices[i].equals("(")){
                equalizer++;
            }
            if(equalizer == Brackets) {
                Position = i;
                break;
            }
        }
        return Position;
    }
    public int firstCloseBracket(String[] splices) {
        int Position = 0;
        int len = splices.length;
        for (int i = 0; i<len; i++){
            if(splices[i].equals(")")) {
                Position = i;
                break;
            }
        }
        return Position;
    }
    public int numCheck(String splice) {
        char firstChar = splice.charAt(0);
        int number = 0;
        if(firstChar =='0') {
            number = Integer.parseInt(splice);
            return number;
        } else if (firstChar == '1') {
            number = Integer.parseInt(splice);
            return number;
        } else if (firstChar == '2') {
            number = Integer.parseInt(splice);
            return number;
        } else if (firstChar == '3') {
            number = Integer.parseInt(splice);
            return number;
        } else if (firstChar == '4') {
            number = Integer.parseInt(splice);
            return number;
        } else if (firstChar == '5') {
            number = Integer.parseInt(splice);
            return number;
        } else if (firstChar == '6') {
            number = Integer.parseInt(splice);
            return number;
        } else if (firstChar == '7') {
            number = Integer.parseInt(splice);
            return number;
        } else if (firstChar == '8') {
            number = Integer.parseInt(splice);
            return number;
        } else if (firstChar == '9') {
            number = Integer.parseInt(splice);
            return number;
        }
        return number;
    }
}
