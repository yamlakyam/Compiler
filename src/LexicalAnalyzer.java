
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class LexicalAnalyzer {

    public static void main(String[] args) {

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();

        boolean isKw = lexicalAnalyzer.isKeyWord("auto");
        System.out.println(isKw);
//        lexicalAnalyzer.getWordList();
        System.out.println(lexicalAnalyzer.getKeyWordList());

        ArrayList<String> keyWords= lexicalAnalyzer.getKeyWordList();
//        lexicalAnalyzer.getKeyWordList();
        lexicalAnalyzer.identifyKeyWords(keyWords);

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

    public ArrayList<String> getWordList() {
        ArrayList<String> wordList = new ArrayList<>();
        try {
            String input = new String(Files.readAllBytes((Paths.get("src/SampleFile.m"))));
            wordList = new ArrayList<>(Arrays.asList(input.split(" ")));
//            System.out.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordList;
    }

    public ArrayList<String> getKeyWordList() {

        ArrayList<String> keyWordList = new ArrayList<>();
        for (int i = 0; i < getWordList().size(); i++) {
            if (isKeyWord(getWordList().get(i))) {
                keyWordList.add(getWordList().get(i));
            }

        }
        return keyWordList;
    }

    public void identifyKeyWords(ArrayList<String> keyWords) {
        ArrayList<String> reservedWords = new ArrayList<>();
        ArrayList<String> specialCharacters = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();
        for (int i = 0; i < keyWords.size(); i++) {
            if(isReservedWord(keyWords.get(i))){
                reservedWords.add(keyWords.get(i));
            }else if(isSpecialCharacter(keyWords.get(i))){
                specialCharacters.add(keyWords.get(i));
            }else if(isOperator(keyWords.get(i))){
                operators.add(keyWords.get(i));
            }
        }

        System.out.println("Reserved words : "+reservedWords);
        System.out.println("Special Characters : "+specialCharacters);
        System.out.println("Operators : "+operators);
    }


    public boolean isReservedWord(String keyword) {
        if (keyword == "function" || keyword == "double" ||
                keyword == "single" || keyword == "char" || keyword == "disp") {
            return true;
        }
        return false;
    }

    public boolean isSpecialCharacter(String keyword) {
        if (keyword == "(" || keyword == ")" ||
                keyword == "." || keyword == "," || keyword == ";" ||
                keyword == "[" || keyword == "]" || keyword == "=") {
            return true;
        }
        return false;
    }

    public boolean isOperator(String keyword) {
        if (keyword == "+" || keyword == "-" || keyword == "*" || keyword == "/") {
            return true;
        }
        return false;
    }

}
