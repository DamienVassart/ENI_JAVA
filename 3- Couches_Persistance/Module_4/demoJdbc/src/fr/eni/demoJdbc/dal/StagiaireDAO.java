package fr.eni.demoJdbc.dal;

import java.util.List;

import fr.eni.demoJdbc.bo.Stagiaire;

public interface StagiaireDAO {
	public void insert(Stagiaire s);
	
	public void update(Stagiaire s);
	
	public Stagiaire selectById(int noStagiaire);
	
	public List<Stagiaire> selectAll();
	
	public void delete(Stagiaire s);
}
