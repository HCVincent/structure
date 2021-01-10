package day02.sparsearray;


public class SparseArray {

	public static void main(String[] args) {
		//创建一个原始的二维数组 11 * 11
		//0：表示没有棋子，1表示黑子，2表示蓝子
		int chessArr1[][] = new int [11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		//输出原始的二维数组
		System.out.println("原始的二维数组");
		for(int[] row : chessArr1) {
			for(int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		//记录非0项
		int sum = 0;
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				if(chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		//创建对应稀疏数组
		int sparseArr[][] = new int[sum+1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = 11;
		//遍历二维数组，存入非0值
		int count = 0; //count用于记录是第几个非0数据
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				if(chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}
		System.out.println();
		System.out.println("得到的稀疏数组为");
		for(int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\n", sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		
		//将稀疏数组恢复成二维数组
		//1.读取行列
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		
		//输出恢复后的二维数组
		System.out.println();
		System.out.println("恢复后的二位数组");
		//读取稀疏数组的数据
		for(int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		for(int[] row : chessArr2) {
			for(int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}

}
