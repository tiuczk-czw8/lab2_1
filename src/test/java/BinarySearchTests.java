import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

}
