package implementation;

import java.util.Scanner;

public class GameDevelopment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();

        int[][] map = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = 1;
        int inPositionCount = 0;

        int x = a;
        int y = b;
        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, 1, 0, -1};

        map[x][y] = 1;

        while(true) {
            d -= 1;
            if (d < 0) d = 3;

            int newX = x + moveX[d];
            int newY = y + moveY[d];
            if (map[newX][newY] == 0) {
                inPositionCount = 0;
                result += 1;
                x = newX;
                y = newY;
                map[x][y] = 1;
            }

            if (map[newX][newY] == 1) {
                if (inPositionCount == 4) {
                    newX = x - moveX[d];
                    newY = y - moveY[d];
                    if (map[newX][newY] == 0) {
                        x = newX;
                        y = newY;
                    } else {
                        break;
                    }
                }
                inPositionCount += 1;
            }
        }
        System.out.println(result);


    }
}
