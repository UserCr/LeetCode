package com.leetcode;

import com.leetcode.solutions.commonDataStructure.ListNode;

import java.util.List;

public class CommonPrint {
    public static void PrintArray(Object[] objects) {
        for (Object object : objects) {
            System.out.print(object + " ");
        }
        System.out.println();
    }

    public static void PrintIntArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static <T> void PrintList(List<T> list) {
        for (T element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void PrintLinkedList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + "->");
            list = list.next;
        }
        System.out.println();
    }
}
