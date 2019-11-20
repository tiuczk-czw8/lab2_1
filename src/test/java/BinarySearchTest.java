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
    public void ElementNotInSeqLength1()  {
        int key = 2;
        int[] seq = new int[]{3};

        SearchResult result = BinarySearch.search(key, seq);

        Assert.assertFalse(result.isFound());
        Assert.assertEquals(-1, result.getPosition());
    }
}
