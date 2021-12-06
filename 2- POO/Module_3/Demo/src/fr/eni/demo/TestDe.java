package fr.eni.demo;

public class TestDe {

	public static void main(String[] args) {
		try {
			De monDe = new De(20);
			do {
				System.out.println("Me dé à " + monDe.getNbFaces() + " faces");
				System.out.println("Le dé est sur la face " + monDe.lancer());
			} while(monDe.getFaceTiree() != 6);
		} catch (Exception e) {
			System.err.println("Le dé n'a pas pu être créé");
		}

	}

}
