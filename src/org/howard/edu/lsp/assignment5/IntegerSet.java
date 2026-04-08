package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet represents a mathematical set of integers.
 * It does not allow duplicate values and supports common set operations.
 */
public class IntegerSet {

    private ArrayList<Integer> set = new ArrayList<>();

    /**
     * Clears all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this set with another set for equality.
     * Two sets are equal if they contain the same elements.
     *
     * @param b another IntegerSet
     * @return true if both sets contain the same elements
     */
    public boolean equals(IntegerSet b) {
        if (b == null) return false;

        ArrayList<Integer> a = new ArrayList<>(this.set);
        ArrayList<Integer> c = new ArrayList<>(b.set);

        Collections.sort(a);
        Collections.sort(c);

        return a.equals(c);
    }

    /**
     * Checks if a value exists in the set.
     *
     * @param value integer to check
     * @return true if value is in the set
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     *
     * @return largest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest value in the set.
     *
     * @return smallest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     *
     * @param item integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     *
     * @param item integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns the union of this set and another set.
     *
     * @param b another IntegerSet
     * @return a new set containing all unique elements from both sets
     */
    public IntegerSet union(IntegerSet b) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);

        for (int num : b.set) {
            if (!result.set.contains(num)) {
                result.set.add(num);
            }
        }

        return result;
    }

    /**
     * Returns the intersection of this set and another set.
     *
     * @param b another IntegerSet
     * @return a new set containing elements common to both sets
     */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int num : this.set) {
            if (b.set.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    /**
     * Returns the difference of this set and another set.
     * (elements in this set but not in b)
     *
     * @param b another IntegerSet
     * @return a new set containing elements in this set but not in b
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = new IntegerSet();

        for (int num : this.set) {
            if (!b.set.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    /**
     * Returns the complement of this set relative to another set.
     * (elements in b but not in this set)
     *
     * @param b another IntegerSet
     * @return a new set containing elements in b but not in this set
     */
    public IntegerSet complement(IntegerSet b) {
        return b.diff(this);
    }

    /**
     * Checks if the set is empty.
     *
     * @return true if the set has no elements
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Format: [1, 2, 3]
     *
     * @return sorted string representation of the set
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
