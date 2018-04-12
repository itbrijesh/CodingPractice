package codefights.list;

import java.util.HashMap;
import java.util.Map;

public class RearrangeLastN {

	//public static int length = 1;
	//public static ListNode<Integer> newTail = null;
	
	public static Map<String, Object> reverseList( ListNode<Integer> list )
	{
		return reverseList( list, false );
	}
	
	public static Map<String, Object> reverseList( ListNode<Integer> list , boolean needTail )
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int length = 1;
		
		ListNode<Integer> helper = list;
		ListNode<Integer> temp = null;
		
		ListNode<Integer> prev = new ListNode<Integer>( list.value );
		
		//if ( needTail ) newTail = prev;
		if ( needTail ) resultMap.put( "NEWTAIL" , prev );
		
		while( helper.next != null )
		{
			// Pre condition give in a program value cannot be,..
			if( helper.next.value > 1000 || helper.next.value < -1000 ) return null;
			
			temp = new ListNode<Integer>(helper.next.value);
			
			temp.next = prev;
			prev = temp;
			
			helper = helper.next;
			if( !needTail ) length++;
			
			// Pre codition given in a program that length cannot be greater than 100,000
			if( length > 100000 ) return null;
		}
		
		resultMap.put("REVERSED_LIST", prev);
		resultMap.put( "LENGTH" , length );
		
		return resultMap;
		//return prev;
	}
	
	ListNode<Integer> rearrangeLastN(ListNode<Integer> list, int n) 
	{
		if( list == null ) return null;
		if( list.value == null ) return null;
		if( n == 0 ) return list;
		if( n < 0 ) return null;
		
		int length = 0;
		
		ListNode<Integer> reversedList = null; // reverseList( list );
		Map<String, Object> map = reverseList( list );
		
		if( map != null && !map.isEmpty() )
		{
			length = (int) map.get( "LENGTH" );
			reversedList = (ListNode<Integer>) map.get( "REVERSED_LIST" );
		}
		
		// Pre condition given in a program.
		if( n > length ) return null;
		if( n == length ) return list;
		
		ListNode<Integer> reversedHelper = new ListNode<Integer>(0);
		reversedHelper.next = reversedList;
		
		ListNode<Integer> result = new ListNode<Integer>(0);
		ListNode<Integer> temp = null;
		
		ListNode<Integer> prev = null;
		ListNode<Integer> head = list;
		
		int counter = 0;
		
		while( reversedList != null )
		{
			counter++;
			temp = reversedList;
			
			if( counter == n )
			{
				temp.next = null;
				break;
			}
			
			reversedList = reversedList.next;
		}
		
		//result = reverseList( reversedHelper.next, true );
		
		map = reverseList( reversedHelper.next, true );
		
		result = map != null ? (ListNode<Integer>) map.get( "REVERSED_LIST" ) : null;
		
		ListNode<Integer> newTail = map != null ? (ListNode<Integer>) map.get("NEWTAIL") : null;
		
		newTail.next = list;
		
		int counter2 = 0;
		while( list != null )
		{
			counter2++;
		
			if( counter2 == length-n ) {
				list.next = null;
				break;
			}
			
			list = list.next;
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
		
		/*node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;*/
		
		RearrangeLastN obj = new RearrangeLastN();
		Utility.printList(  obj.rearrangeLastN( node1 , 1 ) );
	}
}
