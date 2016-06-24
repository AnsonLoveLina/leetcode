package cn.sinobest;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @org.junit.Test
    public void testTopKFrequent() throws Exception {
        Solution347 solution347 = new Solution347();
        List<Integer> result = solution347.topKFrequent(new int[]{1,1,1,2,2,3},2);
        for (Integer integer:result){
            System.out.println("integer = " + integer);
        }
    }

    @Test
    public void testMaxEnvelopes() throws Exception {
        Solution354 solution354 = new Solution354();
        int level = solution354.maxEnvelopes(new int[][]{{27, 20}, {10, 18}, {47, 42}, {22, 35}, {50, 18}, {43, 27}, {43, 8}, {46, 22}, {1, 24}, {28, 13}, {14, 48}, {35, 14}, {10, 15}, {15, 13}, {38, 39}, {14, 20}, {30, 21}, {50, 15}, {41, 6}, {22, 19}, {46, 6}, {41, 38}, {9, 33}, {16, 25}, {6, 1}, {48, 32}, {41, 24}, {44, 37}, {2, 43}, {17, 25}, {45, 49}, {30, 14}, {39, 31}, {27, 23}, {47, 14}, {24, 17}, {24, 44}, {30, 29}, {22, 5}, {25, 6}, {10, 8}, {10, 49}, {22, 27}, {8, 44}, {26, 14}, {4, 21}, {46, 40}, {10, 7}, {5, 14}, {15, 40}, {41, 1}, {23, 41}, {17, 18}, {14, 43}, {3, 36}, {3, 12}, {30, 36}, {30, 28}, {30, 19}});
        System.out.println("level = " + level);
    }

    @Test
    public void testReverseBetween(){
        SolutionMock1 solution = new SolutionMock1();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = solution.reverseBetween(node1,3,4);

    }

    @Test
    public void testIntegerToRoman(){
        String[] array = new String[]{"M","D","C","L","X","V","I"};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getBytes()[0]);
        }
    }
}