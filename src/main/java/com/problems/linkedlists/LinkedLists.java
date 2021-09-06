package com.problems.linkedlists;

import com.datastructures.singlelinkedlist.Node;
import com.datastructures.singlelinkedlist.SingleLinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Mitev
 * Date: 2/12/15
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkedLists {
    public static<T> SingleLinkedList<T> removeDuplicates(SingleLinkedList<T> original) {
        if (original.head.nextNode == null) {
            return original;
        }

        Node<T> i = original.head;
        while (i.nextNode != null) {
            Node<T> j = i;
            while (j != null && j.nextNode != null) {
                if (j.nextNode.data.equals(i.data)) {
                    // Delete the node after j
                    j.nextNode = j.nextNode.nextNode;
                }
                j = j.nextNode;
            }
            i = i.nextNode;
        }

        return original;
    }

    public static<T> Node<T> getKthToTheLast(SingleLinkedList<T> list, int k) {
        if (list == null) {
            return null;
        }

        Node<T> current = list.head;
        Node<T> runner = list.head;

        // Move the runner k elements ahead
        for (int i = 0; i < k-1; i++) {
            if (runner.nextNode == null) {
                // There are no enough elements. Return the head
                return list.head;
            }
            runner = runner.nextNode;
        }

        // Now move both current and runner till the end of the list
        while (runner.nextNode != null) {
            runner = runner.nextNode;
            current = current.nextNode;
        }

        // At the end current should point to the kth node
        return current;
    }

//    private static int index;
    public static Node kthNode;

    public static<T> int getKthToTheLastRecursively(Node<T> current, int k) {
        if (current.nextNode == null) {
            // This is the last node
            return k;
        }
        int index = getKthToTheLastRecursively(current.nextNode, k);
        index = index-1;
        if (index == 1) {
            kthNode = current;
        }
        return index;
    }

    public static<T> Node<T> getKthToTheLastRecursively(SingleLinkedList<T> list, int k) {
        SingleLinkedList<T> kthHeadList = new SingleLinkedList<T>();
        getKRecursively(list.head, k, kthHeadList);
        return kthHeadList.head;
    }

    private static<T> int getKRecursively(Node<T> current, int k, SingleLinkedList<T> kthHeadList) {
        if (current.nextNode == null) {
            // This is the last node
            return k;
        }
        int index = getKRecursively(current.nextNode, k, kthHeadList);
        index = index-1;
        if (index == 1) {
            kthHeadList.head = current;
        }
        return index;
    }

    public static Node<Integer> addReversedLists(Node<Integer> first, Node<Integer> second) {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        Node<Integer> sum = null;
        Node<Integer> sumHead = null;
        int carryover = 0;
        while (first != null || second != null) {
            int fint = (first == null) ? 0 : first.data;
            int sint = (second == null) ? 0 : second.data;

            int sumint = fint + sint + carryover;
            carryover = sumint / 10;
            Node<Integer> node = new Node<Integer>(sumint % 10);
            if (sumHead == null) {
                sumHead = node;
                sum = node;
            } else {
                sum.nextNode = node;
                sum = sum.nextNode;
            }
            first = first.nextNode;
            second = second.nextNode;
        }

        // Add a carryover node if there is a carryover
        if (carryover > 0) {
            sum.nextNode = new Node<Integer>(carryover);
        }

        return sumHead;
    }

    public static SingleLinkedList<Integer> addLists(Node<Integer> first, Node<Integer> second) {
        SingleLinkedList<Integer> sum = new SingleLinkedList<Integer>();
        int carryover = LinkedLists.addLists(first, second, sum);
        if (carryover > 0) {
            Node<Integer> node = new Node<Integer>(carryover);
            node.nextNode = sum.head;
            sum.head = node;
        }
        return sum;
    }

    private static int addLists(Node<Integer> first, Node<Integer> second, SingleLinkedList<Integer> sum) {
        if (first == null && second == null) {
            return 0;
        }

        int carryover = addLists(first.nextNode, second.nextNode, sum);

        int sumint = first.data + second.data + carryover;
        Node<Integer> node = new Node<Integer>(sumint % 10);
        node.nextNode = sum.head;
        sum.head = node;
        return sumint / 10;
    }

    private static Node frontToBack = null;

    public static<T> boolean isPalindrome(Node<T> head) {
        LinkedLists.frontToBack = head;
        return isPalindromeRecursive(head);
    }

    private static<T> boolean isPalindromeRecursive(Node<T> current) {
        if (current == null) {
            return true;
        }

        boolean result = isPalindromeRecursive(current.nextNode);

        if (!result) {
            return result;
        }

        result = LinkedLists.frontToBack.data == current.data;
        LinkedLists.frontToBack = LinkedLists.frontToBack.nextNode;
        return result;
    }

    public static<T> int getKthToTheLastRecursively3(Node<T> current, int k, Node<T> result) {
        if (current.nextNode == null) {
            return 1;
        }

        int currentIndex = 1 + getKthToTheLastRecursively3(current.nextNode, k, result);
        if (currentIndex == k) {
            result.data = current.data;
        }
        return currentIndex;
    }
}
