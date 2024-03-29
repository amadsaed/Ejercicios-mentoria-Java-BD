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
            this.idArista++;
            Arista arista2 = new Arista(this.idArista , nodoOrigen);
            this.idArista++;
            nodoDestino.agregarArista(arista2);
            nodoOrigen.agregarArista(arista);
        }

    }




    public void busquedaAmplitud(Nodo nodoPrimero) {

        int idNextNodo = 0;

        Queue<Nodo> colaNodos = new LinkedList<Nodo>();

        Nodo nodo;

        Grafo grafo = new Grafo();

        Map<Integer, Nodo> mapaNodosVisitados = new HashMap();

        colaNodos.add(nodoPrimero);

        Nodo nodoActual ;

        int i;

        Nodo nodoNext;

        while (!colaNodos.isEmpty()) {

            nodoActual = colaNodos.poll();

            if (!mapaNodosVisitados.containsKey(nodoActual.getId())) {

                mapaNodosVisitados.put(nodoActual.getId(), nodoActual);

                System.out.println("Nodo actual: " + nodoActual.getName() + "   id" +" "+ nodoActual.getId() );

                for (i = 0; i < nodoActual.getAristas().size(); i++) {

                    idNextNodo = nodoActual.getAristas().get(i).getIdNodoDestino().getId();

                    nodoNext = this.nodos.get(idNextNodo -1);// nodo con id next de arista

                    colaNodos.add(nodoNext);

                }

            }else {

                System.out.println(nodoActual.getName() + " fue visitado !");
            }


        }

    }


    public void busquedaProfundidad(Nodo nodoPrimero) {

        int idNextNodo = 0;

        Stack<Nodo> pilaNodos = new Stack<>();

        Nodo nodo;

        Grafo grafo = new Grafo();

        Map<Integer, Nodo> mapaNodosVisitados = new HashMap();

        pilaNodos.push(nodoPrimero);


        Nodo nodoActual ;

        int i;

        Nodo nodoNext;

        while (!pilaNodos.isEmpty()) {

            nodoActual = pilaNodos.pop();

            if (!mapaNodosVisitados.containsKey(nodoActual.getId())) {

                mapaNodosVisitados.put(nodoActual.getId(), nodoActual);

                System.out.println("Nodo actual: " + nodoActual.getName());

                for (i = 0; i < nodoActual.getAristas().size(); i++) {

                    idNextNodo = nodoActual.getAristas().get(i).getIdNodoDestino().getId();

                    nodoNext = this.nodos.get(idNextNodo -1);// nodo con id next de arista

                  //  System.out.println("Nodo a visitar: " + nodoNext.getName());

                    pilaNodos.push(nodoNext);

                }

            }else {

                System.out.println(nodoActual.getName() + " fue visitado !");
            }

        }

    }

}

