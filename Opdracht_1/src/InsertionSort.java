import java.util.ArrayList;

public class InsertionSort {
	
	public InsertionSort() {
		
	}
	
	public long sort(ArrayList<Integer>numbersArray) {
		
		int currentProgress;
		int currentNumber;
		int index;
		
		long startTime = System.currentTimeMillis();
		for(currentProgress = 1; currentProgress < numbersArray.size(); currentProgress++) {
			
			currentNumber = numbersArray.get(currentProgress);
			
			for(index = currentProgress - 1; (index >= 0) && (numbersArray.get(index) > currentNumber); index--) {
				
				numbersArray.set(index + 1, numbersArray.get(index));
			}
			
			numbersArray.set(index + 1, currentNumber);
		}
		
		long stopTime = System.currentTimeMillis();

		return stopTime - startTime;
	}
}