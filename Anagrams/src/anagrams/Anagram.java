package anagrams;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import structures.*;

public class Anagram {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("C:/Users/Albert/Google Drive/dict2"));
		sc.useDelimiter("\n");
		
		WordList[] table = new WordList[99131];
		while(sc.hasNext()) {					//Stores every word in a hash table
			String s = sc.next(); 
			WordNode newWord = new WordNode(s.substring(0, s.length() - 1));
			int i = (int) (newWord.getIndex() % 99131);
			if(i < 0) {
				i = i * -1;
			}
			if(table[i] == null) {
				WordList newList = new WordList();
				newList.append(newWord);
				table[i] = newList;
			}
			else {
				table[i].append(newWord);
			}
		}
		
		ArrayList<WordList> classes = new ArrayList<WordList>();
		for(int i = 0; i < 99131; i++) {		//Deal with collisions
			if(table[i] != null) {
				if(table[i].getSize() > 1) {
					WordNode curr = table[i].getHead();
					long currIndex;				//Index of current word
					ArrayList<WordList> prevIndex = new ArrayList<WordList>();	//Stores wordNodes with unique indexes
					boolean flag;
					while(curr.getNext() != null) {
						currIndex = curr.getIndex();
						flag = true;
						for(int j = 0; j < prevIndex.size(); j++) {
							if(currIndex == prevIndex.get(j).getIndex()) {
								prevIndex.get(j).append(new WordNode(curr.getWord()));
								flag = false;
								continue;
							}
						}
						if(flag) {				//new class
							WordList n = new WordList();
							n.append(new WordNode(curr.getWord()));
							prevIndex.add(n);
							classes.add(n);
						}
						curr = curr.getNext();
					}
					currIndex = curr.getIndex();
					flag = true;
					for(int j = 0; j < prevIndex.size(); j++) {
						if(currIndex == prevIndex.get(j).getIndex()) {
							prevIndex.get(j).append(new WordNode(curr.getWord()));
							flag = false;
							continue;
						}
					}
					if(flag) {
						WordList n = new WordList();
						n.append(new WordNode(curr.getWord()));
						prevIndex.add(n);
						classes.add(n);
					}
				}
				else {
					classes.add(table[i]);
				}
			}
		}
		sc.close();
		System.out.println(classes.size());
		/*for(int i = 0; i < classes.size(); i++) {
			if(classes.get(i).getSize() > 5) {
				WordNode curr = classes.get(i).getHead();
				while(curr.getNext() != null) {
					System.out.print(curr.getWord() + ", ");
					curr = curr.getNext();
				}
				System.out.println(curr.getWord());
			}
		}*/
	}

}
