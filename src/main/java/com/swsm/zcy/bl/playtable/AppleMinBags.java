package com.swsm.zcy.bl.playtable;

/**
 * @author liujie
 * @date 2023-06-28
 */
public class AppleMinBags {

    public static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) { // 如果是奇数，返回-1
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1 : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }

    public static void main(String[] args) {
        for (int apple = 1; apple <= 100; apple++) {
            System.out.println(apple + " : " + minBagAwesome(apple));
        }
    }
    
    
}
