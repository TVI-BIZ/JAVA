package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public Snake (int x, int y){
     //SnakeSection head = new SnakeSection(x,y);
     //SnakeSection body = new SnakeSection(x+1,y);
     sections = new ArrayList<>();
     sections.add(new SnakeSection(x,y));
    // sections.add(body);
     isAlive = true;

    }

    public int getX(){
        return sections.get(0).getX();
    }

    public int getY(){
        return sections.get(0).getY();
    }


    public void move(){
        if(this.isAlive() == false){

        } else if(direction.equals(SnakeDirection.UP)){
            move(0,-1);
        }else if(direction.equals(SnakeDirection.RIGHT)){
            move(1,0);
        } else if(direction.equals(SnakeDirection.DOWN)){
            move(0,1);
        } else if(direction.equals(SnakeDirection.LEFT)){
            move(-1,0);
        }
    }
    public void move(int dx, int dy){
            SnakeSection currentSection = new SnakeSection(dx,dy);
            checkBorders(currentSection);
            checkBody(currentSection);
            SnakeSection head = new SnakeSection(sections.get(0).getX() + dx, sections.get(0).getY()+dy);



            if((Room.game.getMouse().getX() == head.getX())&&(Room.game.getMouse().getY()==head.getY())){
                Room.game.eatMouse();
                sections.add(0,head);
            }

            sections.add(0,head);
            sections.remove(sections.size()-1);
    }
    public void checkBorders(SnakeSection head){
        if((head.getX()>=Room.game.getWidth())||(head.getY()>=Room.game.getHeight())||(head.getX()<0)||head.getY()<0){
            isAlive = false;
        }
    }
    public void checkBody(SnakeSection head){
        if(this.sections.contains(head)) {
            isAlive = false;
        }
    }

}
