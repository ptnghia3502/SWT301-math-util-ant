package com.trongnghia.mathutil.main;

import com.trongnghia.mathutil.core.MathUtil;

/**
 *
 * @author Nghia
 */
public class Main {
    
    public static void main(String[] args) {
        /*
        int n = NghiaUtils.getInt("Nhap vao so n de tinh giai thua: ");
        long result = MathUtil.getFactorial(n);
        System.out.println("Ket qua la: " + result); */
        
        //TEST CASE 1: 0!
        long expectedValue = 1;
        long actualValue = MathUtil.getFactorial(0);
        System.out.println("Test 0! | expected = " + expectedValue 
                                + " | actual = " + actualValue);
        
        //TEST CASE 2: 1!
        expectedValue = 1;
        actualValue = MathUtil.getFactorial(1);
        System.out.println("Test 1! | expected = " + expectedValue 
                                + " | actual = " + actualValue);
        
        //TEST CASE 3: 5!
        expectedValue = 120;
        actualValue = MathUtil.getFactorial(5);
        System.out.println("Test 5! | expected = " + expectedValue 
                                + " | actual = " + actualValue);
        
        //TEST CASE 4: n = -5
        System.out.println("See the illegal Argument Exception if n = -5");
        MathUtil.getFactorial(-5);
    }
    
}
