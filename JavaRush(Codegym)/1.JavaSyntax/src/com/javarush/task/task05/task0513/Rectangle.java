package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    //напишите тут ваш код
    int top;
    int left;
    int width;
    int height;

    public void initialize(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void initialize(int top,int left){
        this.top = top;
        this.left = left;
    }

    public void initialize(int left, int width, int height){
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public void initialize(Rectangle rectangle){
        Rectangle rect = new Rectangle();
        rect = rectangle;
    }

    public static void main(String[] args) {

    }
}
