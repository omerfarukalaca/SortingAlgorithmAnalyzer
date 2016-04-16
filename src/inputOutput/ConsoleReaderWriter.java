package inputOutput;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import helpers.Constant;
import helpers.Constant.AlphabeticalTestOptions;
import helpers.Constant.YesNoAnswer;

public class ConsoleReaderWriter {
	
	private static BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
	private static InputValidation validation = new InputValidation();
	
	public void writeWelcomeMessage(String welcomeMessage) {
		System.out.println(welcomeMessage);
	}
	
	public String writeTestQuestion(int questionNo,String question,ArrayList<String> answerList) throws IOException, InterruptedException {
		System.out.println(Constant.ConsoleBorders.LINE);
		
		System.out.println(questionNo+". "+question);
		
		ArrayList<String> alphabeticalTestOptionsList = new ArrayList<>();
		Constant.AlphabeticalTestOptions alphabeticalTestOptions = new AlphabeticalTestOptions();
		alphabeticalTestOptionsList = alphabeticalTestOptions.getAlphabeticalTestOptionsList();
		int index=0;
		for(String answer:answerList)
		{
			System.out.println("    "+alphabeticalTestOptionsList.get(index++)+". "+answer);
		}
		
		String option = null;
		boolean validate = false;
		while(validate==false){
			System.out.print(Constant.ConsoleBorders.ANSWERICON);
			option = bufferReader.readLine();
			
			validate = validation.validateAlphabeticInput(option,alphabeticalTestOptions.getAllAlphabeticalTestOptionsList());
			if(validate == false)
			{
				System.err.println("Lütfen uygun değer giriniz.[A,B,C,D]");
				Thread.sleep(100);
			}
		}
		Integer optionRank = alphabeticalTestOptions.getOptionRank(option); // Seçenek yerine seçeneğin sırası yazılıyor.
		return answerList.get(optionRank);
	}
	
	public ArrayList<String> writeYesNoQuestion(int questionNo,String question,ArrayList<String> questionList) throws IOException, InterruptedException {
		ArrayList<String> yesAnswers = new ArrayList<>();
		
		System.out.println(Constant.ConsoleBorders.LINE);
		System.out.println(questionNo+". "+question);
		
		Constant.YesNoAnswer yesNoAnswer = new YesNoAnswer();
		for(String que:questionList)
		{
			String selection = null;
			boolean validate = false;
			while(validate==false)
			{
				System.out.print("\t"+Constant.ConsoleBorders.ANSWERICON+que+" :");
				selection = bufferReader.readLine();
				validate = validation.validateAlphabeticInput(selection,yesNoAnswer.getYesNoAnswerList());
				if(validate == false)
				{
					System.err.println("Lütfen uygun değer giriniz.[E/H]");
					Thread.sleep(100);
				}
			}		
			
			if(selection.equals(Constant.YesNoAnswer.EVET) || selection.equals(Constant.YesNoAnswer.evet))
				yesAnswers.add(que);
		}
		return yesAnswers;
	}

	public String writeSubQuestionReadAnswer(String subquestion) throws IOException, InterruptedException {
		String answerString = null;
;		Integer answerInt;
		try{
			System.out.print("\t"+Constant.ConsoleBorders.ANSWERICON+subquestion+" :");
			answerInt =Integer.parseInt(bufferReader.readLine());
			answerString = answerInt.toString();
		}catch(NumberFormatException nfe){
			System.err.print("Lütfen sayı giriniz!\n");
			Thread.sleep(100);
			answerString = writeSubQuestionReadAnswer(subquestion);
		}
		return answerString;
	}

	public void writeInformation(String Title,ArrayList<String> sortingInfos) {
		System.out.println(Constant.ConsoleBorders.SHARPLINE);
		System.out.println(Title);
		for(int index=0;index<sortingInfos.size();index++)
			System.out.println(sortingInfos.get(index)+"\t\t: "+sortingInfos.get(++index));
		System.out.println();
	}
	
	public void writeResult(String title,double estimatedTimeMiliSecond,double estimatedTimeNanoSecond) {
		System.out.println(title+"\t\t: "+estimatedTimeMiliSecond+" milisaniye\t=\t"+(long)estimatedTimeNanoSecond+" nanosaniye");
	}

	public boolean questionOfExit() throws IOException {
		System.out.println(Constant.ConsoleBorders.SHARPLINE);
		System.out.println(Constant.Misc.EXITQUESTION);
		System.out.print(Constant.ConsoleBorders.ANSWERICON);
		String answer = bufferReader.readLine();
		
		if(answer.equals(Constant.YesNoAnswer.evet) || answer.equals(Constant.YesNoAnswer.EVET))
			return false;
		else
			return true;
	}
	
}
