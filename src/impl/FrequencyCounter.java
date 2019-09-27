package impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import api.IFrequency;

public class FrequencyCounter implements IFrequency {

	@Override
	public Map<String, Integer> computeWordFrequency(InputStream fileInput) {

		Map<String, Integer> wordsFrequencies = new HashMap<String, Integer>();

		Scanner scanner = new Scanner(fileInput);
		scanner.useDelimiter("\\s+");
		while (scanner.hasNext()) {

			String next = scanner.next();

			if (next.contains(".")) {
				String word = next.replace(".", "");
				wordsFrequencies = increaseMapValue(wordsFrequencies, word);
			} else {
				wordsFrequencies = increaseMapValue(wordsFrequencies, next);
			}
		}

		scanner.close();

		return wordsFrequencies;
	}

	@Override
	public Map<String, Integer> computeLetterFrequency(String fileInput) throws FileNotFoundException {

		Map<String, Integer> letterFrequencies = new HashMap<String, Integer>();

		File file = new File(fileInput);
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("");
		while (scanner.hasNext()) {

			String next = scanner.next();

			if (Character.isLetter(next.charAt(0))) {
				letterFrequencies = increaseMapValue(letterFrequencies, next);
			}
		}

		scanner.close();

		return letterFrequencies;
	}

	private Map<String, Integer> increaseMapValue(Map<String, Integer> map, String key) {
		String lowerCaseKey = key.toLowerCase();

		if (!map.containsKey(lowerCaseKey)) {
			map.computeIfAbsent(lowerCaseKey, k -> 1);
		} else {
			map.computeIfPresent(lowerCaseKey, (k, v) -> map.get(lowerCaseKey) + 1);
		}

		return map;
	}

}
