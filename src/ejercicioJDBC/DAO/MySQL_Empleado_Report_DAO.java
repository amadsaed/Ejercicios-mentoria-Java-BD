package ejercicioJDBC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQL_Empleado_Report_DAO implements Report_DAO< Empleado , Integer> {

    private static final String EDUCACION = "SELECT e.nombre , t.nombre_titulo FROM empleado e \n" +
                                            "INNER JOIN empleado_titulo et ON e.codigo=et.codigo_empleado\n" +
                                            "INNER JOIN titulo t ON t.id_titulo=et.id_titulo WHERE e.codigo= ? ";


    private static final String TRABAJO = " SELECT e.nombre , a.nombre_agencia , a.nro_telefono , c.nombre_ciudad FROM empleado e , agencia a , ciudad c" +
                                            " WHERE e.agencia=a.nombre_agencia AND e.ciudad=c.nombre_ciudad AND e.codigo=? ";

    private static final String PRESTAMO = "SELECT e.CODIGO, e.NOMBRE , p.id_prestamo FROM empleado e INNER JOIN empleado_prestamo ep \n" +
                                            "ON e.CODIGO = ep.codigo INNER JOIN prestamo p ON ep.tipo = p.tipo WHERE p.tipo = ?";

    // Mostrar el nombre de los empleados Y el nombre de su titulo
    @Override
    public Empleado consultarEducacion(Integer codigo) throws DataBaseException, NotFoundException {
        Connection connection= null;
        Empleado empleado = new Empleado();
        try {
            connection = Empleado_DAO_Factory.createConnection();
            PreparedStatement prst = connection.prepareStatement(EDUCACION);
            prst.setInt(1 ,codigo);
            ResultSet rs = prst.executeQuery();
            if (rs.next()){
                empleado.setNombre(rs.getString("nombre"));
                List<Titulo> titulos = new ArrayList<>();
                do {
                    titulos.add(new Titulo(rs.getString("nombre_titulo")));
                }while (rs.next());
                empleado.setTitulo(titulos);
            }else{
                throw new NotFoundException("error en la base de datos ");
            }
        } catch (SQLException | NotFoundException e) {
            throw new DataBaseException("error en la base de datos ", e);
        }finally {
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new DataBaseException("error en la base de datos ", ex);
            }

        }
        return empleado;
    }


    //Mostrar el nombre de los empleados Y el nombre de su agencia y su numero de telefono y
    // la cantidad de habitantes de la ciudad donde se ubica
    @Override
    public Empleado consultarTrabajo( Integer codigo) throws DataBaseException , NotFoundException{
        Connection connection= null;
        Empleado empleado = new Empleado();
        try {
            connection = Empleado_DAO_Factory.createConnection();
            PreparedStatement prst = connection.prepareStatement(TRABAJO);
            prst.setInt(1 ,codigo);
            ResultSet rs = prst.executeQuery();
            if (rs.next()){
                empleado.setNombre(rs.getString("nombre"));
                empleado.setAgencia(rs.getString("nombre_agencia"));
                empleado.setTelefono(rs.getInt("nro_telefono"));
                empleado.setCiudad(rs.getString("nombre_ciudad"));
            }else{
                throw new NotFoundException("error en la base de datos ");
            }
        } catch (SQLException | NotFoundException e) {
            throw new DataBaseException("error en la base de datos ", e);
        }finally {
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new DataBaseException("error en la base de datos ", ex);
            }

        }
        return empleado;    }


    //
    @Override
    public Empleado consultarPrestamo(Empleado e) throws DataBaseException, NotFoundException {
        Connection connection = null;
        Empleado empleado = new Empleado();
        try {
            connection = Empleado_DAO_Factory.createConnection();
            PreparedStatement prst = connection.prepareStatement(PRESTAMO);
            prst.setString(1, e.getPrestamo().getTipo());
            ResultSet rs = prst.executeQuery();
            if (rs.next()){
                Prestamo prestamo = new Prestamo();
                empleado.setCodigo(rs.getInt("codigo"));
                empleado.setNombre(rs.getString("nombre"));
                prestamo.setId_prestamo(rs.getInt("id_prestamo"));
                empleado.setPrestamo(prestamo);
            }else{
                throw new NotFoundException("error en la base de datos ");
            }
        } catch (SQLException ex) {
            throw new DataBaseException("error en la base de datos ", ex);
            //ex.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new DataBaseException("error en la base de datos ", ex);
            }
        }
        return empleado;
    }

}

