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
        StringBuilder res = new StringBuilder();
        String[] array = new String[]{"M","D","C","L","X","V","I"};
        int qian = num/1000;
        num = num-qian*1000;
        int wubai = num/500;
        num = num-wubai*500;
        int yibai = num/100;
        num = num-yibai*100;
        int wushi = num/50;
        num = num-wushi*50;
        int shi = num/10;
        num = num-shi*10;
        int wu = num/5;
        num = num-wu*5;
        int yi = num;
        int[] sum = new int[]{qian,wubai,yibai,wushi,shi,wu,yi};
        for (int i = 0; i < array.length; i++) {
            if (sum[i]<=3){
                res.append(strRide(array[i],sum[i]));
            }else if (sum[i]==4){
                if (i%2!=0){
                    res.append(array[i]+array[i-1]);
                }else {
                    if (sum[i-1]==1){
                        res = res.delete(res.length()-1,res.length()).append(array[i]+array[i-2]);
                    }else {
                        res.append(array[i]+array[i-1]);
                    }
                }
            }else {
//                System.out.println(array[i]+" error! "+sum[i]);
            }
            System.out.println(sum[i]+":"+array[i]);
            System.out.println(res);
        }

        return res.toString();
    }

    private String strRide(String str,int i){
        String res = "";
        for (int j = 0; j < i; j++) {
            res += str;
        }
        return res;
    }
}
