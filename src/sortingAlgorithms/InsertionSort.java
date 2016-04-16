package sortingAlgorithms;

public class InsertionSort {
	
	public int[] Sort(int[] array) {

		int arrayLength = array.length;
		int key;
		int i;
			
		for(int j=1;j<arrayLength;j++)
		{
			key = array[j];
			i = j-1;
			while(i>=0 && array[i]>key)
			{
				array[i+1] = array[i];
				i=i-1;
			}
			array[i+1] = key;
		}
		return array;
	}
}