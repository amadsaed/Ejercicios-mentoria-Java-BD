package e1;


import java.util.ArrayList;

public class Nodo {

    private int id ;
    private ArrayList<Arista> aristas;
    private String name;

    public boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado){
        this.visitado = visitado;
    }

    public boolean visitado ;

    public Nodo(int id , String name) {
        this.id = id;
        this.name=name;
    }

    public Nodo() {
        this.aristas = new ArrayList<Arista>();
    }

    public Nodo(int id , boolean visitado ,ArrayList<Arista> aristas) {
        this.id = id;
        this.visitado= false;
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
    public String muestrar(){
        return "Id Nodo :" + this.id + ", Aristas :"+ this.aristas.toString();
    }
}

