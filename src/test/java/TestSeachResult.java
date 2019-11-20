import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Assert;
import org.junit.Test;

public class TestSeachResult {
    @Test
    public  void testOneElSearch()
    {
    testBoth(15,1,true,new int[]{15});
    testBoth(2,-1,false,new int[]{15});

    }
    @Test
    public  void testSeveralElSearch()
    {
        testBoth(12,5,true, new int[]{0,2,5,7,12});
        testBoth(4,1,true, new int[]{4,8,11,12});
        testBoth(11,3,true, new int[]{4,8,11,12});
        testBoth(6,-1,false, new int[]{4,8,11,12});
    }


public SearchResult result(int key, int[] arr)
{
    return  BinarySearch.search(key, arr);
}

public void testBoth(int el, int position, boolean isFound, int[] arr)
{
    Assert.assertEquals(isFound, result(el, arr).isFound());
    Assert.assertEquals(position, result(el, arr).getPosition());
}
}
