import java.io.*;

class MyStack {
	private int back;
	private int[] list;
	
	private static final int SIZE = 1000;
	
	MyStack() {
		this.back = 0;
		this.list = new int[SIZE];
	}
	
	public void push(int data) {
		list[back++] = data;
	}
	
	public int pop() {
		if(back == 0) {
			return -1;
		}
		int data = list[--back];
		return data;
	}
	
	public int peek() {
		if(back == 0) {
			return -1;
		}
		return list[back - 1];
	}
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        MyStack stack1 = new MyStack();
        MyStack stack2 = new MyStack();
        
        String[] students = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
        	stack2.push(Integer.parseInt(students[i]));
        }
        
        for(int i = 0; i < n; i++) {
        	stack1.push(stack2.pop());
        }
        
        boolean flag = false;
        for(int i = 1; i <= n; i++) {
        	int data = 0;
        	if((data = stack2.peek()) == i) {
        		data = stack2.pop();
        		continue;
        	}
        	
        	while(true) {
        		data = stack1.peek();
        		if(data == -1) {
        			flag = true;
        			break;
        		}
        		
        		data = stack1.pop();
        		if(data == i) {
        			break;
        		}
        		stack2.push(data);
        	}
        	
        	if(flag) break;
        }
        System.out.println(flag ? "Sad" : "Nice");
        
        br.close();
    }
}