package edu.iis.mto.bsearch;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void searchSingleElementTrue() {
        int key = 25;
        int[] seq = {25};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
    }

    @Test
    public void searchSingleElementFalse() {
        int key = 25;
        int[] seq = {24};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
    }

    @Test
    public void searchFirstElement() {
        int key = 24;
        int[] seq = {24, 25, 27};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(searchResult.getPosition(), 1);
    }
}