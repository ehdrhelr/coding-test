package dfs_bfs;

import java.util.*;

public class BFS5_9 {
    
    /* 숫자가 1부터 8까지 있고 index를 해당 숫자로 매치시키기 위에 index 0은 제외하고 1 - 8까지의 index를 사용 */
    public static boolean[] visited = new boolean[9]; 
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    // BFS 메소드 정의
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        // 현재 노드를 방문 처리
        visited[start] = true;
        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int x = q.poll();
            System.out.print(x + " ");
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 자바는 이렇게 일일히 추가를 해주어야하는가?
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);
        graph.get(2).add(8);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);
        
        bfs(1);
    }
}