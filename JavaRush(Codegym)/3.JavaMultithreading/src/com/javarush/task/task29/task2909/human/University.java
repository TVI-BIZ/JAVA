package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String name;
    int age;



    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

   private List<Student> students = new ArrayList<>();



    public University(String name, int age) {
        super();
    }

    public Student getStudentWithAverageGrade(double score) {
        Student newStudent = getStudents().get(0);
        for(Student elem:getStudents()){
            if(elem.getAverageGrade() == score){
                newStudent = elem;
            }
        }
        return newStudent;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student newStudent = getStudents().get(0);
        for(Student elem:getStudents()){
            if(elem.getAverageGrade()>newStudent.getAverageGrade()){
                newStudent = elem;
            }
        }
        return newStudent;
    }

    public Student getStudentWithMinAverageGrade(){
        Student newStudent = getStudents().get(0);
        for(Student elem:getStudents()){
            if(elem.getAverageGrade()<newStudent.getAverageGrade()){
                newStudent = elem;
            }
        }
        return newStudent;
    }

    public void expel(Student student){
        students.remove(student);
    }

}