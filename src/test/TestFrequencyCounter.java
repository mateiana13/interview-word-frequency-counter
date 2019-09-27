package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import api.IFrequency;
import impl.FrequencyCounter;

@RunWith(JUnitPlatform.class)
class TestFrequencyCounter {
	IFrequency frequencyObj = new FrequencyCounter();
	File file = new File("src/resources/input.txt");
	String input = "This is that and that is this. But what is this.";
	ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());

	@Test
	void testComputeWordFrequency() throws FileNotFoundException {

		Map<String, Integer> frequencies = frequencyObj.computeWordFrequency(bais);

		assertEquals(frequencies.get("this"), 3, "frequency of 'this'");
		assertEquals(frequencies.get("that"), 2, "frequency of 'that'");
	}

	@Test
	void testComputeWordNotInMapFrequency() throws FileNotFoundException {
		Map<String, Integer> frequencies = frequencyObj.computeWordFrequency(bais);

		assertNotEquals(frequencies.get("ana"), 0, "frequency of a word that is not contained by the map");
	}

	@Test
	void testComputeLetterFrequency() throws FileNotFoundException {

		Map<String, Integer> frequencies = frequencyObj.computeLetterFrequency(file.toString());

		assertEquals(frequencies.get("t"), 9, "frequency of letter 't'");
		assertEquals(frequencies.get("s"), 6, "frequency of letter 's'");
	}

}
