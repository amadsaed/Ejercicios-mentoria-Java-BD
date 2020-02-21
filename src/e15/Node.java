package e15;


import e1.Arista;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Edge> amigos;
    private int id;
    private String name;
    private String nationality;
    private String age;
    private String work;
    private String relationship;

    public List<Edge> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Edge> edges) {
        this.amigos = edges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Node(int id, String name, String nationality, String age, String work, String relationship) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.work = work;
        this.relationship = relationship;
    }


    public Node() {
        this.amigos = new ArrayList<Edge>();
    }

    public Node(int id, ArrayList<Edge> edges) {
        this.id = id;
        this.amigos = edges;
    }

    public void addEdges(Edge edge) {

        if (amigos == null) {
            amigos = new ArrayList<>();
        }
        amigos.add(edge);
    }

    public String show() {
        return "Id Node :" + this.id + ", edges:" + this.amigos.toString();
    }


}



