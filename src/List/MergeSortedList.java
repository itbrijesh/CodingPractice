package List;

public class MergeSortedList {

	ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> list1, ListNode<Integer> list2) {

		ListNode<Integer> helper = new ListNode<Integer>(null);
		ListNode<Integer> temp = helper;
		int value1 = 0;
		int value2 = 0;
		long counter1 = 0L;
		long counter2 = 0L;
		
		while( list1 != null || list2 != null )
		{
			if( list1 != null )
			{
				//counter1++;
				if( list1.value == null ) return null;
				if( counter1 > (10*10*10*10)) return null;
				if( value1 < -1000000000  || value1 > 1000000000 ) return null;
				
				value1 = list1.value;
			}
			if( list2 != null )
			{
				//counter2++;
				if( list2.value == null ) return null;
				if( counter2 > (10*10*10*10)) return null;
				if( value2 < -1000000000  || value2 > 1000000000 ) return null;
				
				value2 = list2.value;
			}
			
			if( list1 == null )
			{
				temp.next = list2;
				System.out.println("List 1 finished.");
				break;
			}
			if( list2 == null )
			{
				temp.next = list1;
				System.out.println("List 2 finished.");
				break;
			}
			
			if( value1 < value2 )
			{
				if( list1 != null ) {
					temp.next = list1;
					list1 = list1.next;
				}
			}
			else
			{
				if( list2 != null )
				{
					temp.next = list2;
					list2 = list2.next;	
				}
			}
			temp = temp != null ? temp.next : temp;
			
		}
		return helper.next;
	}
	
	public static void main( String ...args )
	{
		MergeSortedList obj = new MergeSortedList();
		
		ListNode<Integer> node1 = new ListNode<Integer>(2);
		ListNode<Integer> node2 = new ListNode<Integer>(5);
		ListNode<Integer> node3 = new ListNode<Integer>(7);
		ListNode<Integer> node4 = new ListNode<Integer>(4);
		node1.next = node2;
		node2.next = node3;
		//node3.next = node4;
		
		ListNode<Integer> node10 = new ListNode<Integer>(3);
		ListNode<Integer> node11 = new ListNode<Integer>(11);
		ListNode<Integer> node12 = new ListNode<Integer>(5);
		node10.next = node11;
		//node11.next = node12;
		
		ListNode<Integer> result = obj.mergeTwoLinkedLists( node1, node10 );
		
		Utility.printList( result );
	}
}
