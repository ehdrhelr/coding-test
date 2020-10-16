package array;

public class SelectionSort6_1 {
    // r가장 작은 것을 선택해서 맨 앞으로 보낸다.
    public static void main(String[] args) {
        int n = 10; // 데이터의 개수
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
    
        for (int i = 0; i < n; i++) {
            int min_index = i; // 일단 가장 작은 원소의 인덱스를 0으로 설정
            for (int j = i + 1; j < n; j++) { // 그 다음 인덱스를 차례로 돌면서 원소가 제일 작은 인덱스를 찾아냄
                if (arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }

            // 스와프
            int temp = arr[i]; // 첫번째 원소의 인덱스를 가장 작은 원소를 가진 인덱스와 스와프
            arr[i] = arr[min_index];
            arr[min_index] = temp; 
            
            // 첫번째 인덱스에는 가장 작은 값이 들어간다. (for문 한바퀴 돔)
            // 두번째 인덱스부터 같은 과정 반복한다. (i == 1)
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
