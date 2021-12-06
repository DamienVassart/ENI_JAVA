package fr.eni.demoJdbc.dal;

import java.util.List;

import fr.eni.demoJdbc.bo.Stagiaire;
//import fr.eni.demoJdbc.dal.jdbc.StagiaireDAOJdbcImpl;

public class DemoJdbcBis {

	public static void main(String[] args) {
		//StagiaireDAOJdbcImpl daoStagiaire = new StagiaireDAOJdbcImpl();
		//StagiaireDAO daoStagiaire = new StagiaireDAOJdbcImpl();
		StagiaireDAO daoStagiaire = Factory.getStagiaireDAO();
		
		List<Stagiaire> stagiaires = daoStagiaire.selectAll();
		for(Stagiaire s: stagiaires) {
			System.out.println(s);
		}
	}

}
