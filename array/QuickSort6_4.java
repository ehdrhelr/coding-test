package array;

public class QuickSort6_4 {
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return; // 원소가 1개인 경우 종료
        int pivot = start; // 피벗은 첫 번째 원소 (호어 분할)
        int left = start + 1; //왼쪽 시작 index 1
        int right = end; // 오른쪽 시작 index n - 1 (마지막 원소)
        while (left <= right) { 
            // 피벗보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && arr[left] <= arr[pivot]) left++;
            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while (right > start && arr[right] >= arr[pivot]) right--;
            // 엇갈렸다면 작은 데이터와 피벗을 교체
            if (left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
                // right는 피벗보다 작은 값을 찾고 left는 큰 값을 찾는다.
                // 이 둘이 엇갈렸다면 엇갈리기 전에는 그 값들을 찾지 못했다는 것
                // 그렇다면 right는 작은 값 left는 큰 값이 될 것이다.
            }
            // 엇갈리지 않았다면 작은 데이터와 큰 데이트를 교체
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    
    
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
