package greedy;

import java.util.Scanner;

public class ToOne2 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// N, K�� ������ �������� �Է¹ޱ�
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		while (true) {
			// N�� K�� ������ �������� ���� �ɶ������� 1�� ����
			int target = (n / k) * k;
			result += (n - target);
			n = target;
			
			// N�� K���� ���� �� (�� �̻� ������ �������� ���� ��) �ݺ��� Ż��
			if (n < k) break;
			
			n /= k;
			result += 1;
		}
		// ���������� ���� ���� ���Ͽ� 1�� ����. �� ���ִ��� �𸣰ڴ�.
		result += (n - 1); 
		System.out.println(result);
	}
}
