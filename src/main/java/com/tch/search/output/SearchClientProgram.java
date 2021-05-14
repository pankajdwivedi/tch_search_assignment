package com.tch.search.output;

import java.io.IOException;
import java.util.List;

import com.tch.search.input.InputDataReader;
import com.tch.search.model.InputData;
import com.tch.search.processor.Processor;
import com.tch.search.utils.Constants;

/**
 * This is client class which test the Search functionality
 * 
 * @author Pankaj
 *
 */
public class SearchClientProgram {

	public static void main(String[] args) throws IOException {
		if (args != null && args.length > 2) {
			System.err.println(Constants.Errors.INVALID_INPUT.description);
			System.exit(0);
		}
		if (args != null && args.length == 0) {
			System.err.println(Constants.Errors.NO_INPUT.description);
			System.exit(0);
		}

		List<InputData> data = InputDataReader.readFile(Constants.FILE_NAME);

		Processor processor = new Processor(data);

		List<InputData> searchResult = processor.search(args);

		System.out.println(searchResult.toString());
	}

}
