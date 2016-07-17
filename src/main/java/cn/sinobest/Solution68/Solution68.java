package cn.sinobest.Solution68;


import java.util.*;

/**
 * Created by zhouyi1 on 2016/5/9 0009.
 */
public class Solution68 {

    /**
     Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

     You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

     Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

     For the last line of text, it should be left justified and no extra space is inserted between words.

     For example,
     words: ["This", "is", "an", "example", "of", "text", "justification."]
     L: 16.

     Return the formatted lines as:
     [
     "This    is    an",
     "example  of text",
     "justification.  "
     ]
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        String[] groupWords = new String[(maxWidth/2)+2];
        int width = 0;
        for (int i = 0,j=0; i < words.length; i++) {
            groupWords[j] = words[i];
            width += words[i].length();
            j++;
            int length = i==words.length-1?0:words[i+1].length();
            //Note: Each word is guaranteed not to exceed L in length.
            if (width+length+j>maxWidth){
                int remainder = j==1?0:(maxWidth - width)%(j-1);
                int value = j==1?(maxWidth-width):(maxWidth-width)/(j-1);
                result.add(getGoodStr(groupWords,remainder,value,j));
                j=0;
                width=0;
//                groupWords[0] = words[i+1];
            }else if (i==words.length-1){
                result.add(getLeftStr(groupWords,maxWidth,j));
            }

        }
        return result;
    }

    private String getLeftStr(String[] groupWords, int maxWidth, int j){
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < j; k++) {
            if (k==j-1){
                int count = maxWidth-result.length()-groupWords[k].length();
                result.append(groupWords[k]+repeat(" ",count));
                continue;
            }
            result.append(groupWords[k]+" ");
        }
        System.out.println(result.toString());
        return result.toString();
    }

    private String getGoodStr(String[] groupWords, int remainder, int value, int j){
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < j; k++) {
            if (k==j-1 && k!=0){
                result.append(groupWords[k]);
                continue;
            }
            if(remainder!=0 && k<remainder){
                result.append(groupWords[k]+repeat(" ",value+1));
            }else {
                result.append(groupWords[k]+repeat(" ",value));
            }
        }
        System.out.println(result.toString());
        return result.toString();
    }

    /*
    fuck java
     */
    private String repeat(String source, int count) {
        StringBuilder result;
        for(result = new StringBuilder(count * source.length()); count > 0; --count) {
            result.append(source);
        }

        return result.toString();
    }
}
