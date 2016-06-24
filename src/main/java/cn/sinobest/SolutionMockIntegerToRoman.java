package cn.sinobest;

/**
 * Created by zhouyi1 on 2016/5/9 0009.
 */
public class SolutionMockIntegerToRoman {

    /**
     Given an integer, convert it to a roman numeral.

     Input is guaranteed to be within the range from 1 to 3999.
     */

    public String intToRoman(int num) {
//        num = num-3;
        String res = "";
        String[] array = new String[]{"M","D","C","L","X","V","I"};
        String one = "I";
        String[] array1 = new String[]{"IV","IX","IL","IC","ID","IM"};
        int qian = num%1000;
        num = num-qian*1000;
        int wubai = num%500;
        num = num-wubai*500;
        int yibai = num%100;
        num = num-yibai*100;
        int wushi = num%50;
        num = num-wushi*50;
        int shi = num%10;
        num = num-shi*10;
        int wu = num%5;
        num = num-wu*5;
        int yi = num;
        int[] sum = new int[]{qian,wubai,yibai,wushi,shi,wu,yi};
        for (int i = 0; i < array.length; i++) {
            if (sum[i]<=3){
                res += strRide(array[i],sum[i]);
            }else {
                res += strRide(array[i],1);
            }
        }

        return res;
    }

    private String strRide(String str,int i){
        for (int j = 0; j < i; j++) {
            str += str;
        }
        return str;
    }
}
