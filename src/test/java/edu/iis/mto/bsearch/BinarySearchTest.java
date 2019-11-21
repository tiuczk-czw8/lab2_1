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

    @Test (expected = IllegalArgumentException.class)
    public void isSequenceEmpty() {
        int key = 10;
        int[] seq = {};
        BinarySearch.search(key, seq);
    }

    @Test
    public void areTheTwoSequencesTrue() {
        int key = 9;
        int[] seq = new int[] {9,10,11,12};
        int key1 = 9;
        int[] seq1 = new int[] {9,10,11,12};
        SearchResult result = BinarySearch.search(key, seq);
        SearchResult result1 = BinarySearch.search(key1, seq1);
        assertThat(result1.equals(result), Matchers.equalTo(true));
    }

    @Test
    public void areTheTwoSequencesFalse() {
        int key = 10;
        int[] seq = new int[] {9,10,11,12};
        int key1 = 11;
        int[] seq1 = new int[] {9,10,11,12};
        SearchResult result = BinarySearch.search(key, seq);
        SearchResult result1 = BinarySearch.search(key1, seq1);
        assertThat(result1.equals(result), Matchers.equalTo(false));
    }

}