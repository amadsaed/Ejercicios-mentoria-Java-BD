package e1;


import java.util.ArrayList;

public class Nodo {

    private int id ;
    private ArrayList<Arista> aristas;

    public Nodo(int id) {
        this.id = id;
    }

    public Nodo(ArrayList<Arista> aristas) {
        this.aristas = aristas;
    }

    public Nodo(int id , ArrayList<Arista> aristas) {
        this.id = id;
        this.aristas = aristas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAristas(ArrayList<Arista> aristas) {
        this.aristas = aristas;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }


    public void agregarArista (Arista arista){
        if (aristas==null){
            aristas = new ArrayList<>();
        }
        aristas.add(arista);
    }
}

