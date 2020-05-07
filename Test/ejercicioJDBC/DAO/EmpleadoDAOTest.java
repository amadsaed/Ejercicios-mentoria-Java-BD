package ejercicioJDBC.DAO;

import org.junit.BeforeClass;
import org.junit.Test;
import static ejercicioJDBC.DAO.DAO_Factory.MYSQL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmpleadoDAOTest {

    private static Modification_DAO<Empleado,Integer> mySQLEmpleadoModificationDAO;

    @BeforeClass
    public static void configurarTest(){
        DAO_Factory factory= DAO_Factory.getDAOFactory(MYSQL);
        mySQLEmpleadoModificationDAO = factory.getEmpleadoModificationDAO ();
    }

    @Test
    public void consultaPorCodigoTest() throws NotFoundException, DataBaseException {

        Empleado empleado = mySQLEmpleadoModificationDAO.consultarPorClavePrimaria(2);
        System.out.println(empleado.toString());
        assertEquals(2,empleado.getCodigo());
    }

    @Test
    public void crearEmpleadoTest() throws NotFoundException, DataBaseException {
        Empleado empleado = new Empleado(5,555,66,"hana","saed","c","q","prokarma","CABA",null);
       assertTrue(mySQLEmpleadoModificationDAO.crear(empleado));
    }

    @Test
    public void eliminarEmpleadoTest() throws NotFoundException, DataBaseException {
       assertTrue(mySQLEmpleadoModificationDAO.eliminar(5));
    }

    @Test
    public void actualizarEmpleadoTest() throws NotFoundException, DataBaseException {
        Empleado empleado = new Empleado(5,555,66,"hana","saed","c","q","prokarma","CORDOBA", null);
        assertTrue(mySQLEmpleadoModificationDAO.actualizar(empleado));
    }
}
