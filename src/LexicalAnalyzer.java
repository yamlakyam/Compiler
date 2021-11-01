import java.util.ArrayList;
import java.util.Arrays;

public class LexicalAnalyzer {

    public static void main(String[] args) {

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

        boolean isKw = lexicalAnalyzer.isKeyWord("auto");
        System.out.println(isKw);

    }

    boolean isKeyWord(String buffer) {
        ArrayList<String> keywordList = new ArrayList<String>(
                Arrays.asList("auto", "break", "case", "char", "const", "continue",
                        "default", "do", "double", "else", "enum", "extern", "float", "for",
                        "goto", "if", "int", "long", "register", "return", "short", "signed",
                        "sizeof", "static", "struct", "switch", "typedef", "union", "unsigned",
                        "void", "volatile", "while"));

        for (int i = 0; i < keywordList.size(); i++) {
            if (buffer.equals(keywordList.get(i))) {
                return true;
            }
        }
        return false;
    }


}
