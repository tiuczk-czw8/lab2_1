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





}