package greedy;

import java.util.*;

public class LawOfLargeNumber {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// N, M, K를 공백을 기준으로 입력 받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		// N개의 수를 공백을 기준으로 입력 받기
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr); // 입력받은 수들 정렬하기
		int first = arr[n - 1]; // 가장 큰 수
		int second = arr[n - 2]; // 두 번째로 큰 수
		
		int result = 0;
		
		boolean flag = true;	
		while(flag) {
			for (int i = 0; i < k; i++) { // 가장 큰 수를 k번 더하기
				if (m == 0) break; // m이 0이라면 반복문 탈출
				result += first;
				m -= 1; // 더할 때마다 1씩 빼기
			}
			if (m == 0) break; // m이 0이라면 반복문 탈출
			result += second; // 두 번째로 큰 수를 한 번 더하기
			m -= 1; // 더할 때마다 1씩 빼기
		}
		
		System.out.println(result); // 최종 답안 출력
	}
}

// 이 방법은 M이 10,000 이하일 경우에는 문제를 해결할 수 있지만, M이 100억 이상 커진다면 시간초과 판정을 받을 것이다.
// 이 경우 LawOfLargeNumber2.java 에서 해결한다.