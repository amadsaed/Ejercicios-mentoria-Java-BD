package ejercicioOtraVez.DAO;

import ejercicioOtraVez.Sandwich;

import static ejercicioOtraVez.DAO.DAOFactory.MYSQL;

public class app {
    public static void main(String[] args) {
        DAO<Sandwich,Integer> sandwichDAO;
        DAOFactory factory= DAOFactory.getDAOFactory(MYSQL);
        sandwichDAO = factory.getSandwichDAO();
        System.out.println(sandwichDAO.getSandwichByID(1).toString());

    }
}
