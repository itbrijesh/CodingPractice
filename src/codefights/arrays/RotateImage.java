package codefights.arrays;

public class RotateImage {

	int[][] rotateImage(int[][] a) {
		
		if( a == null ) return null;

		int [][] result = new int[a.length][a.length];
		int s = a.length-1;
		
		for( int i = a.length-1; i >= 0; i-- )
		{
			for( int j=0; j< a[i].length; j++)
			{
				result [j][s-i] = a[i][j];
			}
		}
		
		for( int[] a1 : result )
		{
			for ( int a2 : a1 )
			{
				System.out.println( a2 );
			}
		}
		
		return result;
	}
	
	public static void main(String ...args)
	{
		RotateImage obj = new RotateImage();
		
		obj.rotateImage( new int[][] { {1,2,3},{4,5,6},{7,8,9} } );
		
	}
}
