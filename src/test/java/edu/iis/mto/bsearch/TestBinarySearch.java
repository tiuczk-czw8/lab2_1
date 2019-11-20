package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestBinarySearch {
    @Test
    public void oneElementInSequenceFail() {
        int[] seq = {0};
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
    }
    @Test
    public void oneElementInSequenceSuccess() {
        int[] seq = {1};
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
    }

}
