package com.tch.search.processor;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.tch.search.model.InputData;
/**
 * This is Junit class which has test cases for each positive and negative scenarios.
 * @author Pankaj
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProcessorTest {

	Processor processor;

	@Before
	public void setUp() throws Exception {
		processor = new Processor(prepareInputData());
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void searchByZipCodeValid() { 
		List<InputData> result = processor.search("10020");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByZipCodeValid2() { 
		List<InputData> result = processor.search("10021");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByZipCodeValid3() { 
		List<InputData> result = processor.search("10018");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByZipCodeValid4() { 
		List<InputData> result = processor.search("27105");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByZipCodeValid5() { 
		List<InputData> result = processor.search("27107");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByZipCodeValid6() { 
		List<InputData> result = processor.search("75201");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByZipCodeValid7() { 
		List<InputData> result = processor.search("75202");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByZipCodeInValid() {
		List<InputData> result = processor.search("08820");
		assertTrue(result.size() == 0);
	}

	@Test
	public void searchByStateValidNY() {
		List<InputData> result = processor.search("NY");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByStateValidNC() {
		List<InputData> result = processor.search("NC");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByStateValidTX() {
		List<InputData> result = processor.search("TX");
		assertTrue(result.size() > 0);
	}

	@Test
	public void searchByStateInValid() {
		List<InputData> result = processor.search("NJ");
		assertTrue(result.size() == 0);
	}

	@Test
	public void searchByCityValidNY() {
		List<InputData> result = processor.search("New York");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByCityValidSalem() {
		List<InputData> result = processor.search("Winston-Salem");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByCityValidDallas() {
		List<InputData> result = processor.search("Dallas");
		assertTrue(result.size() > 0);
	}
	@Test()
	public void searchByCityInValid() {
		List<InputData> result = processor.search("Chicago");
		assertTrue(result.size() == 0);
	}
	@Test
	public void searchByTypeValid() {
		List<InputData> result = processor.search("Branch");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByTypeValid1() {
		List<InputData> result = processor.search("ATM");
		assertTrue(result.size() > 0);
	}

	@Test
	public void searchByTypeInValid() {
		List<InputData> result = processor.search("ABC");
		assertTrue(result.size() == 0);
	}
	@Test
	public void searchByBankNameValidAmazing() {
		List<InputData> result = processor.search("Amazing Bank");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByBankNameValidNeighborhood() {
		List<InputData> result = processor.search("Neighborhood Bank");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByBankNameValidFriendly() {
		List<InputData> result = processor.search("Friendly Bank");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByBankNameValidAwesome() {
		List<InputData> result = processor.search("Awesome Bank");
		assertTrue(result.size() > 0);
	}

	@Test
	public void searchByBankNameInValid() {
		List<InputData> result = processor.search("Local Bank");
		assertTrue(result.size() == 0);
	}
	@Test
	public void searchByCityStateValid() {
		List<InputData> result = processor.search("New York","NY");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByCityStateValid2() {
		List<InputData> result = processor.search("Winston-Salem","NC");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByCityStateValid3() {
		List<InputData> result = processor.search("Dallas","TX");
		assertTrue(result.size() > 0);
	}
	@Test
	public void searchByCityStateInValid1() {
		List<InputData> result = processor.search("New York","TX");
		assertTrue(result.size() == 0);
	}
	@Test
	public void searchByCityStateInValid2() {
		List<InputData> result = processor.search("Winston-Salem","NY");
		assertTrue(result.size() == 0);
	}
	@Test
	public void searchByCityStateInValid3() {
		List<InputData> result = processor.search("Dallas","NY");
		assertTrue(result.size() == 0);
	}
	@Test
	public void searchWithoutInputs() { 
		List<InputData> result = processor.search(null);
		assertTrue(result.size() == 0);
	}

	@Test
	public void searchWithExtraInputs() {
		List<InputData> result = processor.search("ATM","NY","New York");
		assertTrue(result.size() == 0);
	}

	private List<InputData> prepareInputData() {
		List<InputData> lst = new ArrayList<InputData>();
		lst.add(new InputData("1", "Amazing Bank", "Branch", "New York", "NY", "10018"));
		lst.add(new InputData("2", "Neighborhood Bank", "Branch", "New York", "NY", "10020"));
		lst.add(new InputData("3", "Friendly Bank", "ATM", "New York", "NY", "10020"));
		lst.add(new InputData("4", "Awesome Bank", "Branch", "New York", "NY", "10021"));
		lst.add(new InputData("5", "Amazing Bank", "ATM", "New York", "NY", "10018"));
		lst.add(new InputData("6", "Neighborhood Bank", "ATM", "Winston-Salem", "NC", "27105"));
		lst.add(new InputData("7", "Amazing Bank", "ATM", "Winston-Salem", "NC", "27107"));
		lst.add(new InputData("8", "Neighborhood Bank", "Branch", "Winston-Salem", "NC", "27107"));
		lst.add(new InputData("9", "Awesome Bank", "ATM", "Dallas", "TX", "75201"));
		lst.add(new InputData("10", "Friendly Bank", "Branch", "Dallas", "TX", "75201"));
		lst.add(new InputData("11", "Amazing Bank", "ATM", "Dallas", "TX", "75202"));

		return lst;
	}

}
