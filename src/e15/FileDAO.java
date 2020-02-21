package e15;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileDAO {

    private File reader ;
    private FileWriter writer ;
    private String readFilePath;
    private String writeFilePath;

    public FileDAO(String readFilePath , String writeFilePath) {
        this.readFilePath = readFilePath;
        this.writeFilePath= writeFilePath;
    }



    public void openFile() throws IOException {
        if (readFilePath!=null) {
                reader = new File(readFilePath);
        }
        if(writeFilePath!= null) {
            writer = new FileWriter(writeFilePath);

        }
    }

    public List<UserInfoDTO> readCsvFile() throws FileNotFoundException {
        List<UserInfoDTO> userInfoList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(reader))){
            scanner.nextLine();
            while (scanner.hasNextLine()){
                String line =scanner.nextLine();
                UserInfoDTO userInfo = new UserInfoDTO();
                String[] separateValue =line.split(",");
                userInfo.setId(Integer.parseInt(separateValue[0].trim()));
                userInfo.setName(separateValue[1]);
                userInfo.setNationality(separateValue[2]);
                userInfo.setAge(separateValue[3]);
                userInfo.setWork(separateValue[4]);
                userInfo.setRelationship(separateValue[5]);
                String[] friendsIdValue =separateValue[6].split(" ");
                userInfo.setFriends(Arrays.asList(friendsIdValue));
                userInfoList.add(userInfo);
            }
        }
        return userInfoList;
    }

    public void write(String msg){
        try {
            writer.write(msg + "\n");
            writer.flush();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void close(){
        try {
            writer.close();

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
