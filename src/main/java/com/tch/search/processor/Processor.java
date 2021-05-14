package com.tch.search.processor;

import java.util.List;
import java.util.stream.Collectors;

import com.tch.search.model.InputData;
import com.tch.search.utils.Utility;
/**
 * This is processor class which return data based in input search string
 * @author Pankaj
 *
 */
public class Processor {

	List<InputData> data;

	public Processor(List<InputData> data) {
		this.data = data;
	}

	public List<InputData> search(String... searchString) {

		List<InputData> collect = data.stream().filter(row -> Utility.searchCriteria(row, searchString))
				.collect(Collectors.toList());
		return collect;
	}

}
