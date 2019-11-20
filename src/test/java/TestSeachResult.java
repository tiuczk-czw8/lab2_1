import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;


public class TestSeachResult {
    @Test
    public  void testOneElSearch()
    {
        testBoth(15,0,true,new int[]{15});
        testBoth(2,-1,false,new int[]{15});

    }
    @Test
    public  void testSeveralElSearch()
    {
        testBoth(12,4,true, new int[]{0,2,5,7,12});
        testBoth(5,2,true, new int[]{0,2,5,7,12});
        testBoth(4,0,true, new int[]{4,8,11,12});
        testBoth(11,2,true, new int[]{4,8,11,12});
        testBoth(6,-1,false, new int[]{4,8,11,12});
    }


    @Test (expected = IllegalArgumentException.class)
    public void testEmptySeq() {
        result(1,new int[]{});
    }
    public SearchResult result(int key, int[] arr)
    {
        return  BinarySearch.search(key, arr);
    }

    public void testBoth(int el, int position, boolean isFound, int[] arr)
    {
        Assert.assertThat(result(el, arr).isFound(), Matchers.equalTo(isFound));
        Assert.assertThat(result(el, arr).getPosition(), Matchers.equalTo(position));
    }
}
