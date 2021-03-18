package chapter12_implementation;

import java.util.Scanner;

public class LuckyStrate1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        int half = input.length() / 2;
        String fore = input.substring(0, half);
        String aft = input.substring(half);

        String[] foreArr = fore.split("");
        String[] aftArr = aft.split("");

        int first = 0;
        int second = 0;
        for (String s : foreArr) {
            first += Integer.parseInt(s);
        }
        for (String s : aftArr) {
            second += Integer.parseInt(s);
        }
        if (first == second) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}


/* 책의 풀이
public class Main {

    public static String str;
    public static int summary = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        // 왼쪽 부분의 자릿수의 합 더하기
        for (int i = 0; i < str.length() / 2; i++) {
            summary += str.charAt(i) - '0';
        }

        // 오른쪽 부분의 자릿수의 합 빼기
        for (int i = str.length() / 2; i < str.length(); i++) {
            summary -= str.charAt(i) - '0';
        }

        // 왼쪽 부분과 오른쪽 부분의 자릿수 합이 동일한지 검사
        if (summary == 0) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
 */
