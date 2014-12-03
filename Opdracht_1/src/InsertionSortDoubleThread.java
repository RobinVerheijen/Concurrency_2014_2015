import java.util.ArrayList;
import java.util.Random;

/**
 * Double threaded InsertionSort class
 * @author Robin Verheijen
 * @author Saron Grave
 */
public class InsertionSortDoubleThread extends InsertionSortThread {
		
	/**
	 * Constructor which get passed the array with numbers.
	 * @param numbersArray
	 */
	public InsertionSortDoubleThread(ArrayList<Integer> numbersArray) {
		super(numbersArray);
	}
	
	/**
	 * Run method which will sort the given numbers
	 */
	public void run() {
		
		InsertionSort sorter = new InsertionSort();
		numbersArray = sorter.sort(numbersArray);
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
