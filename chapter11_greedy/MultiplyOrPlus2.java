package chapter11_greedy;

import java.util.*;

public class MultiplyOrPlus2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArr = input.split("");
        int[] numbers = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            numbers[i] = Integer.parseInt(inputArr[i]);
        }
        System.out.println(Arrays.toString(numbers));

        int first = numbers[0];
        int second = numbers[1];
        int max = Math.max(first + second, first * second);
        for (int i = 2; i < numbers.length; i++) {
            max = Math.max(max + numbers[i], max * numbers[i]);
        }
        System.out.println(max);
    }
}

/* 책의 풀이
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        // 첫 번째 문자를 숫자로 변경한 값을 대입
        long result = str.charAt(0) - '0';

        for (int i = 1; i < str.length(); i++) {
            // 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
            int num = str.charAt(i) - '0';
            if (num <= 1 || result <= 1) {
                result += num;
            }
            else {
                result *= num;
            }
        }

        System.out.println(result);
    }
}
*/
