import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashTable h = new HashTable(n);
        StringBuilder sb = new StringBuilder();
        String[] cards = br.readLine().split(" ");
        
        for(String key : cards) {
        	h.put(Integer.parseInt(key));
        }
        
        int m = Integer.parseInt(br.readLine());
        cards = br.readLine().split(" ");
        
        for(String key : cards) {
        	sb.append(h.get(Integer.parseInt(key))).append(" ");
        }
        System.out.println(sb);
        
        br.close();
    }
}

class HashTable {
	class Node {
		int key;
		int value;
		Node next;
		Node(int key) {
			this.key = key;
			this.value = 1;
			next = null;
		}
	}
	
	Node[] head;
	private static final int CONST = 10000000;
	
	HashTable(int size) {
		this.head = new Node[size];
	}
	
	int getIdx(int key) {
		return (key + CONST) % head.length;
	}
	
	void put(int key) {
		int idx = getIdx(key);
		Node now = head[idx];
		Node node = new Node(key);
		if(now == null) {
			head[idx] = node;
			return;
		}
		while(true) {
			if(now.key == key) {
				now.value++;
				return;
			}
			if(now.next == null) break;
			now = now.next;
		}
		now.next = node;
	}
	
	int get(int key) {
		int idx = getIdx(key);
		for(Node n = head[idx]; n != null; n = n.next) {
			if(n.key == key) return n.value;
		}
		return 0;
	}
}