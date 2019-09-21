package com.javarush.task.task25.task2515;

import javafx.scene.effect.Light;

public class Canvas {
    private int width;
    private int height;

    private char[][] matrix;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height][width];
    }
    public void setPoint(double x, double y, char c){
        int xRo = (int) Math.round(x);
        int yRo = (int) Math.round(y);

        if((xRo <0)||(yRo<0)||(yRo>=matrix.length)||(xRo>=matrix[0].length)){

        } else {
            matrix[yRo][xRo] = c;
        }

    }
    public void drawMatrix(double x, double y, int[][] matrix, char c){
        for(int i=0; i < matrix.length; i++){
            for(int j =0; j< matrix[0].length;j++){
                if(matrix[i][j] != 0){
                    this.setPoint(x+j,y+i,c);
                }
            }
        }

    }
}
