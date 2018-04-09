package Arrays;
import java.util.HashSet;

public class ArrayFindDuplicate {

	int firstDuplicate( int [] a )
	{
		HashSet s=new HashSet();
		for(int i=0;i<a.length;i++)
		{
		    s.add(a[i]);
		    if(s.size()==i)
		        return a[i];
		}
		return -1;
	}
	
	int firstDuplicate1(int[] a) {
		
		 if( a == null ) return -1;
		 
		    int result = 100;
		     
		    for( int i =0; i < a.length; i++ )
		    {
		        int element = a[i];
		        int temp[] = new int[a.length-1];
		        
		        for( int j = i+1; j < a.length; j++ )
		        {
		            if( element == a[j] && j < result )
		            {
		            	result = j;
		            }
		            if( result == 1) break;
		        }
		        
		    }
		    
		    return result != 100 ? a[result] : -1;
	}
	
	int firstDuplicate2(int[] a) {
	    
	    if( a == null ) return -1;
	    int result = -1;
	    int found[][] = new int[a.length][a.length];
	    
	    for( int i =0; i < a.length; i++ )
	    {
	        int element = a[i];
	        int temp[] = new int[a.length-1];
	        
	        for( int j = i+1; j < a.length; j++ )
	        {
	            if( element == a[j])
	            {
	                temp[j-1] = j;
	            }
	        }
	        found[i] = temp;
	    }
	    
	    result = a.length;
	    boolean matched = false;
	    for(int i=0; i<found.length; i++){
	    	for( int j=0; j<found[i].length; j++){
	    		System.out.println("["+i+"]["+j+"] == " + found[i][j]);
	    		
	    		if( found[i][j] != 0 && found[i][j] < result ){
	    			result = found[i][j];
	    			matched = true;
	    		}
	    	}
	    }
	
	    return ( matched ? a[result] : -1 );
	}

	public static void main( String ...args) {
		
		System.out.println("Jai Swaminarayan");
		ArrayFindDuplicate obj = new ArrayFindDuplicate();
		int result = obj.firstDuplicate( new int[]{2,3,3,1,5,2});
		System.out.println("\n\n RESULT == " + result);
		result = obj.firstDuplicate( new int[]{2, 4, 3, 5, 1});
		System.out.println("\n\n RESULT == " + result);
		result = obj.firstDuplicate( new int[]{1});
		System.out.println("\n\n RESULT == " + result);
		result = obj.firstDuplicate( new int[]{2,2});
		System.out.println("\n\n RESULT == " + result);
		result = obj.firstDuplicate( new int[]{2,1});
		System.out.println("\n\n RESULT == " + result);
		result = obj.firstDuplicate( new int[]{2,1,3});
		System.out.println("\n\n RESULT == " + result);
		result = obj.firstDuplicate( new int[]{2,3,3});
		System.out.println("\n\n RESULT == " + result);
		result = obj.firstDuplicate( new int[]{3,3,3});
		System.out.println("\n\n RESULT == " + result);
		result = obj.firstDuplicate( new int[]{8, 4, 6, 2, 6, 4, 7, 9, 5, 8});
		System.out.println("\n\n RESULT == " + result);
		result = obj.firstDuplicate( new int[]{10, 6, 8, 4, 9, 1, 7, 2, 5, 3});
		System.out.println("\n\n RESULT == " + result);
		result = obj.firstDuplicate( new int[]{1, 1, 2, 2, 1});
		
		
		System.out.println("\n\n RESULT == " + result);
	}
}
