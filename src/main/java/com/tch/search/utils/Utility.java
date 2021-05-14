package com.tch.search.utils;

import com.tch.search.model.InputData;

/**
 * This class is used to maintain logic for search . ONLY this class is going to change if any changes to search criteria 
 * @author Pankaj
 *
 */
public class Utility {

	public static boolean searchCriteria(InputData row, String... inputs) {
		if (inputs == null || row == null)
			return false;
		if (inputs != null && inputs.length == 1) {//in case user search only By Zip code or State or City or Type or Bank Name
			String searchStr = inputs[0];
			if (searchStr == null || searchStr.trim().length() == 0)
				return false;
			return searchStr.equalsIgnoreCase(row.getBankName()) || searchStr.equalsIgnoreCase(row.getCity())
					|| searchStr.equalsIgnoreCase(row.getState()) || searchStr.equalsIgnoreCase(row.getZipCode())
					|| searchStr.equalsIgnoreCase(row.getType());

		} else if (inputs != null && inputs.length == 2) { // in case user search By City & State
			String city = inputs[0];
			String state = inputs[1];
			if (city == null || state == null || city.trim().length() == 0 || state.trim().length() == 0)
				return false;

			return city.equalsIgnoreCase(row.getCity()) && state.equalsIgnoreCase(row.getState());
		} else
			return false;

	}

}
