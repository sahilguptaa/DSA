
public class TestStack {

	public static void main(String args[]) {
		 String expr = "()"; 
		 System.out.println(checkParanthesis(expr));
	}

	private static boolean checkParanthesis(String expr) {
		// TODO Auto-generated method stub
		Stack stackClass = new Stack();
		
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
	
}
