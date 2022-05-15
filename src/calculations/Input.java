package calculations;

public class Input {
    String input = "0";
    String html = "";
    boolean equalPressed = false;
    String error = "Error";
    int inputLength = input.length();
    int countOpenBrackets = 0;

    public Input(){

    }
    public Parser parse = new Parser();
    public int getInputLength() {
        inputLength = input.length();
        return inputLength;
    }

    public void setInput(String input) {
        this.input += input;

    }

    public String getInput() {
        return input;
    }

    public void clear() {
        input = "0";
    }

    public void deleteInput(){
        input = "";
    }
    public String parseToHtml(String input) {
        /*System.out.println(this.input);*/
        html = "<html><p align=" + '"' +"right" + '"' +">"+ input.replaceAll("<", "&lt;").replaceAll(">","&gt").replaceAll("\n","<br>") + "</p></html>";
        return html;
    }

    public String zeroPressed(){
        if(!equalPressed) {
            if (getInput() == "0") {
                clear();
                return input;
            } else if (getInput().charAt(getInputLength() - 1) == '(') {
                return input;
            } else {
                setInput("0");
                return input;
            }
        }
        return error;
    }
    public String numPressed(String number) {
        if(!equalPressed) {
            if (getInput() == "0") {
                deleteInput();
            }
            if (getInputLength() != 0){
                if (getInput().charAt(getInputLength() - 1) == ')') {

                    setInput(" * "+ number);
                }
            }
            setInput(number);
        }
        return input;
    }
    public String operatorPressed(String operator) {
        if(!equalPressed) {
            if (operator == " - ") {
                if (getInput().charAt(getInputLength() - 1) != ' ') {
                    setInput(operator);
                }
            }
            if (getInput().charAt(getInputLength() - 1) != ' ' && getInput().charAt(getInputLength() - 1) != '(' ) {
                setInput(operator);
            }
            return input;
        }
        return error;
    }

    public String openBracketPressed() {
        if(!equalPressed) {
            if (getInput() == "0") {
                deleteInput();
                setInput("(");
            } else if (getInput().charAt(getInputLength() - 1) != ' '&& getInput().charAt(getInputLength() - 1) != '(' ) {
                setInput(" * (");
            } else {
                setInput("(");
            }
            countOpenBrackets += 1;
            closeBracketPressed();
            return input;

        }
        return error;
    }
    public String closeBracketPressed() {
        if(!equalPressed) {
            if(countOpenBrackets == 0) {
                return input;
            }
            if(countOpenBrackets != 0 && getInput().charAt(getInputLength() - 1) != '(') {
                setInput(")");
                countOpenBrackets -= 1;
            }
            return input;
        }
        return error;
    }
    public String commaPressed() {
        if(!equalPressed) {
            setInput(",");
            return input;
        }
        return error;
    }
    public String equalPressed() {
        if(!equalPressed) {
            if(getInput() == "0") {
                clear();
                return input;
            } else {
                if (getInput().charAt(getInputLength() - 1) == '(') {
                    setInput("0");
                }
                while (countOpenBrackets != 0) {
                    setInput(")");
                    countOpenBrackets -=1;
                }


                /*for (int i = 0 ; i<len;i++){
                    System.out.println(splice[i]);
                }*/
                String answer = parse.echo(input);
                answer += " = \n";
/*
                setInput(" = \n");*/
                countOpenBrackets = 0;
                equalPressed = true;

                return parseToHtml(answer);
            }
        }
        countOpenBrackets = 0;
        return parseToHtml(getInput());
    }
    public String clearPressed() {
        equalPressed = false;
        clear();
        return input;
    }
    public String removeLastCharacter(String str) {
        String result = null;
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 1);
        }
        return result;
    }
    public String delPressed() {
        input = removeLastCharacter(input);
        return input;
    }

}
