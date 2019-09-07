package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution1 = (Solution) o;

        if(o==null){
            return false;
        }
        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        //if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
        if(date != null){
            if(!date.equals(solution1.date)){
                return false;
            }
        }
        //if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return false;
        if(solution != null){
            if(!solution.equals(solution1.solution)){
                return false;
            }
        }
        //if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;
        if(string != null){
            if(!string.equals(solution1.string)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt, string, aDouble, date, solution);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution(5, "Mouse",5.5,null,null));
        System.out.println(s.contains(new Solution(5, "Mouse",5.5,null,null)));
        s.add(new Solution(0, null,0.0,null,null));
        System.out.println(s.contains(new Solution(0, null,0.0,null,null)));
    }
}
