package codefights.list;


/**
 * -- In this program I created a method to reverse the list. Before reverse i used to store it's first node as
 *    the tail. The next of tail would be connected when i reverse the list next time.
 * 
 * -- Cycle through the list and create a new temp list for break downs. 
 * -- As soon you found that it is divided by k = 0, revers this new temp list, store in last tail in above step,
 *    and then reset the new temp list and continue.
 * */

public class ReverseNodesInKgroup {

	public static ListNode<Integer> tail = null;
	public static ListNode<Integer> prevTail = null;
	
	public static ListNode<Integer> reverseList(ListNode<Integer> list )
	{
		ListNode<Integer> helper = list;
		ListNode<Integer> prev = new ListNode<Integer>(list.value);
		boolean flag = true;
		
		while( helper.next != null )
		{
			ListNode<Integer> temp = new ListNode<Integer>(helper.next.value);
			
			// this is the node when next revesed list will be appended. This is just to avoid the iteration
			if( flag ) {
				tail = prev;
				flag = false;
			}
			
			temp.next = prev;
			prev = temp;
			
			// Consider this as an iterator 
			helper = helper.next;
		}
		return prev;
	}
	
	ListNode<Integer> reverseNodesInKGroups( ListNode<Integer> list, int k ) 
	{
		if( k <= 1 ) return list;
		if( list.next == null ) return list;
		if( list.value == null ) return list;
		
		int counter = 0;
		ListNode<Integer> temp = list;
		
		ListNode<Integer> result = null;
		
		ListNode<Integer> temp2 = new ListNode<Integer>(0);
		ListNode<Integer> temp2Helper = temp2;
		
		while( temp != null )
		{
			counter++;
			
			if( counter > 10000) return null;
			
			if( temp.value != null && (temp.value < -1000000000 || temp.value > 1000000000) ) return null;
			
			if( counter % k == 0 ) 
			{
				temp2Helper.next = new ListNode<Integer>( temp.value );
				
				if( result == null ) {
					result = reverseList( temp2.next );
				}
				else {
					prevTail.next = reverseList( temp2.next );
				}
				
				prevTail = tail;
				
				temp2 = new ListNode<Integer>(0);
				temp2Helper = temp2;
			}
			else
			{
				temp2Helper.next = new ListNode<Integer>( temp.value );
				temp2Helper = temp2Helper.next;
			}
			
			temp = temp.next;
		}
		
		System.out.println( "K == " + k + " , Counter == " + counter );
		if( k > counter ) {
			return null;
		}
		
		if( temp2.next != null ) 
		{
			prevTail.next = temp2.next;
		}
		
		return result;
	}
	
	
	public static void main( String ...args )
	{
		ListNode<Integer> node1 = new ListNode<Integer>(1);
		ListNode<Integer> node2 = new ListNode<Integer>(2);
		ListNode<Integer> node3 = new ListNode<Integer>(3);
		ListNode<Integer> node4 = new ListNode<Integer>(4);
		ListNode<Integer> node5 = new ListNode<Integer>(5);
		ListNode<Integer> node6 = new ListNode<Integer>(6);
		ListNode<Integer> node7 = new ListNode<Integer>(7);
		ListNode<Integer> node8 = new ListNode<Integer>(8);
		ListNode<Integer> node9 = new ListNode<Integer>(9);
		ListNode<Integer> node10 = new ListNode<Integer>(10);
		ListNode<Integer> node11 = new ListNode<Integer>(11);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		
		ReverseNodesInKgroup obj = new ReverseNodesInKgroup();
		Utility.printList(  obj.reverseNodesInKGroups( node1 , 10 ) );
		
	}
}
