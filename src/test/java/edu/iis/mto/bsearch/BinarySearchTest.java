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

    @Test
    public void searchLastElementFound() {
        int key = 10;
        int[] seq = {9, 8, 10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(3));
    }

    @Test
    public void searchMiddleElementFound() {
        int key = 8;
        int[] seq = {9, 8, 10};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(2));
    }

    @Test
    public void searchElementNotFound() {
        int key = 8;
        int[] seq = {9, 10, 11};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(-1));


    }

    @Test
    public void isSeqEmpty(){
        int key = 10;
        int [] seq={};
        SearchResult searchResult = BinarySearch.search(key,seq);
        assertThat(seq.length,Matchers.equalTo(0));
    }

}