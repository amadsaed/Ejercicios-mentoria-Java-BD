package e1;

public class Arista {

    private int id ;

    private Nodo NodoDestino ;


    public Arista() {
    }

    public Arista(int id) {
        this.id = id;
    }

    public Arista(Nodo nodoDestino) {
        this.NodoDestino = nodoDestino;
    }


    public Arista(int id, Nodo idNodoDestino ) {
        this.id= id;
        this.NodoDestino= idNodoDestino;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nodo getIdNodoDestino() {
        return NodoDestino;
    }

    public void setIdNodoDestino(Nodo idNodoDestino) {
        this.NodoDestino = idNodoDestino;
    }

    public String toString(){
        return "Id Arista :" + this.id+ "Id Nodo Destino :"+ this.NodoDestino.getId();
    }


}
