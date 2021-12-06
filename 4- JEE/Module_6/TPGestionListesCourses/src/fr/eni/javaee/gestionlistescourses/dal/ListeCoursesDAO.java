package fr.eni.javaee.gestionlistescourses.dal;

import java.util.List;

import fr.eni.javaee.gestionlistescourses.BusinessException;
import fr.eni.javaee.gestionlistescourses.bo.ListeCourses;

public interface ListeCoursesDAO {
	public void insert(ListeCourses listeCourses) throws BusinessException;
	
	public void delete(int id) throws BusinessException;
	
	public List<ListeCourses> selectAll() throws BusinessException;
	
	public ListeCourses selectById(int id) throws BusinessException;
	
	public void deleteArticle(int idArticle) throws BusinessException;
	
	public void checkArticle(int idArticle) throws BusinessException;
	
	public void uncheckArticle(int idArticle) throws BusinessException;
}
