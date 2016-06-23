package cn.sinobest;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.TreeMultimap;

import java.util.*;

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
     */
    public int maxEnvelopes1(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }

    class Envelope{
        int width;
        int length;
        int level;

        public Envelope(int width, int length, int level) {
            this.width = width;
            this.length = length;
            this.level = level;
        }
    }

    private int level=0;

    private Map<Integer,Set<Envelope>> rootMap = new TreeMap<Integer, Set<Envelope>>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
        Map<Integer,Set<Envelope>> sumMap = new TreeMap<Integer, Set<Envelope>>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < envelopes.length; i++) {
            if (envelopes[i].length!=2){
                continue;
            }
            int width = envelopes[i][0];
            int length = envelopes[i][1];
            if (sumMap.containsKey(width+length)){
                sumMap.get(width+length).add(new Envelope(width,length,0));
                rootMap.get(width+length).add(new Envelope(width,length,0));
            }else {
                Set<Envelope> set = new HashSet<Envelope>();
                Set<Envelope> set1 = new HashSet<Envelope>();
                set.add(new Envelope(width,length,0));
                set1.add(new Envelope(width,length,0));
                sumMap.put(width+length, set);
                rootMap.put(width+length, set1);
            }
        }
        for (Map.Entry<Integer,Set<Envelope>> entry:rootMap.entrySet()){
            for (Envelope root:entry.getValue()){
                resolveEnvelope(entry.getKey(),root,sumMap);
            }
        }
        return level+1;
    }

    private void resolveEnvelope(Integer sum,Envelope root,Map<Integer,Set<Envelope>> sumMap){
        for (Map.Entry<Integer,Set<Envelope>> entry:sumMap.entrySet()){
            if (entry.getKey()>sum){
                for (Envelope envelope:entry.getValue()){
                    if (root.width<envelope.width && root.length<envelope.length){
                        envelope.level = root.level+1;
                        level = Math.max(envelope.level,level);
                        rootMap.get(entry.getKey()).remove(envelope);
                        resolveEnvelope(entry.getKey(),envelope,sumMap);
                        break;
                    }
                }
            }
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
