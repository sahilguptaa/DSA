//import sun.security.util.Length;

public class TestStack {

	public static void main(String args[]) {
		 int arr[] = new int[4];
		 arr[0] = 7;
		 arr[1] = 8;
		 arr[2] = 1;
		 arr[3] = 4;
		 
		 nextLargerElement(arr);
	}

	private static boolean checkParanthesis(String expr) {
		// TODO Auto-generated method stub
		Stack<Character> stackClass = new Stack<Character>();
		
		for(int i=0;i<expr.length(); i++) {
			if(expr.charAt(i)=='{' || expr.charAt(i)=='(' || expr.charAt(i)=='[') {
				stackClass.push(expr.charAt(i));
			} else {
				try {
					Character temp = stackClass.pop();
					if(!((temp == '{' && expr.charAt(i) == '}') ||
							(temp == '(' && expr.charAt(i) == ')') ||
							(temp == '[' && expr.charAt(i) == ']')
							)
							
							) {
						return false;
					}
				}
				catch (Exception e) {
					return false;
				}
			}
			
		}
		
//		System.out.println(stackClass.stack);
		return stackClass.isEmpty();
	}

	private static void nextLargerElement(int arr[]) {
		
		Stack<Integer> stack = new Stack<Integer>();
		int[] opArr = new int[arr.length];
		int size = arr.length;
		
		while(size>0) {
			
			if(stack.isEmpty()) {
				opArr[size - 1] = -1;
			} else if(arr[size - 1] < stack.peek()) {
				opArr[size - 1] = stack.peek();
			} else {
				while(!stack.isEmpty() && stack.peek() < arr[size - 1]) {
					try {
						stack.pop();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(stack.isEmpty()) {
					opArr[size - 1] = -1;
				} else {
					opArr[size - 1] = stack.peek();
				}
			}
			
			stack.push(arr[size - 1]);
			size--;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(opArr[i]+" ");
		}
		
	}
	
}
