package collections;

import org.junit.Test;
import system.SystemUtils;

/**
 * Created by handong on 16/2/5.
 */
public class BitUtils {
    public static int getNum(int num , int bitIndex) {
        return num & 1<< bitIndex;
    }

    @Test
    public void testBit(){
        SystemUtils.println(getNum(29460,4));
    }
}
