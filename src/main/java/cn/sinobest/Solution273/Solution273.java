package cn.sinobest.Solution273;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouyi1 on 2016/5/9 0009.
 */
public class Solution273 {

    /**
     Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

     For example,
     123 -> "One Hundred Twenty Three"
     12345 -> "Twelve Thousand Three Hundred Forty Five"
     1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
     */
    public String numberToWords(int num) {
        if (num==0){
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        String[] numStrs = new String[]{""," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"};
        String[] tenStrs = new String[]{" Ten"," Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"};
        String[] tgitStrs = new String[]{"",""," Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"};
        String[] unitStrs = new String[]{" Thousand"," Million"," Billion"," Trillion"};
        String hundred = " Hundred";
        String numStr = Integer.toString(num);
        byte[] numBytes = numStr.getBytes();
        for (int i = (numBytes.length-1),j=0,v=-1; i > -1; i--) {
//            System.out.println(numBytes[i]-48);
            int oneNum = numBytes[i]-48;
            if (j==0){
                if (v!=-1){
                    if (oneNum!=0 || i-3<=-1 || Integer.valueOf(numStr.substring(i-2,i))!=0) {
                        result.insert(0, unitStrs[v]);
                    }
                }
                if(i!=0 && (numBytes[i-1]-48)==1){
                    result.insert(0,tenStrs[oneNum]);
                }else {
                    result.insert(0,numStrs[oneNum]);
                }
                j++;
            }else if (j==1){
                if (oneNum!=1){
                    result.insert(0,tgitStrs[oneNum]);
                }
                j++;
            }else{
                if (oneNum!=0){
                    result.insert(0,hundred);
                }
                result.insert(0,numStrs[oneNum]);
                j=0;
                v++;
            }
        }
        result.deleteCharAt(0);
        return result.toString();
    }
}
