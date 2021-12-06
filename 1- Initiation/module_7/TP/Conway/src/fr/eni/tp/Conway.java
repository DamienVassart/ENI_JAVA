package fr.eni.tp;

public class Conway {
	
	public static String nextMember(String s) {
		StringBuffer r;
		r = new StringBuffer("");
		String[] splitted = s.split("");
		for(int i = 0; i < splitted.length; i++) {
			int count = 1;
			int j = i + 1;
			while(j < splitted.length && splitted[i].equals(splitted[j])) {
				count++;
				i++;
				j++;
			}
			r.append(String.valueOf(count) + splitted[i]);
		}
		return r.toString();
	}
	
	public static void printSequence(int depth) {
		String member = "1", sequence = "";
		int i = 0;
		while(i++ < depth) {
			member = nextMember(member);
			sequence += member + "\n";
		}
		System.out.println(sequence);
	}

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		printSequence(40);
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
