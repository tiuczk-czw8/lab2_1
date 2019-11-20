import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTests {

    @Test
    public void seqOneElementSuccess() {
        int[] seq = {1};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
    }

    @Test
    public void seqOneElementFail() {
        int[] seq = {0};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
    }

    @Test
    public void seqManyElementsFindFail() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 6;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
    }


    @Test
    public void seqManyElementsFindFirst() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition() - 1], searchResult.getPosition());
    }

    @Test
    public void seqManyElementsFindLast() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 5;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq.length, searchResult.getPosition());
    }

    @Test
    public void seqManyElementsFindCenter() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 3;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals((int) Math.ceil(seq.length / 2.0), searchResult.getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void seqZeroElements() {
        int[] seq = {};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
    }

}
