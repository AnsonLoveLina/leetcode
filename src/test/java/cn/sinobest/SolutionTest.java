package cn.sinobest;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @org.junit.Test
    public void testTopKFrequent() throws Exception {
        Solution solution = new Solution();
        List<Integer> result = solution.topKFrequent(new int[]{1,1,1,2,2,3},2);
        for (Integer integer:result){
            System.out.println("integer = " + integer);
        }
    }
}