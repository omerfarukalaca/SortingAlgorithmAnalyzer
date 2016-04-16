package inputOutput;

import java.util.ArrayList;

public class InputValidation {

	public boolean validateAlphabeticInput(String answer, ArrayList<String> optionList) {

		if (optionList.contains(answer)) {
			return true;
		}
		return false;
	}
}
