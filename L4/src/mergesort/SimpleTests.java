/*
 * Joseph Mulray
 * CS 350 L5 JUNIT
 * 5/25/17
 */


package mergesort;
import static org.junit.Assert.*;
import org.junit.* ;

public class SimpleTests {
	
	@Test
	public void testInOrder()
	{
	     Integer [] TestArray = new Integer[] {3,2,4};
	     Integer [] CorrectArray = new Integer[] {2,3,4};
	     MergeSort.mergeSort(TestArray);
	     assertTrue(CompareArrays(TestArray, CorrectArray));
	 
	 }
	
	@Test
	public void testNotOrder()
	{
	     Integer [] TestArray = new Integer[] {1,2,3,4,5};
	     Integer [] CorrectArray = new Integer[] {1,3,2,4,5};
	     MergeSort.mergeSort(TestArray);
	     assertTrue(!CompareArrays(TestArray, CorrectArray));
	}
	
	private boolean CompareArrays(Integer[] testArray, Integer[] correctArray) {
		
		for(int x=0; x< testArray.length; x++){
			if(testArray[x] != correctArray[x])
				return false;
		}
		return true;
	}
}