import java.util.concurrent.LinkedBlockingDeque;

public class Sentence {

	private String currSent;

	/** Constructs a new Sentence object. */
	public Sentence(String p) {
		currSent = p;
	}

	/** Returns a string containing the current sentence. */
	public String toString() {
		return currSent;
	}
	


	/** Returns the index of the nth occurrence of str in the current sencence;
	 * returns -1 of the nth occurrence does not exist.
	 * Precondition:  str.length() > 0 and n > 0
	 * Postcondition: the current sentence if not modified.
	 */
	public int findNthTime(String str, int n) {
		int a = 0;
		if (!currSent.contains(str)){
			return -1;
		}
		for (int i = 0; i < n; i++) {
			a = currSent.indexOf(str, a + 1);
			if (a < 0){
				return -1;
			}
		}
		return a;
	}
/*
	*//** Modifies the current sentence by replacing the nth occurrence of str with repl
	 * If the nth occurrence does not exist, the current sentence is unchanged.
	 * Precondition: str.length() > 0 and n > 0
	 *
	 */
	public void replaceNthTime(String str, int n, String repl) {
		int x = findNthTime(str, n);
		String s1 = currSent, s2;
		if (x >= 0){
			s1 = currSent.substring(0, x);
			s1 += repl;
			s2 = currSent.substring(x + str.length());
			s1 += s2;
		}
		System.out.println(s1);
	}
/*
	*//** Returns the index of the last occurrence of str in the current sentence:
	 * returns -1 if str is not found.
	 * Precondition:  str.length() > 0
	 * Postcondition: the current sentence is not modified.
	 */
	public int findLastTime(String str) {
		// part c - you must call findNthTime here *//*
		int x = 0, a = 1;
		while (a != 0){
			a = currSent.indexOf(str, a + 1);
			if (a < 0){
				return -1;
			}
			x =a;
		}
		int n = findNthTime(str, x);
		return n;
	}

	public static void main(String[] args) {
		Sentence sentence1 = new Sentence("A cat ate late.");
		System.out.println(sentence1.findNthTime("at",1));
		sentence1.replaceNthTime("at", 1, "rane");
		System.out.println(sentence1);

		Sentence sentence2 = new Sentence("A cat ate late.");
		System.out.println(sentence2.findNthTime("at",6));
		sentence2.replaceNthTime("at", 6, "xx");
		System.out.println(sentence2);

		Sentence sentence7 = new Sentence("A cat ate late.");
		System.out.println(sentence7.findNthTime("at",3));
		sentence7.replaceNthTime("at", 3, "xx");
		System.out.println(sentence7);

		Sentence sentence3 = new Sentence("A cat ate late.");
		System.out.println(sentence3.findNthTime("bat",2));
		sentence3.replaceNthTime("bat", 2, "xx");
		System.out.println(sentence3);

		Sentence sentence4 = new Sentence("aaaa");
		sentence4.replaceNthTime("aa", 1, "xx");
		System.out.println(sentence4);

		Sentence sentence5 = new Sentence("aaaa");
		sentence5.replaceNthTime("aa", 2, "bbb");
		System.out.println(sentence5);

		Sentence sentence6 = new Sentence("A cat ate late.");
		System.out.println(sentence6.findLastTime("at"));
		System.out.println(sentence6.findLastTime("cat"));
		System.out.println(sentence6.findLastTime("bat"));
	}


}
