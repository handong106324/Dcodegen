package oa.codegen.util;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by handong on 16/2/25.
 */
public class StringTool {
    public static String lowcaseFirst(String string) {
        char[] chars = Arrays.copyOf(string.toCharArray(),string.length());
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }

    @Test
    public void testLow(){
        System.out.println(lowcaseFirst("WosloLiit"));
    }
}
