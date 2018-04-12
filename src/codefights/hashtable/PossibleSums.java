package codefights.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PossibleSums {

	int possibleSums(int[] coins, int[] quantity) 
	{
		int result = 0;
		Set<Integer> set = new HashSet<>();
		Integer array[] = null;
		
		List<Integer> list = new ArrayList<>();
		
		for( int i = 0; i < coins.length; i++ )
		{
			for( int j = 0; j < quantity[i]; j++ )
			{
				list.add( coins[i] );
			}
		}
		
		list.toArray( array );
		
		for( int i = 0; i < array.length; i++ )
		{
			set.add( array[i] );
			
			for( int j = i+1; j < array.length; j++ )
			{
				set.add( array[i] + array[j] );
			}
		}
		
		System.out.println( list );
		
		return result;
	}

	public static void main ( String ...args )
	{
		PossibleSums obj = new PossibleSums();
		
		int coins[] = { 10, 50, 100 };
		int quantity[] = { 1, 2, 1 };
		
		obj.possibleSums(coins, quantity);
	}
}
