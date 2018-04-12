package codefights.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cryptarithm {

	boolean isCryptSolution(String[] crypt, char[][] solution) 
	{
		if( crypt == null ) return false;
		if( solution == null ) return false;
		if( crypt.length != 3 ) return false;
		if( solution.length > 26 ) return false;
		
		boolean result = false;
		long value1 = 0;
		long value2 = 0;
		
		Map<Character, Long> map;
		try {
			map = getEncodedData( solution, crypt );
		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
		
		try{
			for( int i = 0; i < crypt.length; i++ )
			{
				if( crypt[i] == null || crypt[i].trim().equals("")){
					//System.out.println( "data string is null");
					return false;
				}
				
				String data = crypt[i].trim();
					
				if( !data.matches("[A-Z]+") ) {
					//System.out.println("Invalid String...");
					return false;
				}
				
				if( data.length() < 1 && data.length() > 14 ) {
					//System.out.println("data string is greater than 9!");
					return false;
				}
				
				if( i == crypt.length -1 )
				{
					value2 = getEncodedValue( data, map);
				}
				else
				{
					value1 = value1 + getEncodedValue( data, map);
				}
			}
			
			result = value1 == value2;
			
			System.out.println( value1 + " == " + value2 + " ? " + result );
			
		}
		catch(Exception e )
		{
			 e.printStackTrace();
			return false;
		}
		
		return result;
	}
	
	public Map<Character,Long> getEncodedData( char[][] solution, String [] crypt ) throws Exception
	{
		Set<Character> set = new HashSet<>();
		for( String data : crypt )
		{
			for( int i = 0; i < data.length(); i++ )
			set.add( data.charAt( i ) );
		}
		
		Map<Character,Long> map = getEncodedData( solution );
		
		if( map.size() != set.size() ) throw new Exception("Missmatch of character between crypt and solution map.");
		return map;
	}
	public Map<Character,Long> getEncodedData( char[][] solution ) throws Exception
	{
		Map<Character,Long> map = new HashMap<>();
		Set set = new HashSet();
				
		for( char[] data : solution )
		{
			if( data != null && data.length > 2 ) throw new Exception("Solution length is greate than 2...");
			if( !(""+data[0]).matches("[A-Z]+") ) throw new Exception("Invalid Map Key...");
			if( !(""+data[1]).matches("[0-9]+") ) throw new Exception("Invalid Map Value...");
			
			set.add( data[1] );
			
			map.put( data[0], Long.parseLong( ""+data[1] ));
		}
		
		if( map.size() != set.size() ) throw new Exception("Key and Values are not in same size...");
		if( solution.length != map.size() ) throw new Exception("Duplicate key and values in solution array...");
		
		return map;
	}
	
	public long getEncodedValue( String input, Map<Character,Long> map ) throws Exception
	{
		long result = 0L;
		
		StringBuilder crypt = new StringBuilder("");
		
		for( int i = 0; i < input.length(); i++ )
		{
			char key = input.charAt( i ) ;
			
			if( !map.containsKey(key) ) throw new Exception("No key found in a map for : " + key );
			crypt.append( map.get( input.charAt( i ) ) );
		}
		
		String cryptStr = crypt.toString();
		System.out.println( input + " >> " + crypt );
		
		if( cryptStr.startsWith("0") && cryptStr.length() > 1 ) throw new Exception("*** Starts with ZERO, returning FALSE *** ");
		
		result = (Long.valueOf( cryptStr )).longValue();
		
		//System.out.println( "Init Value >> " + result );
		
		return result;
	}

	public static void main( String ...args )
	{
		long temp = 9999999999999L;
		String [] crypt = new String[]{"SEND", "MORE", "MONEY"};
		char [][] solution = new char[][] {{'O', '0'},
				{'M', '1'},
				{'Y', '2'},
				{'E', '5'},
				{'N', '6'},
				{'D', '7'},
				{'R', '8'},
				{'S', '9'}
				};
				
		/*crypt = new String[]{"TEN","TWO","ONE"};
		
		solution = new char[][]{{'O','1'}, 
				 {'T','0'}, 
				 {'W','9'}, 
				 {'E','5'}, 
				 {'N','4'}};*/
		
		Cryptarithm obj = new Cryptarithm();
		
		obj.isCryptSolution(crypt, solution);
	}
}
