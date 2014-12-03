import java.util.ArrayList;
import java.util.Random;

/**
 * Single threaded InsertionSort class
 * @author Robin Verheijen
 * @author Saron Grave
 */
public class InsertionSort {
	
	// The array with the numbers to be sorted
	private ArrayList<Integer> numbersArray;
	
	/**
	 * Method for sorting the given numbers.
	 * @return The amount of time it took to sort the numbers
	 */
	public ArrayList<Integer> sort(ArrayList<Integer> numbersArray) {
	    	    
		// Declare some variables which will be used for the sorting
		int currentProgress;
		int currentNumber;
		int index;
				
		// Sort the array
		for(currentProgress = 1; currentProgress < numbersArray.size(); currentProgress++) {
			
			// Get the current number from the array based on the current progress
			currentNumber = numbersArray.get(currentProgress);
			
			// Sort the numbers
			for(index = currentProgress - 1; (index >= 0) && (numbersArray.get(index) > currentNumber); index--) {
				
				numbersArray.set(index + 1, numbersArray.get(index));
			}
			
			// Set the next number
			numbersArray.set(index + 1, currentNumber);
		}
				
		// Return the time it took to sort the numbers
		return numbersArray;
	}
	
	/**
	 * Method for sorting the array
	 * @return The sorted array
	 */
	public ArrayList<Integer> sortArray() {
		
		// Variables for sorting the numbers
		int currentProgress;
		int currentNumber;
		int index;
		
		// Sort the numbers
		for(currentProgress = 1; currentProgress < numbersArray.size(); currentProgress++) {
			
			currentNumber = numbersArray.get(currentProgress);
			
			for(index = currentProgress - 1; (index >= 0) && (numbersArray.get(index) > currentNumber); index--) {
				
				numbersArray.set(index + 1, numbersArray.get(index));
			}
			
			numbersArray.set(index + 1, currentNumber);
		}
		
		// Return the sorted array
		return numbersArray;
	}
}