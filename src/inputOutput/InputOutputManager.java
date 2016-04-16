package inputOutput;
import java.io.IOException;
import java.util.ArrayList;

import helpers.Constant;
import helpers.Constant.Numbers.SampleArrayLength;
import mainObjectClasses.SortingProcess;
import helpers.Constant.SortingAlgorithmNames;

public class InputOutputManager {
	
	ConsoleReaderWriter consoleReaderWriter = new ConsoleReaderWriter();

	public ArrayList<String> StartedAsking() throws IOException, InterruptedException {
		// 1. SORU
		///////////////////
		String Answer1;
		// Seçenekler
		SampleArrayLength sampleArrayLenghtInteger = new SampleArrayLength();
		ArrayList<String> sampleArrayLenghtString = new ArrayList<>();
		for (Integer i : sampleArrayLenghtInteger.getSampleArrayLengthList()) {
			sampleArrayLenghtString.add(i.toString());
		}
		sampleArrayLenghtString.add(Constant.Misc.DIGER);

		// Soru ve Seçenekler yazdırılıp cevap alınıyor.
		Answer1 = consoleReaderWriter.writeTestQuestion(1, Constant.Questions.ARRAYLENGTHTEST, sampleArrayLenghtString);

		if (Answer1 == Constant.Misc.DIGER) {
			Answer1 = consoleReaderWriter.writeSubQuestionReadAnswer(Constant.Questions.DESCRIBEARRAYLENGHT);
		}

		// 2. SORU
		//////////////////
		ArrayList<String> Answer2;
		// Seçenekler
		SortingAlgorithmNames SortingAlgorithmNames = new SortingAlgorithmNames();
		ArrayList<String> SortingAlgorithmNamesList = new ArrayList<>();
		SortingAlgorithmNamesList = SortingAlgorithmNames.getSortingAlgorithmNames();
		Answer2 = consoleReaderWriter.writeYesNoQuestion(2, Constant.Questions.CHOOSEALGORITHM,
				SortingAlgorithmNamesList);

		Answer2.add(Answer1);
		return Answer2;
	}

	public void displaySortingInfos(ArrayList<String> sortingInfos) {

		consoleReaderWriter.writeInformation(Constant.InfoTitles.SIRALAMABILGILERIBASLIGI,sortingInfos);
	}

	public void displaySortingResult(SortingProcess sp) {
		consoleReaderWriter.writeResult(sp.algorithmName,sp.timer.estimatedTimeMiliSecond,sp.timer.estimatedTimeNanoSecond);
	}

	public boolean selectStatus() throws IOException {
		return consoleReaderWriter.questionOfExit();
		
	}

}
