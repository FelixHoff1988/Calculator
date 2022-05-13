package calculations;

import java.lang.reflect.Array;
import java.util.function.LongToIntFunction;

public class Parser {
    public Parser() {

    }
    public void splicer(String input) {
        long countOpenBrackets = input.chars().filter(ch -> ch == '(').count();
        int Brackets = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        int counter = 0;
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

            if(splices[i].equals("(")) {
                counter++;
            }
            secondIndex = i;
            if (counter == Brackets) {
                break;
            }
        }

        System.out.println("Brackets: " + Brackets +"\n\n");

        System.out.println("LastIndex: " + secondIndex +"\n\n");
        System.out.println("Found: " + splices[secondIndex] +"\n\n");


    }
}
