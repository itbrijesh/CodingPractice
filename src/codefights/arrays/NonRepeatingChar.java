package codefights.arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class NonRepeatingChar {

	char firstNotRepeatingCharacter(String s) {

		char result = ' ';
		
		LinkedHashSet set = new LinkedHashSet();
		LinkedHashSet set1 = new LinkedHashSet();
		LinkedHashSet set2 = new LinkedHashSet();
		
		for( int i = 0; i < s.length(); i++ )
		{
			char ele = s.charAt( i ) ;
			
			boolean exists = set1.add( ele );
			
			if( !exists ) {
				set2.add( ele );
			}
					
		}
		System.out.println( "set1 == " + set1 );
		System.out.println( "set2 == " + set2 );
		
		set1.removeAll( set2 );
		
		Iterator iterator = set1.iterator();
		
		while( iterator.hasNext() )
		{
			result = (char) iterator.next();
			break;
		}
		
		result = result == ' ' ? '_' : result;
		
		System.out.println("Result : " + result);
		
		return result; 
	}
	
	public static void main ( String ...args )
	{
		NonRepeatingChar obj = new NonRepeatingChar();
		
		obj.firstNotRepeatingCharacter("abacabad");
	}
}
