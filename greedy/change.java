package greedy;

public class Change {
	
	public static void main(String args[]) {
		int n = 1260;
		int count = 0;
		int[] coinTypes = {500, 100, 50, 10}; // 큰 단위의 화폐부터 차례대로 확인
		
		for (int i = 0; i < coinTypes.length; i++) {
			int coin = coinTypes[i];
			count = count + n/coin; // 해당 화폐로 거슬러 줄 수 있는 동전의 개수 세기
			n %= coin;			
		}
		
		System.out.println(count);
	}
}
