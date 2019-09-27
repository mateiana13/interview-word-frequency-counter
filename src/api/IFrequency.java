package api;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public interface IFrequency {

	public Map<String, Integer> computeWordFrequency(InputStream fileInput) throws FileNotFoundException;

	public Map<String, Integer> computeLetterFrequency(String fileInput) throws FileNotFoundException;
}
