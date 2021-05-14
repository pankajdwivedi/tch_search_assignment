package com.tch.search.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tch.search.model.InputData;
import com.tch.search.utils.Constants;
/**
 * This class is used to read CSV file and populate list of row data
 * @author Pankaj
 *
 */
public class InputDataReader {

	public static List<InputData> readFile(String fileName) throws IOException {
		List<InputData> result = new ArrayList<InputData>();
		BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
		try {
			String line = br.readLine();
			if (line == null)
				throw new IllegalArgumentException(Constants.Errors.FILE_EMPTY.description);
			while ((line = br.readLine()) != null) {
				String[] items = line.split(Constants.COMMA);
				try {//convert string array to object 
					InputData inputData = InputData.builder()
							.id(items[0])
							.bankName(items[1])
							.type(items[2])
							.city(items[3])
							.state(items[4])
							.zipCode(items[5]).build();
					result.add(inputData);
				} catch (Exception e) {
					System.err.println("Error while reading file " + line);
				}
			}
			return result;
		} finally {
			br.close();
		}
	}
}
