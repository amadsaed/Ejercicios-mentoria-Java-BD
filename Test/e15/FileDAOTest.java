package e15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileDAOTest {

    private static FileDAO fileDAO;

    @BeforeAll
    public static void setAttributes() throws IOException {
        fileDAO= new FileDAO("C:\\Users\\Ahmad Saed\\Desktop\\newProject\\src\\e15\\resource\\data.csv" ,null);
        fileDAO.openFile();
    }

    @Test
    public void readCsvFileTest() throws IOException {
        assertFalse(fileDAO.readCsvFile().isEmpty());
    }

}
