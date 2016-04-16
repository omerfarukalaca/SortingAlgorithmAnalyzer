package sortingAlgorithms;
import java.util.ArrayList;

import helpers.Constant;
import mainObjectClasses.SortingRequest;
import mainObjectClasses.SortingProcess;

public class SortingManager {

	private SortingRequest newSortRequest = new SortingRequest();
	private InsertionSort insertionSort = new InsertionSort();
	private Mergesort mergesort = new Mergesort();

	public void createSortingInfrastructure(ArrayList<String> answers) {

		int arrayLength = getArrayLengthByAnswer(answers);
		ArrayList<String> sortingAlgorithmNames = new ArrayList<>();
		sortingAlgorithmNames = getAlgorithmsByAnswers(answers);

		this.newSortRequest.setSortingPreferences(arrayLength, sortingAlgorithmNames);
	}

	public void startSorting() {
		for (SortingProcess sp : this.newSortRequest.sortingProcessList) {
			if (sp.algorithmName == Constant.SortingAlgorithmNames.INSERTIONSORT) {
				sp.timer.startTimer();
				insertionSort.Sort(sp.array);
				sp.timer.stopTimer();
			}
			if (sp.algorithmName == Constant.SortingAlgorithmNames.MERGESORT) {
				sp.timer.startTimer();
				mergesort.sort(sp.array);
				sp.timer.stopTimer();
			}
		}
	}

	public SortingRequest getSortingRequest(){
		return this.newSortRequest;
	}
	
	public ArrayList<SortingProcess> getSortingProcessList() {
		return this.newSortRequest.getSortingProcessList();
	}

	public ArrayList<String> getSortingRequestInfos() {
		ArrayList<String> infoArray = new ArrayList<>();
		infoArray = newSortRequest.getInfos();
		return infoArray;
	}

	public int getArrayLengthByAnswer(ArrayList<String> answers) {
		return Integer.parseInt(answers.get(answers.size() - 1));
	}

	public ArrayList<String> getAlgorithmsByAnswers(ArrayList<String> answers) {
		answers.remove(answers.get(answers.size() - 1));
		ArrayList<String> sortingAlgorithmNames = new ArrayList<>();
		sortingAlgorithmNames.addAll(answers);
		return sortingAlgorithmNames;
	}
}
