package e1;


public  class TestGrafo {

    public static Grafo  grafo() {
        Nodo nodo1 = new Nodo(1);
        Nodo nodo2 = new Nodo(2);
        Nodo nodo3 = new Nodo(3);
        Nodo nodo4 = new Nodo(4);

        /*
        nodo1.agregarArista(new Arista(1,nodo2,nodo1));
        nodo2.agregarArista(new Arista(2,nodo4,nodo2));
        nodo3.agregarArista(new Arista(3,nodo1,nodo3));
        nodo4.agregarArista(new Arista(4,nodo3,nodo4));

         */

        Grafo grafo1 = new Grafo();
        grafo1.conectarNodos(nodo1,nodo2);
        grafo1.addNodos(nodo1);
        grafo1.addNodos(nodo2);
        grafo1.addNodos(nodo3);
        grafo1.addNodos(nodo4);

        return grafo1;
    }

    public static void main(String[] args) {

        Grafo grafo = grafo();
        System.out.println(grafo);



    }

}
