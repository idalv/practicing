package com.datastructures.trees;


import com.datastructures.trees.Node;
import com.datastructures.trees.NodeVisitor;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 1/19/15
 * Time: 11:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Heap<T extends Comparable<T>> {
    private ArrayList<T> heap = new ArrayList<T>();

    public void enqueue(T key) {
        heap.add(key);

        int currentIndex = heap.size() - 1;
        while (currentIndex != 0 && heap.get(currentIndex).compareTo(heap.get(getParentIndex(currentIndex))) > 0) {
            int parentIndex = getParentIndex(currentIndex);
            heap.set(currentIndex, heap.get(parentIndex));
            heap.set(parentIndex, key);
            currentIndex = parentIndex;
        }
    }

    private int getParentIndex(int currentIndex) {
        if (currentIndex % 2 == 0) {
            // This is a right child
            return (currentIndex - 2) / 2;
        } else {
            // This is a left child
            return (currentIndex - 1) / 2;
        }
    }

    public T dequeue() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        T result = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));

        if (heap.size() == 1) {
            // The heap has left with one node
            return result;
        }

        // Now ordering the heap to remain its properties
        int currentIndex = 0;
        while (currentIndex * 2 + 1 < heap.size()) {
            int leftIndex = currentIndex * 2 + 1;
            int rightIndex = currentIndex * 2 + 2;

            int indexOfBiggerNode;
            if (rightIndex >= heap.size()) {
                // There is no right child
                indexOfBiggerNode = leftIndex;
            } else if (heap.get(leftIndex).compareTo(heap.get(rightIndex)) > 0){
                indexOfBiggerNode = leftIndex;
            } else {
                indexOfBiggerNode = rightIndex;
            }

            if (heap.get(currentIndex).compareTo(heap.get(indexOfBiggerNode)) > 0) {
                break;
            }

            // Either the left or the right child is bigger
            T tmp = heap.get(currentIndex);
            heap.set(currentIndex, heap.get(indexOfBiggerNode));
            heap.set(indexOfBiggerNode, tmp);
            currentIndex = indexOfBiggerNode;
        }

        return result;
    }


    @Override
    public String toString() {
        return heap.toString();
    }
}
