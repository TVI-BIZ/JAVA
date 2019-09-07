package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        //return n.first.equals(first) && n.last.equals(last);

        return Objects.equals(first, n.first) &&
                Objects.equals(last, n.last);
    }
    public int hashCode() {
        return Objects.hash(first, last);
    }


    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
        s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution(null, null)));
    }
}
