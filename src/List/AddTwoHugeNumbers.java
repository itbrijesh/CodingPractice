package List;

import java.math.BigInteger;

public class AddTwoHugeNumbers {

	public static String correctLength(String input, int length )
	{
		int diff = length - input.length();
		
		if( diff > 0 )
		{
			for( int i = 0; i < diff; i++ )
			{
				input = "0" + input;
			}
		}
		
		return input;
	}
	
	ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> list1, ListNode<Integer> list2 ) 
	{
		if( list1 == null || list2 == null ) return null;
		
		if( list1.value > 9999 || list2.value > 9999 ) return null; 
		
		BigInteger num1 = null;
		BigInteger num2 = null;
		
		StringBuilder sb1 = new StringBuilder(""+list1.value);
		StringBuilder sb2 = new StringBuilder(""+list2.value);
		int length1 = sb1.length();
		int length2 = sb2.length();
		int length = 4; // length1 > length2 ? length1 : length2;
		String strResult = "";
		int start = 0;
		int end = start + length;
		long counter = 0L;
		
		System.out.println( "Length1 = " + length1  + ", Length2 = " + length2 );
		
		while(list1.next != null)
		{
			counter++;
			if( counter > (10*10*10*10)) return null;
			
			if( list1.next.value < 0 || list1.next.value > 9999 ) return null;
			
			sb1.append( correctLength( "" + list1.next.value, length) );
			list1 = list1.next;
		}
		
		counter = 0L;
		while(list2.next != null)
		{
			counter++;
			if( counter > (10*10*10*10)) return null;
			
			if( list2.next.value < 0 || list2.next.value > 9999 ) return null;
			
			sb2.append( correctLength( "" + list2.next.value, length) );
			list2 = list2.next;
		}
		
		System.out.println("Str Num 1 : " + sb1.toString() );
		System.out.println("Str Num 2 : " + sb2.toString() );
		num1 = new BigInteger( sb1.toString() );
		num2 = new BigInteger( sb2.toString() );
		
		BigInteger resultNum = num1.add( num2 );
		String nodeValue = "";
		strResult = resultNum.toString();
		
		System.out.println( "Result Num : " + strResult );
		
		ListNode<Integer> tail = null;
		ListNode<Integer> head = null;
		
		for( int i=strResult.length(); i > 0; i=i-length )
		{
			end = i;
			start = end - length;
			start = start < 0 ? 0 : start;
			
			nodeValue = strResult.substring( start, end );
			System.out.println("NodeValue == " + nodeValue );
			
			if( tail == null )
			{
				tail = new ListNode<Integer>( Integer.parseInt( nodeValue ) );
				head = tail;
			}
			else
			{
				head = new ListNode<Integer>( Integer.parseInt( nodeValue ) );
				head.next = tail;
				tail = head;
			}
			
		}
		
		return head;
	}
	
	public static void main( String ...args )
	{
		correctLength( "89" , 4 );
		
		ListNode<Integer> node1 = new ListNode<Integer>(1);
		ListNode<Integer> node2 = new ListNode<Integer>(22);
		ListNode<Integer> node3 = new ListNode<Integer>(333);
		
		ListNode<Integer> node10 = new ListNode<Integer>(1);
		ListNode<Integer> node11 = new ListNode<Integer>(9000);
		 
		node1.next = node2;
		node2.next = node3;
		
		node10.next = node11;
		
		AddTwoHugeNumbers obj = new AddTwoHugeNumbers();
		obj.addTwoHugeNumbers( node1, node10 );

		//BigInteger num = new BigInteger("99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999997777777777777777777777777777777777777777777777777777777777777777777777777777777777766666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666999");
		
		//System.out.println( num.add( new BigInteger("1")) );
	}
}
