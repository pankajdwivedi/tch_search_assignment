package com.tch.search.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is bean class to store row of CSV file
 * @author Pankaj
 *
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class InputData {

	private String id;
	private String bankName;
	private String type;
	private String city;
	private String state;
	private String zipCode;

}
