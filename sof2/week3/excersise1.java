package week3;

import java.util.Scanner;
import java.lang.Math;
public class excersise1 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println(toBase10(kb.nextLine()));
        kb.close();
    }

    public static String toBase10(String binary) {
        return Integer.toString(Integer.parseInt(binary, 2));
    }
}