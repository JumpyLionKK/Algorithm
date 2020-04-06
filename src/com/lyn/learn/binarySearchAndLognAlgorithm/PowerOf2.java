package com.lyn.learn.binarySearchAndLognAlgorithm;

public class PowerOf2 {
    public static double myPow(double x, int n) {
        // write your code here
        if(n < 0){
            return 1 / power(x, -n);
        }
        return power(x, n);
    }

    private static double power(double x, int n){
        if(n == 0) return 1;
        double half = power(x, n / 2);
        if(n % 2 == 0) return half * half;
        return half * half * x;
    }

    public static double myPow2(double x, int n) {
        double ans = 1, base = x;
        while(n != 0) {
            if(n % 2 == 1){
                ans *= x;
            }
            base *= base;
            n = n / 2;
        }
        return ans;

    }
}
