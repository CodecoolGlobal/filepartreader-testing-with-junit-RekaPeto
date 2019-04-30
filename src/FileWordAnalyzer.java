
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> result = Arrays.asList(filePartReader.readLines().split("\n"));
        Collections.sort(result);
        return result;
    }

    public List<String> getWordsContainingSubstring(String substring)throws IOException{
        List<String> result = new ArrayList<>();
        List<String> originalWords = Arrays.asList(filePartReader.readLines().split("\n"));
        for (String word: originalWords) {
            if(word.contains(substring)) {
                result.add(word);
            }
        }
        return result;
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        List<String> result = new ArrayList<>();
        List<String> originalWords = Arrays.asList(filePartReader.readLines().split("\n"));
        for (String word: originalWords) {
            if(word.equals(new StringBuilder(word).reverse().toString())){
                result.add(word);
            }
        }
        return result;
    }

    /*public static void main(String[] args) throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/proba.txt", 1, 2);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        System.out.println(analyzer.getWordsOrderedAlphabetically());
        System.out.println(analyzer.getWordsContainingSubstring("aa"));
        System.out.println(analyzer.getStringsWhichPalindromes());
    }*/

}
