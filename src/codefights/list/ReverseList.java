package codefights.list;

/*
 * 1. First we will create a new fresh node with value of first element. 
 *    As we are trying to reverse the list so this first element will be our PREVIOUS element.
 * 2. We will store the original list into some temp/helper variable so that when we
 *    cycle through the element we still have it's pointer that can be used later.
 * 3. Now we will cycle through this helper and keep creating a new node appending the previous element.
 * 4. Finally we have two list, one original and other one is reversed.
 * 5. Compare elements of both the list.
 * 
 */
public class ReverseList {

	public static ListNode<Integer> reverseList(ListNode<Integer> list )
	{
		ListNode<Integer> helper = list;
		ListNode<Integer> prev = new ListNode<Integer>(list.value);
		
		while( helper.next != null )
		{
			ListNode<Integer> temp = new ListNode<Integer>(helper.next.value);
			temp.next = prev;
			prev = temp;
			helper = helper.next;
		}
		
		System.out.println("First >>>");
		Utility.printList( list );
		System.out.println("\n Second >>>");
		Utility.printList( prev );
		
		return prev;
	}
	
	public static void main( String ...args )
	{
		
		ListNode<Integer> node1 = new ListNode<Integer>(1);
		ListNode<Integer> node2 = new ListNode<Integer>(2);
		ListNode<Integer> node3 = new ListNode<Integer>(3);
		ListNode<Integer> node4 = new ListNode<Integer>(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		reverseList( node1 );
	}
}
