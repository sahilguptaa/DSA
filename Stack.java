import java.util.ArrayList;

public class Stack<T> {

	int top = 0;
	ArrayList<T> stack;
	public Stack() {
		top = 0;
		stack = new ArrayList<T>();
	}
	
	public int push(T data) {
		top++;
		stack.add(data);
		return top;
	}
	
	public T pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("empty stack");
		}
		T temp = stack.get(top - 1);
		stack.remove(top-1);
		top --;
		return temp;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public T peek() {
		return stack.get(top -1 );
	}
}
