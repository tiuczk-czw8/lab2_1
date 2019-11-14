package edu.iis.mto.bsearch.edu.iis.mto.bsearch;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class BinarySearchTest {

	@Test
	public void searchElementnotfound() {
		int key = 10;
		int[] seq = {21,3,100};
		SearchResult SearchResult = BinarySearch.search(key, seq);
		assertThat(SearchResult.isFound(), Matchers.equalTo(false));
	}

}
