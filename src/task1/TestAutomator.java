package task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestAutomator {
	
	StringBuilder log = new StringBuilder();  
	static String outputFile = "test_result.txt";
	
	@Test
	public void testMainMethod(){
		// arrange
		List<String> files = new ArrayList<String>();
		files.add("src/task1/testfile_correct.txt");
		files.add("src/task1/testfile_false.txt");
		
		// act
		int index = 1;
		for (String file : files) {
			startLog(outputFile, index);
			TestApplication.main(new String[]{file});
			index++;
		}
	}
	
	public static void startLog(String file, int index) {
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			fileWriter.append("\nTestcase" + index + ": ");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
