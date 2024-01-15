package com.steve.combat;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: STEVE
 * @Description:
 * @since: 2024/1/12
 */
public class Solution {

    public static void main(String[] args) {
//        String s = "III";
//        int i = romanToInt(s);
//        System.out.println(i);
        int num = 3;
        String s = intToRoman(3);
        System.out.println(s);
    }

    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        char[] chars = s.toCharArray();
        if(chars.length == 1) {
            return map.get(chars[0]);
        }
        int i = 0;
        for(; i < chars.length - 1; i++) {
            if(chars[i] == 'I' && chars[i + 1] == 'V') {
                res += 4;
                i += 1;
                continue;
            }
            if(chars[i] == 'I' && chars[i + 1] == 'X') {
                res += 9;
                i += 1;
                continue;
            }
            if(chars[i] == 'X' && chars[i + 1] == 'L') {
                res += 40;
                i += 1;
                continue;
            }
            if(chars[i] == 'X' && chars[i + 1] == 'C') {
                res += 90;
                i += 1;
                continue;
            }
            if(chars[i] == 'C' && chars[i + 1] == 'D') {
                res += 400;
                i += 1;
                continue;
            }
            if(chars[i] == 'C' && chars[i + 1] == 'M') {
                res += 900;
                i += 1;
                continue;
            }
            res += map.get(chars[i]);
        }
        if(i == chars.length - 1) {
            res += map.get(chars[i]);
        }
        return res;
    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while(num >= value) {
                num -= value;
                sb.append(symbol);
            }
            if(num == 0) {
                break;
            }
        }
        return sb.toString();
    }

}
