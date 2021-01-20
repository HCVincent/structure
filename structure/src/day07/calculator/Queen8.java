package day07.calculator;

public class Queen8 {

	int max = 8;
	int[] array = new int[max];
	public static void main(String[] args) {
		
	}
	//查看是否冲突
	private boolean judge(int n) {
		for(int i = 0; i < n; i++) {
			//在同一列或在同一斜线
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n])-array[i]) {
				return false;
			}
		}
		return true;
	}
	
	//放置第n个皇后
	private void check(int n) {
		if(n == max) {
			print();
			return;
		}
		for(int i = 0; i < max; i++) {
			array[n] = i;
			if(judge(n)) {//不冲突
				check(n+1);
			} 
		}
	}
	
	//输出皇后位置
	private void print() {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
