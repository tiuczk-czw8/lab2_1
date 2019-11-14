import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Assert;
import org.junit.Test;

public class TestSeachResult {
@Test
public  void testSearch()
{

    Assert.assertEquals(true,result(15, new int[]{15}).isFound());
    Assert.assertEquals(1,result(15, new int[]{15}).getPosition());

    Assert.assertEquals(false,result(2, new int[]{15}).isFound());
    Assert.assertEquals(-1,result(2, new int[]{15}).getPosition());

    Assert.assertEquals(true, result(5, new int[]{0,2,5,12}).isFound());
    Assert.assertEquals(3, result(5, new int[]{0,2,5,12}).getPosition());

    Assert.assertEquals(true, result(12, new int[]{0,2,5,7,12}).isFound());
    Assert.assertEquals(5, result(12, new int[]{0,2,5,7,12}).getPosition());

    Assert.assertEquals(true, result(4, new int[]{4,8,11,12}).isFound());
    Assert.assertEquals(1, result(4, new int[]{4,8,11,12}).getPosition());

    Assert.assertEquals(false, result(6, new int[]{4,8,11,12}).isFound());
    Assert.assertEquals(-1, result(6, new int[]{4,8,11,12}).getPosition());

}

public SearchResult result(int key, int[] arr)
{
    return  BinarySearch.search(key, arr);
}

}
