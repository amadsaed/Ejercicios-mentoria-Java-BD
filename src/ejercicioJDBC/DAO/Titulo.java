package ejercicioJDBC.DAO;

public class Titulo {
    private int id_titulo ;
    private String nombre_titulo;

    public Titulo() {
    }

    public Titulo(String nombre_titulo) {
        this.nombre_titulo = nombre_titulo;
    }

    public Titulo(int id_titulo, String nombre_titulo) {
        this.id_titulo = id_titulo;
        this.nombre_titulo = nombre_titulo;
    }

    public int getId_titulo() {
        return id_titulo;
    }

    public void setId_titulo(int id_titulo) {
        this.id_titulo = id_titulo;
    }

    public String getNombre_titulo() {
        return nombre_titulo;
    }

    public void setNombre_titulo(String nombre_titulo) {
        this.nombre_titulo = nombre_titulo;
    }
}
