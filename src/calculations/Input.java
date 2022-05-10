package calculations;

public class Input {
    String input = "0";
    String html = "";

    public void setInput(String input) {
        if (this.input == "0") {
            this.input = "";
        }
        this.input += input;
    }

    public String getInput() {

        return parseToHtml(input);
    }

    public String clear() {
        input = "0";
        return input;
    }
    public String parseToHtml(String input) {
        String parsedString = "<html><p align=" + '"' +"right" + '"' +">"+ input.replaceAll("<", "&lt;").replaceAll(">","&gt").replaceAll("\n","<br>") + "</p></html>";
        return parsedString;
    }

}
