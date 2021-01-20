package day07.calculator;

public class MiGong {

	public static void main(String[] args) {
		//����һ����ά���飬ģ���Թ�
		//��ͼ
		int[][] map = new int[8][7];
		//ʹ��1��ʾǽ
		//��������Ϊ1
		for(int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		//��������Ϊ1
		for(int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		//���õ��壬��1��ʾ
		map[3][1] = 1;
		map[3][2] = 1;
		//�����ͼ
		System.out.println("��ͼ�����");
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		setWay(map, 1, 1);
		System.out.println("�߹���ĵ�ͼ���");
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	//ʹ�õݹ��������С����·
	/**
	 * @param map ��ʾ��ͼ
	 * @param i ���ĸ�λ�ÿ�ʼ��
	 * @param j
	 * @return ����ҵ�ͨ·������true������false
	 * 
	 * ij��ʾ������
	 * �涨6.5��ʾ����
	 * 0��ʾû�߹���1��ʾǽ��2��ʾ�����ߣ�3��ʾ�߹���
	 */
	public static boolean setWay(int[][] map, int i, int j) {
		if(map[6][5] == 2) {
			return true;
		} else {
			if(map[i][j] == 0) {
				//���ò��� ��������
				map[i][j] = 2;
				if(setWay(map, i+1, j)) {
					return true;
				} else if(setWay(map, i, j+1)) {
					return true;
				} else if(setWay(map, i-1, j)) {
					return true;
				} else if(setWay(map, i, j-1)) {
					return true;
				} else {
					map[i][j] = 3;
					return false;
				}
			} else {
				return false;
			}
		}
	}

}