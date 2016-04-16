package mainObjectClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import helpers.Constant;
import helpers.RandomNumberGenerator;

public class SortingRequest {

	Date requestDateTime;
	int arrayLength; // Sıralanacak dizi uzunluğu
	int[] array; // Sırasız dizi
	int[] orderedArray; // Sıralı
	public ArrayList<SortingProcess> sortingProcessList; // Sıralama işlemleri

	public SortingRequest() {
		Date date = new Date();
		this.requestDateTime = date;
	}

	public void setSortingPreferences(int length, ArrayList<String> sortingAlgorithmNames) {
		// Dizi oluşturuluyor.
		this.arrayLength = length;
		this.array = new int[arrayLength];
		this.orderedArray = new int[arrayLength];

		// Diziye rastgele değerler atanıyor.
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		randomNumberGenerator.fillArrayByRandomIntValue(this.array);
		this.orderedArray = this.array.clone();

		// Sıralı dizi değişkeni kontrol amaçlı kullanılmak için hazır kütüphane
		// ile sıralanıyor.
		Arrays.sort(orderedArray);

		// Sorting Process listesi yani kullanılacak algoritmalar ile sıralama
		// isteği bağlanıyor.
		ArrayList<SortingProcess> sortingProcessList = new ArrayList<>();
		for (String algorithmName : sortingAlgorithmNames) {
			SortingProcess sortingProcess = new SortingProcess(algorithmName, this);
			sortingProcessList.add(sortingProcess);
		}
		this.setSortingProcessList(sortingProcessList);
	}

	public ArrayList<String> getInfos() {
		ArrayList<String> infos = new ArrayList<>();

		infos.add(Constant.InfoTitles.SIRALAMAZAMANI);
		infos.add(this.requestDateTime.toString());
		infos.add(Constant.InfoTitles.DIZIUZUNLUGU);
		infos.add(Integer.toString(this.arrayLength));

		infos.add(Constant.InfoTitles.ALGORITMALAR);
		String algorithms= new String("");
		for(SortingProcess sp :this.sortingProcessList)
		{
			algorithms += (sp.algorithmName+" - ");
		}
		infos.add(algorithms);
		return infos;
	}

	public void setArrayIndex(int index, int value) {
		this.array[index] = value;
		this.orderedArray[index] = value;
	}

	public void setSortingProcessList(ArrayList<SortingProcess> sortingProcessList) {
		this.sortingProcessList = sortingProcessList;
	}

	public ArrayList<SortingProcess> getSortingProcessList() {
		return sortingProcessList;
	}
}
