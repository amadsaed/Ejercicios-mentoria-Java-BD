package e1;


import java.util.*;

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

        Map<String, Nodo> mapaNodosVisitados = new HashMap();

        colaNodos.add(nodoPrimero);

        mapaNodosVisitados.put("0",nodoPrimero);


        Nodo nodoActual = null;

        int i ;

        Nodo nodoNext ;

        while (!colaNodos.isEmpty()){

            nodoActual= colaNodos.poll();

            }

            System.out.println("Nodo actual: " + nodoActual.getName());

            for (i=0 ; i<nodoActual.getAristas().size(); i++){

                idNextNodo = nodoActual.getAristas().get(i).getIdNodoDestino().getId();

                nodoNext = this.nodos.get(idNextNodo-1);// nodo con id next de arista

                System.out.println("Nodo a visitar: " + nodoNext.getName());

                if (nodoNext.getName() != mapaNodosVisitados.get("0").getName()){

                    mapaNodosVisitados.replace("0",nodoNext);

                    colaNodos.add(nodoNext);
                }
            }
        }




    }

