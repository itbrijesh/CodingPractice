package List;

public class RemoveKfromList {

		
	public ListNode<Integer> removeKFromList(ListNode<Integer> list, int k ) throws Exception
	{
		if( list == null || list.value == null ) return null;
		if( k <= -1000 || k >= 1000) return null;
		long counter = 0L;
		
		ListNode<Integer> result = new ListNode<Integer>( 0 ); // dummy head so that we cannot lost the object
		result.next = list; // appending the original list to this dummy head
		ListNode<Integer> temp = result;
		
		while( temp.next != null )
		{
			counter++;
			
			if( counter > (10*10*10*10*10))
			{
				throw new Exception("Cannot handle more than 100,000.");
			}
			
			if( temp == null || temp.value == null ) throw new Exception("Invalid value - null.");
			
			if( temp.value <= -1000 || temp.value >= 1000)
			{
				throw new Exception("Invalid value - out of range.");
			}
			
			if( temp.next != null && temp.next.value == null) throw new Exception("list.next cannot have null values");
			
			if( temp.next != null && temp.next.value != null && temp.next.value == k )
			{
				temp.next = temp.next.next;
			}
			else
			{
				temp = temp.next;
			}
		}
		
		return result.next;
	}
	
	/*
	public ListNode<Integer> removeKFromListUsingRecursion(ListNode<Integer> list, int k, boolean first ) throws Exception
	{
		if( list == null || list.value == null ) return null;
		if( k <= -1000 || k >= 1000) return null;
		//boolean first = true;
		long counter = 0L;
		
		while( list.next != null )
		{
			counter++;
			
			if( counter >= (10*10*10*10*10))
			{
				throw new Exception("Cannot handle more than 100,000.");
			}
			
			if( list == null || list.value == null ) throw new Exception("Invalid value - null.");
			
			if( list.value <= -1000 || list.value >= 1000)
			{
				throw new Exception("Invalid value - out of range.");
			}
			
			if( first )
			{
				first = false;
				while( list != null && list.value == k )
				{
					list = list.next;
				}
			}
			
			if( list.next != null && list.next.value == null) throw new Exception("list.next cannot have null values");
			
			while( list.next != null && list.next.value != null && list.next.value == k )
			{
				list.next = list.next.next;
			}
			
			// We need to check this both times before and after
			if( list.next != null && list.next.value == null ) throw new Exception("Invalid value - Leaf cannot be null");;
			if( list.next != null && ( list.next.value <= -1000 || list.next.value >= 1000) )
			{
				throw new Exception("Invalid value - out of range.");
			}
			
			
			removeKFromList( list.next, k, false );
			break;
		}
		
		return list;
	}
	*/

	public ListNode<Integer> removeKFromList2(ListNode<Integer> list, int k) 
	{
		if( list == null ) return list;
		
		if( k < -1000 && k > 1000)
		{
			//System.out.println( " Search value " + k + " is not allowed. ");
			return null ; //new ListNode<Integer>(list.value);
		}
				
		ListNode<Integer> result = null;
		boolean first = true;
		long counter = 0L;
		
		while( list.next != null )
		{
			counter++;
			
			if( counter > (10*10*10*10*10))
			{
				//System.out.println( "Invalid size..." );
				return null; //new ListNode<Integer>(list.value);
			}
			
			if( list.value <= -1000 || list.value >= 1000)
			{
				//System.out.println( "Invalid node value...");
				return null; //new ListNode<Integer>(list.value);
			}
			
			if( first ) 
			{
				first = false;
				
				while( list!= null && list.value == k )
				{
					list = list.next;
				}
				
				if( list == null ) return null;
				
				result = new ListNode<Integer>(list.value);
			}
			
			if( list.next.value != k ) 
			{
				addNode( result, new ListNode<Integer>(list.next.value) );
			}
			
			list = list.next;
						
		}
		
		//printList( result );
		
		return result;
	}
	
	
	
	public void addNode( ListNode<Integer> list, ListNode<Integer> node )
	{
		while( list.next != null ) 
		{
			addNode( list.next, node );
			break;
		}
		
		if(list.next == null ) 
		{
			//System.out.println( "Leaft Node Value = " + list.value );
			list.next = node;
		}
	}
	
	public void printList( ListNode<Integer> list )
	{
		System.out.print( ( list != null ? list.value : "" ) );
	    while(list != null && list.next != null)
		{
			printList(list.next);
	    	
			break;
		}
		//System.out.print( list.value );
	}
	
	public static void main( String[] args ) throws Exception
	{
		ListNode<Integer> node1 = new ListNode<Integer>(3);
		ListNode<Integer> node11 = new ListNode<Integer>(9);
		ListNode<Integer> node12 = new ListNode<Integer>(3);
		ListNode<Integer> node2 = new ListNode<Integer>(1);
		ListNode<Integer> node3 = new ListNode<Integer>(2);
		ListNode<Integer> node4 = new ListNode<Integer>(3);
		ListNode<Integer> node41 = new ListNode<Integer>(3);
		ListNode<Integer> node42 = new ListNode<Integer>(3);
		ListNode<Integer> node5 = new ListNode<Integer>(4);
		ListNode<Integer> node6 = new ListNode<Integer>(5);
		ListNode<Integer> node7 = new ListNode<Integer>(3);
		ListNode<Integer> node8 = new ListNode<Integer>(000);
		
		node1.next = node11;
		node11.next = node12;
		node12.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node41;
		node41.next = node42;
		node42.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		
		
		RemoveKfromList obj = new RemoveKfromList();
		
		//ListNode<Integer> result = obj.removeKFromList( node1, 3, true );
		//obj.printList( result );
		
		ListNode<Integer> t3node1 = new ListNode<Integer>(1000);
		ListNode<Integer> t3node2 = new ListNode<Integer>(1000);
		
		t3node1.next = t3node2;
		
		ListNode<Integer> result = obj.removeKFromList( node1, 3 );
		obj.printList( result );
	}
}
