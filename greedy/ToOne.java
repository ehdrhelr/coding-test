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

////// 나의 풀이 //////

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 1로 만들 숫자.
    int k = sc.nextInt(); // n을 나눌 숫자(나눠지면)

    int result = 0; // 몇번만에 n을 1로 만들었는지 count

    boolean flag = true; // 밑에 while 문에 쓸 것

    while(flag) {
      if (n % k == 0) { // n이 k로 나눠지면
        n /= k;
        result += 1;
      } else if (n % k != 0) { // n이 k로 안나눠지면
        n -= 1;
        result += 1;
      }
      if (n == 1) break; // n이 1이 되면 break
    }

    /* 책에서의 풀이 
    결과에 차이가 있는지는 모르겠으나 더 느낌있는 코드다.
    while (n >= k) {
      while (n % k != 0) {
        n -= 1;
        result += 1;
      }

      n /= k;
      result += 1;
    }

    while (n < 1) {
      n -= 1;
      result += 1;
    }
    */ 
    System.out.println(result);
  }
}


/* 어떠한 수 n이 1이 될 때까지 다음 연산을 수행.
   1. n에서 1을 뺀다.
   2. n을 k로 나눈다.
   n과 k가 주어질 때 1번 혹은 2번 과정이 수행되어지는 최소 횟수는?

   1. n과 k를 입력받는다.
   2. n이 k로 나눠지는가? 
      yes - 2번
      no - 1번
   3. 2번 과정 반복하면 끝?
 */
