package cn.sinobest.Solution44;


/**
 * Created by zhouyi1 on 2016/5/9 0009.
 */
public class Solution44 {

    /**
     Implement wildcard pattern matching with support for '?' and '*'.

     '?' Matches any single character.
     '*' Matches any sequence of characters (including the empty sequence).

     The matching should cover the entire input string (not partial).

     The function prototype should be:
     bool isMatch(const char *s, const char *p)

     Some examples:
     isMatch("aa","a") → false
     isMatch("aa","aa") → true
     isMatch("aaa","aa") → false
     isMatch("aa", "*") → true
     isMatch("aa", "a*") → true
     isMatch("ab", "?*") → true
     isMatch("aab", "c*a*b") → false
     */
    byte one = "?".getBytes()[0];
    byte all = "*".getBytes()[0];
    /**
     * non-greedy
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        return false;
    }


}
