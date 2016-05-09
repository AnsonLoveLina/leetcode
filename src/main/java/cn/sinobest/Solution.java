package cn.sinobest;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.TreeMultimap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouyi1 on 2016/5/9 0009.
 */
public class Solution {

    /**
     * 347. Top K Frequent Elements
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     * For example,
     * Given [1,1,1,2,2,3] and k = 2, return [1,2].
     *
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ints = new ArrayList<Integer>();
        ArrayListMultimap<Integer,Integer> numCountMap = ArrayListMultimap.create();
        Map<Integer,Integer> numCountSourceMap = Maps.newHashMap();
//        int maxCounts = 1;

        for (int num:nums){
            Integer counts = numCountSourceMap.get(Integer.valueOf(num))==null?1:numCountSourceMap.get(Integer.valueOf(num))+1;
//            maxCounts = Math.max(maxCounts,counts);
            numCountSourceMap.put(num, counts);
        }

        for (Map.Entry<Integer,Integer> entry:numCountSourceMap.entrySet()){
            numCountMap.put(entry.getKey(), entry.getValue());
        }

        TreeMultimap<Integer, Integer> countNummap = Multimaps.invertFrom(numCountMap, TreeMultimap.<Integer,Integer>create());

        for (Map.Entry<Integer,Integer> entry:countNummap.entries()){
//            System.out.println("entryKey = " + entry.getKey());
//            System.out.println("entryValue = " + entry.getValue());
            if (entry.getKey()>=k){
                ints.add(entry.getValue());
            }
        }

        return ints;
    }

    /**
     * 343. Integer Break
     * @param n
     * @return
     */
    public int integerBreak(int n) {

        return 0;
    }

    /**
     * 30. Substring with Concatenation of All Words
     * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
     *
     * For example, given:
     * s: "barfoothefoobarman"
     * words: ["foo", "bar"]
     *
     * You should return the indices: [0,9].
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {

        return null;
    }
}
