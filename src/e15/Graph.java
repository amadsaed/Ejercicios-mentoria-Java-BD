package e15;

import e1.Arista;
import e1.Nodo;

import java.util.*;

public class Graph {

    public List<Node> nodes ;

    public int edgeId ;

    public Graph() {
        this.nodes = new ArrayList<Node>();
        this.edgeId=0;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNodes (Node node){

        nodes.add(node);
    }

    public void connectNodes( int idNodeOrigin, int idNodeDestination){
        Node nodeOrigin = getNode(idNodeOrigin);
        Node nodeDestination = getNode(idNodeDestination);
        connectNode(nodeOrigin , nodeDestination);
    }

    public void connectNode (Node nodeOrigin , Node nodeDestination) {

        if (nodes != null) {
            if (nodeOrigin!=null && nodeDestination!=null) {
                Edge edge = new Edge(this.edgeId, nodeDestination);
                this.edgeId++;
                Edge edge2 = new Edge(this.edgeId, nodeOrigin);
                this.edgeId++;
                nodeDestination.addEdges(edge2);
                nodeOrigin.addEdges(edge);
            }
        }

    }

    public  Node getNode(int idNode){

        Node node= null;

        for (int i =0 ; i<nodes.size() ; i++){

            if (nodes.get(i).getId()==idNode){
               node= nodes.get(i) ;
               break;
            }
        }
        return node;
   }

    public  Node getNodeByName(String name){

        Node node= null;

        for (int i =0 ; i<nodes.size() ; i++){

            if (nodes.get(i).getName().equals(name)){
                node= nodes.get(i) ;
                break;
            }
        }
        return node;
    }

    public Node searchAmplitude(String name ,int firstId) throws NotFoundUserException {

        int idNextNode = 0;

        Queue<Node> nodesQueue = new LinkedList<Node>();

        Map<Integer, Node> visitedNodesMap = new HashMap();

        Node firstNode = getNode(firstId);

        if (firstNode==null){
            throw new NotFoundUserException(firstId +  " not found");
        }
        nodesQueue.add(firstNode);

        Node nodeActual ;

        int i;

        Node nodeNext;

        while (!nodesQueue.isEmpty()) {

            nodeActual = nodesQueue.poll();

            if (!visitedNodesMap.containsKey(nodeActual.getId())) {

                visitedNodesMap.put(nodeActual.getId(), nodeActual);

               // System.out.println("searched name: " + nodeActual.getName() + "   id    " + nodeActual.getId() + "   age   "+ nodeActual.getAge() );

                if (nodeActual.getName().equals(name)){
                    return nodeActual;

                }

                for (i = 0; i < nodeActual.getAmigos().size(); i++) {

                    idNextNode = nodeActual.getAmigos().get(i).getNodeDestination().getId();

                    nodeNext = this.nodes.get(idNextNode);// node with next id of amigos

                    nodesQueue.add(nodeNext);

                }

            }


        }
        throw new  NotFoundUserException(name + " not found");
    }

    public void showGraph( int firstNodeId){

        int idNextNode = 0;

        Queue<Node> nodesQueue = new LinkedList<Node>();

        Map<Integer, Node> visitedNodesMap = new HashMap();
        Node firstNode =getNode(firstNodeId);
        nodesQueue.add(firstNode);

        Node nodeActual ;

        int i;

        Node nodeNext;

        while (!nodesQueue.isEmpty()) {

            nodeActual = nodesQueue.poll();

            if (!visitedNodesMap.containsKey(nodeActual.getId())) {

                visitedNodesMap.put(nodeActual.getId(), nodeActual);

                System.out.println("actual user: " + nodeActual.getName() + "   id" +" "+ nodeActual.getId() );

                for (i = 0; i < nodeActual.getAmigos().size(); i++) {

                    idNextNode = nodeActual.getAmigos().get(i).getNodeDestination().getId();

                    nodeNext = this.nodes.get(idNextNode);// node con id next de arista

                    nodesQueue.add(nodeNext);

                }

            }else {

                System.out.println(nodeActual.getName() + " it has been showed!");
            }


        }

    }


}