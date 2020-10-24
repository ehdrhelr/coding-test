package binarySearch;

import java.util.*;

public class MakingRiceCake7_8 {
    //떡볶이 떡 만들기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 떡의 개수(N)와 요청한 떡의 길이(M)
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 각 떡의 개별 높이 정보
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = (int) 1e9; // 10억 이진탐색하며 자동적으로 조율된다.
        // 이진 탐색 수행 (반복적)
        int result = 0;
        while (start <= end) { 
            long total = 0; // 떡이 개당 10억까지니까 long으로 선언
            int mid = (start + end) / 2; // 중간점 설정 mid가 절단기 높이다.
            for (int i = 0; i < n; i++) {
                // 잘랐을 때의 떡의 양 계산
                if (arr[i] > mid) total += arr[i] - mid; // 떡 한줄의 길이에서 절단기(mid)를 빼고 반복문으로 떡 전체 수행하고 합치면 손님이 가져가는 떡길이 (total)
            }
            if (total < m) { // 떡의 양이 부족한 경우 더 많이 자르기 (왼쪽 부분 탐색)
                // 요청한 떡의 길이(m) 보다 가져갈 수 있는 떡의 길이(total)이 작으면 절단기가 너무 커서 그런다. 
                // 절단기 높이(mid)를 줄여서 다시 수행
                // 절단기 높이 바로 전 (mid - 1)를 끝점으로 잡고 다시 중간점 설정 ( mid = (start + end) / 2 )
                // 중간점이 확 떨어져서 건너뛰는 느낌이 들지만 이것이 이진 탐색
                end = mid - 1;
            }
            else {
                // 이 상태로 떡을 가져갈 수 있다.
                // 그러나 절단기 높이를 더 높여서 m에 근접할 수 있다.
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                start = mid + 1;
            }
        }
        System.out.println(result);

    }
}
