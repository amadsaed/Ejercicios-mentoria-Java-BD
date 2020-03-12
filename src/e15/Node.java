package e15;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Edge> amigos;
    private UserInfoBo userInfoBo ;

    public List<Edge> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Edge> edges) {
        this.amigos = edges;
    }

    public int getId() {
        return userInfoBo.getId();
    }



    public String getName() {
        return userInfoBo.getName();
    }


    public String getNationality() {
        return userInfoBo.getNationality();
    }


    public String getAge() {
        return userInfoBo.getAge();
    }


    public String getWork() {
        return userInfoBo.getWork();
    }


    public String getRelationship() {
        return userInfoBo.getRelationship();
    }


    public Node() {
        this.amigos = new ArrayList<Edge>();
    }


    public void addEdges(Edge edge) {

        if (amigos == null) {
            amigos = new ArrayList<>();
        }
        amigos.add(edge);
    }

    public Node(UserInfoBo userInfoBo) {
        this.userInfoBo = userInfoBo;
    }

    public UserInfoBo getUserInfoBo() {
        return userInfoBo;
    }

    public void setUserInfoBo(UserInfoBo userInfoBo) {
        this.userInfoBo = userInfoBo;
    }
}



