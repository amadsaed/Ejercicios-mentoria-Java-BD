package e15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Test {


    public static void main(String[] args) throws IOException, NotFoundUserException{

        //FileDAO csvReader = new FileDAO("C:\\Users\\Ahmad Saed\\Desktop\\newProject\\src\\e15\\resource\\data.csv", null);

        FileDAO fileDAO= new FileDAO("C:\\Users\\Ahmad Saed\\Desktop\\newProject\\src\\e15\\resource\\data.csv" ,null);

        fileDAO.openFile();

        Logger logger = new Logger("C:\\Users\\Ahmad Saed\\Desktop\\newProject\\src\\e15\\resource");

        logger.writeLog("the program has been started");

        UserSearchService userSearchService= new UserSearchService(fileDAO,logger);

        userSearchService.initializeGraph();

        Scanner inputScanner = new Scanner (System.in);

        String keyboardInput = "";


        do {
            try {
                System.out.println("Enter a name to search (0 to exit ): ");

                keyboardInput = inputScanner.nextLine();

                if (!keyboardInput.equals("0")){

                    logger.writeLog(keyboardInput);

                    Node node=userSearchService.searchGraph(keyboardInput);

                    System.out.println(node.getName() +"   "+ node.getAge()+"   "+ node.getNationality() + "   "+node.getRelationship());

                    logger.writeLog("the user has been found successfully "+ node.getName());
                }


            }catch (NotFoundUserException e){

                System.out.println("the name has not been found ! "+ e.getMessage());

                logger.writeLog(e);
            }
        }while (!keyboardInput.equals("0"));

        logger.writeLog("the program execution has been finished");

        logger.closeLog();
    }
}
