package helpers;
import java.util.concurrent.TimeUnit;

import mainObjectClasses.SortingProcess;

public class Timer {

	public SortingProcess relatedSorting;
	public long startTime;
	public long stopTime;
	public long estimatedTimeNanoSecond;
	public double estimatedTimeMiliSecond;
	public double estimatedTimeSecond;

	public Timer(SortingProcess sortingProcess) {
		super();
		this.relatedSorting = sortingProcess;
	}

	public void startTimer() {
		long result = System.nanoTime();
		this.startTime = result;
	}

	public void stopTimer() {
		long stop = System.nanoTime();
		this.stopTime = stop;

		long result = stopTime - startTime;
		this.estimatedTimeNanoSecond = result;

		GenerateOtherMetrics();
	}

	private void GenerateOtherMetrics() {
		this.estimatedTimeSecond = TimeUnit.NANOSECONDS.toSeconds(this.estimatedTimeNanoSecond);
		this.estimatedTimeMiliSecond = TimeUnit.NANOSECONDS.toMillis(this.estimatedTimeNanoSecond);
	}
}
