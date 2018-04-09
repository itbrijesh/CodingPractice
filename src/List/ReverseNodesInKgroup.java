package List;

public class ReverseNodesInKgroup {

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
	
	ListNode<Integer> reverseNodesInKGroups( ListNode<Integer> list, int k ) {

		int counter = 0;
		ListNode<Integer> helper = new ListNode<Integer>(null);
		helper.next = list;
		ListNode<Integer> temp = helper;
		
		while( list != null )
		{
			
		}
		
		return null;
	}
	
	public static void main( String ...args )
	{
		ListNode<Integer> node1 = new ListNode<Integer>(1);
		ListNode<Integer> node2 = new ListNode<Integer>(2);
		ListNode<Integer> node3 = new ListNode<Integer>(3);
		ListNode<Integer> node4 = new ListNode<Integer>(4);
		ListNode<Integer> node5 = new ListNode<Integer>(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ReverseNodesInKgroup obj = new ReverseNodesInKgroup();
		obj.reverseNodesInKGroups( node1 , 2 );
		
	}
}
