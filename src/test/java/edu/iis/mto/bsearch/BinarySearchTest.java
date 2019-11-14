package edu.iis.mto.bsearch;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void searchInSeqTrue() {
        int key = 25;
        int[] seq={25};
        assertTrue(BinarySearch.search(key,seq).isFound());
    }
    

}