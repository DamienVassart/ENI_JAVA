package fr.eni.javaee.gestionlistescourses.dal;

public abstract class DAOFactory {
	public static ListeCoursesDAO getListeCoursesDAO() {
		return new ListeCoursesDAOJdbcImpl();
	}
}
