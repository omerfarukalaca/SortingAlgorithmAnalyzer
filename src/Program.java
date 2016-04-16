import java.io.IOException;
import java.util.ArrayList;

import inputOutput.InputOutputManager;
import mainObjectClasses.SortingProcess;
import sortingAlgorithms.SortingManager;

public class Program {

	public static void main(String[] args) throws IOException, InterruptedException {

		boolean exit = false;
		while (exit == false) {
			// Kullanıcı etkileşimi
			InputOutputManager inputOutputManager = new InputOutputManager();
			ArrayList<String> answers = new ArrayList<>();
			answers = inputOutputManager.StartedAsking();

			// Sıralama için array'in oluşturulması, sıralama bilgilerinin
			// güncellenmesi.
			SortingManager sortingManager = new SortingManager();
			sortingManager.createSortingInfrastructure(answers);

			// Sıralama öncesi sıralam bilgilerinin görüntülenmesi.
			ArrayList<String> sortingInfos = new ArrayList<>();
			sortingInfos = sortingManager.getSortingRequestInfos();
			inputOutputManager.displaySortingInfos(sortingInfos);

			// Sıralama işlemi yapılıyor.
			sortingManager.startSorting();
			for (SortingProcess sp : sortingManager.getSortingProcessList()) {
				inputOutputManager.displaySortingResult(sp);
			}
			exit = inputOutputManager.selectStatus();
		}
		System.exit(0);
	}
}