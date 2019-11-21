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
        isInExpectedPosition(key,set,1);
    }

    @Test
    public void searchInMultiSeqLast()
    {
        key = 653;
        set = new int[]{231,345,842,653};
        isInExpectedPosition(key,set,3);
    }

    @Test
    public void searchInMultiSeqMiddle() {
        key = 3;
        set = new int[]{2,3,4};
        isInExpectedPosition(key,set,2);
    }

    @Test
    public void searchInMultiSeqNotFound() {
        key = 29;
        set = new int[]{1,23,28,123};
        isInSequence(key,set,false);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void searchInEmptySeq() {
    	key = 25;
    	set = new int[]{};
    	BinarySearch.search(key, set);

    }
    
    @Test
    public void checkTwoSequencesTrue() {
    	key = 226;
        set = new int[]{225,226,227};
        int key2 = 226;
        int [] set2 = new int[]{225,226,227};
        SearchResult result1 = BinarySearch.search(key, set);
        SearchResult result2 = BinarySearch.search(key2, set2);
        areResultsSame(result1,result2, false);
    }
    
    @Test
    public void checkTwoSequencesfalse() {
    	key = 236;
        set = new int[]{235,236,237,238};
        int key2 = 237;
        int [] set2 = new int[]{235,236,237,238};
        SearchResult result1 = BinarySearch.search(key, set);
        SearchResult result2 = BinarySearch.search(key2, set2);
        areResultsSame(result1,result2, false);
    }
    
    private void isInExpectedPosition(int key, int[] seq, int position) {
    	assertThat(BinarySearch.search(key,seq).getPosition(),Matchers.equalTo(position));
    }
    
    private void isInSequence(int key, int[] seq, boolean isIt) {
    	assertThat(BinarySearch.search(key,seq).isFound(),Matchers.equalTo(isIt));
    }
    
    private void areResultsSame(SearchResult result1, SearchResult result2, boolean isIt) {
    	assertThat(result1.equals(result2), Matchers.equalTo(isIt)); 
    }

}
