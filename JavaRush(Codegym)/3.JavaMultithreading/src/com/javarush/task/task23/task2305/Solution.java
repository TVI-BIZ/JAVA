package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static class InnerClass {

    }

    public static Solution[] getTwoSolutions() {
        Solution[] solArr = new Solution[2];
        Solution sol1 = new Solution();
        Solution sol2 = new Solution();

        solArr[0] = sol1;
        solArr[1] = sol2;

        InnerClass [] inner1 = new InnerClass[2];
        inner1[0] = new InnerClass();
        inner1[1] = new InnerClass();

        InnerClass [] inner2 = new InnerClass[2];
        inner2[0] = new InnerClass();
        inner2[1] = new InnerClass();



        sol1.innerClasses = inner1;
        sol2.innerClasses = inner2;
        return solArr;
    }

    public static void main(String[] args) {

    }
}
