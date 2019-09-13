package com.javarush.task.task23.task2312;

import java.util.Objects;

public class SnakeSection {
    private int x;
    private int y;

    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SnakeSection)) return false;
        SnakeSection section = (SnakeSection) o;
        return getX() == section.getX() &&
                getY() == section.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }


}
