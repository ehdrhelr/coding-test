package greedy;

public class Change {
	
	public static void main(String args[]) {
		int n = 1260;
		int count = 0;
		int[] coinTypes = {500, 100, 50, 10}; // 큰 단위의 화폐부터 차례대로 확인
		
		for (int i = 0; i < coinTypes.length; i++) {
			int coin = coinTypes[i];
			count = count + n/coin; // 해당 화폐로 거슬러 줄 수 있는 동전의 개수 세기
			n %= coin;			
		}
		
		System.out.println(count);
	}
}

/////////// 나의 풀이 ///////////	

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // 거슬러줘야할 돈
    int result = 0; // 거슬러 줘야할 동전의 갯수
    int[] coins = {500, 100, 50, 10}; // 동전 종류를 담은 배열

    for (int coin : coins) {
      result += n / coin; // n을 coin으로 나누면 몫이 동전 갯수가 됨
      n %= coin; // 나머지는 다시 거슬러줘야할 남은 돈이 됨
    }

    System.out.println(result);
  }
}

/* 500, 100, 50, 10 으로 
   n 원을 거슬러 준다.
   거슬러 줘야할 동전의 갯수는?

  1. n원을 입력 받는다.
  2. 동전이 담겨 있는 배열을 생성한다.
  3. 큰 동전으로 나눈 몫을 result에 추가하고 
    나머지를 다시 다음으로 큰 동전으로 나눈다.
  4. 3을 반복한다.
*/
