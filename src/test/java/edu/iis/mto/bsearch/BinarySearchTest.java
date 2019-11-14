package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void searchInSeqTrue() {
        int key = 25;
        int[] seq={25};
        assertTrue(BinarySearch.search(key,seq).isFound());
    }

    @Test
    public void searchInSeqFalse() {
        int key = 24;
        int[] seq = {25};
        assertFalse(BinarySearch.search(key,seq).isFound());
    }

    @Test
    public void searchInMultiSeqFirst()
    {
        int key = 25;
        int[] set = {25,26,27};
        SearchResult result = BinarySearch.search(key,set);
        assertEquals(result.getPosition(),1);
    }




}