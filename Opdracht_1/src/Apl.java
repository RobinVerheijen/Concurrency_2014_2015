import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * Main class with the static void main method which is called after starting the application.
 * @author Robin Verheijen
 * @author Saron Grave
 */
public class Apl {
	
	/**
	 * Main method where can be chosen which assignment should be tested.
	 * @param args
	 */
	public static void main(String[] args) {
	    
		// Let the user see which options are available
		System.out.println("Which assignment would you like to test?\n 1: single threaded\n 2: double threaded\n 3: multi threaded");
		
		// Variable which determines the amount of numbers to be sorted.
		int amountOfNumbers = 800000;
		
		// Variables for keeping track of time
		long startTime;
		long stopTime;
		long elapsedTime;
		
		// Create an array with random numbers
		ArrayList<Integer> numbersArray = generateArray(amountOfNumbers, amountOfNumbers);
				
		// Create a merger for merging sorted arrays
		Merger merger = new Merger();
				
		// Create the scanner for reading input from the console
		Scanner consoleReader = new Scanner(System.in);
		
		// Read the input from the console
		String consoleInput = consoleReader.nextLine();
						
		// Check which input was received
		switch (consoleInput) {
			case "1":
				System.out.println("Started sorting single threaded");
				
				// Create a single threaded insertion sorter, pass the amount of numbers to the constructor
			    InsertionSort sorter = new InsertionSort();
				
			    // Get the start time
				startTime = System.currentTimeMillis();
				
			    // Sort the array
				sorter.sort(numbersArray);
				
				// Get the end time
				stopTime = System.currentTimeMillis();
				
				// Calculate the amount of time it took to sort the numbers
				elapsedTime = stopTime - startTime;
				
				// Show the user how long it took to sort the amount of numbers
				System.out.println("Took " + elapsedTime + " milliseconds to sort " + amountOfNumbers);
				break;
			case "2":
				System.out.println("Started sorting double threaded");
				
				// Create some variables used for the sorting
				InsertionSortDoubleThread firstThread;
				InsertionSortDoubleThread secondThread;
				ArrayList<Integer> firstPart;
				ArrayList<Integer> secondPart;
				
				// Generate numbers and place them in the arrays
				firstPart = generateArray(amountOfNumbers / 2 - 1, amountOfNumbers);
				secondPart = generateArray(amountOfNumbers / 2, amountOfNumbers);
			    
				// Create the sorting threads, pass the array to them
			    firstThread = new InsertionSortDoubleThread(firstPart);
			    secondThread = new InsertionSortDoubleThread(secondPart);
			    
			    // Get the current time
			    startTime = System.currentTimeMillis();
			    
			    // Start the threads
			    firstThread.start();
			    secondThread.start();
			    
			    // Wait for the threads to have finished
			    try {
			    	
			    	firstThread.join();
			    	secondThread.join();
			    } catch(InterruptedException e) {
			    	
			    	// Catch an error
			    	System.out.println("The sorting was interrupted");
			    }
			    
			    // Merge the two sorted arrays into one
			    merger.merge(firstThread.getSortedArray(), secondThread.getSortedArray());
			    
			    // Calculate how long it took to sort the numbers
	    		stopTime = System.currentTimeMillis();
	    		long duration = stopTime - startTime;
	    		
	    		// Show the user how long it took to sort the numbers
	    		System.out.println("Took " + duration + " milliseconds to sort " + amountOfNumbers);
				break;
			case "3":
				System.out.println("Started sorting multi threaded");
				long[] timeList = new long[10];
				long average = 0;
				for (int i =0; i < 10; i++) {
					// Create a thread to sort the numbers, pass the array to the constructor
				    InsertionSortMultiThread originalThread = new InsertionSortMultiThread(numbersArray, 5000);
				    
				    // Get the start time
				    long beginTime = System.currentTimeMillis();
				    
				    // Start the array
				    originalThread.start();
				    
				    // Wait for the thread to have finished
				    try {
				    	
				    	originalThread.join();
				    } catch(InterruptedException e) {
				    	
				    	// Catch an error
				    	System.out.println("The sorting was interrupted");
				    }
				    
				    // Calculate how long it took to sort
		    		long endTime = System.currentTimeMillis();
		    		timeList[i] = (endTime - beginTime);
				}
			    
				for (int i = 0; i < timeList.length; i++) {
					average = average + timeList[i];
				}
				average = (average/10);
	    		
	    		// Show the user how long it took to sort the numbers
	    		System.out.println("Took " + average + " milliseconds to sort " + amountOfNumbers);
				break;
			default:
				
				// Catch errors
				System.out.println("Please fill in 1, 2 or 3. Run the application again.");
				break;
		}
		
		// Close the scanner
		consoleReader.close();
	}
	
	private static ArrayList<Integer> generateArray(int amountOfNumbers, int maxNumber) {
		
		// Instantiate the numbers array
		ArrayList<Integer> theArray = new ArrayList<Integer>();
		
		// Instantiate a random generator
		Random randomGenerator = new Random();
		
		// Fill the numbers array with random numbers
	    for (int idx = 0; idx <= amountOfNumbers; ++idx){
    	
	    	int randomInt = randomGenerator.nextInt(maxNumber);
	    	theArray.add(randomInt);
	    }
	    
	    return theArray;
	}
}