package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node2 {
    private int index;
    private int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class MazeEscape5_11 {
    public static int n, m; // 가로 n, 세로 m
    public static int[][] graph = new int[201][201]; // 4 <= n,m < 200
    // index 0은 제외하고 (1,1) ~ (n,m)까지가 아니라 graph[0][0]을 시작위치 (1, 1)로 보는 것 같다.

    // 이동할 네 가지 방향 정의   (상, 하, 좌, 우) 
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = { 0, 0,-1, 1};

    public static int bfs(int x, int y) {
        // 큐(Queue) 구현을 위해 queue라이브러리 사용
        Queue<Node2> q = new LinkedList<>();
        q.offer(new Node2(x,y)); // 인덱스와 거리를 넣는다. 처음엔 (0,0)
        // 큐가 빌 때까지 반복하기
        while (!q.isEmpty()) {
            Node2 node = q.poll();
            x = node.getIndex();
            y = node.getDistance();
            // 현재 위치에서 4가지 방향으로의 위치 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 미로 찾기 공간을 벗어난 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽인 경우 무시? -> 괴물이 있는 경우 무시
                if (graph[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node2(nx, ny));
                }
            }
        }
        // 가장 오른쪽 아래까지의 최단 거리 반환
        return graph[n - 1][m - 1]; // 시작 위치(1,1) 은 graph[0][0]이고 가장 오른쪽 아래는 graph[n - 1][m - 1]
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n, m을 공백을 기준으로 구분하여 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();

        sc.nextLine(); // 버퍼 지우기

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // BFS를 수행한 결과 출력
        System.out.println(bfs(0, 0));
    }

    /* 이 소스 코드 상에서는 첫 번째 시작 위치는 다시 방문할 수 있도록 되어 
        첫 번째 시작 위치에 해당하는 값이 변경될 여지가 있지만, 본 문제는 단순히 가장 오른쪽 아래 위치로 이동하는 것을
        요구하고 있기 때문에, 첫 번째 시작위치가 변경되어도 의미가 없으며 정상적으로 답을 도출할 수 있다.
        -> 첫 번째뿐만 아니라 상하좌우로 모두 다시 방문할 수 있기 때문에 다른 값도 계속 변경될 수 있다.
           그래도 답을 찾는데는 문제가 없다?
    */
}
