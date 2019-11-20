import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class BinarySearchTests {

    @Test
    public void elementInSequence() {
        int[] seq = {1};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(true));
    }

    @Test
    public void elementNotInSequence() {
        int[] seq = {0};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(false));
    }
    @Test
    public void manyElementsNotInSequence() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 6;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(false));
    }
    @Test
    public void finfFirstElementInSequence() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(1));
    }

}