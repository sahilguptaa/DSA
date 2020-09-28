//import sun.security.util.Length;

public class TestStack {

	public static void main(String args[]) {
		int price[] = { 100 , 80, 60, 70, 60, 75, 85 }; 
        int n = price.length; 
        int S[] = new int[n]; 
  
        // Fill the span values in array S[] 
        calculateStockSpan(price, n, S); 
	}

	private static void calculateStockSpan(int[] price, int n, int[] s) {
		
		// https://www.geeksforgeeks.org/the-stock-span-problem/
		
		// Auxiliary Space: O(n) in worst case when all elements are sorted in decreasing order.
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i=0;i<n;i++) {
			
			if(stack.isEmpty()) {
				s[i] = i+1;
			} else if(price[stack.peek()] > price[i]) {
				s[i] = i - stack.peek();
			} else {
				while(!stack.isEmpty() && price[stack.peek()] < price[i]) {
					try {
						stack.pop();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(stack.isEmpty()) {
					s[i] = i+1;	
				} else {
					s[i] = i - stack.peek();
				}
			}
			
			stack.push(i);
		}
		System.out.println(s);
		
	}

	private static void nextLargerElementOnLeft(int[] arr) {
		
		// Time Complexity: O(n). It seems more than O(n) at first look. 
		// If we take a closer look, we can observe that every element of the array is added and removed from the stack at most once.
		// So there are total 2n operations at most. Assuming that a stack operation takes O(1) time, 
		// we can say that the time complexity is O(n).
		
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
					//s
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
