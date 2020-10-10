package dfs_bfs;

import java.util.Scanner;

public class FreezingJuice5_10 {

    public static int n, m; // 가로 n, 세로 m
    public static int[][] graph = new int[1000][1000]; // 1 <= n, m <=1,000
    
    // DFS로 특정 노드를 방문하고 연결된 모든 노드들도 방문
    public static boolean dfs(int x, int y) {
        // 주어진 범위를 벗어나는 경우, 즉시 종료
        if (x <= -1 || x >= n || y <= -1 || y >= m) {
            return false;
        }

        // 현재 노드를 아직 방문하지 않았다면
        if (graph[x][y] == 0) {
            // 해당 노드 방문 처리
            graph[x][y] = 1;
            /* 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
               특정위치의 상하좌우, 그 상하좌우들의 상하좌우들을 계속 방문
               계속 방문하다보면 방문하지 않은 곳을 모두 방문하고 방문 처리 후 true 반환
               -> 음료수 얼음 1개
             */
            dfs(x - 1, y); // 상
            dfs(x + 1, y); // 하
            dfs(x, y - 1); // 좌
            dfs(x, y + 1); // 우
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // n, m을 공백을 기준으로 구분하여 입력
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // 모든 노드(위치)에 대하여 음료수 채우기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재 위치에서 DFS 수행
                if(dfs(i, j)) {
                    result += 1;
                }
            }
        }
        System.out.println(result); // 정답 출력
    }

}
