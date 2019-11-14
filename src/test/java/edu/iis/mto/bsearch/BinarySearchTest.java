package edu.iis.mto.bsearch;


import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void searchSingleElementTrue() {
        int key = 10;
        int[] seq = {10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(true));
    }

    @Test
    public void searchSingleElementNotFound() {
        int key = 10;
        int[] seq = {7};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(false));
    }

    @Test
    public void searchFirstElementFound() {
        int key = 10;
        int[] seq = {10, 11, 12};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(1));
    }
}