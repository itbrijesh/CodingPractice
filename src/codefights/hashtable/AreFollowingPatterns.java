package codefights.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AreFollowingPatterns {

	boolean areFollowingPatterns(String[] strings, String[] patterns) 
	{
		if( strings == null ) return false;
		if( patterns == null ) return false;
		
		if( strings.length != patterns.length ) return false;
		if( strings.length > 100000 ) return false;
		 
		
		Map<String, String> map = new HashMap<>();
		
		String key = null;
		
		for( int i = 0; i < strings.length; i++ )
		{
			if( strings[i].trim().length() <= 0 ) return false;
			if( strings[i].trim().length() > 10 ) return false;
			if( patterns[i].trim().length() <= 0 ) return false;
			if( patterns[i].trim().length() > 10 ) return false;
			
			key = map.get( strings[i] );
			
			if( key != null )
			{
				if( !key.equals( patterns[i] ) ) return false;
			}
			else
			{
				map.put( strings[i] , patterns[i]);
			}
		}
		
		System.out.println( "Map >>  " + map );
		
		if( map != null && !map.isEmpty() )
		{
			Set<String> tempSet = new HashSet<>();
			for( String temp : map.keySet() )
			{
				tempSet.add( map.get( temp ) );
			}
			
			if( map.size() != tempSet.size() ) {
				
				System.out.println( "Not Unique Patters returning FALSE !" );
				return false;
			}
		}
		
		return true;
	}
	
	public static void main ( String ...args )
	{
		AreFollowingPatterns obj = new AreFollowingPatterns();
		
		String[] strings = { "cat", "dog", "doggy" };
		String[] patterns = { "a", "b", "b" };
		
		
		System.out.println( "Result >>> " + obj.areFollowingPatterns( strings, patterns ) );
	}
}
