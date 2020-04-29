package ejercicioJDBC.DAO;

import org.junit.BeforeClass;
import org.junit.Test;
import static ejercicioJDBC.DAO.DAOFactory.MYSQL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmpleadoDAOTest {

    private static ModificationDAO<Empleado,Integer> mySQLEmpleadoModificationDAO;

    @BeforeClass
    public static void configurarTest(){
        DAOFactory factory= DAOFactory.getDAOFactory(MYSQL);
        mySQLEmpleadoModificationDAO = factory.getEmpleadoDAO();
    }

    @Test
    public void consultaPorCodigoTest() throws NotFoundException, DataBaseException {

        Empleado empleado = mySQLEmpleadoModificationDAO.consultarPorClavePrimaria(2);
        System.out.println(empleado.toString());
        assertEquals(2,empleado.getCodigo());
    }

    @Test
    public void crearEmpleadoTest() throws NotFoundException, DataBaseException {
        Empleado empleado = new Empleado(5,555,66,"hana","saed","c","q","prokarma","CABA");
       assertTrue(mySQLEmpleadoModificationDAO.crear(empleado));
    }

    @Test
    public void eliminarEmpleadoTest() throws NotFoundException, DataBaseException {
       assertTrue(mySQLEmpleadoModificationDAO.eliminar(5));
    }

    @Test
    public void actualizarEmpleadoTest() throws NotFoundException, DataBaseException {
        Empleado empleado = new Empleado(5,555,66,"hana","saed","c","q","prokarma","CORDOBA");
        assertTrue(mySQLEmpleadoModificationDAO.actualizar(empleado));
    }
}
