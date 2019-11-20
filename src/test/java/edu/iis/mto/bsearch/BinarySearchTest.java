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
}