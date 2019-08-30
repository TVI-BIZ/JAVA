package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();


    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");

    }

    public static void main(String[] args) {

    }



    public static class IncomeDataAdapter implements Customer,Contact  {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data){
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            String cpuntCode = this.data.getCountryCode();
            String countryName = "";
            for(Map.Entry<String,String> pair: countries.entrySet()){
                String key = pair.getKey();
                String value = pair.getValue();

                if(cpuntCode.equals(key)){
                    countryName = value;
                }

            }

            return countryName;
        }

        @Override
        public String getName() {
            String firstName = this.data.getContactFirstName();
            String lastName = this.data.getContactLastName();

            return lastName + ", " + firstName;
        }

        @Override
        public String getPhoneNumber() {

            String num = String.format("%010d", data.getPhoneNumber());

            return String.format("+%d(%.3s)%s-%s-%s", data.getCountryPhoneCode(),
                    num, num.substring(3, 6), num.substring(6, 8), num.substring(8, 10));
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}