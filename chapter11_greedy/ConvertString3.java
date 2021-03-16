package chapter11_practice.greedy;

import java.util.*;

public class ConvertString3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int count0 = 0;
        int count1 = 0;

        String[] inputArr = input.split("");

        if ("1".equals(inputArr[0])) {
            count0 += 1;
        } else {
            count1 += 1;
        }

        for (int i = 0; i < inputArr.length - 1; i++) {
            if (!inputArr[i].equals(inputArr[i + 1])) {
                if ("1".equals(inputArr[i + 1])) {
                    count0 += 1;
                } else {
                    count1 += 1;
                }
            }
        }
        System.out.println(Math.min(count0, count1));
    }
}
