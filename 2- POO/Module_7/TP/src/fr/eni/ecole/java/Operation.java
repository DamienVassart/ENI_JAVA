package fr.eni.ecole.java;

/**
 * Classe modélisant les opérations possibles sur la calculatrice
 * @author Damien Vassart
 * @version 1.0
 *
 */
public class Operation {
	
	public static int ajouter(int val1, int val2) throws DepassementCapaciteException {
		long resLong = (long) val1 + val2;
		int resInt = val1 + val2;
		if(resLong != resInt)
			throw new DepassementCapaciteException();
		return resInt;
	}
	
	public static int soustraire(int val1, int val2) throws DepassementCapaciteException {
		long resLong = (long) val1 - val2;
		int resInt = val1 - val2;
		if(resLong != resInt)
			throw new DepassementCapaciteException();
		return resInt;
	}
	
	public static int multiplier(int val1, int val2) throws DepassementCapaciteException {
		long resLong = (long) val1 * val2;
		int resInt = val1 * val2;
		if(resLong != resInt)
			throw new DepassementCapaciteException();
		return resInt;
	}
}
