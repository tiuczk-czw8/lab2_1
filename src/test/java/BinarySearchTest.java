import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import java.util.Arrays;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

public class BinarySearchTest {

    @NotNull
    private static Integer[] getBoxedArray(int[] array) {
        return Arrays.stream(array)
                     .boxed()
                     .toArray(Integer[]::new);
    }

    private static void testResultForTrueAssumptions(SearchResult result, int[] seq, int key, int idx) {
        assertThat(result, instanceOf(SearchResult.class));
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), equalTo(idx));
        assertThat(getBoxedArray(seq), hasItemInArray(key));
        assertThat(key, equalTo(seq[idx]));
    }

    private static void testResultForFalseAssumptions(SearchResult result, int[] seq, int key) {
        assertThat(result, instanceOf(SearchResult.class));
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), lessThanOrEqualTo(-1));
        assertThat(getBoxedArray(seq), not(hasItemInArray(key)));
    }

    private static void testPreconditions(@NotNull int[] seq) {
        assertThat(seq.length, greaterThan(0));
        assertThat(hasConsecutiveValues(seq), is(true));
        assertThat(hasDistinctValues(seq), is(true));
    }

    @Contract(pure = true)
    private static boolean hasConsecutiveValues(@NotNull int[] seq) {
        if (seq.length == 1) {
            return true;
        }

        int previousValue = seq[0];

        for (int i = 1; i < seq.length; i++) {
            if (seq[i] <= previousValue) {
                return false;
            }

            previousValue = seq[i];
        }

        return true;
    }

    @Contract(pure = true)
    private static boolean hasDistinctValues(@NotNull int[] seq) {
        for (int i = 0; i < seq.length; i++) {
            for (int j = i + 1; j < seq.length - 1; j++) {
                if (seq[i] == seq[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void elementShouldBeInSequenceLength1() {
        int key = 2;
        int[] seq = new int[] {key};
        int idx = 0;

        SearchResult result = BinarySearch.search(key, seq);

        testPreconditions(seq);
        testResultForTrueAssumptions(result, seq, key, idx);
    }

    @Test
    public void elementShouldNotToBeInSequenceLength1() {
        int key = 2;
        int[] seq = new int[] {3};

        SearchResult result = BinarySearch.search(key, seq);

        testPreconditions(seq);
        testResultForFalseAssumptions(result, seq, key);
    }

    @Test
    public void shouldBeFirstElementInSequenceLengthGreaterThan1() {
        int key = 4;
        int[] seq = new int[] {key, 5, 6, 7, 8, 9};
        int idx = 0;

        SearchResult result = BinarySearch.search(key, seq);

        testPreconditions(seq);
        testResultForTrueAssumptions(result, seq, key, idx);
    }

    @Test
    public void shouldBeTheLastElementInSequenceLengthGreaterThan1() {
        int key = 11;
        int[] seq = new int[] {10, key};
        int idx = 1;

        SearchResult result = BinarySearch.search(key, seq);

        testPreconditions(seq);
        testResultForTrueAssumptions(result, seq, key, idx);
    }

    @Test
    public void shouldBeTheMiddleElementInSequenceLengthGreaterThan1() {
        int key = 13;
        int[] seq = new int[] {12, key, 14};
        int idx = 1;

        SearchResult result = BinarySearch.search(key, seq);

        testPreconditions(seq);
        testResultForTrueAssumptions(result, seq, key, idx);
    }

    @Test
    public void elementShouldNotBeInSequenceLengthGreaterThan1() {
        int key = 15;
        int[] seq = new int[] {16, 17, 18};

        SearchResult result = BinarySearch.search(key, seq);

        testPreconditions(seq);
        testResultForFalseAssumptions(result, seq, key);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForSequenceLengthZero() {
        int[] seq = new int[] {};

        BinarySearch.search(0, seq);
    }
}
