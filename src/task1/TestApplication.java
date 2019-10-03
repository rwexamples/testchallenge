package task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TestApplication {
	static String outputFile = "test_result.txt";

	public static void main(String[] args) {
		RandomNumberValidator validator = new RandomNumberValidator();
		validator.checkLineNumbers(args[0]);
		writeLog(outputFile, validator.messages);
	}

	public static void writeLog(String outputFile, List<String> messages) {
		try {
			FileWriter fileWriter = new FileWriter(outputFile, true);
			if (messages.size() == 0) {
				fileWriter.append("Pass");
			} else {
				fileWriter.append("Fail");
				StringBuilder builder = new StringBuilder();
				for (String m : messages) {
					builder.append("\n" + m);
				}

				fileWriter.append(builder.toString());
			}

			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
