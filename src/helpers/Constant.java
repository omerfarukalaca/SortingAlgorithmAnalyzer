package helpers;

import java.util.ArrayList;
import java.util.Hashtable;

public class Constant {

	public final static class Numbers {

		/**
		 * Random sayı üretici için default min-max değerleri
		 */
		public final static class RandomRangeValue {
			public static final Integer INT_MAX = (int) Math.pow(2, 64) - 1;
			public static final Integer INT_MIN = 0;
		}

		/**
		 * Dizi uzunluğu seçenekleri
		 */
		public final static class SampleArrayLength {

			public static final Integer TENMILLION = 10000000;
			public static final Integer THREEHUNDREDTHOUSAND = 300000;
			public static final Integer FIVEHUNDREDTHOUSAND = 500000;
			public static final Integer ONEMILLION = 1000000;

			public ArrayList<Integer> getSampleArrayLengthList() {
				ArrayList<Integer> SampleArrayLengthList = new ArrayList<>();
				SampleArrayLengthList.add(TENMILLION);
				SampleArrayLengthList.add(ONEMILLION);
				SampleArrayLengthList.add(FIVEHUNDREDTHOUSAND);
				SampleArrayLengthList.add(THREEHUNDREDTHOUSAND);
				return SampleArrayLengthList;
			}

		}
	}

	public final static class ModeTypes {

		public static final String USERDEFINED = "User Defined";
		public static final String DEFAULT = "Default";

		public ArrayList<String> getModeTypesList() {
			ArrayList<String> ModeTypesList = new ArrayList<>();
			ModeTypesList.add(USERDEFINED);
			ModeTypesList.add(DEFAULT);
			return ModeTypesList;
		}
	}

	public final static class SortingAlgorithmNames {

		public static final String MERGESORT = "Mergesort";
		public static final String INSERTIONSORT = "Insertion Sort";

		public ArrayList<String> getSortingAlgorithmNames() {
			ArrayList<String> sortingAlgorithmNameList = new ArrayList<>();
			sortingAlgorithmNameList.add(MERGESORT);
			sortingAlgorithmNameList.add(INSERTIONSORT);
			return sortingAlgorithmNameList;
		}
	}

	public final static class YesNoAnswer {

		public static final String EVET = "E";
		public static final String HAYIR ="H";
		public static final String evet = "e";
		public static final String hayır ="h";

		public ArrayList<String> getYesNoAnswerList() {
			ArrayList<String> yesNoAnswerList = new ArrayList<>();
			yesNoAnswerList.add(EVET);
			yesNoAnswerList.add(HAYIR);
			yesNoAnswerList.add(evet);
			yesNoAnswerList.add(hayır);
			return yesNoAnswerList;
		}
	}

	public final static class AlphabeticalTestOptions {
		
		public static final String A = "A";
		public static final String B = "B";
		public static final String C = "C";
		public static final String D = "D";
		public static final String E = "E";
		
		public static final String a = "a";
		public static final String b = "b";
		public static final String c = "c";
		public static final String d = "d";
		public static final String e = "e";
		
		public ArrayList<String> getAllAlphabeticalTestOptionsList() {
			ArrayList<String> allAlphabeticalTestOptionsList = new ArrayList<>();
			allAlphabeticalTestOptionsList.add(A);
			allAlphabeticalTestOptionsList.add(a);
			allAlphabeticalTestOptionsList.add(B);
			allAlphabeticalTestOptionsList.add(b);
			allAlphabeticalTestOptionsList.add(C);
			allAlphabeticalTestOptionsList.add(c);
			allAlphabeticalTestOptionsList.add(D);
			allAlphabeticalTestOptionsList.add(d);
			allAlphabeticalTestOptionsList.add(E);
			allAlphabeticalTestOptionsList.add(e);
			return allAlphabeticalTestOptionsList;
		}
		
		public ArrayList<String> getAlphabeticalTestOptionsList() {
			ArrayList<String> alphabeticalTestOptionsList = new ArrayList<>();
			alphabeticalTestOptionsList.add(A);
			alphabeticalTestOptionsList.add(B);
			alphabeticalTestOptionsList.add(C);
			alphabeticalTestOptionsList.add(D);
			alphabeticalTestOptionsList.add(E);
			return alphabeticalTestOptionsList;
		}
		
		public Integer getOptionRank(String option)
		{
			Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
			hashtable.put("A",0);
			hashtable.put("a",0);
			hashtable.put("B",1);
			hashtable.put("b",1);
			hashtable.put("C",2);
			hashtable.put("c",2);
			hashtable.put("D",3);
			hashtable.put("d",3);
			hashtable.put("E",4);
			hashtable.put("e",4);
			return hashtable.get(option);
		}
	}
	
	public final static class ConsoleBorders {
		public static final String LINE = "--------------------------------------------------------------------------------------";
		public static final String SHARPLINE = "\n######################################################################################";
		public static final String ANSWERICON = ">> ";
	}
	
	public final static class Questions {
		public static final String ARRAYLENGTHTEST = "Sıralanacak olan dizinin uzunluğunu seçiniz.";
		public static final String CHOOSEALGORITHM = "Dizinin sıralanmasını istediğiniz algoritmaları seçiniz.[E/H]";
		public static final String DESCRIBEARRAYLENGHT = "Dizi uzunluğunu giriniz";
	}
	
	public final static class Misc {
		public static final String DIGER = "Diğer";
		public static final String EXITQUESTION = "Yeni bir arama için E, çıkmak için herhangi bir tışa basınız.";
	}
	
	public final static class InfoTitles {
		public static final String SIRALAMABILGILERIBASLIGI = "SIRALAMA BİLGİLERİ;";
		public static final String SIRALAMAZAMANI = "Sıralama Zamanı";
		public static final String DIZIUZUNLUGU = "Dizi Uzunluğu";
		public static final String ALGORITMALAR = "Algoritmalar";
	}
}

