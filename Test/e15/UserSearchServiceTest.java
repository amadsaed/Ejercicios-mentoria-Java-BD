package e15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserSearchServiceTest {
    static UserSearchService userSearchService;

    @BeforeAll
    public static void initializeData() throws IOException {
        FileDAO csvReader = new FileDAO("C:\\Users\\Ahmad Saed\\Desktop\\newProject\\Test\\resource\\data_Test.csv", null);
        Logger logger = new Logger("C:\\Users\\Ahmad Saed\\Desktop\\newProject\\Test\\outputTest");
        csvReader.openFile();
        userSearchService= new UserSearchService(csvReader, logger);
        userSearchService.initializeGraph();
    }
   @Test
    public void searchAmplitudeTest () throws NotFoundUserException {
        assertEquals("Lionel Messi", userSearchService.searchGraph("Lionel Messi").getName());
   }

    @Test()
    public void searchAmplitudeExpectedNotFoundUserTest (){
        Assertions.assertThrows(NotFoundUserException.class,() -> userSearchService.searchGraph("amad"));

    }
}