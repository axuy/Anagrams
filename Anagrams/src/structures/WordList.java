package structures;

public class WordList { //A linked list of word objects

	WordNode head;
	WordNode tail;
	int size;
	
	public WordList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public WordNode getHead() {
		return head;
	}
	
	public int getSize() {
		return size;
	}
	
	public long getIndex() {
		return head.getIndex();
	}

	public WordList append(WordNode w) {
		if(head == null) {
			head = w;
			tail = w;
		}
		else if(size == 1) {
			head.setNext(w);
			tail = w;
		}
		else {
			tail.setNext(w);
			tail = w;
		}
		size++;
		return this;
	}
	
}
