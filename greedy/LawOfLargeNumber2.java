package greedy;

import java.util.*;

public class LawOfLargeNumber2 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// N, M, K�� �������� �����Ͽ� �Է� �ޱ�
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		// N���� ���� �������� �����Ͽ� �Է� �ޱ�
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) { 
			arr[i] = sc.nextInt();	
		}
		
		Arrays.sort(arr); // �Է� ���� �� ����
		int first = arr[n - 1]; // ���� ū ��
		int second = arr[n - 2]; // �� ��°�� ū ��
		
		int count = 0;
		int result = 0;
		
		// ���� ū ���� �������� Ƚ�� ���
		count += (m / (k + 1)) * k;
		count += m % (k + 1);
		
		result += count * first; // ���� ū �� ���ϱ�
		result += (m-count) * second; // �� ��°�� ū �� ���ϱ�
		
		System.out.println(result); // ���� ��� ���

	}
}
