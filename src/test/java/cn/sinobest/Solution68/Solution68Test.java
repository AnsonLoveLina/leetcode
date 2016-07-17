package cn.sinobest.Solution68;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zy-xx on 16/7/1.
 */
public class Solution68Test {

    @Test
    public void testFullJustify() throws Exception {
        Solution68 solution68 = new Solution68();
        List<String> results = solution68.fullJustify(new String[]{""},0);
        System.out.println("results = " + results.toString());
    }
}