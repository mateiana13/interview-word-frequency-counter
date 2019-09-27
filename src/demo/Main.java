package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import api.IFrequency;
import impl.FrequencyCounter;
import impl.Utils;

public class Main {

	public static void main(String[] args) throws IOException {
		IFrequency frequencyCounter = new FrequencyCounter();

		InputStream fir = new FileInputStream(new File("src/resources/input.txt"));

		Map<String, Integer> frequencies = frequencyCounter.computeWordFrequency(fir);

		OutputStream prWords = new FileOutputStream("src/resources/words_frequencies.txt");
		Utils.writeFile(prWords, frequencies);

		frequencies = frequencyCounter.computeLetterFrequency("src/resources/input.txt");
		OutputStream prLetters = new FileOutputStream("src/resources/letter_frequencies.txt");
		Utils.writeFile(prLetters, frequencies);
	}

}
