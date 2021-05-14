package com.tch.search.utils;
/**
 * This class is used to maintain constants used in the project
 * @author Pankaj
 *
 */
public class Constants {

	public static String COMMA = ",";
	public static String FILE_NAME = "input.csv";
	
	public enum Errors {
	    FILE_EMPTY("File is empty"),
	    FILE_NOT_FOUND("File is not found"),
	    INVALID_INPUT ("Not search defined for this input"),
	    NO_INPUT ("No search input provided to the program");

	    public final String description;

	    private Errors(String description) {
	        this.description = description;
	    }
	}
}
