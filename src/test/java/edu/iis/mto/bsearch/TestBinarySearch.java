package edu.iis.mto.bsearch;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBinarySearch {
    @Test
    public void oneElementInSequenceFail() {
        int[] seq = {0};
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(false));
    }

    @Test
    public void oneElementInSequenceSuccess() {
        int[] seq = {1};
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(true));
    }

    @Test
    public void findLastElementWhenSeqIsMoreThan1() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 5;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(5));
    }

    @Test
    public void findFirstElementWhenSeqIsMoreThan1() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(1));
    }

    @Test
    public void findMiddleElementWhenSeqIsMoreThan1() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 3;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo((int) Math.ceil(seq.length / 2.0)));
    }

    @Test
    public void noSuchElementInSequenceMoreThan1Fail() {
        int[] seq = {1, 2, 3, 4, 5};
        int key = 9;

        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(false));
        assertThat(searchResult.getPosition(), Matchers.equalTo(-1));
    }

    @Test
    public void noSequenceTest() {
        int[] seq = new int[]{};
        int key = 1;
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(false));
        assertThat(searchResult.getPosition(), Matchers.equalTo(-1));

    }
}
