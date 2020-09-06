package greedy;

import java.util.Scanner;

public class NumberCardGame {
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		// N, M�� ������ �������� �Է¹ޱ�
		int n = sc.nextInt();
		int m = sc.nextInt();
		int result = 0;
		
		// �� �پ� �Է¹޾� Ȯ���ϱ�
		for (int i = 0; i < n; i++) {
			//���� �ٿ��� '���� ���� ��' ã��
			int min_value = 10001;
			for (int j = 0; j < m; j++) {
				int x = sc.nextInt();
				min_value = Math.min(min_value, x);
			}
			// '���� ���� ��'�� �߿��� ���� ū �� ã��
			result = Math.max(result, min_value);
		}
		
		System.out.println(result); // ���� ��� ���
	}
}

// 2�� �ݺ��� ������ min(), max() �޼ҵ带 �̿��Ͽ� �ذ�