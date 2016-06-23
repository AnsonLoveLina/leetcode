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
     * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

     What is the maximum number of envelopes can you Russian doll? (put one inside other)

     Example:
     Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

     Subscribe to see which companies asked this question
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        List<Envelopes> envelopesList = new ArrayList<Envelopes>();
        int level = 0;
        for (int i = 0; i < envelopes.length; i++) {
            if (envelopes[i].length!=2){
                return 0;
            }
            int width = envelopes[i][0];
            int length = envelopes[i][1];
            Envelopes envelopes1 = new Envelopes(new int[][]{envelopes[i]},width+length);
//            if ()
        }
        return level;
    }

    class Envelopes{
        int [][] widthAndLength;
        int sum;

        public Envelopes(int[][] widthAndLength, int sum) {
            this.widthAndLength = widthAndLength;
            this.sum = sum;
        }

        public void addWidthAndLength(int[][] widthAndLength){

        }

        @Override
        public int hashCode() {
            return sum;
        }

        @Override
        public boolean equals(Object obj) {
            return sum == ((Envelopes)obj).sum;
        }
    }

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
