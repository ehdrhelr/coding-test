package dynamic_programming;

import java.util.Scanner;

public class AntWarrior8_6 {
    
    public static int[] d = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 식량 창고 갯수 N입력
        int n = sc.nextInt();

        // 모든 식량 정보 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        d[0] = arr[0]; // 식량 창고가 1개만 있다고 가정하면, 첫번째 식량 창고를 선택하면 그 값이 최종 결과가 된다.
        d[1] = Math.max(arr[0], arr[1]); // 식량 창고가 2개만 있다고 가정하면, 2개중 큰 값이 최종결과가 된다.(인접한 식량창고 공격X)

        // i번째 식량 창고까지 최종 결과를 구하려면, (i - 1번째 값)과, (i - 2번째 값 + i번째 값) 중 최대값을 구하면된다.
        // i - 1번째와 i - 2번째는 이미 최대값을 최적화가 되어있기 때문이다.
        for (int i = 2; i > n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }

        System.out.println(d[n - 1]);
    }
}
