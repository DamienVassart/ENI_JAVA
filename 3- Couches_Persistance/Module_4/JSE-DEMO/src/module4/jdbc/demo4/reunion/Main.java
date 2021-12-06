package module4.jdbc.demo4.reunion;

import java.util.List;

import module4.jdbc.demo4.reunion.bo.Stagiaire;
import module4.jdbc.demo4.reunion.dal.DALException;
import module4.jdbc.demo4.reunion.dal.StagiaireDAOJdbcImpl;

public class Main {

	public static void main(String[] args) {
		try {
			StagiaireDAOJdbcImpl dao = new StagiaireDAOJdbcImpl();
			
			//dao.insert(new Stagiaire(null, "Jean-Marie", "Bigard", "jmbigard@mail.com", "123456"));
			
			List<Stagiaire> listeStagiaires = dao.selectAll();
			
			for(Stagiaire stagiaire : listeStagiaires) {
				System.out.println(stagiaire);
			}
		} catch (DALException ex) {
			ex.printStackTrace();
		}
	}

}
