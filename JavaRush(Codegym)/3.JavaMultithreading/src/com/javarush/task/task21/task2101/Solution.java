package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask)
    {
        String s1 = helper(ip);
        String s2 = helper(mask);

        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        char[] res = new char[cs1.length];

        for(int i=0; i < cs1.length; i++){


            if(Character.valueOf(cs1[i]).equals(Character.valueOf(cs2[i]))){
                if(Character.valueOf(cs1[i]).equals(Character.valueOf('1'))){
                    res[i] = '1';
                } else if(Character.valueOf(cs1[i]).equals(Character.valueOf('0'))){
                    res[i] = '0';
                }
            } else {
                res[i] = '0';
            }
        }


        int[] intArr = new int[4];

        String tempChar = new String(res);

        for(int i = 0; i< 4; i++){
            String line = tempChar.substring(i*8,i*8 + 8);
            int tempInt = Integer.parseInt(line,2);
            intArr[i] = tempInt;
        }

        byte[] resByte = new byte[4];

        for(int i=0; i < resByte.length; i++){
            resByte[i] = (byte) intArr[i];
        }
        return resByte;
        //return new byte[4];
    }

    public static void print(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for(int i = 0; i < Byte.SIZE * bytes.length; i++){
                sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0':'1');
        }
        String resString = sb.toString();
        resString = resString.substring(0,8)+ " " +
                    resString.substring(8,16)+ " " +
                    resString.substring(16,24)+" " +
                    resString.substring(24,32);
        System.out.println(resString);
    }
    public static String helper(byte[] bytes){
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for(int i = 0; i < Byte.SIZE * bytes.length; i++){
                sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0':'1');
        }
        return sb.toString();
    }

}
