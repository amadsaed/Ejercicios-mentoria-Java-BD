package e15;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;

public class FileDAOTest {

    private static FileDAO fileDAO;

    @BeforeClass
    public static void setAttributes() throws IOException {
        fileDAO= new FileDAO("C:\\Users\\Ahmad Saed\\Desktop\\newProject\\src\\e15\\resource\\data.csv" ,null);
        fileDAO.openFile();
    }

    @Test
    public void readCsvFileTest() throws IOException {
        assertFalse(fileDAO.readCsvFile().isEmpty());
    }

}
