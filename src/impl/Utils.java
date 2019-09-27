package impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

public class Utils {

	public static void writeFile(OutputStream fileOutput, Map<String, Integer> frequencies) throws IOException {

		PrintWriter fileWriter = new PrintWriter(fileOutput);

		for (Entry<String, Integer> wordPair : frequencies.entrySet()) {
			fileWriter.write(wordPair.getKey() + ", " + wordPair.getValue() + "\n");
		}

		fileWriter.close();

	}

}
