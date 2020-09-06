package greedy;

import java.util.Scanner;

public class ToOne2 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// N, K를 공백을 기준으로 입력받기
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		while (true) {
			// N이 K로 나누어 떨어지는 수가 될때까지만 1씩 빼기
			int target = (n / k) * k;
			result += (n - target);
			n = target;
			
			// N이 K보다 작을 때 (더 이상 나누어 떨어지지 않을 때) 반복문 탈출
			if (n < k) break;
			
			n /= k;
			result += 1;
		}
		// 마지막으로 남은 수에 대하여 1씩 빼기. 왜 해주는지 모르겠다.
		result += (n - 1); 
		System.out.println(result);
	}
}
