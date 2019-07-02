package io.github.jschenfeld.exercise1.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUtils {

	 public static List<Map<String, String>> readCSV(String fileName) {
	        List<Map<String,String>> data = new ArrayList<>();


	        try (BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)));) {

	            // read the first line from the text file
	            String line = br.readLine();
	            String[] titles = line.split(";"); 
	            // loop until all lines are read
	            line = br.readLine();
	            while (line != null) {

	                // use string.split to load a string array with the values from
	                // each line of
	                // the file, using a comma as the delimiter
	                String[] values = line.split(";");

	                Map<String, String> record = new HashMap<>();
	                for (int i = 0; i < values.length; i++) {
		                record.put(titles[i], values[i]);
					}
	                data.add(record);
	                // read next line before looping
	                // if end of file reached, line would be null
	                line = br.readLine();
	            }

	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        }

	        return data;
	    }
}
