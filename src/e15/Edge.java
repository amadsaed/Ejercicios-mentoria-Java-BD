package e15;

import e1.Nodo;

public class Edge {

    private int id ;

    private Node nodeDestination ;


    public Edge() {
    }

    public Edge(int id) {
        this.id = id;
    }

    public Edge(Node nodeDestination) {
        this.nodeDestination = nodeDestination;
    }


    public Edge(int id, Node nodeDestination ) {
        this.id= id;
        this.nodeDestination= nodeDestination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getNodeDestination() {
        return nodeDestination;
    }

    public void setNodeDestination(Node nodeDestination) {
        this.nodeDestination = nodeDestination;
    }

    public String toString(){
        return "Id Arista :" + this.id+ "Id Nodo Destino :"+ this.nodeDestination.getId();
    }


}
