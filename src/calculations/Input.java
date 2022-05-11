package calculations;

public class Input {
    String input = "0";
    String html = "";
    boolean equalPressed = false;
    int inputLength = input.length();
    int countOpenBrackets = 0;


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
        System.out.println(this.input);
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
        return input;
    }
    public String numPressed(String number) {
        if(!equalPressed) {
            if (getInput() == "0") {
                deleteInput();
            }
            setInput(number);
        }
        return input;
    }
    public String operatorPressed(String operator) {
        if(!equalPressed) {
            if (getInput().charAt(getInputLength() - 1) != ' ') {
                setInput(operator);
            }
            return input;
        }
        return input;
    }

    public String openBracketPressed() {
        if(!equalPressed) {
            if (getInput().charAt(getInputLength() - 1) != ' ') {
                setInput(" * (");
            } else {
                setInput("(");
            }
            countOpenBrackets += 1;
            return input;

        }
        return input;
    }
    public String closeBracketPressed() {
        if(!equalPressed) {
            if(countOpenBrackets != 0 && getInput().charAt(getInputLength() - 1) != '(') {
                setInput(")");
                countOpenBrackets -= 1;
            }
            return input;
        }
        return input;
    }
    public String commaPressed() {
        if(!equalPressed) {
            setInput(",");
            return input;
        }
        return input;
    }
    public String equalPressed() {
        if(!equalPressed) {
            if(getInput() == "0") {
                clear();
                return input;
            } else {
                if (countOpenBrackets != 0) {
                    for(int i = 0; i <= countOpenBrackets; i++) {
                        setInput(")");
                        countOpenBrackets -= 1;
                    }
                }
                setInput(" = \n");
                equalPressed = true;
                return parseToHtml(getInput());
            }
        }
        return input;
    }
    public String clearPressed() {
        equalPressed = false;
        clear();
        return input;
    }
}
