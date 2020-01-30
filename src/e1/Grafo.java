package e1;


import java.util.ArrayList;

public class Grafo {

    private ArrayList<Nodo> nodos ;

    public Grafo() {
    }

    public Grafo(ArrayList<Nodo> nodos) {
        this.nodos = nodos;
    }

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    public void addNodos (Nodo nodo){
        if(nodos==null){
            nodos= new ArrayList<>();
        }
        nodos.add(nodo);

    }

    public void conectarNodos (Nodo nodoOrigen  ,Nodo nodoDestino){
        //chequear//

        Arista arista = new Arista(nodoDestino);
        nodoOrigen.agregarArista(arista);

    }

}
