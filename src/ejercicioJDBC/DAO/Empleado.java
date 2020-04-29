package ejercicioJDBC.DAO;

import java.util.List;

public class Empleado {
    private int codigo;
    private int dni ;
    private int nss ;
    private String nombre;
    private String apellido;
    private String categoria;
    private String centralSindical;
    private String agencia;
    private String ciudad;
    private List<Titulo> titulo ;
    private int telefono;
    private Prestamo prestamo;

    public Empleado() {
    }

    public Empleado(int codigo, int dni, int nss, String nombre, String apellido, String categoria, String centralSindical, String agencia, String ciudad , List<Titulo> titulo) {
        this.codigo = codigo;
        this.dni = dni;
        this.nss = nss;
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoria = categoria;
        this.centralSindical = centralSindical;
        this.agencia = agencia;
        this.ciudad = ciudad;
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCentralSindical() {
        return centralSindical;
    }

    public void setCentralSindical(String centralSindical) {
        this.centralSindical = centralSindical;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Titulo> getTitulo() {
        return titulo;
    }

    public void setTitulo(List<Titulo> titulo) {
        this.titulo = titulo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public String toString(){
        return " codigo  " + this.codigo + " dni  " + this.dni + " nss  " + this.nss + " nombre : " + this.nombre + " apellido  " + this.apellido;
    }
}
