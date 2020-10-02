package implementation;

import java.util.*;

public class GameDevelopment {

    public static int n, m, x, y, direction;
    // 방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
    public static int[][] d = new int[50][50];
    // 전체 맵 정보
    public static int[][] arr = new int[50][50];

    /* 북, 동, 남, 서 방향 정의
        북쪽 : 0, 동쪽 : 1, 남쪽 : 2, 서쪽 : 3 이기 때문에 
        캐릭터가 북쪽으로 이동하려면 (-1, 0), 동 (0 ,1), 남(1, 0), 서 (0, -1)을
        현재 포지션에 더해주면 된다. -> line 52
    */
    public static int dx[] = {-1, 0, 1, 0}; 
    public static int dy[] = { 0, 1, 0,-1};

    // 왼쪽으로 회전
    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M을 공백을 기준으로 구분하여 입력받기
        n = sc.nextInt();
        m = sc.nextInt();

        // 현재 캐릭터의 X 좌표, Y 좌표, 방향을 입력받기
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        d[x][y] = 1; // 현재 좌표 방문 처리

        // 전체 맵 정보를 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 시뮬레이션 시작
        int cnt = 1;
        int turn_time = 0;
        while (true) {
            // 왼쪽으로 회전
            turn_left();
            int nx = x + dx[direction]; // nx, ny는 캐릭터가 회전한 후 이동하게 될 새로운 좌표
            int ny = y + dx[direction];
            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if (d[nx][ny] == 0 && arr[nx][ny] == 0) { // d[nx][ny]는 가봤느냐(1) 안가봤느냐(0)
                d[nx][ny] = 1;                        // arr[nx][ny]는 육지냐(0) 바다냐(1) -> line 40
                x = nx;                               // 안가본 곳이면 방문처리 d[nx][dy] = 1 하고
                y = ny;                               // 캐릭터 뉴 포지션 x = nx;, y = ny;
                cnt += 1;                             // 가본 곳의 갯수 추가 +1
                turn_time = 0;                        // turn_time은 필요한가???? line 66에서 4방향 모두 갈 수 없는 경우에 대비해 필요하다.
                continue;                             // 다시 while문으로 continue
            }
            // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else turn_time += 1; // 한번 더 돌린다.
            // 네 방향 모두 갈 수 없는 경우
            if (turn_time == 4) { // 4번 돌았는데 아무대도 갈 수 없다.
                nx = x - dx[direction]; // 뒤로 갈 위치 저장
                ny = y - dy[direction];
                // 뒤로 갈 수 있다면 이동하기
                if (arr[nx][ny] == 0) { // 뒤에 육지가 있으면
                    x = nx;
                    y = ny;
                }
                // 뒤가 바다로 막혀있는 경우
                else break;
                turn_time=0; // 1턴 후에 다시 초기화
            }
        }
        System.out.println(cnt);
    }   

}