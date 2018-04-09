package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateArrays3x3 {

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
	
	public static void main( String ...args )
	{
		CreateArrays3x3 obj = new CreateArrays3x3();
		List list = obj.createArrays( 
				new char[][]{{'1','2','3','4','5','6','7','8','9'}, 
							 {'1','2','3','4','5','6','7','8','9'}, 
							 {'1','2','3','4','5','6','7','8','9'}, 
							 {'1','2','3','4','5','6','7','8','9'}, 
							 {'1','2','3','4','5','6','7','8','9'}, 
							 {'1','2','3','4','5','6','7','8','9'}, 
							 {'1','2','3','4','5','6','7','8','9'}, 
							 {'1','2','3','4','5','6','7','8','9'}, 
							 {'1','2','3','4','5','6','7','8','9'}} 
				
		);
		
		for( int i = 0; i < list.size(); i++ )
		{
			char[][] array = (char[][]) list.get(i);
			
			System.out.println( " Array " + i + "--------------------------------------------------");
			for( int x = 0; x < array.length; x++ )
			{
				for( int y = 0; y < array[x].length; y++ )
				{
					System.out.println( "("+x+","+y+"):" + array[x][y]);
				}
			}
		}
	}
}
