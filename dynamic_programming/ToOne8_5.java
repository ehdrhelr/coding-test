package dynamic_programming;

import java.util.Scanner;

public class ToOne8_5 {
    
    public static int[] d = new int[30_001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1로 만들고자 하는 수 x
        int x = sc.nextInt(); 
        
        // i가 1일 경우 1로 만들 수 있는 경우는 그대로 0이니까 d[1] = 0;
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우, 왜 1을 더해주는 것일까.
            d[i] = d[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1); // 위의 1로 뺀 경우(d[i])와 2로 나눈 경우(d[i / 2] + 1) 중 작은 값을 구한다.
            }
            // 현재의 수가 3으로 나누어 떨어지는 경우, 2보다 3으로 나누었을 때 더 값이 작아지므로 2 아래에 3을 두어 값을 줄인다.
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1); // 위에서 정해진 경우와 3으로 나눈 경우 중 작은 값을 구한다.
            }
            // 현재의 수가 5로 나누어 떨어지는 경우, 5로 나누는 경우가 값이 가장 크게 작아지므로 가장 아래에 두었다.
            if (i % 5 == 0) {
                d[i] = Math.min(d[i], d[i / 5] + 1); // 위에서 정해진 경우와 5로 나눈 경우 중 작은 값을 구한다.
            }
        }
        
        System.out.println(d[x]);
    }
}
