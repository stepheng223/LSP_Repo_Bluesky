package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test cases for IntegerSet.
 * Covers all required methods including normal and edge cases.
 */
public class IntegerSetTest {

    // -------- clear() --------
    @Test
    public void testClearNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    @Test
    public void testClearEdgeEmptySet() {
        IntegerSet set = new IntegerSet();
        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    // -------- length() --------
    @Test
    public void testLengthNormal() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(20);

        assertEquals(2, set.length());
    }

    @Test
    public void testLengthEdgeEmptySet() {
        IntegerSet set = new IntegerSet();

        assertEquals(0, set.length());
    }

    // -------- equals() --------
    @Test
    public void testEqualsSameElementsDifferentOrder() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(2);
        set2.add(1);

        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEqualsMismatch() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set2.add(2);

        assertFalse(set1.equals(set2));
    }

    // -------- contains() --------
    @Test
    public void testContainsPresent() {
        IntegerSet set = new IntegerSet();
        set.add(5);

        assertTrue(set.contains(5));
    }

    @Test
    public void testContainsNotPresent() {
        IntegerSet set = new IntegerSet();

        assertFalse(set.contains(99));
    }

    // -------- largest() --------
    @Test
    public void testLargestNormal() throws Exception {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(10);
        set.add(3);

        assertEquals(10, set.largest());
    }

    @Test
    public void testLargestSingleElement() throws Exception {
        IntegerSet set = new IntegerSet();
        set.add(7);

        assertEquals(7, set.largest());
    }

    @Test
    public void testLargestEmptyException() {
        IntegerSet set = new IntegerSet();

        assertThrows(Exception.class, set::largest);
    }

    // -------- smallest() --------
    @Test
    public void testSmallestNormal() throws Exception {
        IntegerSet set = new IntegerSet();
        set.add(8);
        set.add(2);
        set.add(5);

        assertEquals(2, set.smallest());
    }

    @Test
    public void testSmallestSingleElement() throws Exception {
        IntegerSet set = new IntegerSet();
        set.add(42);

        assertEquals(42, set.smallest());
    }

    @Test
    public void testSmallestEmptyException() {
        IntegerSet set = new IntegerSet();

        assertThrows(Exception.class, set::smallest);
    }

    // -------- add() --------
    @Test
    public void testAddNormal() {
        IntegerSet set = new IntegerSet();
        set.add(4);

        assertTrue(set.contains(4));
        assertEquals(1, set.length());
    }

    @Test
    public void testAddDuplicate() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(4);

        assertEquals(1, set.length());
    }

    // -------- remove() --------
    @Test
    public void testRemoveNormal() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(1);

        assertFalse(set.contains(1));
    }

    @Test
    public void testRemoveValueNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(99);

        assertTrue(set.contains(1));
        assertEquals(1, set.length());
    }

    // -------- union() --------
    @Test
    public void testUnionNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set2.add(2);

        set1.union(set2);

        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertEquals(2, set1.length());
    }

    @Test
    public void testUnionWithEmptySet() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet empty = new IntegerSet();

        set1.add(1);
        set1.union(empty);

        assertEquals(1, set1.length());
    }

    // -------- intersect() --------
    @Test
    public void testIntersectNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set2.add(2);

        set1.intersect(set2);

        assertTrue(set1.contains(2));
        assertEquals(1, set1.length());
    }

    @Test
    public void testIntersectNoCommonElements() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set2.add(2);

        set1.intersect(set2);

        assertTrue(set1.isEmpty());
    }

    // -------- diff() --------
    @Test
    public void testDiffNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set1.add(2);
        set2.add(2);

        set1.diff(set2);

        assertTrue(set1.contains(1));
        assertFalse(set1.contains(2));
    }

    @Test
    public void testDiffIdenticalSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set2.add(1);

        set1.diff(set2);

        assertTrue(set1.isEmpty());
    }

    // -------- complement() --------
    @Test
    public void testComplementNormal() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set1.add(1);
        set2.add(1);
        set2.add(2);

        IntegerSet result = set1.complement(set2);

        assertTrue(result.contains(2));
        assertEquals(1, result.length());
    }

    @Test
    public void testComplementDisjointSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        set2.add(3);

        IntegerSet result = set1.complement(set2);

        assertTrue(result.contains(3));
    }

    // -------- isEmpty() --------
    @Test
    public void testIsEmptyTrue() {
        IntegerSet set = new IntegerSet();

        assertTrue(set.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        IntegerSet set = new IntegerSet();
        set.add(1);

        assertFalse(set.isEmpty());
    }

    // -------- toString() --------
    @Test
    public void testToStringNormal() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);

        assertEquals("[1, 2, 3]", set.toString());
    }

    @Test
    public void testToStringEmpty() {
        IntegerSet set = new IntegerSet();

        assertEquals("[]", set.toString());
    }
}