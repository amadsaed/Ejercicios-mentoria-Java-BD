package e15;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private FileDAO loggerDAO ;
    private static final String LOG_FILE_NAME = "facebook_log_";
    private static final String LOG_FILE_EXTENSION = ".log";

    public Logger(String path ) throws IOException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formattedDate = simpleDateFormat.format(new Date());
        String fileName = LOG_FILE_NAME + formattedDate + LOG_FILE_EXTENSION;
        this.loggerDAO = new FileDAO(null,path + "/" +fileName);
        this.loggerDAO.openFile();
    }

    public void writeLog(String msg){
        Date date = new Date();
        String message = date + "   "+ msg;
        this.loggerDAO.write(message);
    }

    public void writeLog( Exception e){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        Date date = new Date();
        String message = date + "   "+ sw.toString();
        this.loggerDAO.write(message);
    }

    public void closeLog (){
        this.loggerDAO.close();
    }


}
