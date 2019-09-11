package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface  {
        TableInterface tableInterface;

        @Override
        public void setModel(List rows) {
            this.tableInterface.setModel(rows);
            System.out.println(rows.size());
        }

        @Override
        public String getHeaderText() {

            return tableInterface.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            this.tableInterface.setHeaderText(newHeaderText);
        }

        public TableInterfaceWrapper(TableInterface tableInterface){
            this.tableInterface = tableInterface;
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}