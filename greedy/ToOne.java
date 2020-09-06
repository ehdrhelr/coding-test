package greedy;

import java.util.Scanner;

public class ToOne {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		// N, K�� ������ �������� �Է¹ޱ�
		int n = sc.nextInt();
		int k = sc.nextInt();
		int result = 0;
		
		// N�� K �̻��̶�� K�� ��� ������
		while (n >= k) {
			// N�� K�� ������ �������� �ʴ´ٸ� N���� 1�� ����
			while (n % k != 0) {
				n -= 1;
				result += 1;
			}
			// k�� ������
			n /= k;
			result += 1;
		}
		
		// ���������� ���� ���� ���Ͽ� 1�� ����
		while (n > 1) {
			n -= 1;
			result += 1;
		}
		
		System.out.println(result);
	}

}
