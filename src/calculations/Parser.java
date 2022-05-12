package calculations;

import java.util.function.LongToIntFunction;

public class Parser {
    public Parser() {

    }
    public void splicer(String input) {
        long countOpenBrackets = input.chars().filter(ch -> ch == '(').count();
        int Brackets = 0;
        int Position = 0;
        String transcript = input.replaceAll("\\( - ", "(- ").replaceAll("\\(", "( ").replaceAll("\\)", " )");
        String[] splices = transcript.split(" ");
        int lengthSplices = splices.length;
        for(int i = 0; i<lengthSplices;i++) {
            if(splices[i].equals("(")) {
                Brackets++;
            }

            System.out.println(splices[i]);
        }
        for (int i = 0; i <lengthSplices; i++) {
            int equalizer = 0;
            equalizer++;
            if(splices[i].equals("(") && equalizer == Brackets) {
                Position = i;
            }
        }

        System.out.println("Brackets: " + Position +"\n\n");


    }
}
