package com.swsm.zcy.bl.eor;

/**
 * @author liujie
 * @date 2023-06-10
 */
public class Swap {

    public static void main(String[] args) {
        int a = 3;
        int b = 8;
        System.out.println("a = " + a + ",b = " + b);
        
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = " + a + ",b = " + b);
        
    }
    
    
}
