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

////// 나의 풀이 //////

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 1로 만들 숫자.
    int k = sc.nextInt(); // n을 나눌 숫자(나눠지면)

    int result = 0; // 몇번만에 n을 1로 만들었는지 count

    boolean flag = true; // 밑에 while 문에 쓸 것

    while (flag) {
      int target = (n / k) * k; // target은 n을 k로 나눠지는 숫자로 만드는 것
      result += n - target; // 1씩 빼는 횟수를 한번에 처리
      n = target; // target은 새로운 n이 되어 다음 연산을 수행.

      if (n < k) break; // n이 k보다 작아지면 안나눠지니까 그만하자.

      n /= k; // 이제 k로 나눌 수 있다.
      result += 1; // 연산한번 했으니 1 추가.
    }
    // n이 k보다 작아지면 n - 1번 만큼 1을 빼주면 n이 1이 되겠지.
    result += n - 1;
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

   ///// 추가 //////

   n의 범위가 작을 때는 일일이 1씩 빼도 괜찮은데 범위가 엄청 커진다면?
   n이 k의 배수가 되도록 효율적으로 한번에 빼는 것이 좋겠다.

   1. target을 설정한다. n / k 의 몫
   2. n % k의 나머지만큼 result에 추가.
   3. target은 새로운 n이 된다.

 */
