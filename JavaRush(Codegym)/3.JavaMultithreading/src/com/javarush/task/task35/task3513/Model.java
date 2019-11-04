package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score;
    protected int maxTile;

    public Model() {

        resetGameTiles();
    }

    private List<Tile> getEmptyTiles(){
        List<Tile> tileList = new ArrayList<>();
        for(Tile[] elem:gameTiles){
            for(int i=0; i < FIELD_WIDTH; i++){
                if(elem[i].isEmpty()){
                    tileList.add(elem[i]);
                }
            }
        }
        return tileList;
    }
    private void addTile(){
        if(!getEmptyTiles().isEmpty()){
            getEmptyTiles().get((int)(getEmptyTiles().size()*Math.random())).value = (Math.random() < 0.9 ? 2 : 4);
        }
    }
    protected void resetGameTiles(){
        score = 0;
        maxTile = 0;
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for(int i=0;i<FIELD_WIDTH;i++){
            for(int j=0;j<FIELD_WIDTH;j++){
                gameTiles[j][i]=new Tile();
            }
        }
        addTile();
        addTile();
    }
    private boolean compressTiles(Tile[] tiles){
//        Tile[] oldTile = tiles;
////        Arrays.sort(tiles, Comparator.comparing(Tile::isEmpty));
////        Tile[] newTile = tiles;
////
////        if(Arrays.equals(oldTile,newTile)){
////            return true;
////        } else {
////            return false;
////        }
        boolean isChanged = false;
        Tile temp;
        for (int i = 0; i < FIELD_WIDTH-1; i++) {
            for (int j = 0; j < FIELD_WIDTH-1; j++) {
                if (tiles[j].value == 0 && tiles[j + 1].value != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean flag = false;
        for(int i=0; i < FIELD_WIDTH-1;i++){
            if(tiles[i].value==tiles[i+1].value){
                if(tiles[i].value!=0){
                    flag = true;
                }
                tiles[i].value = tiles[i].value*2;
                tiles[i+1].value = 0;
                if(tiles[i].value> maxTile){
                    maxTile = tiles[i].value;
                }
                score += tiles[i].value;
            }
        }
        compressTiles(tiles);
        return flag;
    }
    public void left(){
        boolean changed = false;
        for(int i=0; i<FIELD_WIDTH;i++){
            if(compressTiles(gameTiles[i])||mergeTiles(gameTiles[i])){
               changed = true;
            }
        }
        if(changed){
            addTile();
        }
    }
    public void right(){
        boolean changed = false;
        for(int i=FIELD_WIDTH-1; i<1;i--){
            if(compressTiles(gameTiles[i])||mergeTiles(gameTiles[i])){
                changed = true;
            }
        }
        if(changed){
            addTile();
        }
    }

    public void up(){

    }
    public void down(){

    }



}
