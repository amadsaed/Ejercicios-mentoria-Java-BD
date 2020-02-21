package e15;

import java.util.HashMap;
import java.util.Map;

public class CacheMemory {

    private Map<String ,Node> usersMemory;

    public CacheMemory() {
        this.usersMemory =  new HashMap<>();
    }

    public void addToMemory (String name , Node user){
        this.usersMemory.put(name , user);
    }

    public  boolean  isInMemory (String name){
       return this.usersMemory.containsKey(name);

    }

    public Node getNodeFromMemory (String nameNode){

        return usersMemory.get(nameNode);

        /*
      Node node = null;
        for (Map.Entry<String,Node> p: usersMemory.entrySet()){
            node = p.getValue();
        }
        return node;

         */
    }
}
