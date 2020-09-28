import java.util.ArrayList;

public class Stack {

	int top = 0;
	ArrayList<Character> stack;
	public Stack() {
		top = 0;
		stack = new ArrayList<Character>();
	}
	
	public int push(Character data) {
		top++;
		stack.add(data);
		return top;
	}
	
	public Character pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("empty stack");
		}
		Character temp = stack.get(top - 1);
		stack.remove(top-1);
		top --;
		return temp;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public int peek() {
		return stack.get(top -1 );
	}
}
