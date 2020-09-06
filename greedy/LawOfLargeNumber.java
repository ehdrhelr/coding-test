package greedy;

import java.util.*;

public class LawOfLargeNumber {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// N, M, K�� ������ �������� �Է� �ޱ�
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		// N���� ���� ������ �������� �Է� �ޱ�
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr); // �Է¹��� ���� �����ϱ�
		int first = arr[n - 1]; // ���� ū ��
		int second = arr[n - 2]; // �� ��°�� ū ��
		
		int result = 0;
		
		boolean flag = true;	
		while(flag) {
			for (int i = 0; i < k; i++) { // ���� ū ���� k�� ���ϱ�
				if (m == 0) break; // m�� 0�̶�� �ݺ��� Ż��
				result += first;
				m -= 1; // ���� ������ 1�� ����
			}
			if (m == 0) break; // m�� 0�̶�� �ݺ��� Ż��
			result += second; // �� ��°�� ū ���� �� �� ���ϱ�
			m -= 1; // ���� ������ 1�� ����
		}
		
		System.out.println(result); // ���� ��� ���
	}
}

// �� ����� M�� 10,000 ������ ��쿡�� ������ �ذ��� �� ������, M�� 100�� �̻� Ŀ���ٸ� �ð��ʰ� ������ ���� ���̴�.
// �� ��� LawOfLargeNumber2.java ���� �ذ��Ѵ�.