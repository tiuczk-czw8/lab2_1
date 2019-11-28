package edu.iis.mto.bsearch;
import static org.junit.Assert.*;
import org.hamcrest.Matchers;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void search() {
        int key = 60;
        int[] seq = {60};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(true));
    }
    @Test
    public void searchSingleElementNotFound() {
        int key = 60;
        int[] seq = {5};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.isFound(), Matchers.equalTo(false));
    }
    @Test
    public void searchFirstElementFound() {
        int key = 60;
        int[] seq = {60, 61, 62};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(1));
    }
    @Test
    public void searchLastElementFound() {
        int key = 60;
        int[] seq = {58, 59, 60};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(3));
    }
    @Test
    public void searchMiddleElementFound() {
        int key = 60;
        int[] seq = {61, 60, 62};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(2));
    }

    @Test
    public void searchElementNotFound() {
        int key = 60;
        int[] seq = {61, 62, 63};
        SearchResult searchResult = BinarySearch.search(key, seq);
        assertThat(searchResult.getPosition(), Matchers.equalTo(-1));
    }
    @Test (expected = IllegalArgumentException.class)
    public void isSequenceEmpty() {
        int key = 60;
        int[] seq = {};
        BinarySearch.search(key, seq);
    }






}