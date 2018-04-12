package codefights.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku2 {

	char[][] rotate( char[][] grid)
	{
		char[][] result = new char[grid.length][grid.length];
		int s = grid.length -1;
		
		for( int i = grid.length-1; i >= 0; i-- )
		{
			for( int j = 0; j < grid[i].length; j++ )
			{
				result[j][s-i] = grid[i][j];
			}
		}
		
		return result;
	}
	
	boolean checkForUniqueByRow( char[][] grid, boolean byRow )
	{
		boolean result = true;
		Set set = new HashSet();
		
		for( char[] grid1 : grid )
		{
			if( byRow ) set = new HashSet();
			for( char grid2: grid1 )
			{
				if( !(grid2 == '.') )
				{
					if( !set.add( grid2 ) ) {
						System.out.println( set );
						return false;
					}
				}
			}
		}
		
		return result;
	}
	
	public List createArrays(char [][] grid)
	{
		List list = new ArrayList(9);
		
		int index = 0;
		int arrayI = -1;
		int arrayJ = -1;
		int counter = -1;
		int arrayCounter = -1;
				
		for( int i = 0; i < grid.length; i++ )
		{
			if( i % 3 == 0 ) arrayI = 0 ; else arrayI = arrayI + 1;
			
			for( int j = 0; j < grid[i].length; j++ )
			{
				if( i % 3 == 0 && j % 3 == 0) 
				{
					counter=counter+1;
					char [][] array = new char[3][3];
					list.add( array );
					arrayCounter = counter;
				}
				else if( i != 0 )
				{
					if( j == 0 ) arrayCounter = counter-2;
					else if( j % 3 == 0 ) arrayCounter++;
				}

				if( j % 3 == 0 ) arrayJ = 0; else arrayJ = arrayJ + 1;
				
				//System.out.println( "( "+arrayI+","+arrayJ+" )");
				//System.out.println( "Array Counter == " + arrayCounter );
				
				char[][] array = (char[][]) list.get( arrayCounter );
				
				array[arrayI][arrayJ] = grid[i][j];
			}
		}
		//System.out.println("Counter == " + counter );
		return list;
	}
	
	boolean checkEquality( char[][] grid )
	{
		boolean result = true;
		
		List list = createArrays( grid );
		
		System.out.println( "Checking qnique with 3x3 -----------------------");
		
		for( int i = 0; i < list.size(); i++ )
		{
			char[][] array = (char[][]) list.get( i );
			
			System.out.println( "\nArray : " + i );
			result = checkForUniqueByRow( array , false);
			
			System.out.println( "Whole array unique ? " + result );
			
			result = result ? checkForUniqueByRow( rotate( array ) , false ) : result ;
			
			System.out.println( "Whole array unique with rotation ? " + result );
			
			if( !result ) return result;
		}
		
		return result;
	}
	
	boolean sudoku2(char[][] grid) {

		boolean result = false;
		
		result = checkForUniqueByRow( grid, true);
		
		System.out.println("Whole Grid unique ? " + result );
		
		result = result ? checkForUniqueByRow( rotate( grid), true ) : result ;
		
		System.out.println("Whole Grid unique with rotation ? " + result );
		
		result = result ? checkEquality( grid ) : result;
		
		System.out.println( result );
		return result;
	}
	
	public static void main( String ...args )
	{
		Sudoku2 obj = new Sudoku2();
		
		obj.sudoku2(  
				
  new char[][]{{'.','.','.','.','.','.','5','.','.'}, 
			   {'.','.','.','.','.','.','.','.','.'}, 
			   {'.','.','.','.','.','.','.','.','.'}, 
			   {'9','3','.','.','2','.','4','.','.'}, 
			   {'.','.','7','.','.','.','3','.','.'}, 
			   {'.','.','.','.','.','.','.','.','.'}, 
			   {'.','.','.','3','4','.','.','.','.'}, 
			   {'.','.','.','.','.','3','.','.','.'}, 
			   {'.','.','.','.','.','5','2','.','.'}}
				);
	}
}
