package array;

public class InsertionSort6_3 {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        // 삽입 정렬은 두번째 데이터부터 시작
        // 첫번째는 그 자체로 정렬되어 있다고 판단
        for (int i = 1; i < n; i++) {
            // 인덱스 i부터 1까지 감소하며 반복하는 문법
            for (int j = i; j > 0; j--) {
                // 한 칸씩 왼쪽으로 이동
                if (arr[j] < arr[j - 1]) { // arr[1] < arr[0] 두번째 데이터가 첫번째 데이터 보다 작다면
                    // 스와프 
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    //arr[j]와 arr[j - 1] 바뀜
                    //다음 턴 arr[j - 1]인데 결국 기존데이터가 계속 기준이 됨
                }
                // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
                else break;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        // 정렬이 이루어진 원소는 항상 오름차순
    }
}
