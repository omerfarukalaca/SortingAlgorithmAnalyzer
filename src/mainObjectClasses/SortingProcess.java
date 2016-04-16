package mainObjectClasses;
import java.util.ArrayList;

import helpers.Timer;

public class SortingProcess {

	public String algorithmName;
	public SortingRequest connectedSortRequest;
	public int[] array;
	public Timer timer;

	public SortingProcess(String algorithmName, SortingRequest sortRequest) {
		this.algorithmName = algorithmName;
		this.array = sortRequest.array.clone();
		this.connectedSortRequest = sortRequest;
		this.timer = new Timer(this);
	}
	
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public ArrayList<String> getInfos() {
		ArrayList<String> infos = new ArrayList<>();

		infos.add(algorithmName);
		infos.add(Double.toString(timer.estimatedTimeMiliSecond));
		infos.add(Double.toString(timer.estimatedTimeSecond));

		return infos;
	}
}
