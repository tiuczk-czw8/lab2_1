package edu.iis.mto.bsearch;

import org.junit.Test;
import org.hamcrest.Matchers;
import static org.junit.Assert.*;

public class BinarySearchTest {

    private int key;
    private int[] seq;

    @Test
    public void searchSingleElementExpectedTrue() {
        key = 25;
        seq = new int[]{25};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsFound(searchResult.isFound(), true);
    }

    @Test
    public void searchSingleElementExpectedFalse() {
        key = 25;
        seq = new int[]{24};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsFound(searchResult.isFound(), false);
    }

    @Test
    public void searchFirstElement() {
        key = 24;
        seq = new int[]{24, 25, 27};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsOnPosition(searchResult.getPosition(), 1);
    }

    @Test
    public void searchLastElement() {
        key = 27;
        seq = new int[]{24, 25, 27};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsOnPosition(searchResult.getPosition(), 3);
    }

    @Test
    public void searchMiddleElement() {
        key = 25;
        seq = new int[]{24, 25, 27};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsOnPosition(searchResult.getPosition(), 2);
    }

    @Test
    public void searchNotFoundExpected() {
        key = 29;
        seq = new int[]{24, 25, 27};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsOnPosition(searchResult.getPosition(), -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkIllegalArgumentExpectedOnEmptySeq() {
        key = 0;
        seq = new int[0];
        BinarySearch.search(key, seq);
    }

    @Test
    public void checkIfTwoSeqEqualsExpectedTrue() {
        int key1 = 24;
        int[] seq1 = {24, 25, 26};
        int key2 = 24;
        int[] seq2= {24, 25, 26};
        SearchResult searchResult1 = BinarySearch.search(key1, seq1);
        SearchResult searchResult2 = BinarySearch.search(key2, seq2);
        checkIfTwoSeqEquals(searchResult1, searchResult2, true);
    }

    @Test
    public void checkIfTwoSeqEqualsExpectedFalse() {
        int key1 = 24;
        int[] seq1 = {24, 25, 26};
        int key2 = 25;
        int[] seq2= {24, 25, 26};
        SearchResult searchResult1 = BinarySearch.search(key1, seq1);
        SearchResult searchResult2 = BinarySearch.search(key2, seq2);
        checkIfTwoSeqEquals(searchResult1, searchResult2, false);
    }

    private void checkIfIsFound(boolean isFound, boolean expectedBoolean) {
        assertThat(isFound, Matchers.equalTo(expectedBoolean));
    }

    private void checkIfIsOnPosition(int positionInSeq, int expectedPosition) {
        assertThat(positionInSeq, Matchers.equalTo(expectedPosition));
    }

    private void checkIfTwoSeqEquals(SearchResult firstSearchResult, SearchResult secondSearchResult, boolean expectedBoolean){
        assertThat(firstSearchResult.equals(secondSearchResult), Matchers.equalTo(expectedBoolean));
    }
}