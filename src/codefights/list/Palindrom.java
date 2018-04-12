package codefights.list;

public class Palindrom {

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
	
	boolean isListPalindrome(ListNode<Integer> list ) {
		
		if( list == null ) return true;
		
		ListNode<Integer> reversedList = reverseList( list );
		
		long counter = 0L;
		
		while( list.next != null )
		{
			counter++;
			
			if( counter > (5*10*10*10*10*10)) return false;
			
			if( list.value < -1000000000 || list.value > 1000000000) return false;
			
			if( list.value.intValue() != reversedList.value.intValue() ) {
				System.out.println( "\n"+list.value + " != " + reversedList.value );
				return false;
			}
			
			list = list.next;
			reversedList = reversedList.next;
		}
		
		return true;
	}
	
	public static void main( String ...args )
	{
		Palindrom obj = new Palindrom();
		
		ListNode<Integer> node1 = new ListNode<Integer>(1);
		ListNode<Integer> node2 = new ListNode<Integer>(1000000);
		ListNode<Integer> node3 = new ListNode<Integer>(-1000000);
		ListNode<Integer> node4 = new ListNode<Integer>(-1000000);
		ListNode<Integer> node5 = new ListNode<Integer>(1000000);
		ListNode<Integer> node6 = new ListNode<Integer>(1);
		
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		boolean result = obj.isListPalindrome( node1 );
		
		System.out.println( "Result : " + result );
		
		System.out.println(">>>>>>>>>>> " + (1000000000!=1000000000) );
	}
}
