import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {
    String filePath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader() {
        this.filePath = null;
        this.fromLine = null;
        this.toLine = null;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine){
        this.filePath = filePath;
        if (fromLine < 0){
            throw new IllegalArgumentException();
        } else {
            this.fromLine = fromLine;
        }if(toLine < fromLine){
            throw new IllegalArgumentException();
        }else {
            this.toLine = toLine;
        }
    }

    public String read() throws IOException {
        String result = "";
        FileInputStream fstream = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        while ((strLine = reader.readLine()) != null){
            result += strLine + "\n";
        }
        return result;
    }

    public String readLines() throws IOException {
        String result = "";
        String originalContentOfFile = read();
        List<String> listOfOriginalContent= Arrays.asList(originalContentOfFile.split("\n"));
        for (int i = this.fromLine-1; i < this.toLine; i++) {
            result += listOfOriginalContent.get(i) + "\n";
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/proba.txt", 1, 2);
        System.out.println(reader.read());
        System.out.println(reader.readLines());
    }
}
