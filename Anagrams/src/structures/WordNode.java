package structures;

public class WordNode {
	
	String word;
	long index;
	WordNode next;
	
	public WordNode(String s) {
		word = s;
		long index = 1;
		int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
				  		31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
				  		73, 79, 83, 89, 97, 101, 103};
		
		//Assigns a specific prime number to each character and multiplies the value 
		//of every character in a word together to make an index
		for(int i = 0; i < s.length(); i++) {
			index = index * primes[(((int) s.charAt(i)) - 97)];
		}
		
		this.index = index;
	}
	
	public String getWord() {
		return word;
	}
	
	public long getIndex() {
		return index;
	}
	
	public WordNode getNext() {
		return next;
	}
	
	public void setNext(WordNode w) {
		next = w;
	}
	
}
