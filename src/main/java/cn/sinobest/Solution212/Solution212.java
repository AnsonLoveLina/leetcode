package cn.sinobest.Solution212;

import java.util.*;

/**
 * Created by zy-xx on 16/7/17.
 */
public class Solution212 {
    public List<String> findWords(char[][] board, String[] words) {
        HashMap<Character,Set<Integer[]>> boardMap = new HashMap<Character, Set<Integer[]>>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!boardMap.containsKey(board[i][j])){
                    HashSet<Integer[]> hs = new HashSet<Integer[]>();
                    hs.add(new Integer[]{i,j});
                    boardMap.put(board[i][j],hs);
                }else {
                    boardMap.get(board[i][j]).add(new Integer[]{i,j});
                }
            }
        }

        List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (isConver(words[i],boardMap)){
                result.add(words[i]);
            }
        }
        return result;
    }

    private boolean isConver(String word,HashMap<Character,Set<Integer[]>> boardMap){
        char[] chars = word.toCharArray();
        HashMap<Integer[],Set<Character>> revMap = new HashMap<Integer[], Set<Character>>();
        for (int j = 0; j < chars.length; j++) {
            Set<Integer[]> sets = boardMap.get(chars[j]);
            if (sets==null || sets.size()==0 || sets.isEmpty())continue;
            for (Integer[] ints:sets){
                if (revMap.containsKey(ints)){
                    Set<Character> charSet = revMap.get(ints);
                    charSet.add(chars[j]);
                    if (charSet.size()>word.length()){
                        return true;
                    }
                }else {
                    Set<Character> charSet = new HashSet<Character>();
                    charSet.add(chars[j]);
                    revMap.put(ints,charSet);
                }
            }
        }
        return false;
    }
}
