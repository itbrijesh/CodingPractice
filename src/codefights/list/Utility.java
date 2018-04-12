package codefights.list;

public class Utility {

	public static void printList( ListNode<Integer> list )
	{
		System.out.print( ( list != null ? list.value + ", " : " "  ) );
	    while(list != null && list.next != null)
		{
			printList(list.next);
	    	
			break;
		}
		//System.out.print( list.value );
	}
}
