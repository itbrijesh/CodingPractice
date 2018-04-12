package codefights.hashtable;

import java.util.HashMap;
import java.util.Map;

public class ContainsCloseNums {

	boolean containsCloseNums(int[] nums, int k) {

		if( nums == null ) return false;
		if( nums.length == 0 ) return false;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		Integer index = null;
		
		for( int i=0; i < nums.length; i++ )
		{
			index = map.get( nums[i] );
			
			if( index != null && (i - index.intValue() ) <= k ) {
				System.out.println( "Found same element ("+nums[i]+") at position " + i + " with index " + index.intValue() + " , Diff : " + (i - index.intValue() ) );
				return true;
			}
			else
			{
				map.put( nums[i] , i );
			}
		}
		
		return false;
	}
	
	public static void main( String ...args )
	{
		ContainsCloseNums obj = new ContainsCloseNums();
		
		int[] nums = { 0, 1, 2, 3, 5, 2 };
		
		System.out.println( obj.containsCloseNums( nums, 3 ) );
	}
}
