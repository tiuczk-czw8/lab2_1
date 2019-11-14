package edu.iis.mto.bsearch.edu.iis.mto.bsearch;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

	@Test
	public void searchElementInSequenceLength1() {
		int key = 2;
		int[] seq = new int[] {key};
		int index = 0;
		
		SearchResult result = BinarySearch.search(key, seq);
		
		Assert.assertTrue(result.isFound());
		Assert.assertEquals(index, result.getPosition());
		Assert.assertEquals(key,seq[index]);		
	}
	
	@Test 
	public void SearchElementNotInSequenceLength1() {
		int key = 3;
		int[] seq = new int[] {3};
		
		SearchResult result = BinarySearch.search(key, seq);
		
		Assert.assertFalse(result.isFound());
		Assert.assertEquals(-1,result.getPosition());
	}
	
	@Test
	public void searchElementNotInSequenceLengthGreaterThan1() {
		int key = 10;
		int[] seq = {21,3,100};
		SearchResult result = BinarySearch.search(key, seq);
		assertThat(result.isFound(), Matchers.equalTo(false));
	}
	
}
