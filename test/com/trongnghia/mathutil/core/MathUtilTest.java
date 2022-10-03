package com.trongnghia.mathutil.core;

import com.trongnghia.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nghia
 */
public class MathUtilTest {
    
    //Ghi chu:
    // @Test là 1 đánh dấu để báo với JVM
    // để biết hàm này là hàm main() và chạy code trong hàm này
    // nếu thiếu @Test trước hàm thì JUnit ko vận hành
    
    @Test
    public void testFactorialGivenRightArgumentReturnsWell2() {
        Assert.assertEquals(24, MathUtil.getFactorial(4));
        Assert.assertEquals(120, MathUtil.getFactorial(5));
    }
    
    @Test
    public void testFactorialGivenRightArgumentReturnsWell() {
        long expected = 1;
        long actual = MathUtil.getFactorial(0);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(1, MathUtil.getFactorial(1));
        Assert.assertEquals(2, MathUtil.getFactorial(2));
        Assert.assertEquals(6, MathUtil.getFactorial(3));
    }
    
    //bắt Exception thì sao?
    @Test(expected = IllegalArgumentException.class)
    //Test case: n = -5, -5! expected: hy vọng thấy ngoại lệ được ném ra
    //nếu -5 đưa vào hàm, thì phải thấy ngoại lệ xuất hiện
    //nếu ngoại lệ xuất hiện khi tính -5!, nghĩa là hàm chạy đúng
    //muốn đo, có ngoại lệ xuất hiện hay ko khi chơi -5
    //do ngoại lệ ko là value kiểu long để so sánh
    //khi chạy -5!, EXPECTED = IllegalArgumentException
    //nghĩa là có sự xuất hiện của 1 object thuộc class Illegal
   
    public void testFactorialGivenWrongArgumentThrowsException() {
        MathUtil.getFactorial(-55);
    }
    
//    @Test
//    public void testGreen() {
//        Assert.assertEquals(10, 10);
//    }
//    
//    @Test
//    public void testRed() {
//        Assert.assertEquals(10, 100);
//    }
    
}
