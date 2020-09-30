package implementation;

import java.util.*;

public class UpDownLeftRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n을 입력 받기
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        // 계획표 얻기
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1; // 초기 위치 (1, 1)

        // L R U D에 따른 위치 이동
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = dx[j] + x;
                    ny = dy[j] + y; 
                    
                }
            }
            
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            x = nx;
            y = ny;
        }
        
        System.out.println(x + " " + y);
    }
}


/** 계획서의 L, R, U, D를 담는 문자 배열을 생성한다.
 * L, R, U, D마다 움직이는 좌표의 추가 값을 배열로 만든다.
 * 입력된 값만큼 반복문을 돌리면서 좌표를 갱신한다.
 * 좌표값은 (1, 1)로 시작하고, 1 미만이거나 n을 초과할 수 없다.
 * 
*/

