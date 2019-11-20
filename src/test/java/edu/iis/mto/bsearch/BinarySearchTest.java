package edu.iis.mto.bsearch;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
	private int key;
	private int[] set;

    @Test
    public void searchInSingleSeqTrue() {
        key = 25;
        set=new int[]{25};
        isInSequence(key,set,true);
    }

    @Test
    public void searchInSingleSeqFalse() {
        key = 24;
        set = new int[]{25};
        isInSequence(key,set,false);
    }

    @Test
    public void searchInMultiSeqFirst()
    {
    	key = 25;
        set = new int[]{25,26,27};
        SearchResult result = BinarySearch.search(key,set);
        isInExpectedPosition(key,set,1);
    }

    @Test
    public void searchInMultiSeqLast()
    {
        key = 27;
        set = new int[]{25,26,27};
        SearchResult result = BinarySearch.search(key,set);
        isInExpectedPosition(key,set,3);
    }

    @Test
    public void searchInMultiSeqMiddle() {
        key = 26;
        set = new int[]{25,26,27};
        SearchResult result = BinarySearch.search(key,set);
        isInExpectedPosition(key,set,2);
    }

    @Test
    public void searchInMultiSeqNotFound() {
        key = 28;
        set = new int[]{25,26,27};
        isInSequence(key,set,false);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void searchInEmptySeq() {
    	key = 25;
    	set = new int[]{};
    	BinarySearch.search(key, set);

    }
    
    private void isInExpectedPosition(int key, int[] seq, int position) {
    	assertThat(BinarySearch.search(key,seq).getPosition(),Matchers.equalTo(position));
    }
    
    private void isInSequence(int key, int[] seq, boolean isIt) {
    	assertThat(BinarySearch.search(key,seq).isFound(),Matchers.equalTo(isIt));
    }

}