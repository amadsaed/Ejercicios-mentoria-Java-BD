package e15;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.io.IOException;

class UserSearchServiceTest {
    static UserSearchService userSearchService;

    @BeforeClass
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
       // Assertions.assertThrows(NotFoundUserException.class,() -> userSearchService.searchGraph("amad"));

    }
}