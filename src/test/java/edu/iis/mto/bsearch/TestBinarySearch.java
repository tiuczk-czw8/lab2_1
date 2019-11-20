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

    @Test
    public void findLastElementWhenSeqIsMoreThan1() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals(seq.length, searchResult.getPosition());
    }

    @Test
    public void findFirstElementWhenSeqIsMoreThan1() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition() - 1], searchResult.getPosition());
    }

    @Test
    public void findMiddleElementWhenSeqIsMoreThan1() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 3;

        SearchResult searchResult = BinarySearch.search(key, seq);

        assertTrue(searchResult.isFound());
        assertEquals((int) Math.ceil(seq.length / 2.0), searchResult.getPosition());
    }

}
