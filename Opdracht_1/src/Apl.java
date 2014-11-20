import java.util.ArrayList;
import java.util.Random;

public class Apl {
	
	public static void main(String[] args) {
		
		int amountOfNumbers = 50000;
		ArrayList<Integer> numbersArray = new ArrayList<Integer>();
		
		Random randomGenerator = new Random();
	    for (int idx = 0; idx <= amountOfNumbers; ++idx){
	    	
	      int randomInt = randomGenerator.nextInt(amountOfNumbers);
	      numbersArray.add(randomInt);
	    }
	    
		InsertionSort sorter = new InsertionSort();
		
		long elapsedTime = sorter.sort(numbersArray);
		
		System.out.println("Took " + elapsedTime + " milliseconds to sort " + amountOfNumbers);
	}
}