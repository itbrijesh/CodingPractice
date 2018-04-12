package codefights.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Gropingdishes {

	String[][] groupingDishes(String[][] dishes) 
	{
		String[][] result = null;
		
		TreeMap<String, TreeSet<String>> map = new TreeMap<>();
		TreeSet<String> dishesFound = new TreeSet<>();
		TreeSet<String> dishesFinal = new TreeSet<>(); 
		
		boolean dishFlag = true;
		String dishName = null;
		
		
		for( String[] array1 : dishes )
		{
			dishName = null;
			dishesFound = new TreeSet<>();
			
			for( String array2 : array1 )
			{
				if( dishName == null ) 
				{
					dishName = array2;
				}
				else 
				{
					if( map.containsKey( array2 ) )
					{
						dishesFinal.add( array2 );
						
						map.get( array2 ).add( dishName );
						
					}
					else
					{
						dishesFound = new TreeSet();
						dishesFound.add( dishName );
						map.put( array2 , dishesFound );
					}
				}
			}
		}
		
		System.out.println( " MAP " + map );
		System.out.println( " Final Resul " + dishesFinal );
		
		result = new String[ dishesFinal.size() ][];
		int counter = 0;
		
		for( String dish : dishesFinal )
		{
			String [] temp = new String[ map.get( dish ).size()+1 ];
			int counter2 = 0;
			
			temp[counter2] = dish;
			
			for( String stemp : map.get( dish) )
			{
				counter2++;
				temp[counter2] = stemp;
			}
			
			result[counter] = temp;
			counter++;
		}
		
		return result;
	}

	public static void main ( String ...args )
	{
		Gropingdishes obj = new Gropingdishes();
		
		String[][] dishes = 
					{{"Salad","Tomato","Cucumber","Salad","Sauce"}, 
					{"Pizza","Tomato","Sausage","Sauce","Dough"}, 
					{"Quesadilla","Chicken","Cheese","Sauce"}, 
					{"Sandwich","Salad","Bread","Tomato","Cheese"}};
		
		
		obj.groupingDishes(dishes);
	}
}
