package e1;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {

    public ArrayList<Nodo> nodos ;

    public int  idArista ;




    public Grafo() {
        this.nodos = new ArrayList<Nodo>();
        this.idArista=0;
    }

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    public void addNodos (Nodo nodo){

        nodos.add(nodo);

    }

    public void conectarNodos (Nodo nodoOrigen  , Nodo nodoDestino) {

        if (nodos != null) {

            Arista arista = new Arista(this.idArista , nodoDestino);
            nodoOrigen.agregarArista(arista);
            this.idArista++;
        }

    }

    public void busquedaAmplitud(Nodo nodoPrimero){
        int idNextNodo = 0;
        Queue<Nodo> colaNodos = new LinkedList<Nodo>();
        Nodo nodo;
        Grafo grafo = new Grafo();
        colaNodos.add(nodoPrimero);
        nodoPrimero.setVisitado(true);
        Nodo actual;
        int i ;
        Nodo next ;
        while (!colaNodos.isEmpty()){
            actual= colaNodos.poll();
            if(!actual.getVisitado()){
                actual.setVisitado(true);
            }
            System.out.println("Nodo actual: " + actual.getName());
            for (i=0 ; i<actual.getAristas().size(); i++){
                idNextNodo = actual.getAristas().get(i).getIdNodoDestino().getId();
                next = this.nodos.get(idNextNodo-1);// nodo con id next de arista
                System.out.println("Nodo a visitar: " + next.getName());
                if (next.visitado== false){
                    next.setVisitado(true);
                    colaNodos.add(next);
                }
            }
        }




    }
}
