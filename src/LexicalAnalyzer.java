import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class LexicalAnalyzer {

    public static void main(String[] args) {

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

        boolean isKw = lexicalAnalyzer.isKeyWord("auto");
        System.out.println(isKw);
        lexicalAnalyzer.readFile();

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

    public void readFile()  {
        try {
            String input = new String(Files.readAllBytes((Paths.get("src/SampleFile.m"))));
            String [] word = input.split(" ");
            System.out.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
