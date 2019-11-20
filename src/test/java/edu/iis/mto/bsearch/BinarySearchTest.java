package edu.iis.mto.bsearch;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class BinarySearchTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void oneElementSequenceSuccess() {
        int key = 10;
        int[] seq = {10};
        SearchResult result = BinarySearch.search(key, seq);
        assertTrue(result.isFound());
        assertEquals(result.getPosition(), 1);
    }

    @Test
    public void oneElementSequenceFail() {
        int[] seq = {10};
        int key = 9;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
    }

    @Test
    public void findFirstElementWhenSequenceIsMoreThanOne() {
        int key = 3;
        int[] seq = {3, 5, 10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(searchResult.getPosition(), 1);
    }

    @Test
    public void findLastElementWhenSequenceIsMoreThanOne() {
        int[] seq = {10, 5, 23};
        int key = 23;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(seq.length, searchResult.getPosition());
        assertTrue(searchResult.isFound());
    }

    @Test
    public void findMiddleElementWhenSequenceIsMoreThanOne() {
        int key = 10;
        int[] seq = new int[]{5, 10, 15};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(searchResult.getPosition(), 2);
    }

    @Test
    public void notFindElementWhenSequenceIsMoreThanOne() {
        int key = 11;
        int[] seq = new int[]{5, 10, 15};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertEquals(searchResult.getPosition(), -1);
    }
}