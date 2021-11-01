import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class LexicalAnalyzer {

    public static void main(String[] args) {

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

        boolean isKw = lexicalAnalyzer.isKeyWord("auto");
        System.out.println(isKw);

    }

    public boolean isKeyWord(String buffer) {
        ArrayList<String> keywordList = new ArrayList<String>(
                Arrays.asList("function", "double", "single", "char", "disp",
                        "(", ")", ".", "'", ",", ";", "[", "]", "=",
                        "+", "-", "*", "/"));

        for (int i = 0; i < keywordList.size(); i++) {
            if (buffer.equals(keywordList.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void readFile(){
        File file = new File("");
    }


}
