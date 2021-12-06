package fr.eni.tp;

public class SissaChessboard {
	static final int CHESSBOARD_CASES = 64;
	
	public static float computeGrains(int n) {
		float grainsOnCase = 1f;
		float totalGrains = grainsOnCase;
		for(int i = 0; i < n; i++) {
			grainsOnCase *= 2;
			totalGrains += grainsOnCase;
		}
		return totalGrains;
	}
	
	public static void main(String[] args) {
		float grains = computeGrains(CHESSBOARD_CASES);
		System.out.println("Nombre de grains de riz: " + grains);
	}

}
