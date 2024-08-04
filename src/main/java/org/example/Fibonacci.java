package org.example;

/**
 * Example for TDD
 *
 * @author Vinod John
 * @Date 04.08.2024
 */
public class Fibonacci {
    public static int getValue(int num) {
         // int result = 0;

        if (num == 0 || num == 1) {
            return num;
        }

//        if (num > 1) {
//            int position1 = 0;
//            int position2 = 1;
//
//            for (int i = 2; i <= num; i++) {
//                result = position1 + position2;
//                position1 = position2;
//                position2 = result;
//            }
//        }
//
//        return result;

        return getValue(num - 2) + getValue(num - 1);
    }
}
