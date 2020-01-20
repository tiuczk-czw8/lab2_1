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
    @Test
    public void searchFirstElementFound() {
        int key = 50;
        int[] seq = {50, 51, 52};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(1));
    }
    @Test
    public void searchLastElementFound() {
        int key = 50;
        int[] seq = {49, 48, 50};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(3));
    }
    @Test
    public void searchMiddleElementFound() {
        int key = 50;
        int[] seq = {51, 50, 52};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(2));
    }
    @Test
    public void searchElementNotFound() {
        int key = 50;
        int[] seq = {51, 52, 53};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(-1));
    }
    @Test (expected = IllegalArgumentException.class)
    public void isSequenceEmpty() {
        int key = 50;
        int[] seq = {};
        BinarySearch.search(key, seq);
    }
    @Test
    public void areTheTwoSequencesTrue() {
        int key = 50;
        int[] seq = new int[] {50,51,52,53};
        int key1 = 50;
        int[] seq1 = new int[] {50,51,52,53};
        SearchResult result = BinarySearch.search(key, seq);
        SearchResult result1 = BinarySearch.search(key1, seq1);
        assertThat(result1.equals(result), Matchers.equalTo(true));
    }
    @Test
    public void areTheTwoSequencesFalse() {
        int key = 50;
        int[] seq = new int[] {49,50,51,52};
        int key1 = 51;
        int[] seq1 = new int[] {49,50,51,52};
        SearchResult result = BinarySearch.search(key, seq);
        SearchResult result1 = BinarySearch.search(key1, seq1);
        assertThat(result1.equals(result), Matchers.equalTo(false));
    }

}