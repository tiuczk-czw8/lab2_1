package edu.iis.mto.bsearch.edu.iis.mto.bsearch;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

	@Test(expected = IllegalArgumentException.class)
	public void sequenceisEmpty() {
		int key = 2;
		int[] seq = new int[] {};
		
		BinarySearch.search(key, seq);	
	}
	
	@Test
	public void searchElementInSequenceLength1() {
		int key = 2;
		int[] seq = new int[] {key};
		int index = 0;
		
		SearchResult result = BinarySearch.search(key, seq);
		
		assertTrue(result.isFound());
		assertThat(result.getPosition(),is(index));
		assertThat(seq[index],is(key));		
	}
	
	@Test 
	public void SearchElementNotInSequenceLength1() {
		int key = 3;
		int[] seq = new int[] {4};
		
		SearchResult result = BinarySearch.search(key, seq);
		
		assertFalse(result.isFound());
		assertThat(result.getPosition(),is(-1));
	}
	
	@Test 
	public void searchElementIsFirstInSequenceLengthGreaterThan1() {
		int key = 4;
		int[] seq = new int[]{key,5,21,100};
		int index = 0; 
		
		SearchResult result = BinarySearch.search(key, seq);
		
		assertTrue(result.isFound());
		assertThat(result.getPosition(),is(index));
		assertThat(seq[index],is(key));
	}
	
	@Test
	public void searchElementIsLastInSequenceLengthGreaterThan1() {
		int key = 102;
		int[] seq = new int[] {3,21,100,key};
		int index = 3;
		
		SearchResult result = BinarySearch.search(key, seq);
		
		assertTrue(result.isFound());
		assertThat(result.getPosition(),is(index));
		assertThat(seq[index],is(key));
	}
	
	@Test
	public void searchElementIsInMiddleInSequenceLengthGreaterThan1() {
		int key = 102;
		int[] seq = new int[] {3,key,200};
		int index = 1;
		
		SearchResult result = BinarySearch.search(key, seq);
		
		assertTrue(result.isFound());
		assertThat(result.getPosition(),is(index));
		assertThat(seq[index],is(key));
	}
	
	@Test
	public void searchElementNotInSequenceLengthGreaterThan1() {
		int key = 10;
		int[] seq = {3,21,100};
		
		SearchResult result = BinarySearch.search(key, seq);
		
		assertFalse(result.isFound());
	}
		
}
