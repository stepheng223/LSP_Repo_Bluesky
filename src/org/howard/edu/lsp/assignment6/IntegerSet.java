package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet represents a collection of unique integers and supports
 * common set operations such as union, intersection, difference, and complement.
 */
public class IntegerSet {

    private List<Integer> set = new ArrayList<>();

    /**
     * Default constructor that initializes an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this set with another set for equality.
     * Two sets are considered equal if they contain the same elements,
     * regardless of order.
     *
     * @param b the IntegerSet to compare with
     * @return true if both sets contain the same elements, false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (b == null || this.length() != b.length()) {
            return false;
        }

        for (Integer value : this.set) {
            if (!b.contains(value)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Determines whether the set contains a given value.
     *
     * @param value the integer value to search for
     * @return true if the value exists in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     *
     * @return the largest integer in the set
     * @throws Exception if the set is empty
     */
    public int largest() throws Exception {
        if (set.isEmpty()) {
            throw new Exception("IntegerSet is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set.
     *
     * @return the smallest integer in the set
     * @throws Exception if the set is empty
     */
    public int smallest() throws Exception {
        if (set.isEmpty()) {
            throw new Exception("IntegerSet is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds a value to the set if it is not already present.
     *
     * @param item the integer value to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes a value from the set if it exists.
     * If the value is not present, the set remains unchanged.
     *
     * @param item the integer value to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs the union of this set with another set.
     * The result is stored in this set.
     *
     * @param intSetb the set to union with
     */
    public void union(IntegerSet intSetb) {
        if (intSetb == null) {
            return;
        }

        for (Integer value : intSetb.set) {
            if (!this.set.contains(value)) {
                this.set.add(value);
            }
        }
    }

    /**
     * Performs the intersection of this set with another set.
     * Only elements common to both sets are retained.
     *
     * @param intSetb the set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        if (intSetb == null) {
            clear();
            return;
        }

        List<Integer> result = new ArrayList<>();

        for (Integer value : this.set) {
            if (intSetb.contains(value)) {
                result.add(value);
            }
        }

        this.set = result;
    }

    /**
     * Removes all elements from this set that are also present in another set.
     *
     * @param intSetb the set whose elements will be removed from this set
     */
    public void diff(IntegerSet intSetb) {
        if (intSetb == null) {
            return;
        }

        List<Integer> result = new ArrayList<>();

        for (Integer value : this.set) {
            if (!intSetb.contains(value)) {
                result.add(value);
            }
        }

        this.set = result;
    }

    /**
     * Computes the complement of this set relative to another set.
     * The result contains elements that are in intSetb but not in this set.
     *
     * @param intSetb the reference set
     * @return a new IntegerSet containing the complement
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        if (intSetb == null) {
            return result;
        }

        for (Integer value : intSetb.set) {
            if (!this.set.contains(value)) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * Checks whether the set is empty.
     *
     * @return true if the set contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     * The format is: [1, 2, 3]
     *
     * @return the string representation of the set
     */
    public String toString() {
        Collections.sort(set);
        return set.toString();
    }
}