package edu.iis.mto.bsearch;

import static org.junit.Assert.assertThat;
import org.hamcrest.Matchers;

import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void assumedTestCases() {
        testBinarySearch(1, new int[] {1}, true, 0);
        testBinarySearch(1, new int[] {2}, false, -1);
        testBinarySearch(1, new int[] {1, 2, 3, 4}, true, 0);
        testBinarySearch(4, new int[] {1, 2, 3, 4}, true, 3);
        testBinarySearch(3, new int[] {1, 2, 3, 4, 5}, true, 2);
        testBinarySearch(6, new int[] {1, 2, 3, 4, 5}, false, -1);
    }

    public void testBinarySearch(int key, int[] seq, boolean isFound, int position) {
        assertThat(BinarySearch.search(key, seq).isFound(), Matchers.equalTo(isFound));
        assertThat(BinarySearch.search(key, seq).getPosition(), Matchers.equalTo(position));
    }

}