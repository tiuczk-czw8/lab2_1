package edu.iis.mto.bsearch;

import static org.junit.Assert.assertThat;
import org.hamcrest.Matchers;

import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void elementIn1ElementSequence() {
        testBinarySearch(1, new int[]{1}, true, 0);
    }

    @Test
    public void elementNotIn1ElementSequence() {
        testBinarySearch(1, new int[]{2}, false, -1);
    }

    @Test
    public void elementNotInSequence() {
        testBinarySearch(6, new int[]{1, 2, 3, 4, 5}, false, -1);
        testBinarySearch(9, new int[]{1, 2, 3, 4, 5, 6}, false, -1);
        testBinarySearch(3, new int[]{1, 2, 4, 4, 5}, false, -1);
    }

    @Test
    public void firstElementInSequence() {
        testBinarySearch(1, new int[]{1, 2, 3, 4}, true, 0);
    }

    @Test
    public void lastElementInSequence() {
        testBinarySearch(4, new int[]{1, 2, 3, 3, 3, 3, 4}, true, 6);
    }

    @Test
    public void middleElementInSequence() {
        testBinarySearch(2, new int[]{1, 2, 3}, true, 1);
        testBinarySearch(3, new int[]{1, 2, 3, 4, 5}, true, 2);
    }

    @Test
    public void equivalentResults() {
        testEquivalence(BinarySearch.search(3, new int[]{1, 2, 3, 4, 5}), BinarySearch.search(2, new int[]{1, 1, 2, 4}), true);
        testEquivalence(BinarySearch.search(4, new int[]{1, 2, 3, 4, 5, 6}), BinarySearch.search(2, new int[]{1, 1, 2, 4}), false);
    }

    public void testBinarySearch(int key, int[] seq, boolean isFound, int position) {
        assertThat(BinarySearch.search(key, seq).isFound(), Matchers.equalTo(isFound));
        assertThat(BinarySearch.search(key, seq).getPosition(), Matchers.equalTo(position));
    }

    public void testEquivalence(SearchResult firstSearchResult, SearchResult secondSearchResult, boolean expected) {
        assertThat(firstSearchResult.equals(secondSearchResult),Matchers.equalTo(expected));
    }

}