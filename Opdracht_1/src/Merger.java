import java.util.ArrayList;

/**
 * Merger for merging two sorted ArrayLists into one
 * @author Robin Verheijen
 * @author Saron Grave
 */
public class Merger {
	
	/**
	 * Method for merging two sorted lists into one
	 * @param list1
	 * @param list2
	 * @return The merged list
	 */
	public ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		
		for (int index1 = 0, index2 = 0; index2 < list2.size(); index1++) {
	        if (index1 == list1.size() || list1.get(index1) > list2.get(index2)) {
	        	list1.add(index1, list2.get(index2++));
	        }
	    }
		
		// Return the merged list
		return list1;
	}
}
