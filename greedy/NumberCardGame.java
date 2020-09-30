package greedy;

import java.util.Scanner;

public class NumberCardGame {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		// N, M을 공백을 기준으로 입력받기
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = 0;
		
		// 한 줄씩 입력받아 확인하기
		for (int i = 0; i < n; i++) {
			//현재 줄에서 '가장 작은 수' 찾기
			int min_value = 10001;
			for (int j = 0; j < m; j++) {
				int x = sc.nextInt();
				min_value = Math.min(min_value, x);
			}
			// '가장 작은 수'들 중에서 가장 큰 수 찾기
			result = Math.max(result, min_value);
		}
		
		System.out.println(result); // 최종 답안 출력
	}
}

// 2중 반복문 구조와 min(), max() 메소드를 이용하여 해결

////// 나의 풀이 //////

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // row의 개수
    int m = sc.nextInt(); // 열의 개수

    // 굳이 배열은 안 만들어줘도 괜찮은 것 같다?
    /* 여기에서 초기화 해주면 이전의 행의 작업 결과가 다음 행의 작업에도 영향을 미친다.
    int min_value = 10_001; // 각 숫자는 1이상 10,000이하의 자연수이기 때문에
    */
    int result = 0; // 각 행의 최솟값 중 최대값을 저장할 변수

    for (int i = 0; i < n; i++) { // row의 크기만큼 돌린다.
      int min_value = 10_001; // 최소값은 각 행마다 독립적으로 판단되기 때문에 한 행의 사이클마다 min_value를 초기화해준다.
      for(int j = 0; j < m; j++) { // 열의 개수만큼 숫자 입력받는다.
        // 입력된 값과 min_value를 비교하여 최소값을 찾아낸다.
        min_value = Math.min(min_value, sc.nextInt());
      }
      result = Math.max(result, min_value); // 한 행에 대한 최소값 찾기가 끝났을 때 기존의 최대값과 비교하여 더 큰 값을 result에 담아준다.
    }

    System.out.println(result);
  }
}


/* row의 개수 n, column의 개수 m을 입력받는다.
   각 행에서 가장 작을 수를 뽑는다.
   이렇게 했을 때 가장 큰 수를 뽑으려면?
   배열중에서 가장 작은 수가 다른 row중에서 가장 큰 값을 가지는 행을 선택하고 그 값을 취한다.

   1. n, m을 받아와서 숫자를 계속 입력한다.
   2. 한 사이클(한 row)를 입력해서 가장 작은 값을 min_value에 넣는다.
    가장 작은 값이라고 min_value를 0으로 초기화하면 어느 입력값과 비교해도 결과는 계속 0이 될 것이다.
    그러니 주어진 숫자보다 1 큰 값으로 초기화하여 어느 입력값이 와도 바뀔 수 있도록 하자.
   3. 그 다음 result(초기값 0)과 비교하여 큰 수를 다시 result에 넣는다.
   4. 2-3과정을 반복한다.
   5. 이때 min_value를 전역변수로 초기화하게 되면 한 row가 끝나고 다음 row에서도 이전 row의 min_value가 적용되어 결과값이 제대로 나오지 않는다.
   그래서 한 row가 끝나면 다시 min_value를 초기화할 수 있도록 지역변수로 선언해준다.

*/
