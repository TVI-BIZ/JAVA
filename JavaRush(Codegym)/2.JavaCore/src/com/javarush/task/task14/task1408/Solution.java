package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
//        System.out.println(hen.getDescription());
//        Hen hen2 = HenFactory.getHen(Country.MOLDOVA);
//        hen2.getCountOfEggsPerMonth();
//        System.out.println(hen2.getDescription());
//        Hen hen3 = HenFactory.getHen(Country.RUSSIA);
//        hen3.getCountOfEggsPerMonth();
//        System.out.println(hen3.getDescription());
//        Hen hen4 = HenFactory.getHen(Country.UKRAINE);
//        hen4.getCountOfEggsPerMonth();
//        System.out.println(hen4.getDescription());

    }

   public static class HenFactory {

       public static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            if(country.equals(Country.BELARUS)){
                hen = new BelarusianHen();
            }
            else if (country.equals(Country.MOLDOVA)){
                hen = new MoldovanHen();
            } else if (country.equals(Country.RUSSIA)){
                hen = new RussianHen();
            } else if (country.equals(Country.UKRAINE)){
                hen = new UkrainianHen();
            }

            return hen;
        }


    }
//    public static abstract class Hen{
//        public   abstract int getCountOfEggsPerMonth();
//
//        public static String getDescription(){
//            return "Я - курица.";
//        }
//    }

//    public static class RussianHen extends Hen{
//
//        public int getCountOfEggsPerMonth(){
//            return 25;
//        }
//        public String getDescription(){
//            return this.getDescription() + " Моя страна - Россия. Я несу 25 яиц в месяц.";
//        }
//
//
//        //<getDescription() родительского класса> + <" Моя страна - Sssss. Я несу N яиц в месяц.">
//    }
//    public static class UkrainianHen extends Hen{
//        public int getCountOfEggsPerMonth(){
//            return 26;
//        }
//        public String getDescription(){
//            return this.getDescription() + " Моя страна - Украина. Я несу 26 яиц в месяц.";
//        }
//
//    }
//    public static class MoldovanHen extends Hen{
//        public int getCountOfEggsPerMonth(){
//            return 27;
//        }
//        public String getDescription(){
//            return this.getDescription() + " Моя страна - Молдавия. Я несу 27 яиц в месяц.";
//
//        }
//
//    }

//    public static class BelarusianHen extends Hen{
//        public int getCountOfEggsPerMonth(){
//            return 28;
//        }
//        public String getDescription(){
//            return this.getDescription() + " Моя страна - Белоруссия. Я несу 28 яиц в месяц.";
//        }
//
//    }


}
