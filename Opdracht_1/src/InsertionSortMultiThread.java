import java.util.ArrayList;

/**
 * Multi threaded InsertionSort class
 * @author Robin Verheijen
 * @author Saron Grave
 */
public class InsertionSortMultiThread extends InsertionSortThread {
	
	// M
	private Merger merger;
	
	/**
	 * Constructor which get passed the array with numbers
	 * @param numbersArray
	 */
	public InsertionSortMultiThread(ArrayList<Integer> numbersArray) {
		super(numbersArray);
		
		// Instantiate the merger
		merger = new Merger();
	}
	
	/**
	 * Run method in which is determined if the remaining amount of numbers is greater than a certain amount. 
	 * If so the given array is split into two new arrays, these arrays are then put into two new InsertionSortMultiThreads.
	 * If the remaining amount of numbers is smaller than the certain amount the numbers are sorted.
	 */
	public void run() {
		
		// Check if the remaining amount of numbers is greater or equal to a certain amount
		if(this.numbersArray.size() >= 8000) {
			
			// Instantiate two new arrays for containing the numbers
			ArrayList<Integer> firstPart = new ArrayList<Integer>();
			ArrayList<Integer> secondPart = new ArrayList<Integer>();
			
			// Split the original array in two and put the numbers into the previously created arrays
			for(int i = 0; i < this.numbersArray.size(); i++) {
				
				if(i <= this.numbersArray.size() / 2 - 1) {
					
					firstPart.add(this.numbersArray.get(i));
				} else {
					
					secondPart.add(this.numbersArray.get(i));
				}
			}
			
			// Instantiate two new threads and pass the arrays to them
			InsertionSortMultiThread firstMultiThread = new InsertionSortMultiThread(firstPart);
		    InsertionSortMultiThread secondMultiThread = new InsertionSortMultiThread(secondPart);
		    
		    // Start the threads
		    firstMultiThread.start();
		    secondMultiThread.start();
	    	
		    // Wait for the threads to have finished
		    try {
		    	
		    	firstMultiThread.join();
		    	secondMultiThread.join();
		    } catch(InterruptedException e) {
		    	
		    	// Catch an error
		    	System.out.println("The sorting was interrupted");
		    }
    		
		    // Merge the results of the threads into the numbers array
		    this.numbersArray = merger.merge(firstMultiThread.getSortedArray(), secondMultiThread.getSortedArray());
		} else {
			
			InsertionSort sorter = new InsertionSort();
			this.numbersArray = sorter.sort(numbersArray);		
		}
	}
}