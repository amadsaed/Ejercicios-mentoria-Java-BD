package ejercicioJDBC.DAO;

import java.sql.*;

public class MySQLEmpleadoDAO implements DAO <Empleado , Integer>{


    private static final String INSERT = "INSERT INTO empleado (codigo,dni,nss,nombre,apellido,categoria,centralSindical,agencia,ciudad) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM empleado WHERE codigo= ?";
    private static final String SELECT ="SELECT * FROM empleado WHERE codigo=?";
    private static final String UPDATE = "UPDATE empleado SET dni=?, nss=? , nombre=?, apellido=?, categoria=?,centralSindical=?,agencia=?,ciudad=? WHERE codigo=?";


    @Override
    public boolean crear(Empleado e) throws NotFoundException, NoConnectionException {
    Connection connection = null;
    try {
        connection = MySQLDAOFactory.createConnection();
        PreparedStatement prst = connection.prepareStatement(INSERT);
        prst.setInt(1, e.getCodigo());
        prst.setInt(2, e.getDni());
        prst.setInt(3,e.getNss());
        prst.setString(4,e.getNombre());
        prst.setString(5, e.getApellido());
        prst.setString(6 ,e.getCategoria());
        prst.setString(7, e.getCentralSindical());
        prst.setString(8, e.getAgencia());
        prst.setString(9,e.getCiudad());
        return prst.executeUpdate()>0;
    } catch (SQLException ex) {
        throw new NotFoundException("error en la base de datos ", ex);
        //ex.printStackTrace();
    }finally {
        try {
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException ex) {
            throw new NoConnectionException("error en la base de datos ", ex);
        }
    }

    }

    @Override
    public boolean eliminar(Integer codigo) throws NotFoundException , NoConnectionException{
        Connection connection=null;
        try {
            connection = MySQLDAOFactory.createConnection();
            PreparedStatement prst = connection.prepareStatement(DELETE);
            prst.setInt(1, codigo);
            return prst.executeUpdate()>0;
            /*if (!exito){
                System.out.println("no se eliminó el empleado con el codigo "+ codigo);
            }
             */
        } catch (SQLException e) {
            throw new NotFoundException("error en la base de datos ", e);
            //e.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new NoConnectionException("error en la base de datos ", ex);
            }
        }
    }

    @Override
    public Empleado consultarPorClavePrimaria(Integer codigo) throws NotFoundException, NoConnectionException  {
        Connection connection= null;
        Empleado empleado = new Empleado();
        try {
            connection = MySQLDAOFactory.createConnection();        PreparedStatement prst = connection.prepareStatement(SELECT);
        prst.setInt(1 ,codigo);
        ResultSet rs = prst.executeQuery();
        if (rs.next()){
            empleado.setCodigo(rs.getInt("codigo"));
            empleado.setDni(rs.getInt("dni"));
            empleado.setNss(rs.getInt("nss"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setCategoria(rs.getString("categoria"));
            empleado.setCentralSindical(rs.getString("centralSindical"));
            empleado.setAgencia(rs.getString("agencia"));
            empleado.setCiudad(rs.getString("ciudad"));
        }else{
            System.out.println("no se encontró el empleado");
        }
    } catch (SQLException e) {
            throw new NotFoundException("error en la base de datos ", e);

            // e.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new NoConnectionException("error en la base de datos ", ex);
                //ex.printStackTrace();
            }

        }
    return empleado;
    }

    @Override
    public boolean actualizar(Empleado e) throws NotFoundException, NoConnectionException  {
        Connection connection = null;
        try {
            connection = MySQLDAOFactory.createConnection();
            PreparedStatement prst = connection.prepareStatement(UPDATE);
            prst.setInt(1, e.getDni());
            prst.setInt(2,e.getNss());
            prst.setString(3,e.getNombre());
            prst.setString(4, e.getApellido());
            prst.setString(5,e.getCategoria());
            prst.setString(6, e.getCentralSindical());
            prst.setString(7, e.getAgencia());
            prst.setString(8,e.getCiudad());
            prst.setInt(9,e.getCodigo());
            return prst.executeUpdate()>0;
        } catch (SQLException ex) {
            throw new NotFoundException("error en la base de datos ", ex);
            //ex.printStackTrace();
        }finally {
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new NoConnectionException("error en la base de datos ", ex);
                // ex.printStackTrace();
            }
        }
    }
}
