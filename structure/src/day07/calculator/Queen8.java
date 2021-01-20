package day07.calculator;

public class Queen8 {

	int max = 8;
	int[] array = new int[max];
	public static void main(String[] args) {
		
	}
	//�鿴�Ƿ��ͻ
	private boolean judge(int n) {
		for(int i = 0; i < n; i++) {
			//��ͬһ�л���ͬһб��
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n])-array[i]) {
				return false;
			}
		}
		return true;
	}
	
	//���õ�n���ʺ�
	private void check(int n) {
		if(n == max) {
			print();
			return;
		}
		for(int i = 0; i < max; i++) {
			array[n] = i;
			if(judge(n)) {//����ͻ
				check(n+1);
			} 
		}
	}
	
	//����ʺ�λ��
	private void print() {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
