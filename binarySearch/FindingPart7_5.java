package binarySearch;

import java.util.*;

public class FindingPart7_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] store = new int[n];

        for (int i = 0; i < store.length; i++) {
            store[i] = sc.nextInt();
        }

        Arrays.sort(store); // 정렬되어 있다면 더 빠르게 찾을 수 있다.

        int m = sc.nextInt();
        int[] request = new int[m];
        
        for (int i = 0; i < request.length; i++) {
            request[i] = sc.nextInt();
        }

        for (int i = 0; i < request.length; i++) {
            int result = binarySearch(store, request[i], 0, store.length - 1);
            if (result != -1) System.out.printf("%s ", "yes"); 
            else System.out.printf("%s ", "no");
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        else return binarySearch(arr, target, mid + 1, end);
    }
}
