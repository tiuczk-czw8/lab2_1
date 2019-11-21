import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.hamcrest.Matchers;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;


public class BinarySearchTest {

    @Test
    public void shouldElementBeInSequenceLength1() {
        int key = 2;
        int[] seq = new int[]{key};

        SearchResult result = BinarySearch.search(key, seq);

        assertThat(result.isFound(), Matchers.equalTo(true));
    }


    @Test
    public void ElementNotInSeqLength1()  {
        int key = 2;
        int[] seq = new int[]{3};

        SearchResult result = BinarySearch.search(key, seq);

        assertThat(result.isFound(), Matchers.equalTo(false));
    }

    @Test
    public void MiddleElementInSeq() {
        int key = 2;
        int[] seq = new int[]{1, key, 3};

        SearchResult result = BinarySearch.search(key, seq);

        assertThat(result.getPosition(), Matchers.equalTo(1));
    }

    @Test
    public void FirstElementInSeq() {
        int key = 2;
        int[] seq = new int[]{key, 3, 4};

        SearchResult result = BinarySearch.search(key, seq);

        assertThat(result.getPosition(), Matchers.equalTo(0));
    }

    @Test
    public void  LastElementInSeq() {
        int key = 4;
        int[] seq = new int[]{1, 2, 3, 4};

        SearchResult result = BinarySearch.search(key, seq);

        assertThat(result.getPosition(), Matchers.equalTo(3));
    }

    @Test
    public void ElementNotInSeq() {
        int key = 5;
        int[] seq = new int[]{1, 2, 3, 4};

        SearchResult result = BinarySearch.search(key, seq);

        assertThat(result.getPosition(), Matchers.equalTo(-1));
    }

    @Test
    public void SeqIsEmpty() {
        int key = 1;
        int[] seq = new int[]{};

        SearchResult result = BinarySearch.search(key, seq);

        assertThat(result.getPosition(), Matchers.equalTo(-1));
    }
}
