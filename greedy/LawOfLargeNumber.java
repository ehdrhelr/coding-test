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

////////// 나의 풀이 //////////

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 배열의 크기
    int m = sc.nextInt(); // 숫자가 더해지는 횟수
    int k = sc.nextInt(); // 같은 숫자를 연속으로 더할 수 있는 최대 횟수

    int result = 0; // 가장 큰 결과를 담는다.
    int[] numbers = new int[n]; // n크기의 숫자를 담을 배열

    /* inhanced for문을 쓰면 result가 0으로 나온다. 
       초기화가 안되어 있어서 그런것 같다.
    for (int number : numbers) { // 배열의 크기(n)의 횟수만큼 숫자입력
      number = sc.nextInt();
    }
    */
    
    for (int i = 0; i < n; i++) {
      numbers[i] = sc.nextInt();
    }

    Arrays.sort(numbers); // 입력된 배열을 정렬한다 ASCENDING
    int first = numbers[n - 1]; // 가장 큰 값은 마지막 index가 되겠지 index는 0 ~ n-1
    int second = numbers[n - 2]; // 두번째로 큰 값

    boolean flag = true; // 밑에 while문 용

    while(flag) {
      for (int i = 0; i < k; i++) {
        result += first; // 가장 큰 수가 k번 더해진다.
        m--; // m은 k만큼 줄어든다.
        if (m == 0) break; // m이 0 되면 반복문 나간다.
      }
      result += second; // 두번째로 큰 수 1번 더해준다.
      m--; // 1번 더해줬으니까 m도 줄인다.
      if (m == 0) break; // 다시 m이 0 되면 반복문을 나간다.
    }

    System.out.println(result);
  }
}

/* n개의 자연수가 주어진다.
   n개의 각 자연수 중 m번 더하여 가장 큰 값을 추출한다.
   같은 값을 연속으로 더할 수 있는 최대 횟수는 k번이다.

  1. n, m, k를 입력받고, for문으로 n번 입력받아 배열에 저장한다.
    배열의 크기 = n
  2. 배열을 작은 수부터 정렬하면 마지막 index(n-1)의 값은 가장 큰 값(first)
     마지막에서 두번째 index(n-2)의 값은 두번째로 큰 값이 된다.(second)
  3. first값은 k번, second값은 1번 더해준다.
  4. m이 k보다 작아지면 남은 횟수는 first 값만 더해준다.
*/
