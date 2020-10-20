package array;

import java.util.*;

public class TopToBottom6_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        /* 내 풀이 */
        Arrays.sort(arr);
        
        for (int i = n - 1 ; i >= 0; i--) {
            System.out.printf("%d ", arr[i]);
        }

        /* 책에서의 풀이 */
        // Arrays.sort(arr, Collections.reverseOrder()); //sort에서 에러
        
        // for (int i = 0; i < n; i++) {
        //     System.out.printf("%d ", arr[i]);
        // }
    }
}
