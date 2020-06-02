
public class LinkedList {
	int data;
	LinkedList next;
	
	LinkedList(int x){
		data = x;
		next = null;
	}
	
	static LinkedList removeDuplicatesFromLinkedList(LinkedList head) {
		boolean firstDel = true;
		int x = head.data;
		boolean remove = false;
		LinkedList temp = head;
		while(temp!=null && temp.next!= null) {
			if(temp.next.data == x) {
				remove = true;
				temp.next = temp.next.next;
				if(firstDel) {
					head = temp;
				}
			} else {
				
				x = temp.next.data;
				if(remove == true) {
					temp.data = temp.next.data;
					temp.next = temp.next.next;
					if(firstDel) {
						head = temp;
					}
					firstDel = false;
					remove = false;
				} else {
					temp = temp.next;
					firstDel=false;
				}
			}
		}
		if(remove) {
			temp  = temp.next;
			if(firstDel) {
				head=temp;
			}
		}
		return head;
	}
	
}
