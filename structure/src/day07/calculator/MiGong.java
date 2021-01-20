package day07.calculator;

public class MiGong {

	public static void main(String[] args) {
		//创建一个二维数组，模拟迷宫
		//地图
		int[][] map = new int[8][7];
		//使用1表示墙
		//上下设置为1
		for(int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		//左右设置为1
		for(int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		//设置挡板，用1表示
		map[3][1] = 1;
		map[3][2] = 1;
		//输出地图
		System.out.println("地图的情况");
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		setWay(map, 1, 1);
		System.out.println("走过后的地图情况");
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	//使用递归回溯来给小球找路
	/**
	 * @param map 表示地图
	 * @param i 从哪个位置开始找
	 * @param j
	 * @return 如果找到通路，返回true，否则false
	 * 
	 * ij表示出发点
	 * 规定6.5表示出口
	 * 0表示没走过，1表示墙，2表示可以走，3表示走过了
	 */
	public static boolean setWay(int[][] map, int i, int j) {
		if(map[6][5] == 2) {
			return true;
		} else {
			if(map[i][j] == 0) {
				//设置策略 下右上左
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
