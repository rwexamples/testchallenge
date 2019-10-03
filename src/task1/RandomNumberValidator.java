package task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomNumberValidator {
	List<String> messages;
	
	public void checkLineNumbers(String fileName) {
		boolean correctCount;
		messages = new ArrayList<String>();
		
		List<int[]> result = readFile(fileName);
		
		correctCount = (result.size() == 50);
		if(!correctCount) {
			messages.add("The number of lines is incorrect.");
		}
		
		for (int[] entry : result) {
			if(entry[1] < 100) {
				messages.add("Line " + entry[0] + ": Value " + entry[1] + " is too small");
			}
			else if(entry[1] > 500) {
				messages.add("Line " + entry[0] + ": Value " + entry[1] + " is too large");
			}
		}
	}
	
	public List<int[]> readFile(String fileName) {
		List<int[]> lines = new ArrayList<int[]>();
		
		try {
            String readLine = "";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            
            while ((readLine = reader.readLine()) != null) {
            	int[] line = Arrays.asList(readLine.split("\t"))
            			.stream()
            			.mapToInt(Integer::parseInt)
            			.toArray();
                lines.add(line);
            }
			
            reader.close();
            return lines;
		}
		catch(FileNotFoundException e) {
			System.out.println("The file in the parameter was not found.");
			return null;
		}
		catch(IOException e) {
			e.printStackTrace();
			return lines;
		}
		catch(NumberFormatException e) {
			System.out.println("NumberFormatException");
			return lines;
		}
	}
}
