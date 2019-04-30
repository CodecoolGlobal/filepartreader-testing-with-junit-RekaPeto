import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testSetup(){
        FilePartReader reader = new FilePartReader();
        //Exception exception = assertThrows(FileNotFoundException.class, () -> reader.setup("blabla.txt",1,2));   nemeeeeegy
        //assertEquals("(No such file or directory)", exception.getMessage());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> reader.setup("src/proba.txt",-1,2));
        assertEquals("a", exception.getMessage());
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> reader.setup("src/proba.txt",2,1));
        assertEquals("b", exception2.getMessage());
    }

    @Test
    public void testRead() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("proba.txt", 1, 2);
        Exception exception = assertThrows(FileNotFoundException.class, reader::read);
        assertEquals("proba.txt (No such file or directory)", exception.getMessage());
        reader.setup("src/proba.txt", 1, 2);
        assertEquals("A\nlittle\nduck\nwalks\nin\nthe\nforest\n", reader.read());
    }

    @Test
    public void testReadLine() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("proba.txt", 1, 2);
        Exception exception = assertThrows(FileNotFoundException.class, reader::read);
        assertEquals("proba.txt (No such file or directory)", exception.getMessage());
        reader.setup("src/proba.txt", 1, 2);
        assertEquals("A\nlittle\n", reader.readLines());
    };

}