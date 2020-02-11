package e1;


public  class TestGrafo {


    public static void main(String[] args) {

        Nodo nodo1 = new Nodo(1, "www.facebook.com");
        Nodo nodo2 = new Nodo(2 ,"www.google.com");
        Nodo nodo3 = new Nodo(3 , "www.github.com");
        Nodo nodo4 = new Nodo(4 , "www.instagram.com");
        Nodo nodo5 = new Nodo(5 , "www.twiter.com");
        Nodo nodo6 = new Nodo(6 , "www.yahoo.com");


        /*
        nodo1.agregarArista(new Arista(1,nodo2,nodo1));
        nodo2.agregarArista(new Arista(2,nodo4,nodo2));
        nodo3.agregarArista(new Arista(3,nodo1,nodo3));
        nodo4.agregarArista(new Arista(4,nodo3,nodo4));

         */

        Grafo grafo1 = new Grafo();

        grafo1.addNodos(nodo1);
        grafo1.addNodos(nodo2);
        grafo1.addNodos(nodo3);
        grafo1.addNodos(nodo4);
        grafo1.addNodos(nodo5);
        grafo1.addNodos(nodo6);



        grafo1.conectarNodos(nodo1,nodo2);
        grafo1.conectarNodos(nodo2,nodo4);
        grafo1.conectarNodos(nodo4,nodo3);
        grafo1.conectarNodos(nodo3,nodo1);
        grafo1.conectarNodos(nodo2,nodo1);
        grafo1.conectarNodos(nodo2,nodo5);
        grafo1.conectarNodos(nodo5,nodo6);
        grafo1.conectarNodos(nodo6,nodo3);
        grafo1.conectarNodos(nodo3,nodo6);
        grafo1.conectarNodos(nodo3,nodo5);
        grafo1.conectarNodos(nodo5,nodo1);





/*
        for (Nodo n : grafo1.getNodos()){
            System.out.println(n.muestrar());
        }

 */

        grafo1.busquedaAmplitud(nodo1);

        System.out.println("============================================================================");
        grafo1.busquedaPofundidad(nodo1);

    }

}
