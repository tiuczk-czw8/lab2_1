import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Test;
import org.hamcrest.Matchers;
import static org.junit.Assert.*;

public class BinarySearchTests {

    @Test
    public void seqOneElementSuccess() {
        int[] seq = {1};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(),Matchers.equalTo(true));
    }

    @Test
    public void seqOneElementFail() {
        int[] seq = {0};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(),Matchers.equalTo(false));
    }

    @Test
    public void seqManyElementsFindFail() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 6;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(),Matchers.equalTo(false));
    }


    @Test
    public void seqManyElementsFindFirst() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(1));
    }

    @Test
    public void seqManyElementsFindLast() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 5;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(seq.length));
    }

    @Test
    public void seqManyElementsFindCenter() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 3;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(((int) Math.ceil(seq.length / 2.0))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void seqZeroElements() {
        int[] seq = {};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
    }

}
