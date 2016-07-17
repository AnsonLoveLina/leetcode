package cn.sinobest.Solution212;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zy-xx on 16/7/18.
 */
public class Solution212Test {

    @Test
    public void testFindWords() throws Exception {
        Solution212 solution212 = new Solution212();
        List<String> result = solution212.findWords(new char[][]{
        {'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}
        },new String[]{"oath","pea","eat","rain"});
        System.out.println(result);
    }
}