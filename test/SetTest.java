import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;

/**
 * JUnit test fixture for {@code Set<String>}'s constructor and kernel methods.
 *
 * @author Wesam Khalil, Abhayjeet Singh, Pravin Harikrishnan
 *
 */
public abstract class SetTest {

    /**
     * Invokes the appropriate {@code Set} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new set
     * @ensures constructorTest = {}
     */
    protected abstract Set<String> constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new set
     * @ensures constructorRef = {}
     */
    protected abstract Set<String> constructorRef();

    /**
     * Creates and returns a {@code Set<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsTest = [entries in args]
     */
    private Set<String> createFromArgsTest(String... args) {
        Set<String> set = this.constructorTest();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    /**
     * Creates and returns a {@code Set<String>} of the reference implementation
     * type with the given entries.
     *
     * @param args
     *            the entries for the set
     * @return the constructed set
     * @requires [every entry in args is unique]
     * @ensures createFromArgsRef = [entries in args]
     */
    private Set<String> createFromArgsRef(String... args) {
        Set<String> set = this.constructorRef();
        for (String s : args) {
            assert !set.contains(
                    s) : "Violation of: every entry in args is unique";
            set.add(s);
        }
        return set;
    }

    // TODO - add test cases for constructor, add, remove, removeAny, contains, and size

    /**
     * Simple Test Case.
     */
    @Test
    public final void constructorTestNoArguments() {

        Set<String> s = this.createFromArgsTest();
        Set<String> sExpected = this.createFromArgsRef();

        assertEquals(sExpected, s);
    }

    /**
     * Boundary Test Case.
     */
    @Test
    public final void addTestAddingToEmptySet() {
        Set<String> s = this.createFromArgsTest();

        s.add("a");

        Set<String> sExpected = this.createFromArgsRef("a");

        assertEquals(sExpected, s);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void addTestAddingToSingleElementSet() {
        Set<String> set = this.createFromArgsTest("a");
        set.add("c");
        Set<String> setExpected = this.createFromArgsRef("a", "c");
        assertEquals(setExpected, set);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void addTestAddingToMultipleElementSet() {
        Set<String> set = this.createFromArgsTest("a", "b");
        set.add("c");
        Set<String> setExpected = this.createFromArgsRef("a", "b", "c");
        assertEquals(setExpected, set);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void addTestCallAddMultipleTimes() {
        Set<String> set = this.createFromArgsTest("a");
        set.add("b");
        set.add("c");
        set.add("d");
        Set<String> setExpected = this.createFromArgsRef("a", "b", "c", "d");
        assertEquals(setExpected, set);
    }

    /**
     * Boundary Test Case.
     */
    @Test
    public final void removeTestFromSingleElementSet() {
        Set<String> set = this.createFromArgsTest("a");
        String element = set.remove("a");
        String elementExpected = "a";
        Set<String> setExpected = this.createFromArgsRef();
        assertEquals(setExpected, set);
        assertEquals(elementExpected, element);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void removeTestFromMultipleElementSet() {
        Set<String> set = this.createFromArgsTest("a", "b", "c", "d");
        String element = set.remove("c");
        String elementExpected = "c";
        Set<String> setExpected = this.createFromArgsRef("a", "b", "d");
        assertEquals(setExpected, set);
        assertEquals(elementExpected, element);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void removeTestCallRemoveMutipleTimes() {
        Set<String> set = this.createFromArgsTest("a", "b", "c");
        String element1 = set.remove("c");
        String element1Expected = "c";
        String element2 = set.remove("b");
        String element2Expected = "b";
        Set<String> setExpected = this.createFromArgsRef("a");
        assertEquals(setExpected, set);
        assertEquals(element1Expected, element1);
        assertEquals(element2Expected, element2);
    }

    /**
     * Boundary Test Case (not using guidelines as there is only one element).
     */
    @Test
    public final void removeAnyTestFromSingleElementSet() {
        Set<String> set = this.createFromArgsTest("a");
        String element = set.removeAny();
        String elementExpected = "a";
        Set<String> setExpected = this.createFromArgsRef();
        assertEquals(setExpected, set);
        assertEquals(elementExpected, element);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void removeAnyTestFromMutipleElementSet() {
        //Setup
        Set<String> set = this.createFromArgsTest("a", "b");
        Set<String> setExpected = this.createFromArgsRef("a", "b");
        //Call
        String element = set.removeAny();
        //Evaluation
        boolean expectedContains = setExpected.contains(element);
        assertEquals(true, expectedContains);
        if (expectedContains) {
            String elementExpected = setExpected.remove(element);
            assertEquals(elementExpected, element);
            assertEquals(setExpected, set);
        }
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void removeAnyTestCallRemoveAnyMultipleTimes() {
        //Setup
        Set<String> set = this.createFromArgsTest("a", "b", "c", "d");
        Set<String> setExpected = this.createFromArgsRef("a", "b", "c", "d");
        //Call
        String element1 = set.removeAny();
        String element2 = set.removeAny();
        //Evaluation
        boolean expectedContains1 = setExpected.contains(element1);
        boolean expectedContains2 = setExpected.contains(element2);
        assertEquals(true, expectedContains1);
        assertEquals(true, expectedContains2);
        if (expectedContains1 && expectedContains2) {
            String elementExpected1 = setExpected.remove(element1);
            String elementExpected2 = setExpected.remove(element2);
            assertEquals(elementExpected1, element1);
            assertEquals(elementExpected2, element2);
            assertEquals(setExpected, set);
        }
    }

    /**
     * Boundary Test Case.
     */
    @Test
    public final void containsTestFromEmptySet() {
        Set<String> set = this.createFromArgsTest();
        boolean contains = set.contains("");
        assertEquals(false, contains);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void containsTestFromSingleElementSet() {
        Set<String> set = this.createFromArgsTest("b");
        boolean contains = set.contains("b");
        assertEquals(true, contains);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void containsTestFromMutipleElementSet() {
        Set<String> set = this.createFromArgsTest("a", "b", "c");
        boolean contains = set.contains("p");
        assertEquals(false, contains);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void containsTestCallContainsMultipleTimes() {
        Set<String> set = this.createFromArgsTest("a", "b", "c");
        boolean contains = set.contains("p");
        boolean contains2 = set.contains("b");
        assertEquals(false, contains);
        assertEquals(true, contains2);
    }

    /**
     * Boundary Test Case.
     */
    @Test
    public final void sizeTestFromEmptySet() {
        Set<String> set = this.createFromArgsTest();
        int length = set.size();
        assertEquals(0, length);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void sizeTestFromSingleElementSet() {
        Set<String> set = this.createFromArgsTest("a");
        int length = set.size();
        final int lengthExpected = 1;
        assertEquals(lengthExpected, length);
    }

    /**
     * Routine Test Case.
     */
    @Test
    public final void sizeTestFromMultipleElementSet() {
        Set<String> set = this.createFromArgsTest("a", "b", "c", "d", "e");
        int length = set.size();
        final int lengthExpected = 5;
        assertEquals(lengthExpected, length);
    }

}
