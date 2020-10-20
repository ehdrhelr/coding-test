package array;

import java.util.*;

public class ChangeData6_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        

        Arrays.sort(a); // 배열 a를 작은 값부터 정렬
        Arrays.sort(b, Collections.reverseOrder()); //배열 b를 큰 값부터 정렬, b를 참조타입 배열로 만들어야한다.
        
        /* 단순히 이렇게 하면 a원소값이 더 클 경우에도 바뀌어서 문제가 생긴다. */
        // for (int i = 0; i < k; i++) {
        //     a[i] = b[i];
        // }
        
        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]) { // a원소값이 b원소값보다 작은 때만 바꾼다
                int temp = a[i];
                b[i] = a[i];
                b[i] = temp;
            } else break; // a원소가 b 원소보다 크거나 같을 경우 반복문 탈출
            // else 의 경우 더 이상 바꿔치기를 할 필요가 없다
            // a의 가장 작은 값이 b의 가장 큰 값보다 크면 이미 a는 최대값이다.
            // 최대 k번 가능하니 그 이하도 물론 가능한 것, 안바꿔도 된다.

        }


        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        System.out.println(sum);


        
    }

}