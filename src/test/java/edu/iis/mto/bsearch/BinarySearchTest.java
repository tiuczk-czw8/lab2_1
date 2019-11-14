package edu.iis.mto.bsearch;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class BinarySearchTest {

    @Test
    public void search() {
        int key = 25;
        int[] seq = {25};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
    }
}