package edu.iis.mto.bsearch;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BinarySearchTest {

    SearchResult searchResult;
    int key = 1;
    int[] seq = {-5, -1, 0, 1, 3, 4, 6, 7, 8, 9};

    @Before
    public void setup() {

        searchResult = BinarySearch.search(key, seq);
    }

    @Test
    public void searchedElementIsInSequence() {
        int key = 42;
        int[] seq = {42};

         searchResult = BinarySearch.search(key, seq);
         assertEquals(searchResult.getPosition(), 1);
    }

    @Test
    public void searchedElementIsNotInSequence() {
        int key = 42;
        int[] seq = {43};

        searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
    }

    @Test
    public void searchedElementIsFirstInSequence() {
        int key = 42;
        int[] seq = {42, 43, 45};

        searchResult = BinarySearch.search(key, seq);
        assertEquals(searchResult, 0);
    }
}
