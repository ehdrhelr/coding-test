package greedy;

import java.util.Scanner;

public class ToOne {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// N, K를 공백을 기준으로 입력받기
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		// N이 K 이상이라면 K로 계속 나누기
		while (n >= k) {
			// N이 K로 나누어 떨어지지 않는다면 N에서 1씩 빼기
			while (n % k != 0) {
				n -= 1;
				result += 1;
			}
			// k로 나누기
			n /= k;
			result += 1;
		}
		
		// 마지막으로 남은 수에 대하여 1씩 빼기
		while (n > 1) {
			n -= 1;
			result += 1;
		}
		
		System.out.println(result);
	}

}
