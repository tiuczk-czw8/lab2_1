package edu.iis.mto.bsearch;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
public class BinarySearchTest {
    @Test
    public void searchSingleElementTrue() {
        int key = 50;
        int[] seq = {50};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(true));
    }
    @Test
    public void searchSingleElementNotFound() {
        int key = 50;
        int[] seq = {9};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(false));
    }

}