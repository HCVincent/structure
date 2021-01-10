package day02.sparsearray;


public class SparseArray {

	public static void main(String[] args) {
		//����һ��ԭʼ�Ķ�ά���� 11 * 11
		//0����ʾû�����ӣ�1��ʾ���ӣ�2��ʾ����
		int chessArr1[][] = new int [11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		//���ԭʼ�Ķ�ά����
		System.out.println("ԭʼ�Ķ�ά����");
		for(int[] row : chessArr1) {
			for(int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		//��¼��0��
		int sum = 0;
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				if(chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		//������Ӧϡ������
		int sparseArr[][] = new int[sum+1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = 11;
		//������ά���飬�����0ֵ
		int count = 0; //count���ڼ�¼�ǵڼ�����0����
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
		System.out.println("�õ���ϡ������Ϊ");
		for(int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\n", sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		
		//��ϡ������ָ��ɶ�ά����
		//1.��ȡ����
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		
		//����ָ���Ķ�ά����
		System.out.println();
		System.out.println("�ָ���Ķ�λ����");
		//��ȡϡ�����������
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
