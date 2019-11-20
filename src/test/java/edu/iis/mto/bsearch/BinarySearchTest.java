package edu.iis.mto.bsearch;

import org.junit.Test;
import org.hamcrest.Matchers;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void searchSingleElementTrue() {
        int key = 25;
        int[] seq = {25};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsFound(searchResult.isFound(), true);
    }

    @Test
    public void searchSingleElementFalse() {
        int key = 25;
        int[] seq = {24};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsFound(searchResult.isFound(), false);
    }

    @Test
    public void searchFirstElement() {
        int key = 24;
        int[] seq = {24, 25, 27};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsOnPosition(searchResult.getPosition(), 1);
    }

    @Test
    public void searchLastElement() {
        int key = 27;
        int[] seq = {24, 25, 27};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsOnPosition(searchResult.getPosition(), 3);
    }

    @Test
    public void searchMiddleElement() {
        int key = 25;
        int[] seq = {24, 25, 27};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsOnPosition(searchResult.getPosition(), 2);
    }

    @Test
    public void searchNotFound() {
        int key = 29;
        int[] seq = {24, 25, 27};
        SearchResult searchResult = BinarySearch.search(key, seq);
        checkIfIsOnPosition(searchResult.getPosition(), -1);
    }

    private void checkIfIsFound(boolean isFound, boolean expectedBoolean) {
        assertThat(isFound, Matchers.equalTo(expectedBoolean));
    }

    private void checkIfIsOnPosition(int positionInSeq, int expectedPosition) {
        assertThat(positionInSeq, Matchers.equalTo(expectedPosition));
    }
}