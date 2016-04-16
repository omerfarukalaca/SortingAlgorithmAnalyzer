package helpers;

import java.util.Random;

public class RandomNumberGenerator {

	public int getRandomIntByMinMaxValue(int min, int max) {
		Random rand;
		rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public int getRandomInt() {
		Random rand;
		rand = new Random();
		int randomNum = rand
				.nextInt((Constant.Numbers.RandomRangeValue.INT_MAX - Constant.Numbers.RandomRangeValue.INT_MIN) + 1)
				+ Constant.Numbers.RandomRangeValue.INT_MIN;
		return randomNum;
	}

	public int[] fillArrayByRandomIntValue(int[] array) {

		for (int i = 0; i < array.length; i++) {
			array[i] = getRandomInt();
		}
		return array;
	}
}
