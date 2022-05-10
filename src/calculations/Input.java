package calculations;

public class Input {
    String input = "0";
    String html = "";
    int inputLength = input.length();

    public int getInputLength() {
        return inputLength;
    }

    public void setInput(String input) {
        if (this.input == "0") {
            this.input = "";
        }
        this.input += input;
    }

    public String getInput() {

        return input;
    }

    public String clear() {
        input = "0";
        return input;
    }
    public String parseToHtml(String input) {
        System.out.println(this.input);
        String parsedString = "<html><p align=" + '"' +"right" + '"' +">"+ input.replaceAll("<", "&lt;").replaceAll(">","&gt").replaceAll("\n","<br>") + "</p></html>";
        return parsedString;
    }

}
