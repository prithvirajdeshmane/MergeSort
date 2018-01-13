import java.util.ArrayList;

public class MergeSort {

	public static void main(String[] args) {
		ArrayList<Integer> input = createInput();
		System.out.println("Original: " + input);

		input = mergeSort(input);
		System.out.println("Sorted: " + input);
	}
	
	private static ArrayList<Integer> mergeSort(ArrayList<Integer> input) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		// if array or split is only 1 cell, return itself
		if(input.size() == 1) {
			return input;
		}
		
		// if array or split has 2 elements only, sort them and return sorted array
		if(input.size() == 2) {
			return swap(input);
		}
		
		// split and make recursive calls
		int split = (input.size()+1)/2;
		
		ArrayList<Integer> leftPartition = new ArrayList<Integer>();
		for (int i = 0; i < split; i++) {
			leftPartition.add(input.get(i));			
		}
		
		ArrayList<Integer> rightPartition = new ArrayList<Integer>();
		for (int i = split; i < input.size(); i++) {
			rightPartition.add(input.get(i));			
		}
		
		// recursively call mergeSort on left and right partitions
		leftPartition = mergeSort(leftPartition);
		rightPartition = mergeSort(rightPartition);
				
		// merge in sorted order
		result = merge(leftPartition, rightPartition);
		
		return result;
	}
	
	
	// Merge two sorted arrays
	private static ArrayList<Integer> merge(ArrayList<Integer> input1, ArrayList<Integer> input2) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int indexA = 0, indexB = 0, indexRes = 0;
		
		// Start merging until all elements from at least one array have been exhausted
		while(indexA < input1.size() && indexB < input2.size()) {			
			if(input1.get(indexA) < input2.get(indexB)) {
				result.add(indexRes++, input1.get(indexA++));
			} else {
				result.add(indexRes++, input2.get(indexB++));
			}			
		}
		
		// If there are remaining unprocessed elements in first array, append them to the resulting array 
		while (indexA < input1.size()) { 
			result.add(indexRes++, input1.get(indexA++));
		}
		
		// If there are remaining unprocessed elements in second array, append them to the resulting array
		while (indexB < input2.size()) {
			result.add(indexRes++, input2.get(indexB++));
		}
		
		return result;
	}
	
	// Sort the two elements in the array
	private static ArrayList<Integer> swap(ArrayList<Integer> input) {
		
		int min = Math.min(input.get(0), input.get(1));
		int max = Math.max(input.get(0), input.get(1));
		
		input.set(0, min);
		input.set(1, max);
		
		return input;		
	}
	
	// Create a new input array
	private static ArrayList<Integer> createInput () {
		ArrayList<Integer> input = new ArrayList<Integer> ();
		
		input.add(85);
		input.add(77); 
		input.add(24); input.add(35); 
		input.add(42); input.add(17); input.add(93); input.add(58);
		input.add(71);
		
		return input;
	}

}
