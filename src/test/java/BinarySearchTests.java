import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class BinarySearchTests {

    @Test
    public void searchOneElementSuccess() {
        int[] seq = {1};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(true));
    }

    @Test
    public void searchOneElementFail() {
        int[] seq = {0};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(false));
    }

    @Test
    public void searchManyElementsFindFail() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 6;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(false));
    }


    @Test
    public void searchManyElementsFindFirst() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(1));
    }

    @Test
    public void searchManyElementsFindLast() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 5;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(seq.length));
    }

    @Test
    public void searchManyElementsFindCenter() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 3;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(((int) Math.ceil(seq.length / 2.0))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchZeroElements() {
        int[] seq = {};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
    }

    @Test
    public void searchManyElementsFindCenterNotEvenV3() {
        int[] seq = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 5;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(((int) Math.ceil(seq.length / 2.0))));
    }

}
