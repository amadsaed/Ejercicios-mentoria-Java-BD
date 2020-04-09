package ejercicioJDBC.DAO;

public class Agencia {
    private String nombre;
    private int nro_telefono;
    private String direccion;
    private String nombre_ciudad;

    public Agencia() {
    }

    public Agencia(String nombre, int nro_telefono, String direccion, String nombre_ciudad) {
        this.nombre = nombre;
        this.nro_telefono = nro_telefono;
        this.direccion = direccion;
        this.nombre_ciudad = nombre_ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNro_telefono() {
        return nro_telefono;
    }

    public void setNro_telefono(int nro_telefono) {
        this.nro_telefono = nro_telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }
}
