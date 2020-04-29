package ejercicioJDBC.DAO;

public class Prestamo {
    private int id_prestamo ;
    private String tipo ;
    private String tipo_interes;
    private int periedo_vigencia;

    public Prestamo() {
    }

    public Prestamo(int id_prestamo, String tipo, String tipo_interes, int periedo_vigencia) {
        this.id_prestamo = id_prestamo;
        this.tipo = tipo;
        this.tipo_interes = tipo_interes;
        this.periedo_vigencia = periedo_vigencia;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo_interes() {
        return tipo_interes;
    }

    public void setTipo_interes(String tipo_interes) {
        this.tipo_interes = tipo_interes;
    }

    public int getPeriedo_vigencia() {
        return periedo_vigencia;
    }

    public void setPeriedo_vigencia(int periedo_vigencia) {
        this.periedo_vigencia = periedo_vigencia;
    }
}
