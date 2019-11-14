package edu.iis.mto.bsearch;

import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void searchInSeqTrue() {
        int key = 25;
        int[] seq={25};
        assertThat(BinarySearch.search(key,seq).isFound(), Matchers.equalTo(true));
    }

    @Test
    public void searchInSeqFalse() {
        int key = 24;
        int[] seq = {25};
        assertThat(BinarySearch.search(key,seq).isFound(), Matchers.equalTo(false));
    }

    @Test
    public void searchInMultiSeqFirst()
    {
        int key = 25;
        int[] set = {25,26,27};
        SearchResult result = BinarySearch.search(key,set);
        assertThat(result.getPosition(),Matchers.equalTo(1));
    }

    @Test
    public void searchInMultiSeqLast()
    {
        int key = 27;
        int[] set = {25,26,27};
        SearchResult result = BinarySearch.search(key,set);
        assertThat(result.getPosition(),Matchers.equalTo(3));
    }

    @Test
    public void searchInMultiSeqMiddle() {
        int key = 26;
        int[] set = {25,26,27};
        SearchResult result = BinarySearch.search(key,set);
        assertThat(result.getPosition(),Matchers.equalTo(2));
    }

    @Test
    public void searchInMultiSeqNotFound() {
        int key = 28;
        int[] set = {25,26,27};
        assertThat(BinarySearch.search(key,set).isFound(), Matchers.equalTo(false));
    }


}