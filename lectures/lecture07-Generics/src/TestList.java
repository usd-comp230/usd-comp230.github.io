import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestList {

    @Test
    public void testAdd() {
        List<String> slist = new AList<String>();
        slist.add("banana");
        slist.add("apple");

        assertEquals("banana", slist.get(0));
        assertEquals("apple", slist.get(1));
    }

    @Test
    public void testAddThenSize() {
        List<Integer> ilist = new AList<Integer>();
        ilist.add(500);
        ilist.add(12);

        assertEquals(2, ilist.size());
    }

    @Test
    public void testListOfLists() {

        // What is the declaration for bllist?
        // Here are some options:

        List<List<String>> bllist = new AList<List<String>>();   // E

        bllist.add(new AList<String>());
        bllist.add(new AList<String>());
        bllist.get(0).add("a");
        bllist.get(0).add("b");
        bllist.get(1).add("c");
        bllist.get(1).add("d");
        bllist.get(1).add("e");

        assertEquals("a", bllist.get(0).get(0));
        assertEquals("b", bllist.get(0).get(1));
        assertEquals("c", bllist.get(1).get(0));
        assertEquals("d", bllist.get(1).get(1));
        assertEquals("e", bllist.get(1).get(2));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegativeIndex() {
        List<String> slist = new AList<String>();
        slist.add("banana");
        slist.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testTooLargeIndexWithinCapacity() {
        List<String> slist = new AList<String>();
        slist.add("banana");
        slist.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testTooLargeIndexBeyondCapcity() {
        List<String> slist = new AList<String>();
        slist.add("banana");
        slist.get(100);
    }

}