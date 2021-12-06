package fr.eni.demoJdbc.dal;

import fr.eni.demoJdbc.dal.jdbc.StagiaireDAOJdbcImpl;

public class Factory {
	public static StagiaireDAO getStagiaireDAO() {
		return new StagiaireDAOJdbcImpl();
	}
}
