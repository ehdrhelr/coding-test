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

////// 나의 풀이 //////

import java.util.*;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 배열의 크기
    int m = sc.nextInt(); // 숫자가 더해지는 횟수
    int k = sc.nextInt(); // 같은 숫자를 연속으로 더할 수 있는 최대 횟수

    int result = 0; // 가장 큰 결과를 담는다.
    int[] numbers = new int[n]; // n크기의 숫자를 담을 배열

    for (int i = 0; i < n; i++) {
      numbers[i] = sc.nextInt();
    }

    Arrays.sort(numbers); // 입력된 배열을 정렬한다 ASCENDING
    int first = numbers[n - 1]; // 가장 큰 값은 마지막 index가 되겠지 index는 0 ~ n-1
    int second = numbers[n - 2]; // 두번째로 큰 값

    int count = 0; // 최대값이 더해지는 횟수
    count += (m / (k + 1)) * k; // 사이클이 성립하는 동안 first 가 더해지는 횟수
    count += m % (k + 1); // 사이클이 성립하지 않는 동안 first가 더해지는 횟수 

    result += count * first; // 최대값이 가능한 횟수만큼 더해진다.
    result += (m - count) * second; // 두번째로 큰 값이 가능한 횟수만큼 더해진다.

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
  
  /////// 추가 ///////
  
  입력 값이 너무 커지면 너무 커진다면 하나씩 줄여나가는 것은 부담이 될 수 있다.

  1. first는 k번 더해지고 second는 1번 더해진다.
    한 사이클에서 k + 1이 소모된다.
  2. 정상적인 사이클이 적용될 때 m / (k + 1) 번의 사이클이 있다.
  3. first는 한 사이클에서 k번 더해지니, m이 사이클로 나눠지는 동안에는 
    first가 (m / (k + 1)) * k 번 더해진다.
  4. m이 k + 1 보다 작아져서 사이클을 돌릴 수 없을 때는 
    남은 m만큼 k를 더해주면 된다.
  5. second는 m에서 first를 뺀만큼 더해주면 된다.

*/
