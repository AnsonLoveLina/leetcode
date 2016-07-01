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
        String[] groupWords = new String[(maxWidth/2)+1];
        int width = 0;
        for (int i = 0,j=0; i < words.length; i++) {
            groupWords[j] = words[i]+" ";
            if (width + words[i].length()+1>maxWidth){
                int remainder = (maxWidth - width)%(j-1);
                int value = (maxWidth-width)/(j-1);
                for (int k = 0; k < j-1; k++) {
                    if(remainder!=0 && k==remainder){
                        groupWords[j] += repeat(" ",value+1);
                    }else {
                        groupWords[j] += repeat(" ",value);
                    }
                }
                result.add(Arrays.toString(groupWords));
                j=0;
                groupWords[j] = words[i]+" ";
            }else {
                width += words[i].length()+1;
                j++;
            }
        }
        return result;
    }

    /*
    fuck java
     */
    private static String repeat(String source, int count) {
        StringBuilder result;
        for(result = new StringBuilder(count * source.length()); count > 0; --count) {
            result.append(source);
        }

        return result.toString();
    }
}
