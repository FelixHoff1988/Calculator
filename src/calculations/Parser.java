package calculations;

public class Parser {
    public Parser() {

    }
    public int searchFor(String haystack, String needle) {
        long countOpenBrackets = haystack.chars().filter(ch -> ch == '(').count();
        int Brackets = 0;
        int equalizer = 0;
        int Position = 0;
        String transcript = haystack.replaceAll("\\( - ", "(- ").replaceAll("\\(", "( ").replaceAll("\\)", " )");
        String[] splices = transcript.split(" ");
        int lengthSplices = splices.length;
        for(int i = 0; i<lengthSplices;i++) {
            if(splices[i].equals(needle)) {
                Brackets++;
            }
        }
        for (int i = 0; i <lengthSplices; i++) {
            if(splices[i].equals(needle)){
                equalizer++;
            }
            if(equalizer == Brackets) {
                Position = i;
                break;
            }
        }
        return Position;
    }
}
