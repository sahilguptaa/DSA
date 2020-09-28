//import sun.security.util.Length;

public class TestStack {

	public static void main(String args[]) {
		 int arr[] = new int[4];
		 arr[0] = 7;
		 arr[1] = 8;
		 arr[2] = 1;
		 arr[3] = 4;
		 
		 nextLargerElementOnLeft(arr);
	}

	private static void nextLargerElementOnLeft(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] opArr = new int[arr.length];
		int size = 0;
		
		while(size < arr.length) {
			
			if(stack.isEmpty()) {
				opArr[size] = -1;
			} else if (stack.peek() > arr[size]) {
				opArr[size] = stack.peek();
			} else {
				while(!stack.isEmpty() && stack.peek() < arr[size]) {
					try {
						stack.pop();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(stack.isEmpty()) {
					opArr[size] = -1;
				} else {
					opArr[size] = stack.peek();
				}
			}
			
			stack.push(arr[size]);
			size++;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(opArr[i]+" ");
		}
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
		
		// In test case where input  = [ 5 1 2 3 4]
		// The while loop only runs n times for one element which is '5' and not for the rest of the elements (1,2,3,4).
		// So, the complexity is still better than brute force.


		// Explanation :- 
		// "The second loop is subjective to a condition." 
		// it is usually a constant factor (K) * N complexity, where k can be >1 or even <1 (depends upon the each problem input) 
		// but no where near O(N^2).
		
		
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
