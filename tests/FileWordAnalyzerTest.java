import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    public void testgetStringsWhichPalindromes() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/proba.txt", 1, 3);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        List<String> result = new ArrayList<>();
        result.add("A");
        assertEquals(result, analyzer.getStringsWhichPalindromes());
    }

    @Test
    public void testGetWordsContainingSubstrings() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/proba.txt", 1, 3);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        List<String> result = new ArrayList<>();
        result.add("duck");
        assertEquals(result, analyzer.getWordsContainingSubstring("uc"));
    }

    @Test
    public void testGetWordsOrderedByAlphabetically() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/proba.txt", 1, 3);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        List<String> result = new ArrayList<>();
        result.add("A");
        result.add("duck");
        result.add("little");
        assertEquals(result, analyzer.getWordsOrderedAlphabetically());
    }


}