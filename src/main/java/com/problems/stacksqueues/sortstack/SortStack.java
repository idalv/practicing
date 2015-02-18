package com.problems.stacksqueues.sortstack;

import com.problems.stacksqueues.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/18/15
 * Time: 11:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class SortStack {

    public static Stack<Integer> sortStack(Stack<Integer> original) {
        Stack<Integer> sorted = new SimpleStack<Integer>();

        Integer lastMinElement = null;
        while (original.peek() != null) {
            Integer minElement = null;
            int minElementCount = -1;

            // Find the min element with its count
            while (original.peek() != null) {
                sorted.push(original.pop());

                if (minElement == null || sorted.peek() < minElement) {
                    minElement = sorted.peek();
                    minElementCount = 1;
                } else if (sorted.peek() == minElement) {
                    minElementCount++;
                }
            }

            // Move all but the min elements back to original
            while (sorted.peek() != null) {
                // If we have reached the sorted part abort
                if (lastMinElement != null && sorted.peek() == (int) lastMinElement) {
                    break;
                }

                int current = sorted.pop();
                if (current > minElement) {
                    original.push(current);
                }
            }

            // Now push all min elements in sorted
            for (int i = minElementCount; i > 0; i--) {
                sorted.push(minElement);
            }

            // Mark where the sorted part starts
            lastMinElement = minElement;
        }

        return sorted;
    }

    public static Stack<Integer> sortStackElegantly(Stack<Integer> original) {
        Stack<Integer> sorted = new SimpleStack<Integer>();

        while (original.peek() != null) {
            // Take the current element at the top
            int current = original.pop();

            while (sorted.peek() != null && current < sorted.peek()) {
                // Find the current elements position by comparing it with the elements from sorted
                original.push(sorted.pop());
            }

            // Push the current element in its correct position
            sorted.push(current);
        }

        return sorted;
    }

}
