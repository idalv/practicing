package com.sorting;

import com.datastructures.trees.Heap;
import com.util.Utilities;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/29/15
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeapSort {
    public List<Integer> sort(List<Integer> array) {
        List<Integer> heap = convertToHeap(array);

        for (int i = heap.size() - 1; i > 0; i--) {
            // Swap the root of the heap with the element at position i
            Utilities.swap(heap, i, 0);
            // Restore the heap
            Heap.moveDown(heap, 0, i-1);
        }

        return heap;
    }

    /**
     * Floyd algorithm for  bottom-up heap construction, see Section 6.9.2
     *
     * @param array
     * @return
     */
    private List<Integer> convertToHeap(List<Integer> array) {
        for (int i = array.size() / 2 - 1; i >= 0; i--) {
            Heap.moveDown(array, i, array.size()-1);
        }

        return array;
    }
}
