import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void shouldElementBeInSequenceLength1() {
        int key = 2;
        int[] seq = new int[]{key};
        int idx = 0;

        SearchResult result = BinarySearch.search(key, seq);

        Assert.assertTrue(result.isFound());
        Assert.assertEquals(idx, result.getPosition());
        Assert.assertEquals(key, seq[idx]);
    }

    @Test
    public void ElementNotInSeq()  {
        int key = 2;
        int[] seq = new int[]{3};

        SearchResult result = BinarySearch.search(key, seq);

        Assert.assertFalse(result.isFound());
        Assert.assertEquals(-1, result.getPosition());
    }

    @Test
    public void MiddleElementInSeq() {
        int key = 2;
        int[] seq = new int[]{1, key, 3};
        int idx = 1;

        SearchResult result = BinarySearch.search(key, seq);

        Assert.assertTrue(result.isFound());
        Assert.assertEquals(idx, result.getPosition());
        Assert.assertEquals(key, seq[idx]);
    }

    @Test
    public void FirstElementInSeq() {
        int key = 2;
        int[] seq = new int[]{key, 3, 4};
        int idx = 0;

        SearchResult result = BinarySearch.search(key, seq);

        Assert.assertTrue(result.isFound());
        Assert.assertEquals(idx, result.getPosition());
        Assert.assertEquals(key, seq[idx]);
    }

    @Test
    public void  LastElementInSeq() {
        int key = 4;
        int[] seq = new int[]{1, 2, 3, 4};
        int idx = 3;

        SearchResult result = BinarySearch.search(key, seq);

        Assert.assertTrue(result.isFound());
        Assert.assertEquals(idx, result.getPosition());
        Assert.assertEquals(key, seq[idx]);
    }
}
