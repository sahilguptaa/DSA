
public class Node {
	
	public int data;
	public Node left;
	public Node right;
	
	public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    }
	
	public Node addNode(Node current, int value) {
		if(current == null) {
			return new Node(value);
		}
		if(value < current.data) {
			current.left = addNode(current.left, value);
		} else if(value > current.data) {
			current.right = addNode(current.right, value);
		} else {
			return current;
		}
		return current;
	}
	
}
