import java.util.ArrayList;

/**
 * Base InsertionSortThread class from which other classes can inherit.
 * This class contains the array with the numbers to be sorted, a basic constructor and a method to get the sorted array.
 * @author Robin Verheijen
 * @author Saron Grave
 */
public class InsertionSortThread extends Thread {
	
	// The array with the numbers
	protected ArrayList<Integer> numbersArray;
	
	/**
	 * Constructor which get passed the array with numbers.
	 * @param numbersArray
	 */
	public InsertionSortThread(ArrayList<Integer> numbersArray) {
		
		// Put the passed array into the local array variable
		this.numbersArray = numbersArray;
	}
	
	/**
	 * Method for returning the sorted array
	 * @return The sorted array
	 */
	public ArrayList<Integer> getSortedArray() {
		
		// Return the sorted array
		return numbersArray;
	}
}