package e15;

import e1.Grafo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserSearchService {
    private FileDAO fileDAO;
    private  Graph graph ;
    private CacheMemory usersCacheMemory;
    private Logger logger;

    public UserSearchService (FileDAO fileDAO , Logger logger){
        this.fileDAO=fileDAO;
        this.graph = new Graph();
        this.usersCacheMemory=new CacheMemory();
        this.logger = logger;
    }

    public void initializeGraph() throws FileNotFoundException {
        List<UserInfoDTO> userInfoList  = fileDAO.readCsvFile();
        Map<Integer , List<String> > friendsMap = new HashMap<>();
        for(int i=0 ; i<userInfoList.size() ; i++){
            Node node = new Node();
            UserInfoBo userInfoBo = new UserInfoBo();
            userInfoBo.setUserInfoDTO(userInfoList.get(i));
            node.setUserInfoBo(userInfoBo);
            friendsMap.put(userInfoList.get(i).getId(), userInfoList.get(i).getFriends());
            graph.addNodes(node);
        }
        for (Map.Entry<Integer,List<String> > e :friendsMap.entrySet()){
            int idOrigin =e.getKey();
            List<String> friends = e.getValue();
            for( int i=0 ; i < friends.size(); i++) {
                graph.connectNodes(idOrigin, Integer.parseInt(friends.get(i).trim()));
            }
        }
    }

    public void showGraph (){
        graph.showGraph(1);
    }

    public Node searchGraph (String name) throws NotFoundUserException{

        Node node;

        if(!usersCacheMemory.isInMemory(name)){

            node= graph.searchAmplitude (name , 0);

            usersCacheMemory.addToMemory(node.getName(),node);

            logger.writeLog( " this user " +node.getName()+" has not been found in the cache memory ," +
                    " it has been searched from UserSearchedService class " +
                    "and then it has been added to the cache memory ");
        }else {

            node=usersCacheMemory.getNodeFromMemory(name);

            logger.writeLog("this user " +node.getName()+" has been found in the cache memory " );

        }

        return node;

    }
}

