package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        FileReader fileReader = new FileReader("C://files/file.txt");
        fileReader.read();
    }

    public static void main(String[] args) throws Exception {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.veryComplexMethod();
    }
}
