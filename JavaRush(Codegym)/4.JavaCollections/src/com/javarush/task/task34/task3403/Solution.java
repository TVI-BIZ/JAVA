package com.javarush.task.task34.task3403;

import java.util.ArrayList;

/*
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);

    }

    public void recurse(int n) {

        int minD = 2;
        if(n % minD == 0){
            n = n / minD;
            System.out.print(minD + " ");
            if(n==1){
                return;
            } else {
                recurse(n);
            }
        } else {
            minD ++;
            System.out.println("else" + minD);
            if(minD < n){
                recurse(n);
            } else {
                return;
            }

        }
    }
};


