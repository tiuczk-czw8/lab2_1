package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;

public class BinarySearchTest {

    SearchResult searchResult;
    int key = 42;

    @Test
    public void searchedElementIsInOneElementSequence() {
        int[] seq = {42};

        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(0));
    }

    @Test
    public void searchedElementIsNotInOneElementSequence() {
        int[] seq = {43};

        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.is(Boolean.FALSE));
    }

    @Test
    public void searchedElementIsFirstInSequence() {
        int[] seq = {42, 43, 45};

        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(0));
    }

    @Test
    public void searchedElementIsLastInSequence() {
        int[] seq = {40, 41, 42};

        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(seq.length - 1));
    }

    @Test
    public void searchedElementIsMiddleInSequence() {
        int[] seq = {41, 42, 43};

        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo((seq.length - 1) / 2));
    }

    @Test
    public void searchedElementIsNotInOddSequence() {
        int[] seq = {40, 41, 43};

        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.is(Boolean.FALSE));
    }

    @Test
    public void searchedElementInEmptySequence() {
        int[] seq = {};

        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.is(Boolean.FALSE));
    }

    @Test
    public void searchedElementIsNotInEvenSequence() {
        int[] seq = {39, 40, 41, 43};

        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.is(Boolean.FALSE));
    }

    @Test
    public void searchedElementIsAnywhereInSequence() {
        int[] seq = {39, 40, 41, 42, 43};

        searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(findIndex(seq, key)));
    }

    public int findIndex(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
