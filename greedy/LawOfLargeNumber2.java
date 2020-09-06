package greedy;

import java.util.*;

public class LawOfLargeNumber2 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// N, M, K를 공백으로 구분하여 입력 받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		// N개의 수를 공백으로 구분하여 입력 받기
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) { 
			arr[i] = sc.nextInt();	
		}
		
		Arrays.sort(arr); // 입력 받은 수 정렬
		int first = arr[n - 1]; // 가장 큰 수
		int second = arr[n - 2]; // 두 번째로 큰 수
		
		int count = 0;
		int result = 0;
		
		// 가장 큰 수가 더해지는 횟수 계산
		count += (m / (k + 1)) * k;
		count += m % (k + 1);
		
		result += count * first; // 가장 큰 수 더하기
		result += (m-count) * second; // 두 번째로 큰 수 더하기
		
		System.out.println(result); // 최종 답안 출력

	}
}
