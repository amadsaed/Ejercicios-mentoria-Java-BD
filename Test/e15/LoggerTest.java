package e15;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoggerTest {

    private static Logger logger;

    @BeforeAll
    public static void setAttributes() throws IOException {
        logger = new Logger("C:\\Users\\Ahmad Saed\\Desktop\\newProject\\Test\\outputTest");
    }
    @AfterAll
    public static void closeResources (){
        logger.closeLog();
    }

    @Test
    public void writeLog_message_Test() {
        logger.writeLog("test !");
    }
    @Test
    public void writeLog_exception_Test() {
        logger.writeLog(new NotFoundUserException("exception test !"));
    }

}
