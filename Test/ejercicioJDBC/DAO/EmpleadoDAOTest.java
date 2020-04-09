package ejercicioJDBC.DAO;

import org.junit.BeforeClass;
import org.junit.Test;
import static ejercicioJDBC.DAO.DAOFactory.MYSQL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmpleadoDAOTest {
    private static DAO<Empleado,Integer> mySQLEmpleadoDAO;

    @BeforeClass
    public static void configurarTest(){
        DAOFactory factory= DAOFactory.getDAOFactory(MYSQL);
        mySQLEmpleadoDAO = factory.getEmpleadoDAO();
    }

    @Test
    public void consultaPorCodigoTest() throws NotFoundException, NoConnectionException {

        Empleado empleado = mySQLEmpleadoDAO.consultarPorClavePrimaria(2);
        System.out.println(empleado.toString());
        assertEquals(2,empleado.getCodigo());
    }

    @Test
    public void crearEmpleadoTest() throws NotFoundException, NoConnectionException {
        Empleado empleado = new Empleado(5,555,66,"hana","saed","c","q","prokarma","CABA");
       assertTrue(mySQLEmpleadoDAO.crear(empleado));
    }

    @Test
    public void eliminarEmpleadoTest() throws NotFoundException, NoConnectionException {
       assertTrue(mySQLEmpleadoDAO.eliminar(5));
    }

    @Test
    public void actualizarEmpleadoTest() throws NotFoundException, NoConnectionException{
        Empleado empleado = new Empleado(5,555,66,"hana","saed","c","q","prokarma","CORDOBA");
        assertTrue(mySQLEmpleadoDAO.actualizar(empleado));
    }
}
